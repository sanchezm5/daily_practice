/** Udacity: Delivering Flowers Service Entity Exercise 2
 *
 *  Create a new class called Shrub and add attributes for height and width. We want to keep using our table ‘plant’ to
 *  store all the shared data, but our flowers and shrubs should have separate tables for their unique fields, so make
 *  any changes necessary for this to happen.
 */

package entitiesExercise2;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor
public class Shrub extends Plant {

    private int height;
    private int width;

    public Shrub(Long id, String name, BigDecimal price, Delivery delivery, int height, int width) {
        super(id, name, price, delivery);
        this.height = height;
        this.width = width;
    }
}
