/** Udacity: JpaExercise1
 *
 *  For this exercise, you should create a class that can add new Delivery objects to the database.
 *  It should support the following interface:
 *      void persist(Delivery delivery);
 *      Delivery find(Long id);
 *      Delivery merge(Delivery delivery);
 *      void delete(Long id);
 */

package jpaExercise1;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

     void persist(Delivery delivery) {
         entityManager.persist(delivery);
     }

     Delivery find(Long id) {
         return entityManager.find(Delivery.class, id);
     }

     Delivery merge(Delivery delivery) {
         return entityManager.merge(delivery);
     }

     void delete(Long id) {
         Delivery delivery = entityManager.find(Delivery.class, id);
         entityManager.remove(id);
     }
}

