package co.simplon.safetynetalertsapp.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

//TODO: or @Repository?
@Component
public class AccessToEntireJson {

    private final File file = new File("src/main/resources/data.json");
    final Logger LOGGER = LoggerFactory.getLogger(AccessToEntireJson.class);
    final ObjectMapper mapper = new ObjectMapper();

    public <T> List<T> readList(String path, Class<T> itemType) throws IOException {

        JsonNode jsonNode;
        CollectionType object;
        List<T> objectsList = null;
        try {
            jsonNode = mapper.readTree(file);
            object = mapper.getTypeFactory().constructCollectionType(List.class, itemType);
            objectsList = mapper.readValue(jsonNode.get(path).toString(), object);

            LOGGER.info("SUCCESS READING DATA.JSON");
        } catch (IOException e) {
            LOGGER.error("FAIL READING DATA.JSON", e);
        }
        return objectsList;
   }
}
