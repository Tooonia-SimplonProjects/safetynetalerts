package co.simplon.safetynetalertsapp.service;

import co.simplon.safetynetalertsapp.model.Person;
import co.simplon.safetynetalertsapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PersonService {

//    @Autowired //Does not work without initializing it with = new PersonRepository();! <<< It does work now without!!!
//    private PersonRepository personRepository = new PersonRepository();
    private final  PersonRepository personRepository;

    List<Person> personList;
//    Person person;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

//    CRUD READ
    public List<Person> getAllPersons() throws IOException {
        return personRepository.getAllPersons();
    }

    public Person getSinglePerson(String firstName, String lastName) throws IOException {
        return personRepository.getOnePerson(firstName, lastName);
    }
//    CRUD CREATE
    public Person createPerson(Person person) throws IOException {
        return personRepository.createPerson(person);
    }

//    CRUD UPDATE // TODO: here, = getSinglePerson (minthogy mar ez is a personRepository-t hasznalja) to use, or = personRepository.getOnePerson ?
    // TODO: Sehol sem hasznalom a PersonRepository umpdatePerson methode-omat???
    public void updatePerson(Person person) throws IOException {
        personRepository.updatePerson(person);
    }

//    CRUD DELETE
    public void deletePerson(String firstName, String lastName) throws IOException {
        personRepository.deletePerson(firstName, lastName);
    }

}


