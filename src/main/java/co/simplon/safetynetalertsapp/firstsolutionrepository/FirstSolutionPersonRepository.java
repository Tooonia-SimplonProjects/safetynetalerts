package co.simplon.safetynetalertsapp.firstsolutionrepository;

import co.simplon.safetynetalertsapp.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstSolutionPersonRepository {

    List<Person> personList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

//    TODO: try/catch or "if()" bloc to add with LOGGER if success or failure?
    public List<Person> getPersonList() throws JsonProcessingException {

        FirstSolutionAccessToEntireJson firstSolutionAccessToEntireJson = new FirstSolutionAccessToEntireJson();
        Person[] person= objectMapper.readValue(firstSolutionAccessToEntireJson.readJsonFile().get("persons").toString(), Person[].class);
//  Converting the array into a list, and filling it with all the Person data. This method returns a list view of the specified array.
        personList = Arrays.asList(person);
//  Works also :
//      personList = Arrays.toString(person);

//  Prints out the default value of Array.toString() of the array, "[" for array, "L" for "List" element,
//  then the internal address of the array: [Lco.simplon.safetynetalertsapp.model.Person;@1844f12b :
//        System.out.println(person);
//  Prints out 23, as the number of Person Object inside the Person[] person array :
//        System.out.println(person.length);

        return personList;
    }
}
