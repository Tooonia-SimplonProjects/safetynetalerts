package co.simplon.safetynetalertsapp.controller;

import co.simplon.safetynetalertsapp.model.Person;
import co.simplon.safetynetalertsapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public List<Person> getAllPersons() throws IOException {
        return personService.getAllPersons();
    }

    @GetMapping("/person/getOnePerson")
    public Person getOnePerson(@RequestParam String firstName, @RequestParam String lastName)
            throws IOException {
        return personService.getSinglePerson(firstName, lastName);
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) throws IOException {
            return personService.createPerson(person);
    }

    @PutMapping("/person")
    public void updatePerson(@RequestBody Person person) throws IOException {
        personService.updatePerson(person);
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestParam String firstName, @RequestParam String lastName)
            throws IOException {
        personService.deletePerson(firstName, lastName);
    }

    /*private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getListOfAllPersons() throws IOException {
        List<Person> personList = personService.getPersonList();
        return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
    }*/
}
