/** Udacity: Delivering Flowers Service Entity Exercise 3
 *
 *  Create a class called PlantDTO that contains name and price variables.
 */

package entitiesExercise3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor
public class PlantDTO {

    private String name;
    private BigDecimal price;
}
