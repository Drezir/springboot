package springboot.properties;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class ValueInject {

  private static final Logger LOG = LoggerFactory.getLogger(ValueInject.class);

  @Value("${property.static}")
  private String msg;

  @Value("${property.dynamic}")
  private String uuid;

  @Value("${ext.property}")
  private int cmdProperty;

  @Value("${property.profileName}")
  @NotEmpty
  private String profileName;

  @PostConstruct
  public void init() {
    LOG.info("Properties: {}", Arrays.toString(new Object[]{msg, uuid, cmdProperty, profileName}));
  }

}
