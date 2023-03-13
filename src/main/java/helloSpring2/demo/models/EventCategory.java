package helloSpring2.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class EventCategory {

    @Id
    @GeneratedValue
    public int id;

    @Size(min = 2, max = 500, message = "Message required")
    public String name;

    public EventCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EventCategory() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
