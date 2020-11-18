import java.util.ArrayList;
import java.util.List;

public class ApiAggregator {

    ApiCaller caller;


    public ApiAggregator(ApiCaller caller){
      this.caller = caller;
    }


    public List<String> call(List<String> endpoints) {
        List<String> response = new ArrayList<>();

        for (var endpoint: endpoints) {
          response.add(caller.call(endpoint));
        }

        return response;
    }



}
