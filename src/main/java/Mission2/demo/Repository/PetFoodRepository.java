package Mission2.demo.Repository;

import Mission2.demo.Model.PetFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface PetFoodRepository extends JpaRepository<PetFood, Long> {

}
