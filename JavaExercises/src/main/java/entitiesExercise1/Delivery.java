/** Udacity: Delivering Flowers Service Entity Exercise 1
 *
 *  The Delivery should have a recipient name, address, delivery date, and delivery time. Let’s store the whole
 *  address in a single field, so make sure the column will be wide enough to hold up to 500 characters. We’ll
 *  call this column address_full. There should also be an attribute on the Delivery entity that shows if it is
 *  completed or not, which should show up as ‘Y’ or ‘N’ in the database. Make sure that the recipient name will
 *  support international language characters and that the delivery time is stored without timezone information.
 *  Finally, make sure to add getters and setters to your class.
 */

package entitiesExercise1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized // will support international language characters
    private String name;
    @Column(name="address_full", length = 500) // will be wide enough to hold up to 500 characters
    private String address;
    private LocalDateTime deliveryDateAndTime;
    @Type(type="yes_no") // should show up as 'Y' or 'N' in the database
    private Boolean completed;

    public Delivery(Long id, String name, String address, LocalDateTime deliveryDateAndTime, Boolean completed) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.deliveryDateAndTime = deliveryDateAndTime;
        this.completed = completed;
    }
}
