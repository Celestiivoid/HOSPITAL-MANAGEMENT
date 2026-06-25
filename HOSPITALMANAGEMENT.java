import java.util.Scanner;
import java.util.ArrayList;

class PATIENT {
    String name;
    int age;
    String gender;
    String contactNumber;
    String address;
    String medicalHistory;
    int patientID;
}
public class HOSPITALMANAGEMENT {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<PATIENT> patient = new ArrayList<>();
    static int patientIDnumbers = 1001;
    public static void main(String[] args) {
        while(true) {
            System.out.println("=====HOSPITAL-MANAGEMENT-SYSTEM=====");
            System.out.println("[1] Patient Registration");
            System.out.println("[2] Appointment Booking");
            System.out.println("[3] Billing");
            System.out.println("[4] View Records");
            System.out.println("[5] Admin Panel");
            System.out.println("[6] Exit");

            System.out.println("Enter an option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option >= 7) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> REGISTRATIONMENU();
                case 2 -> APPOINTMENT();
                case 3 -> BILLING();
                case 4 -> RECORDS();
                case 5 -> ADMIN();
                case 6 -> {
                    while(true) {
                        System.out.println("Do you want to exit? (Yes/No)");
                        String exit = scanner.nextLine();

                        if(exit.equalsIgnoreCase("Yes")) {
                            return;
                        }
                        else if(exit.equalsIgnoreCase("No")) {
                            break;
                        }
                        else {
                            System.out.println("Invalid input.");
                        }
                    }
                }
            }
        }
    }
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

            if(!genderRegistration.equalsIgnoreCase("Male") && !genderRegistration.equalsIgnoreCase("Female")) {
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

            PATIENT patientRegistration = new PATIENT();
            patientRegistration.name = patientName;
            patientRegistration.age = ageRegistration;
            patientRegistration.gender = genderRegistration;
            patientRegistration.contactNumber = contactnumberRegistration;
            patientRegistration.address = addressRegistration;
            patientRegistration.medicalHistory = medicalhistoryRegistration;
            patientRegistration.patientID = patientIDnumbers++;
            patient.add(patientRegistration);
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

            for(PATIENT ptt : patient) {
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
                }
            }

            if(!findPatient) {
                System.out.println("Patient record not found.");
                return;
            }
        }
    }
    static void APPOINTMENT() {

    }
    static void BILLING() {

    }
    static void RECORDS() {

    }
    static void ADMIN() {

    }
}