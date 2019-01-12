package springboot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:XmlConfig.xml")
@Configuration
public class ExampleConfigurationXml {

}
