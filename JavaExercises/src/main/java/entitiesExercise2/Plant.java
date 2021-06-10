/** Udacity: Delivering Flowers Service Entity Exercise 2
 *
 *  Create a new parent class called Plant (Entity) that contains the shared attributes of name, price, and id. Create
 *  subclasses Shrub and Flower. We want to keep using our table ‘plant’ to store all the shared data, but our flowers
 *  and shrubs should have separate tables for their unique fields, so make any changes necessary for this to happen.
 */

package entitiesExercise2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) // stores shared fields in 'plant' table and unique fields in subclass tables
public abstract class Plant {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized // name will support international language characters
    private String name;
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
