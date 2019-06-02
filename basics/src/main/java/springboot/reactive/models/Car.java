package springboot.reactive.models;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cars")
public class Car {

  private String brand;
  private Double power;

  @Id
  @Indexed(unique = true)
  private Long carId;

}
