package co.simplon.safetynetalertsapp.firstsolutionrepository;

import co.simplon.safetynetalertsapp.model.MedicalRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstSolutionMedicalRecordRepository {

    List<MedicalRecord> medicalRecordList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    public List<MedicalRecord> getMedicalRecordList() throws JsonProcessingException {

        FirstSolutionAccessToEntireJson firstSolutionAccessToEntireJson = new FirstSolutionAccessToEntireJson();
        MedicalRecord[] medicalRecord = objectMapper.readValue(firstSolutionAccessToEntireJson.readJsonFile().get("medicalrecords").toString(), MedicalRecord[].class);
//  Converting the array into a list, and filling it with all the MedicalRecord data. This method returns a list view of the specified array.
        medicalRecordList = Arrays.asList(medicalRecord);

        return medicalRecordList;
    }
}
