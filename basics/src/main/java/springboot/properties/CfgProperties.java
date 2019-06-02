package springboot.properties;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "property")
@Component
@Validated
public class CfgProperties {

  private static final Logger LOG = LoggerFactory.getLogger(CfgProperties.class);

  @NotNull
  private Set<String> servers = new HashSet<>();
  private LocalDate date;
  @Range(min = 2, max = 5)
  private int validatedNumber;

  public Set<String> getServers() {
    return servers;
  }

  public void setServers(Set<String> servers) {
    this.servers = servers;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public int getValidatedNumber() {
    return validatedNumber;
  }

  public void setValidatedNumber(int validatedNumber) {
    this.validatedNumber = validatedNumber;
  }

  @PostConstruct
  public void init() {
    LOG.info("Configuration properties {}", Arrays.toString(new Object[]{servers.toString(), date, validatedNumber}));
  }
}
