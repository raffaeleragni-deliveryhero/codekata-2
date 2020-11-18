import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiAggregatorTest {

    ApiAggregator aggregator;
    ApiCaller caller;

    @BeforeEach
    void setup(){
        caller = mock(ApiCaller.class);
        aggregator = new ApiAggregator(caller);
    }

    @Test
    void isEmptyList(){
        var endpoints = Collections.<String>emptyList();
        var response = aggregator.call(endpoints);
        assertThat(response,is(Collections.emptyList()));
    }


    @Test
    void singleEndpoint() {
      when(caller.call("/uri1")).thenReturn(Optional.of("response1"));

      var responseList = aggregator.call(List.of("/uri1"));
      assertThat(responseList, is(List.of("response1")));
    }

    @Test
    void responseWithDifferentUri() {
      when(caller.call("/uri2")).thenReturn(Optional.of("response2"));
      
      var responseList = aggregator.call(List.of("/uri2"));
      assertThat(responseList, is(List.of("response2")));
    }


}
