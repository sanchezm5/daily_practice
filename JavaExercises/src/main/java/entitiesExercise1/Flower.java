/** Udacity: Delivering Flowers Service Entity Exercise 1
 *
 *  The Flower should have a name, color, and price attribute. Flowers will be stored in a table called ‘plant’.
 *  Make sure the price is stored as a DECIMAL column with 12 precision and 4 decimal places (scale). Make sure
 *  that the flower name will support international language characters and that getters and setters are added to
 *  the class.
 */

package entitiesExercise1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="plant")
public class Flower {

    @Id
    @GeneratedValue
    private Long Id;

    @Nationalized // name will support international language characters
    private String name;
    private String color;
    @Column(precision=12, scale=4) // 12 precision and 4 decimal places
    private BigDecimal price;

    public Flower(Long id, String name, String color, BigDecimal price) {
        Id = id;
        this.name = name;
        this.color = color;
        this.price = price;
    }
}
