package springboot.reactive;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class ReactiveConfiguration extends AbstractReactiveMongoConfiguration {

  @Override
  public MongoClient reactiveMongoClient() {
    return MongoClients.create(String.format("mongodb://localhost:%d", 27017));
  }

  @Override
  protected String getDatabaseName() {
    return "spring-test";
  }
}
