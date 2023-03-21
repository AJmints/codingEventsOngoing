package helloSpring2.demo.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventCategory extends AbstractEntity{

    private String name;

    @OneToMany(mappedBy = "eventCategory")
    private final List<Event> events = new ArrayList<>();

    public EventCategory() {
    }

    public List<Event> getEvents() {
        return events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
