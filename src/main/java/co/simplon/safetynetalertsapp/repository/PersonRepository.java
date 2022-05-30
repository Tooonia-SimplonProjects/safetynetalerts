package co.simplon.safetynetalertsapp.repository;

import co.simplon.safetynetalertsapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private AccessToEntireJson accessToEntireJson = new AccessToEntireJson();
    List<Person> personList = new ArrayList<>();

    @Autowired
    public PersonRepository(AccessToEntireJson accessToEntireJson) {
        this.accessToEntireJson = accessToEntireJson;
    }

//  This method gets the initial list of Persons from data.json :
    public List<Person> getInitialPersonListFromJson() throws IOException {
        personList = accessToEntireJson.readList("persons", Person.class);
        return personList;
    }

//  READ
//  This method gets the list of Persons "updated", that were modified via CRUD methods :
    public List<Person> getAllPersons() throws IOException {
        if (personList.isEmpty()) {
            personList.addAll(this.getInitialPersonListFromJson());
        }
        return personList;
    }

    public Person getOnePerson(String firstName, String lastName) throws IOException {
        if (personList.isEmpty()) {
            personList.addAll(this.getInitialPersonListFromJson());
        }
        for(Person person : personList) {
            if (person.getFirstName().equals(firstName)
                    && person.getLastName().equals(lastName)) {
                return person;
            }
        } return null;
    }

//  CREATE
    public Person createPerson(Person person) throws IOException {
        if (personList.isEmpty()) {
            personList.addAll(this.getInitialPersonListFromJson());
        }
        Person personToCreate = new Person();
        personToCreate.setFirstName(person.getFirstName());
        personToCreate.setLastName(person.getLastName());
        personToCreate.setAddress(person.getAddress());
        personToCreate.setCity(person.getCity());
        personToCreate.setZip(person.getZip());
        personToCreate.setPhone(person.getPhone());
        personToCreate.setEmail(person.getEmail());
        personList.add(personToCreate);

        return person;
    }

//  UPDATE
//  TODO: do I keep a return boolean, or adding LOGGING, or something.
//   Person person représente deja la nouvelle personne a mettre a jour dans la base, n'est-ce pas?
//   Et puisqu'on considere q firstName et lastName restent constante, car ils sont les "id" a defaut d'en avoir ici,
//    on ne peut pas modifier ni firstName, ni lastName.
    public void updatePerson(Person person) throws IOException {
        if (personList.isEmpty()) {
            personList.addAll(this.getInitialPersonListFromJson());
        }

        for(Person p : personList) {
            if(p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {
                p.setAddress(person.getAddress());
                p.setCity(person.getCity());
                p.setZip(person.getZip());
                p.setPhone(person.getPhone());
                p.setEmail(person.getEmail());
            }
        }
    }

//  DELETE
    //  TODO: do I keep a return boolean, or adding LOGGING, or something?
    public void deletePerson(String firstName, String lastName) throws IOException {
        if (personList.isEmpty()) {
            personList.addAll(this.getInitialPersonListFromJson());
        }
//        TODO: insert error message if personToDelete not found!
        Person personToDelete = getOnePerson(firstName, lastName);
        personList.remove(personToDelete);
    }
//  These 2 solutions trows a java.util.ConcurrentModificationException, as when one element is removed, the list changes, so the iteration is no more valide!
//  One possible solution: start iteration from the end!

//  The following code uses Collection.removeIf :
//      personList.removeIf(person -> person.getFirstName().equals(firstName)
//                && person.getLastName().equals(lastName));
//  The previous code in more detail:
//      for(Person person : personList) {
//            if (person.getFirstName().equals(firstName)
//                    && person.getLastName().equals(lastName)) {
//                personList.remove(person);
//            }
//        }
}
