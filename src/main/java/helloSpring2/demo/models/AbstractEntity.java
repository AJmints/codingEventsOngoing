package helloSpring2.demo.models;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    public int id;

    public int getId() {
        return id;
    }

}
