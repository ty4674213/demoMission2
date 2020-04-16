package Mission2.demo.Controller;

import Mission2.demo.Model.PetFood;
import Mission2.demo.Repository.PetFoodJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Repository
@RestController
@RequestMapping("/petfood")
public class PetFoodAPIController {

   //@Autowired
    //private PetFoodRepository petFoodRepository;

    @Autowired
    private PetFoodJdbcRepository petFoodJdbcRepository;

    @GetMapping
    public ResponseEntity<Iterable<PetFood>> findAll() {
        return ResponseEntity.ok(petFoodJdbcRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetFood> findById(@PathVariable Long id) {
        Optional<PetFood> stock = petFoodJdbcRepository.findById(id);
        if (!stock.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(stock.get());
    }

    @PostMapping
    public ResponseEntity<List<PetFood>> create(@RequestBody PetFood petFood) {
        return ResponseEntity.ok(petFoodJdbcRepository.insert(petFood));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!petFoodJdbcRepository.findById(id).isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        petFoodJdbcRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<PetFood>> update(@PathVariable Long id, @RequestBody PetFood petFood) {
        if (!petFoodJdbcRepository.findById(id).isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        petFoodJdbcRepository.findById(id);
        return ResponseEntity.ok(petFoodJdbcRepository.update(petFood));
    }

    /*@GetMapping
    public ResponseEntity<Iterable<PetFood>> findAll() {
        return ResponseEntity.ok(petFoodRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetFood> findById(@PathVariable Long id) {
        Optional<PetFood> stock = petFoodRepository.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(stock.get());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody PetFood petFood) {
        return ResponseEntity.ok(petFoodRepository.save(petFood));
    }


    @PutMapping("/{id}")
    public ResponseEntity<PetFood> update(@PathVariable Long id, @RequestBody PetFood petFood) {
        if (!petFoodRepository.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        petFoodRepository.findById(id);
        return ResponseEntity.ok(petFoodRepository.save(petFood));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!petFoodRepository.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        petFoodRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }*/
}
