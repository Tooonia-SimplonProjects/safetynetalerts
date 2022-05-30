package co.simplon.safetynetalertsapp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicalRecord {

    private String firstName;
    private String lastName;
    private String birthdate; //TODO should be date
    private List<String> medications = new ArrayList<>();
    private List<String> allergies = new ArrayList<>();
    private int age;


    public MedicalRecord(String firstName, String lastName, String birthdate, List<String> medications,
                         List<String> allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.medications = medications;
        this.allergies = allergies;
    }

    public MedicalRecord() {
    }

    //	Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    //	Add and remove medication and allergy
    // TODO: at Manel's: "MedicalRecord addMedication, return this". Why?
    // TODO: is it here to declare "add" and "return" methods???
    public void addMedication(String medication) {
        medications.add(medication);
    }

    public void removeMedication(String medication) {
        medications.remove(medication);
    }

    public void addAllergy(String allergy) {
        allergies.add(allergy);
    }

    public void removeAllergy(String allergy) {
        allergies.remove(allergy);
    }

//	Getting the age of a Person from birthdate
	public int getAge() throws ParseException{
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(this.birthdate);
        age = (int) ChronoUnit.YEARS.between((Temporal) dateOfBirth, LocalDate.now());
        return age;
	}

    @Override
    public String toString() {
        return "\n MedicalRecord {" +
                "firstName='" + firstName +
                "', lastName='" + lastName +
                "', birthdate='" + birthdate +
                "', medications='" + medications +
                "', allergies='" + allergies +
                "', age='" + age +
                "'}";
    }
}
