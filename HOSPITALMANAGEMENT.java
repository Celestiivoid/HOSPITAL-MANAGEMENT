package HOSPITALMANAGEMENT;
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
    int appointmentID;
    String appointmentDate;
    String appointmentTime;
    String appointmentStatus;
}
class DOCTOR {
    String name;
    String specialization;
    double consultationFee;
    String availability;
    int doctorID;
}
public class HOSPITALMANAGEMENT {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<PATIENT> patient = new ArrayList<>();
    static ArrayList<DOCTOR> doctor = new ArrayList<>();
    static int patientIDnumbers = 1001;
    static int doctorIDnumbers = 101;
    static String adminName = "admin";
    static String adminPassword = "admin123";
    static DOCTOR doctorSequence;
    static PATIENT patientSequence;
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
                case 5 -> ADMINLOGIN();
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
                    return;
                }
            }

            if(!findPatient) {
                System.out.println("Patient record not found.");
                return;
            }
        }
    }
    static void APPOINTMENT() {
        while(true) {
            boolean findPatient = false;
            System.out.println("=====BOOK-APPOINTMENT=====");
            System.out.println("Enter Patient ID: ");
            int appointmentID;

            try {
                appointmentID = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(appointmentID < 1000 || appointmentID > 9999) {
                System.out.println("4 Digits only.");
                continue;
            }

            for(PATIENT ptt : patient) {
                if(appointmentID == ptt.patientID) {
                    patientSequence = ptt;
                    findPatient = true;
                    System.out.println("Patient ID found.");
                }
            }

            if(!findPatient) {
                System.out.println("Patient ID not found.");
                return;
            }

            for(int i = 0; i < doctor.size(); i++) {
                doctorSequence = doctor.get(i);
                System.out.println((i + 1) + ".) " 
                + " Dr. " + doctorSequence.name + " | " 
                + doctorSequence.specialization + " | " 
                + doctorSequence.availability);
            }

            System.out.println("Choose doctor: ");
            int choose = - 1;

            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(choose < 1 || choose > doctor.size()) {
                System.out.println("Out of range.");
                continue;
            }

            System.out.println("Date for appointment: Ex. (XX/XX/XXXX)");
            String appoDate = scanner.nextLine();

            if(!appoDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("Invalid date.");
                continue;
            }

            System.out.println("Time for appointment: Ex. (XX:XX(AM/PM))");
            String appoTime = scanner.nextLine();

            if(!appoTime.matches("\\d{2}:\\d{2}(AM|PM)")) {
                System.out.println("Invalid time.");
                continue;
            }

                System.out.println("=====APPOINTMENT-SUMMARY=====");
                System.out.println("Appointment ID: " + appointmentID);
                System.out.println("Patient: " + patientSequence.name);
                System.out.println("Doctor: " + doctorSequence.name);
                System.out.println("Specialization: " + doctorSequence.specialization);
                System.out.println("Date: " + appoDate);
                System.out.println("Time: " + appoTime);
                System.out.println("Status: Scheduled");

                System.out.println("Confirm Appointment? ");
                System.out.println("[1] Yes");
                System.out.println("[2] No");
                int confirmation;

                try {
                    confirmation = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only.");
                    continue;
                }

                if(confirmation < 1 || confirmation >= 3) {
                    System.out.println("Out of range.");
                    continue;
                }

                switch(confirmation) {
                    case 1 : {
                        patientSequence.appointmentStatus = "Scheduled";
                        patientSequence.appointmentDate = appoDate;
                        patientSequence.appointmentTime = appoTime;
                        System.out.println("Appointment scheduled successfully.");
                        return;
                    }
                    case 2 : {
                        System.out.println("Appointment schedule voided.");
                        return;
                    }
                }
        }
    }
    static void BILLING() {

    }
    static void RECORDS() {

    }
    static boolean ADMINLOGIN() {
        while(true) {
            System.out.println("=====ADMIN-LOGIN=====");
            System.out.println("USERNAME: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            System.out.println("PASSWORD: ");
            String pass = scanner.nextLine();
            
            if(pass.isEmpty()) {
                System.out.println("Password field cannot be empty.");
                continue;
            }

            if(name.equals(adminName) && pass.equals(adminPassword)) {
                System.out.println("Login successful!");
                ADMINMENU();
                return true;
            }
            else {
                System.out.println("Invalid credentials.");
                return false;
            }
        }
    }
    static void ADMINMENU() {
        while(true) {
            System.out.println("=====ADMIN-PANEL=====");
            System.out.println("[1] Add Doctor");
            System.out.println("[2] Remove Doctor");
            System.out.println("[3] Update Doctor Availability");
            System.out.println("[4] Hospital Revenue");
            System.out.println("[5] Back");

            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option >= 6) {
                System.out.println("Out of range.");
                continue;
            }
            switch(option) {
                case 1 -> ADD();
                case 2 -> REMOVE();
                case 3 -> UPDATE();
                case 4 -> REVENUE();
                case 5 -> {
                    return;
                }
            }
        }
    }
    static void ADD() {
        while(true) {
            System.out.println("=====ADD-DOCTOR=====");
            System.out.println("Doctor Name: ");
            String doctorName = scanner.nextLine();

            if(doctorName.isEmpty()) {
                System.out.println("Doctor field cannot be empty.");
                continue;
            }

            System.out.println("Specialization: ");
            String doctorSpecialization = scanner.nextLine();

            if(doctorSpecialization.isEmpty()) {
                System.out.println("Specialization field cannot be empty.");
                continue;
            }

            System.out.println("Consultation Fee: ");
            double doctorconsultationFee;

            try {
                doctorconsultationFee = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(doctorconsultationFee <= 0.0) {
                System.out.println("Cannot set 0 or negative numbers for consultation fee field.");
                continue;
            }

            System.out.println("Availability type: ");
            System.out.println("Available");
            System.out.println("Unavailable");
            System.out.println("On-Leave");
            System.out.println("Enter availability: ");
            String doctorAvailability = scanner.nextLine();

            if(doctorAvailability.isEmpty()) {
                System.out.println("Availability field cannot be empty.");
                continue;
            }
            if(doctorAvailability.equals("Available")
            || doctorAvailability.equals("Unavailable")
            || doctorAvailability.equals("On-Leave")){
            }
            else {
                System.out.println("Invalid availability type.");
                continue;
            }
            DOCTOR doctorAdd = new DOCTOR();
            doctorAdd.name = doctorName;
            doctorAdd.specialization = doctorSpecialization;
            doctorAdd.consultationFee = doctorconsultationFee;
            doctorAdd.availability = doctorAvailability;
            doctorAdd.doctorID = doctorIDnumbers++;
            doctor.add(doctorAdd);
            System.out.println("Doctor added successfully.");
            System.out.println("DOCTOR ID: " + "HPMD" + doctorAdd.doctorID);
            return;
        }
    }
    static void REMOVE() {
        while(true) {
            System.out.println("=====REMOVE-DOCTOR=====");

            if(doctor.isEmpty()) {
                System.out.println("No doctors assigned at the moment.");
                return;
            }

            for(int i = 0; i < doctor.size(); i++) {
                doctorSequence = doctor.get(i);
                System.out.println((i + 1) + ".) " 
                + "Dr. " + doctorSequence.name 
                + " | Specialization: " 
                + doctorSequence.specialization
                + " | Availability: " 
                + doctorSequence.availability);
            }

            System.out.println("Select a doctor to remove: ");
            int remove;

            try {
                remove = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(remove < 1 || remove > doctor.size()) {
                System.out.println("Out of range.");
                continue;
            }

            doctor.remove(remove - 1);
            System.out.println("Doctor removed successfully.");
            return;
        }
    }
    static void UPDATE() {
        while(true) {
            boolean doctorFind = false;
            System.out.println("=====UPDATE-AVAILABILITY=====");

            if(doctor.isEmpty()) {
                System.out.println("No doctors available at the moment.");
                return;
            }

            System.out.println("Enter Doctor ID: ");
            int doctorIDinput;

            try {
                doctorIDinput = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(doctorIDinput < 100 || doctorIDinput > 999) {
                System.out.println("3 Digits only.");
                continue;
            }
            for(DOCTOR dtr : doctor) {
                if(doctorIDinput == dtr.doctorID) {
                    doctorSequence = dtr;
                    doctorFind = true;
                    System.out.println("Doctor found.");
                    System.out.println("Doctor Name: " + dtr.name);
                    System.out.println("Doctor ID: " + "HPMD"+ dtr.doctorID);
                    System.out.println("Current Status: " + dtr.availability);
                }
            }

            if(!doctorFind) {
                System.out.println("Doctor not found.");
                return;
            }
            System.out.println("New status option: ");
            System.out.println("[1] Available");
            System.out.println("[2] Unavailable");
            System.out.println("[3] On-Leave");
            System.out.println("Pick new status: ");
            int status;

            try {
                status = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(status >= 4) {
                System.out.println("Out of range.");
                continue;
            }

            if(status == 1) {
                doctorSequence.availability = "Available";
            }
            else if(status == 2) {
                doctorSequence.availability = "Unavailable";
            }
            else if(status == 3) {
                doctorSequence.availability = "On-Leave";
            }
            
            System.out.println("Availability updated.");
            return;
        }
    }
    static void REVENUE() {

    }
}