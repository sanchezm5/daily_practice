/** Udacity: Delivering Flowers Service Entity Exercise 3
 *
 *  Then create a class called PlantController that offers two methods. One of these methods will return a PlantDTO that
 *  includes only the name and price. The other method should return a Plant Entity instance. Both the method and entity
 *  should be modified so that only the name and price fields from the Entity are returned.
 */

package entitiesExercise3;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name) {
        return convertPlantEntityToDTO(plantService.getPlantByName(name));
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name) {
        return plantService.getPlantByName(name);
    }

    public PlantDTO convertPlantEntityToDTO(Plant plant) {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }
}
