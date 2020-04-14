package Mission2.demo.Repository;

import Mission2.demo.Model.PetFood;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetFoodRepository extends CrudRepository<PetFood, Long> {
}
