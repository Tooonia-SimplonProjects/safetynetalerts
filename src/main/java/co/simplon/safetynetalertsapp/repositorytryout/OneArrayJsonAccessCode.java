package co.simplon.safetynetalertsapp.repositorytryout;

import co.simplon.safetynetalertsapp.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneArrayJsonAccessCode {
    File file = new File("src/main/resources/onedata.json");
    final Logger LOGGER = LoggerFactory.getLogger(OneArrayJsonAccessCode.class);

    ObjectMapper mapper = new ObjectMapper();
    List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        try {
		    Person[] person= mapper.readValue(file, Person[].class);
            personList = new ArrayList(Arrays.asList(person));

            LOGGER.info("SUCCESS READING DATA.JSON");
        } catch (IOException e) {
            LOGGER.error("FAIL READING", e);
        }

		return personList;
    }
}
