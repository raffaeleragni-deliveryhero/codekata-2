import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ApiAggregatorTest {

    ApiAggregator aggregator;

    @BeforeEach
    void setup(){
        aggregator = new ApiAggregator();
    }

    @Test
    void isEmptyList(){
        var endpoints = Collections.<String>emptyList();
        var response = aggregator.call(endpoints);
        assertThat(response,is(Collections.emptyList()));
    }


    @Test
    void singleEndpoint() {
      var responseList = aggregator.call(List.of("/uri1"));
      assertThat(responseList, is(List.of("response1")));
    }

    @Test
    void responseWithDifferentUri() {
      var responseList = aggregator.call(List.of("/uri2"));
      assertThat(responseList, is(List.of("response2")));
    }


}
