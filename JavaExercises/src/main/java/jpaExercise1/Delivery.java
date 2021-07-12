/** Udacity: JpaExercise1
 *
 *  Modify Delivery so that if it is removed, it will also remove any Plants associated with it at the same time.
 */

package jpaExercise1;

import entitiesExercise2.Plant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    // added CascadeType.REMOVE to automatically clear any associated plants when removed
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.REMOVE)
    private List<Plant> plants;
}
