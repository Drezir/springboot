package springboot.ws;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns = "/*") // only usable with embedded application server
public class ExampleWebFilter implements Filter {

  private static final Logger LOG = LoggerFactory.getLogger(ExampleWebFilter.class);

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    LOG.info("ExampleWebFilter/headers {}", toString(httpServletRequest.getHeaderNames()));
    filterChain.doFilter(servletRequest, servletResponse);
  }

  private <T> String toString(final Enumeration<T> enumeration) {
    StringBuilder stringBuilder = new StringBuilder();
    while (enumeration.hasMoreElements()) {
      stringBuilder.append(enumeration.nextElement().toString()).append(",");
    }
    return stringBuilder.toString();
  }
}
