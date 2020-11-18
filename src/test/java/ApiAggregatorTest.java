import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

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






}
