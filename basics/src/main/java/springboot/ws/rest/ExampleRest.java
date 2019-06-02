package springboot.ws.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springboot.configuration.ExampleConfiguration.Person;

@RestController
public class ExampleRest {

  @GetMapping("/")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("name", new Person("Adam", "Ostrožlík"));
    return modelAndView;
  }

  @GetMapping("/hello")
  public String home() {
    return "Hello World!";
  }
}
