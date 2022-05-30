package co.simplon.safetynetalertsapp.repositorytryout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MultipleArraysJsonAccess {

    File file = new File("src/main/resources/twoarraysdata.json");
    ObjectMapper mapper = new ObjectMapper();

    public <T> List<T> readList(File file, Class<T> itemType) throws IOException {
        file = this.file;
        if (file == null) {
            throw new FileNotFoundException("Ressource de type" + itemType.getSimpleName() + " introuvable au chemin : " + file);
        }
        //There is another way to work with, without getTypeFactory which is the modern way!
        CollectionType valueType = mapper.getTypeFactory().constructCollectionType(List.class, itemType);
        return mapper.readValue(file, valueType);
    }
}
