package co.simplon.safetynetalertsapp.repositorytryout;

import co.simplon.safetynetalertsapp.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TwoArraysJsonAccessCode {


//    When using a onedata.json in this format : { "persons": [ { "firstName":... }... ], "firestations": [...] }

    File file = new File("src/main/resources/twoarraysdata.json");

    final Logger LOGGER = LoggerFactory.getLogger(TwoArraysJsonAccessCode.class);

    private ObjectMapper mapper = new ObjectMapper();

//    TODO: readAll() method








//    TODO: read() only "persons" or "firestations"


    String json = "persons";
//    J jsonpObject = new JSONObject();

//    @JsonProperty
    List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        try {

//	The following code works fine!*/
//				personList = mapper.readValue(file, new TypeReference<List<Person>>() {});
//	Another try without TypeReference<>.
//					If I only add the following line, it returns me an empty array [], but SUCCESS READING DATA.JSON:
//					This is the ex. when onedata.json is juste in [ {"firstName": ...} ... ] format.
            CollectionType allJsonFile= mapper.readValue(file, CollectionType.class);

//					But adding the following line, it converts the array into a list, and fill it with all the Person data:
//            personList = new Array(Arrays.asList(person).iterator()); //TODO: works also as "new ArrayList<>(...);" or "new ArrayList(...);"
//            personList.get("persons").toString();
//				personList.toString(); // TODO: I still read the file with or without that line.
            /*for(Person p : personList) {
                p.getFirstName(),
                p.getLastName(),
                p.getAddress(),
                p.getCity(),
                p.getZip(),
                p.getPhone(),
                p.getEmail();
            }*/
//	Using the Logger to print out a message of success reading the onedata.json file:
            LOGGER.info("SUCCESS READING DATA.JSON");

        } catch (IOException e) {
            // Si il n'arrive pas a attraper le fichier, cela me retourne l'erreur
            // Si on utilise un logger, on mettra un message "Fichier non lu." ici avec
            LOGGER.error("FAIL READING", e); //probablement pas besoin du coup de la ligne après:
//            e.printStackTrace();
        }
//    Returns an empty array, and message exception "FAIL READIND!!!
        System.out.println(personList);
        System.out.println(file);
        return personList;
    }
}
