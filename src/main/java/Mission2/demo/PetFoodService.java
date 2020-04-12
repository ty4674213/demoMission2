package Mission2.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class PetFoodService {
    private final PetFoodRepository petFoodRepository;

    public List<PetFood> findAll(){
        return petFoodRepository.findAll();
    }

    public Optional<PetFood> findById(Long id){
        return petFoodRepository.findById(id);
    }

    public PetFood save(PetFood stock){
        return petFoodRepository.save(stock);
    }

    public void deleteById(Long id){
        petFoodRepository.deleteById(id);
    }

}
