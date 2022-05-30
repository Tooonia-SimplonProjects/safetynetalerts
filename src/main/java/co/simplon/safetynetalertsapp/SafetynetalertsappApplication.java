package co.simplon.safetynetalertsapp;

import co.simplon.safetynetalertsapp.repository.*;
import co.simplon.safetynetalertsapp.repositorytryout.OneArrayJsonAccessCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SafetynetalertsappApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(SafetynetalertsappApplication.class, args);

//  Code that works with one JSON Array of multiple JSON Objects [{"fisrtName":...},...] :
		OneArrayJsonAccessCode test = new OneArrayJsonAccessCode();
		System.out.println(test.getPersonList());

//  Code for Two arrays' JSON: TODO
		/*TwoArraysJsonAccessCode test = new TwoArraysJsonAccessCode();
		System.out.println(test.getPersonList());*/

//	Code for MultipleArraysJsonAccess: TODO
//		MultipleArraysJsonAccess testAccess = new MultipleArraysJsonAccess();
//		File file = new File("src/main/resources/twoarraysdata.json");
//		List<Person> persons = testAccess.readList(file, Person.class);
//		System.out.println(persons);
//		List<FireStation> fireStations = testAccess.readList(file, FireStation.class);
//					But adding the following line, it converts the array into a list, and fill it with all the Person data:
//                  = This method returns a list view of the specified array.
//		personList = new ArrayList(Arrays.asList(person));

//		---------------------------------------------

//	My 3 working calling methods of 1st solutions:
//		FirstSolutionPersonRepository firstSolutionPersonRepository = new FirstSolutionPersonRepository();
//		System.out.println(firstSolutionPersonRepository.getPersonList());
//
//		FirstSolutionFireStationRepository firstSolutionFireStationRepository = new FirstSolutionFireStationRepository();
//		System.out.println(firstSolutionFireStationRepository.getFireStationList());
//
//		FirstSolutionMedicalRecordRepository firstSolutionMedicalRecordRepository = new FirstSolutionMedicalRecordRepository();
//		System.out.println(firstSolutionMedicalRecordRepository.getMedicalRecordList());

//		---------------------------------------------

//	The generic solution with less code:
//		PersonRepository personRepository = new PersonRepository();
//		System.out.println(personRepository.getInitialPersonListFromJson());
//
//		FireStationRepository fireStationRepository = new FireStationRepository();
//		System.out.println(fireStationRepository.getFireStationList());
//
//		MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();
//		System.out.println(medicalRecordRepository.getMedicalRecordList());

//		---------------------------------------------


//		PersonService personService = null;
//		System.out.println(personService.deletePerson("Jacob", "Boyd"));



//
////		To put the "path" reference to the application.properties file! >>> Separation of concerns!
//		File file = new File("src/main/resources/onedata.json");
//
//		final Logger LOGGER = LoggerFactory.getLogger(SafetynetalertsappApplication.class);
//
//		ObjectMapper mapper = new ObjectMapper();
//
//		List<Person> personList = new ArrayList<>();
////	Dans readValue() :
////		Premier argument : le chemin ou se trouve mon fichier Json
////		Deuxieme argument : je veux q tu me transformes les donnees recuperees en un objet de type que je veux, puis
////			.class, car c'est la classe q j'appelle
//			try {
//
////	The following code works fine!*/
////				personList = mapper.readValue(file, new TypeReference<List<Person>>() {});
////	Another try without TypeReference<>.
////					If I only add the following line, it returns me an empty array [], but SUCCESS READING DATA.JSON:
////					This is the ex. when onedata.json is juste in [ {"firstName": ...} ... ] format.
//				Person[] person= mapper.readValue(file, Person[].class);
////					But adding the following line, it converts the array into a list, and fill it with all the Person data:
//				personList = new ArrayList(Arrays.asList(person)); //TODO: works also as "new ArrayList<>(...);
//				personList.toString(); // TODO: I still read the file with or without that line.
////
////	Using the Logger to print out a message of success reading the onedata.json file:
//				LOGGER.info("SUCCESS READING DATA.JSON");
//
//			} catch (IOException e) {
//				// Si il n'arrive pas a attraper le fichier, cela me retourne l'erreur
//				// Si on utilise un logger, on mettra un message "Fichier non lu." ici avec
//				LOGGER.error("FAIL READING", e); //probablement pas besoin du coup de la ligne après:
////            e.printStackTrace();
//			}
//
//		System.out.println(personList);
//		System.out.println(file);
//	}


		/*
		* personList.get("persons").toString();
		*
//          /*for(Person p : personList) {
//              p.getFirstName(),
//              p.getLastName(),
//              p.getAddress(),
//              p.getCity(),
//              p.getZip(),
//               p.getPhone(),
//              p.getEmail();
//          }*/
	}
}
