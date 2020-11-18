import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class SingleApiCallerTest {

  SingleApiCaller apiCaller;
  
  @BeforeEach
  void setup() {
    apiCaller = new SingleApiCaller();
  }
  
  @Test
  void testCallWithNullUrl() {
    var ex = assertThrows(NullPointerException.class, () -> apiCaller.call(null));
    assertThat(ex.getMessage(), is("Null URL is passed"));
  }
}
