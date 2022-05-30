package co.simplon.safetynetalertsapp.repositorytryout;

import co.simplon.safetynetalertsapp.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class DataJsonRepository {

    //	Adding a logger :
    private static final Logger LOGGER = LoggerFactory.getLogger(DataJsonRepository.class);

//    @Value("${json.file.location}")
    private File file;

    ObjectMapper mapper = new ObjectMapper();

//TODO: We need here a readAll() for the entire onedata.json, and probably a read(), as in rudi!
//    It is supposed to be the general acess file that all 3 others repository calls for individual readings!

    public List<Person> readAllPerson(File file, Class<Person> person) throws IOException {

        List<Person> personList = new ArrayList<>();
//	Premier argument : le chemin ou se trouve mon fichier Json
//	Deuxieme argument : je veux q tu me transformes les donnees recuperees en un objet de type que je veux, puis
//	.class, car c'est la classe q j'appelle
        try {
            personList = Arrays.asList(mapper.readValue(file, Person[].class));
//            personList.get("persons").toString();
            personList.toString();
            /*for(Person p : personList) {
                p.getFirstName(),
                p.getLastName(),
                p.getAddress(),
                p.getCity(),
                p.getZip(),
                p.getPhone(),
                p.getEmail();
            }*/
//	On peut ajouter cela:
			LOGGER.info("SUCCESS READING DATA.JSON");

        } catch (IOException e) {
            // Si il n'arrive pas a attraper le fichier, cela me retourne l'erreur
            // Si on utilise un logger, on mettra un message "Fichier non lu." ici avec
             LOGGER.error("FAIL READING", e); //probablement pas besoin du coup de la ligne après:
//            e.printStackTrace();
        }

        return personList;
    }
/*
    @Value("${json.file.location}")
    private File file;

//	Adding a logger:
	private static final Logger LOGGER = LoggerFactory.getLogger(DataJsonRepository.class);

    public DataJson readAll() {

        DataJson data = new DataJson();
//	library Jackson avec object mapper qui permet d'aller lire dans notre fichier Json
        ObjectMapper mapper = new ObjectMapper();
//	Premier argument : le chemin ou se trouve mon fichier Json
//	Deuxieme argument : je veux q tu me transformes les donnees recuperees en un objet de type que je veux, puis
//	.class, car c'est la classe q j'appelle
        try {
            data = mapper.readValue(file, DataJson.class);
//	On peut ajouter cela:
			LOGGER.info("SUCCESS READING DATA.JSON");

        } catch (IOException e) {
            // Si il n'arrive pas a attraper le fichier, cela me retourne l'erreur
            // Si on utilise un logger, on mettra un message "Fichier non lu." ici avec
             LOGGER.error("FAIL READING", e); //probablement pas besoin du coup de la ligne après:
//            e.printStackTrace();
        }

        return data;
    }
*/

/*

    private List<Person> persons = new ArrayList<Person>();

    public List<Person> getPersons(File file) {
         jsonIterator = JsonIterator
        return persons;
    }
*/

   /* public DataJson writeAll() {
        return null;
    }*/
}
