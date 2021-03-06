package springboot.properties;

import java.time.LocalDate;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class Conversion implements Converter<String, LocalDate> {

  @Override
  public LocalDate convert(String s) {
    return LocalDate.parse(s);
  }
}
