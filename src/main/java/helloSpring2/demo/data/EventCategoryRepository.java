package helloSpring2.demo.data;

import helloSpring2.demo.models.EventCategory;
import org.springframework.data.repository.CrudRepository;
import helloSpring2.demo.models.Event;

public interface EventCategoryRepository extends CrudRepository<EventCategory, Integer> {

}
