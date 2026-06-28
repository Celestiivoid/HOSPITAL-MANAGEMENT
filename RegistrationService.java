package HOSPITALMANAGEMENT;
import java.util.Scanner;

public class RegistrationService {
    static Scanner scanner = HospitalManagement.scanner;

    static void REGISTRATIONMENU() {
        while(true) {
            System.out.println("=====PATIENT-REGISTRATION=====");
            System.out.println("[1] Register Patient");
            System.out.println("[2] Search Patient");
            System.out.println("[3] Back");

            System.out.println("Enter an option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option >= 4) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> REGISTRATION();
                case 2 -> SEARCH();
                case 3 -> {
                    return;
                }
            }
        }
    }
    static void REGISTRATION() {
        while(true) {

            System.out.println("=====REGISTER-PATIENT=====");
            System.out.println("Patient name: ");
            String patientName = scanner.nextLine();

            if(patientName.isEmpty()) {
                System.out.println("Patient field cannot be empty.");
                continue;
            }

            System.out.println("Age: ");
            int ageRegistration;

            try {
                ageRegistration = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(ageRegistration <= 0) {
                System.out.println("Cannot validate 0 or negative numbers for age field.");
                continue;
            }

            System.out.println("Gender: ");
            String genderRegistration = scanner.nextLine();

            if(genderRegistration.isEmpty()) {
                System.out.println("gender field cannot be empty.");
                continue;
            }

            if(!genderRegistration.equalsIgnoreCase("Male") 
                && !genderRegistration.equalsIgnoreCase("Female")) {
                System.out.println("Invalid gender.");
                continue;
            }

            System.out.println("Contact number: ");
            String contactnumberRegistration = scanner.nextLine();

            if(contactnumberRegistration.isEmpty()) {
                System.out.println("Contact number field cannot be empty.");
                continue;
            }

            if(!contactnumberRegistration.matches("\\d{11}")) {
                System.out.println("Must be 11 digits only.");
                continue;
            }

            System.out.println("Address: ");
            String addressRegistration = scanner.nextLine();

            if(addressRegistration.isEmpty()) {
                System.out.println("Address field cannot be empty.");
                continue;
            }

            System.out.println("Medical history: ");
            String medicalhistoryRegistration = scanner.nextLine();

            if(medicalhistoryRegistration.isEmpty()) {
                System.out.println("Medical history field cannot be empty.");
                continue;
            }

            Patient patientRegistration = new Patient();
            patientRegistration.name = patientName;
            patientRegistration.age = ageRegistration;
            patientRegistration.gender = genderRegistration;
            patientRegistration.contactNumber = contactnumberRegistration;
            patientRegistration.address = addressRegistration;
            patientRegistration.medicalHistory = medicalhistoryRegistration;
            patientRegistration.patientID = HospitalManagement.patientIDnumbers++;
            HospitalManagement.patient.add(patientRegistration);
            System.out.println("PATIENT REGISTRATION SUCCESSFUL");
            System.out.println("PATIENT ID: " + "HPM-" + patientRegistration.patientID);
            return;
        }
    }
    static void SEARCH() {
        while(true) {
            boolean findPatient = false;
            System.out.println("=====SEARCH-PATIENT=====");
            System.out.println("Enter Patient ID: ");
            int patientSearch;

            try {
                patientSearch = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(patientSearch < 1000 || patientSearch > 9999) {
                System.out.println("4 digits only.");
                continue;
            }

            for(Patient ptt : HospitalManagement.patient) {
                if(patientSearch == ptt.patientID) {
                    findPatient = true;
                    System.out.println("Patient found.");
                    System.out.println("=====PATIENT-RECORD=====");
                    System.out.println("Patient ID: " + "HPM" + ptt.patientID);
                    System.out.println("Patient Name: " + ptt.name);
                    System.out.println("Patient Age: " + ptt.age);
                    System.out.println("Patient Gender: " + ptt.gender);
                    System.out.println("Patient Contact Number: " + ptt.contactNumber);
                    System.out.println("Patient Address: " + ptt.address);
                    System.out.println("Patient Medical History: " + ptt.medicalHistory);
                    return;
                }
            }

            if(!findPatient) {
                System.out.println("Patient record not found.");
                return;
            }
        }
    }
}
