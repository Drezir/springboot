package springboot.utils;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

public class StartAnalyzer implements FailureAnalyzer {

  @Override
  public FailureAnalysis analyze(Throwable failure) {
    failure.printStackTrace();
    return new FailureAnalysis("Something went wrong", "SpringBoot run", failure);
  }
}
