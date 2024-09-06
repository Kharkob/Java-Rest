package petstore;

import jakarta.persistence.CascadeType;

public @interface ManyToMany {

    String mappedBy();

    CascadeType[] cascade();

}
