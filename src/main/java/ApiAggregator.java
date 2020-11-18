import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApiAggregator {

    ApiCaller caller;


    public ApiAggregator(ApiCaller caller){
      this.caller = caller;
    }


    public List<String> call(List<String> endpoints) {
        List<String> response = new ArrayList<>();

        for (var endpoint: endpoints) {
            caller.call(endpoint).ifPresent(response::add);
        }

        return response;
    }



}
