package springboot.properties;

import java.util.Collection;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanMapProperty {

  @Bean
  @ConfigurationProperties("property")
  public ServersBean createServersBean() {
    return new ServersBean();
  }

  public static class ServersBean {

    private Collection<String> servers;

    public Collection<String> getServers() {
      return servers;
    }

    public void setServers(Collection<String> servers) {
      this.servers = servers;
    }
  }

}
