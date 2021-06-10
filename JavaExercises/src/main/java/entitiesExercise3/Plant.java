/** Udacity: Delivering Flowers Service Entity Exercise 3
 *
 *  Use the @JsonView annotation in Plant.java and PlantController.java so that getFilteredPlant method only returns name and price.
 */

package entitiesExercise3;

import com.fasterxml.jackson.annotation.JsonView;
import entitiesExercise2.Delivery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) // stores shared fields in 'plant' table and unique fields in subclass tables
public class Plant {

    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized // name will support international language characters
    private String name;

    @JsonView(Views.Public.class)
    @Column(precision=12, scale=4) // 12 precision and 4 decimal places
    private BigDecimal price;

    @ManyToOne // many plants belong to one delivery
    @JoinColumn(name = "delivery_id") // establishes a bidirectional relationship with Delivery referenced as "delivery_id"
    private Delivery delivery;

    public Plant(Long id, String name, BigDecimal price, Delivery delivery) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.delivery = delivery;
    }
}
