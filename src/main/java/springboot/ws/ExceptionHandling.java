package springboot.ws;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandling {

  @GetMapping("/exception")
  public void testException() {
    throw new MyException();
  }

  @GetMapping("/numberexception")
  public void testNumberException() {
    double a = 5 / 0;
  }

  @ExceptionHandler(MyException.class)
  public String handleException() {
    return "<H1>Error</h1>";
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  public static class MyException extends RuntimeException {

  }

}
