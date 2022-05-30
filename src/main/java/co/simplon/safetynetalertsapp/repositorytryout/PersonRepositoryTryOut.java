package co.simplon.safetynetalertsapp.repositorytryout;

import co.simplon.safetynetalertsapp.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonRepositoryTryOut {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRepositoryTryOut.class);

    private DataJsonRepository dataJsonRepository;

    public List<Person> getList() throws IOException {
        List<Person> personList;
//      personList = JsonIterator
        personList = this.dataJsonRepository.readAllPerson(new File("src/main/resources/onedata.json"), Person.class);
//        for(Person p : personList) {
//            p.getFirstName(),
//            p.getLastName();
//        }
//
//
//        ).forEach();
        return personList;
    }


}
