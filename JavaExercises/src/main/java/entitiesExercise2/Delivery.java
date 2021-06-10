/** Udacity: Delivering Flowers Service Entity Exercise 2
 *
 *  We also want to update our Delivery class so that it is associated with our plants. Modify Delivery so that it
 *  includes a list of all the Flowers and Shrubs to be included in the delivery. Make this association bidirectional,
 *  and store the association in the ‘plant’ table in a column called ‘delivery_id’. Make sure to add and update any
 *  relevant getter and setter methods.
 */

package entitiesExercise2;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
    private List<Plant> plants;

    public Delivery(Long id, String name, String address, LocalDateTime deliveryDateAndTime, Boolean completed, List<Plant> plants) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.deliveryDateAndTime = deliveryDateAndTime;
        this.completed = completed;
        this.plants = plants;
    }
}
