package helloSpring2.demo.controller;

import helloSpring2.demo.data.EventCategoryRepository;
import helloSpring2.demo.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String eventCategoryDisplay(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/index";
    }

    @GetMapping("create")
    public String renderCreateEventCategoryDisplay(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute(new EventCategory());
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/create";
    }

    @PostMapping("create")
    public String processCreateEventCategoryForm(@ModelAttribute @Valid EventCategory newEventCategory,
                                                Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            return "eventCategories/create";
        }

        model.addAttribute("title", "Create Category");
        eventCategoryRepository.save(newEventCategory);
        return "redirect:/eventCategories";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/delete";
    }

    @PostMapping("delete")
    public String processDeleteCategoryEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                eventCategoryRepository.deleteById(id);
            }
        }
        return "redirect:/eventCategories";
    }

}
