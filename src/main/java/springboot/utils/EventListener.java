package springboot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EventListener implements ApplicationListener {

  private static final Logger LOG = LoggerFactory.getLogger(EventListener.class);

  @Override
  public void onApplicationEvent(ApplicationEvent applicationEvent) {
    LOG.debug("Event caught from {}", applicationEvent.getSource());
  }
}
