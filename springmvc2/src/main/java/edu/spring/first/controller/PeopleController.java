package edu.spring.first.controller;

import edu.spring.first.data.Person;
import edu.spring.first.data.PersonStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PeopleController {

    @Autowired
    PersonStore dataSource;

    @GetMapping("/people")
    public String list(Model model) {
        model.addAttribute("people", dataSource.getPeople());
        return "allPeople";
    }

    @GetMapping("/people/new")
    public String newPersonForm() {
        return "newPerson";
    }

    @PostMapping("/people")
    public RedirectView add(@RequestParam(name = "name") String name,
                            @RequestParam(name = "age") int age,
                            @RequestParam(name = "gender") String gender) {
        dataSource.addPerson(new Person(name, age, gender));
        return new RedirectView("/people");
    }

}