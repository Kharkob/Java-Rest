package petstore;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
@Data
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;

    @ManyToMany(cascade = {CascadeType.PERSIST}, mappedBy = "")
    @JoinTable(name = "pet_store_customer",
    joinColumns = @JoinColumn(name = "pet_store_id"),
    inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Customer> customers;

    @OneToMany(mappedBy = "petStore", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Employee> employees;

    
}