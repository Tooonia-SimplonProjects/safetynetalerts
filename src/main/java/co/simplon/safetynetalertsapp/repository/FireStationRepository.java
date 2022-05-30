package co.simplon.safetynetalertsapp.repository;

import co.simplon.safetynetalertsapp.model.FireStation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FireStationRepository {

    AccessToEntireJson accessToEntireJson = new AccessToEntireJson();
    List<FireStation> fireStationList = new ArrayList<>();

    public List<FireStation> getInitialFireStationListFromJson() throws IOException {

        fireStationList = accessToEntireJson.readList("firestations", FireStation.class);
        return fireStationList;
    }
}
