package springboot.utils;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class AppArgs {

  private static final Logger LOG = LoggerFactory.getLogger(AppArgs.class);

  @Autowired
  public AppArgs(ApplicationArguments args) {
    LOG.info("Arguments {}", Arrays.toString(args.getSourceArgs()));
  }

}
