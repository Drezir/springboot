package springboot.recipe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Descriptions")

@Data
public class Description {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  private String description;

  @PrePersist
  public void doSomething() {
    System.out.println("Prepersist of description");
  }

}
