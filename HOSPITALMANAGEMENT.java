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
    int billID;
}
class DOCTOR {
    String name;
    String specialization;
    double consultationFee;
    String availability;
    int doctorID;
    double medicineFee;
    double laboratoryFee;
    double totalAmount;
    String status;
}
class BILL {
    
}
public class HOSPITALMANAGEMENT {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<PATIENT> patient = new ArrayList<>();
    static ArrayList<DOCTOR> doctor = new ArrayList<>();
    static int patientIDnumbers = 1001;
    static int doctorIDnumbers = 101;
    static int appointmentIDnumbers = 501;
    static int billingIDnumbers = 3001;
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
                case 2 -> APPOINTMENTMENU();
                case 3 -> BILLINGMENU();
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
    static void APPOINTMENTMENU() {
        while(true) {
            System.out.println("=====APPOINTMENT-MENU=====");
            System.out.println("[1] Book Appointment");
            System.out.println("[2] Cancel Appointment");
            System.out.println("[3] Back");

            System.out.println("Enter option: ");
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
                case 1 -> BOOKAPPOINTMENT();
                case 2 -> CANCELAPPOINTMENT();
                case 3 -> {
                    return;
                }
            }
        }
    }
    static void BOOKAPPOINTMENT() {
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

            doctorSequence = doctor.get(choose - 1);

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
                System.out.println("Appointment ID: " + appointmentIDnumbers);
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
                        patientSequence.appointmentID = appointmentIDnumbers++;
                        doctorSequence.status = "Unpaid";
                        doctorSequence.availability = "Unavailable";

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
    static void CANCELAPPOINTMENT() {
        while(true) {
            boolean findAppointment = false;
            System.out.println("=====CANCEL-APPOINTMENT=====");
            System.out.println("Enter Appointment ID: ");
            int appoID;

            try  {
                appoID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(appoID < 100 || appoID > 999) {
                System.out.println("3 Digits only.");
                continue;
            }

            for(PATIENT ptt: patient) {
                if(appoID == ptt.appointmentID) {
                    findAppointment = true;
                    System.out.println("Appointment Found.");
                    System.out.println("Patient: " + ptt.name);
                    System.out.println("Doctor: Dr. " + doctorSequence.name);
                    System.out.println("Status: " + ptt.appointmentStatus);
                }
            }

            if(!findAppointment) {
                System.out.println("Appointment not found.");
                continue;
            }

            System.out.println("Cancel appointment? ");
            System.out.println("[1] Yes");
            System.out.println("[2] No");

            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option >= 3) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 : {
                    patientSequence.appointmentStatus = "Cancelled";
                    for(DOCTOR dtr : doctor) {
                        if(doctorSequence.name.equals(dtr.name)) {
                            dtr.availability = "Available";
                            break;
                        }
                    }
                    System.out.println("Appointment cancelled successfully.");
                    System.out.println("Dr. " + doctorSequence.name + " is now available.");
                    return;
                }
                case 2 : {
                    return;
                }
            }
        }
    }
    static void BILLINGMENU() {
        while(true) {
            System.out.println("=====BILLING-MENU=====");
            System.out.println("[1] Generate Bill");
            System.out.println("[2] Pay Bill");
            System.out.println("[3] Back");

            System.out.println("Enter option: ");
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
                case 1 -> GENERATEBILL();
                case 2 -> PAYBILL();
                case 3 -> {
                    return;
                }
            }
        }
    }
    static void GENERATEBILL() {
        while(true) {
            double total = 0.0;
            boolean findID = false;
            System.out.println("=====GENERATE-BILL=====");
            System.out.println("Enter Appointment ID: ");
            int generateAppo;

            try {
                generateAppo = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(generateAppo < 100 || generateAppo > 999) {
                System.out.println("3 Digits only.");
            }

            for(PATIENT ptt: patient) {
                if(generateAppo  == ptt.appointmentID) {
                    findID = true;
                    System.out.println("Appointment ID found.");
                }
            }

            if(!findID) {
                System.out.println("Appointment ID not found.");
                continue;
            }

            System.out.println("Medicine Fee: ");
            double medFee;

            try {
                medFee = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(medFee <= 0.0) {
                System.out.println("Cannot validate 0 or negative numbers for medicine fee field.");
                continue;
            }

            System.out.println("Laboratory Fee:");
            double labFee;

            try {
                labFee = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(labFee <= 0.0) {
                System.out.println("Cannot validate 0 or negative numbers for laboratory fee field.");
                continue;
            }

            System.out.println("=====BILL-SUMMARY=====");
            System.out.println("Consultation Fee: " + doctorSequence.consultationFee);
            System.out.println("Medicine Fee:" + medFee);
            System.out.println("Laboratory Fee: " + labFee);
            System.out.println("=========================");
            total = doctorSequence.consultationFee + medFee + labFee;
            System.out.println("TOTAL: " + total);
            System.out.println("Payment Status: " + doctorSequence.status);

            System.out.println("\nConfirm Bill? ");
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option >= 3) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 : {
                    doctorSequence.medicineFee = medFee;
                    doctorSequence.laboratoryFee = labFee;
                    doctorSequence.totalAmount = total;
                    doctorSequence.status = "Pending Payment";
                    patientSequence.billID = billingIDnumbers++;
                    System.out.println("Bill generated successfully.");
                    System.out.println("Bill ID: " + "HPM" + patientSequence.billID);
                    return;
                }
                case 2 : {
                    return;
                }
            }
        }
    }
    static void PAYBILL() {
        while(true) {
            boolean billFind = false;
            double change = 0.0;
            System.out.println("=====PAY-BILL=====");
            System.out.println("Enter Bill ID: ");
            int billingID;

            try {
                billingID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(billingID < 3000 || billingID > 9999) {
                System.out.println("Invalid billing ID.");
                continue;
            }

            for(PATIENT ptt : patient) {
                if(billingID == ptt.billID) {
                    billFind = true;
                    System.out.println("Bill Found.");
                    System.out.println("Total Amount: " + doctorSequence.totalAmount);
                    System.out.println("===BREAKDOWN-OF-PAYMENT===");
                    System.out.println("Medicine Fee: " + doctorSequence.medicineFee);
                    System.out.println("Laboratory Fee: " + doctorSequence.laboratoryFee);
                    System.out.println("=========================");
                    System.out.println("Payment Status: " + doctorSequence.status);
                }
            }

            if(!billFind) {
                System.out.println("Bill not Found.");
                continue;
            }
            System.out.println("\nEnter Payment: ");
            double payment;

            try {
                payment = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(payment <= 0.0) {
                System.out.println("Cannot validate 0 or negative numbers for payment field.");
                continue;
            }

            if(payment < doctorSequence.totalAmount) {
                System.out.println("Insufficient payment.");
                continue;
            }

            change = payment - doctorSequence.totalAmount;
            doctorSequence.status = "Paid";
            System.out.println("Payment successful.");
            System.out.println("Change: " + change);
            return;
        }
    }
    static void RECORDS() {

    }
    static void VIEWPATIENT() {

    }
    static void VIEWDOCTORS() {

    }
    static void VIEWAPPOINTMENTS() {

    }
    static void VIEWBILLS() {

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