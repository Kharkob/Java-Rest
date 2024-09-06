package petstore;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String customerEmail;

    @ManyToMany(mappedBy = "customers", cascade =   CascadeType.PERSIST)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<PetStore> petStores;
}
