package Mission2.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Data
public class PetFood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false) private String brand;
    @Column(nullable = false) private String description;
    @Column(nullable = false) private BigDecimal price;
}
