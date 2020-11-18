import java.util.Objects;

public class SingleApiCaller implements ApiCaller {

  @Override
  public String call(String endpointUrl) {
    Objects.requireNonNull(endpointUrl, "Null URL is passed");
    
    return null;
  }

  
}
