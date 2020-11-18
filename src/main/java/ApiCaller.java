import java.util.Optional;

public interface ApiCaller {
  Optional<String> call(String url);
}
