package springboot.utils;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdRunner implements CommandLineRunner {

  private static final Logger LOG = LoggerFactory.getLogger(CmdRunner.class);

  @Override
  public void run(String... args) throws Exception {
    LOG.info("CommandLineRunner {}", Arrays.toString(args));
  }
}
