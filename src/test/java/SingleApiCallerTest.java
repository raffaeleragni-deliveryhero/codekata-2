import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SingleApiCallerTest {

  SingleApiCaller apiCaller;
  HttpClient client;

  @BeforeEach
  void setup() {
    client = mock(HttpClient.class);
    apiCaller = new SingleApiCaller(client);
  }

  @Test
  void testCallWithNullUrl() {
    var ex = assertThrows(NullPointerException.class, () -> apiCaller.call(null));
    assertThat(ex.getMessage(), is("Null URL is passed"));
  }

  @Test
  void testHttpClient() {
    var request = HttpRequest.newBuilder()
      .uri(URI.create("http://openjdk.java.net/"))
      .build();
    var response = mock(HttpResponse.class);
    when(client.sendAsync(request, BodyHandlers.ofString()))
      .thenReturn(CompletableFuture.completedFuture(response));

    when(response.body()).thenReturn("response1");

    var result = apiCaller.call("http://openjdk.java.net/");

    assertThat(result, is("response1"));
  }
}
