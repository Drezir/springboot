package springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/logging.yaml")
public class ExampleConfiguration {

  @Bean("person1")
  public Person createPerson() {
    return new Person("Adam", "Ostrožlík");
  }


  public static class Person {

    private String name, surname;

    public Person(String name, String surname) {
      this.name = name;
      this.surname = surname;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getSurname() {
      return surname;
    }

    public void setSurname(String surname) {
      this.surname = surname;
    }

    @Override
    public String toString() {
      return String.format("%s %s", name, surname);
    }
  }

}
