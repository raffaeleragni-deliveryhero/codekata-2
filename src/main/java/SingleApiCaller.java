import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Optional;

public class SingleApiCaller implements ApiCaller {

  final HttpClient client;

  public SingleApiCaller(HttpClient client) {
    this.client = client;
  }

  @Override
  public Optional<String> call(String endpointUrl) {
    Objects.requireNonNull(endpointUrl, "Null URL is passed");

    var request = HttpRequest.newBuilder()
      .uri(URI.create(endpointUrl))
      .build();

    var response = client
      .sendAsync(request, HttpResponse.BodyHandlers.ofString())
      .join();


    return Optional.of(response.body());
  }


}
