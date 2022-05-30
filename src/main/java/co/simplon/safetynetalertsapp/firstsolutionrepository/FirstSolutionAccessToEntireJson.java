package co.simplon.safetynetalertsapp.firstsolutionrepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class FirstSolutionAccessToEntireJson {

//  To put the "path" reference to the application.properties file! >>> "Separation of concerns"
    private final File file = new File("src/main/resources/data.json");

    final Logger LOGGER = LoggerFactory.getLogger(FirstSolutionAccessToEntireJson.class);

    final ObjectMapper mapper = new ObjectMapper();

    public JsonNode readJsonFile() {
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(file);
            //	Using the Logger to print out a message of success reading the onedata.json file:
            LOGGER.info("SUCCESS READING DATA.JSON");
        } catch (IOException e) {
            // Si il n'arrive pas a attraper le fichier, cela me retourne l'erreur
            LOGGER.error("FAIL READING DATA.JSON", e);
        }
//  jsonNode returns the entire data.json file as a huge String.
        return jsonNode;
    }
}
