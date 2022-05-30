package co.simplon.safetynetalertsapp.firstsolutionrepository;

import co.simplon.safetynetalertsapp.model.FireStation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstSolutionFireStationRepository {

    List<FireStation> fireStationList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    public List<FireStation> getFireStationList() throws JsonProcessingException {

        FirstSolutionAccessToEntireJson firstSolutionAccessToEntireJson = new FirstSolutionAccessToEntireJson();
        FireStation[] fireStation = objectMapper.readValue(firstSolutionAccessToEntireJson.readJsonFile().get("firestations").toString(), FireStation[].class);
//  Converting the array into a list, and filling it with all the FireStation data. This method returns a list view of the specified array.
        fireStationList = Arrays.asList(fireStation);

        return fireStationList;
    }
}
