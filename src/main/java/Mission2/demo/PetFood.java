package Mission2.demo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PetFood {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
