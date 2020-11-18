import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class SingleApiCaller implements ApiCaller {

  final HttpClient client;

  public SingleApiCaller(HttpClient client) {
    this.client = client;
  }

  @Override
  public String call(String endpointUrl) {
    Objects.requireNonNull(endpointUrl, "Null URL is passed");

    var request = HttpRequest.newBuilder()
      .uri(URI.create(endpointUrl))
      .build();

    var futureResponse = client
      .sendAsync(request, HttpResponse.BodyHandlers.ofString());

    return futureResponse.join().body();
  }


}
