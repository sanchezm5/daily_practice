/** Udacity: Delivering Flowers Service Entity Exercise 3
 *
 *  Let’s add a shell Service and Controller to demonstrate how to use DTOs and @JSONView. Create a class called
 *  PlantService that returns a Plant instance:
 */

package entitiesExercise3;

import org.springframework.stereotype.Service;

@Service
public class PlantService {

    public Plant getPlantByName(String name){
        return new Plant();
    }
}
