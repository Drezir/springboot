package springboot.tests;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class ReactiveStreamTest {

  @Test
  public void testReactiveStream() {
    System.out.println("Collecting resources - Provider");
    Flux<Integer> flux = Flux.range(1, 20)
        .filter(n -> n % 2 == 0)
        .map(n -> n / 2)
        .log();
    System.out.println("Some entity wants resources -Subscriber");
    flux.subscribe();
    System.out.println("End of test");
  }


}
