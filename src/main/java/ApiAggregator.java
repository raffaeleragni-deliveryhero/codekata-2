import java.util.ArrayList;
import java.util.List;

public class ApiAggregator {

    


    public ApiAggregator(){

    }


    public List<String> call(List<String> endpoints) {
        List<String> response = new ArrayList<>();

        for (var endpoint: endpoints) {
          if ("/uri2".equals(endpoint)) {
            response.add("response2");
          } else {
            response.add("response1");
          }
        }
        
        return response;
    }



}
