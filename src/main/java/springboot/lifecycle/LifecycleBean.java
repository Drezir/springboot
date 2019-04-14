package springboot.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifecycleBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean factory has been set");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("My bean name is " + s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean has been destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Properties have been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post construct has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Pre destroy has been called");
    }

    public void beforeInit() {
        System.out.println("BeforeInit - called by bean post-processor");
    }

    public void afterInit() {
        System.out.println("AfterInit - called by bean after post-processor");
    }
}
