/** Udacity: Delivering Flowers Service Entity Exercise 2
 *
 *  Turn Flower into a subclass of Plant that just has the attribute color. We want to keep using our table ‘plant’ to
 *  store all the shared data, but our flowers and shrubs should have separate tables for their unique fields, so make
 *  any changes necessary for this to happen.
 */

package entitiesExercise2;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor
public class Flower extends Plant {

    private String color;

    public Flower(Long id, String name, BigDecimal price, Delivery delivery, String color) {
        super(id, name, price, delivery);
        this.color = color;
    }
}
