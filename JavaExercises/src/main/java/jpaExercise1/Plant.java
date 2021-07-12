/** Udacity: JpaExercise1
 *
 *  Modify Plant so that it will only query for Delivery objects when they are referenced, not every time the Plant is retrieved.
 */

package jpaExercise1;

import com.fasterxml.jackson.annotation.JsonView;
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

    @ManyToOne(fetch = FetchType.LAZY) // don't retrieve delivery if we don't need it
    @JoinColumn(name = "delivery_id") // establishes a bidirectional relationship with Delivery referenced as "delivery_id"
    private Delivery delivery;
}