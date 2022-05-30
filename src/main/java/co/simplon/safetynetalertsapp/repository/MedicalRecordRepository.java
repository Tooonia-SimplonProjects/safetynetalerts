package co.simplon.safetynetalertsapp.repository;

import co.simplon.safetynetalertsapp.model.MedicalRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordRepository {

    AccessToEntireJson accessToEntireJson = new AccessToEntireJson();
    List<MedicalRecord> medicalRecordList = new ArrayList<>();

    public List<MedicalRecord> getInitialMedicalRecordListFromJson() throws IOException {

        medicalRecordList = accessToEntireJson.readList("medicalrecords", MedicalRecord.class);
        return medicalRecordList;
    }

}
