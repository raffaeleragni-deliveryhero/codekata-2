import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiAggregatorIT {

    ApiCaller apiCaller;


    @BeforeEach
    void setup(){
        apiCaller = new SingleApiCaller(HttpClient.newHttpClient());

    }

    @Test
    void successfulApiCall(){
        var response = apiCaller.call("http://localhost:12345/sample1");
        assertThat(response, is(Optional.of("sample1")));

    }






}
