package springboot;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springboot.configuration.ExampleConfiguration.Person;
import springboot.properties.BeanMapProperty.ServersBean;

@SpringBootApplication
@ServletComponentScan // for web filters, ...
public class SpringExample {

  private static final Logger LOG = LoggerFactory.getLogger(SpringExample.class);

  private final Person p1, p2;
  private final ServersBean serversBean;

  @Autowired
  public SpringExample(
      @Qualifier("person1") Person p1,
      @Qualifier("person2") Person p2,
      ServersBean serversBean) {
    this.p1 = p1;
    this.p2 = p2;
    this.serversBean = serversBean;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringExample.class, args);
  }

  @PostConstruct
  public void init() {
    LOG.info("Person1: {} {}", p1.getName(), p1.getSurname());
    LOG.info("Person2: {} {}", p2.getName(), p2.getSurname());
    LOG.info("ServersBean has servers: {}", serversBean.getServers().toString());
  }

}
