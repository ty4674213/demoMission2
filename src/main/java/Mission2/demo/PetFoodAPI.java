package Mission2.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/petfood")
@Slf4j
@RequiredArgsConstructor
public class PetFoodAPI {
    private final PetFoodService petFoodService;

    @GetMapping
    public ResponseEntity<List<PetFood>> findAll(){
        return ResponseEntity.ok(petFoodService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody PetFood petFood){
        return ResponseEntity.ok(petFoodService.save(petFood));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetFood> findById(@PathVariable Long id){
        Optional<PetFood> stock = petFoodService.findById(id);
        if(!stock.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetFood> findById(@PathVariable Long id, @RequestBody PetFood petFood){
        if (!petFoodService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(petFoodService.save(petFood));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!petFoodService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        petFoodService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
