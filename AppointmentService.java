package HOSPITALMANAGEMENT;
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentService {
    static Scanner scanner = HospitalManagement.scanner;
    static ArrayList<PATIENT> patient = HospitalManagement.patient;
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
            PATIENT patientfound = null;
            System.out.println("=====BOOK-APPOINTMENT=====");
            System.out.println("Enter Patient ID: ");
            int patientID;

            try {
                patientID = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(patientID < 1000 || patientID > 9999) {
                System.out.println("4 Digits only.");
                continue;
            }

            for(PATIENT ptt : patient) {
                if(ptt.patientID == patientID) {
                    patientfound = ptt;
                    System.out.println("Patient ID found.");
                    break;
                }
            }

            if(patientfound == null) {
                System.out.println("Patient ID not found.");
                return;
            }

            for(int i = 0; i < HospitalManagement.doctor.size(); i++) {
                DOCTOR dtr = HospitalManagement.doctor.get(i);
                System.out.println((i + 1) + ".) " 
                + " Dr. " + dtr.name + " | " 
                + dtr.specialization + " | " 
                + dtr.availability);
            }

            System.out.println("Choose doctor: ");
            int choose = - 1;

            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(choose < 1 || choose > HospitalManagement.doctor.size()) {
                System.out.println("Out of range.");
                continue;
            }

            DOCTOR doctorfound = HospitalManagement.doctor.get(choose - 1);

            if(doctorfound.availability.equalsIgnoreCase("Unavailable")) {
                System.out.println("Dr. " + doctorfound.name + " is currently unavailable." );
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
                System.out.println("Appointment ID: " + HospitalManagement.appointmentIDnumbers);
                System.out.println("Patient: " + patientfound.name);
                System.out.println("Doctor: " + doctorfound.name);
                System.out.println("Specialization: " + doctorfound.specialization);
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
                        APPOINTMENT app = new APPOINTMENT();
                        app.patient = patientfound;
                        app.appointmentStatus = "Scheduled";
                        app.doctor = doctorfound;
                        app.patient = patientfound;
                        app.appointmentDate = appoDate;
                        app.appointmentTime = appoTime;
                        app.appointmentID = HospitalManagement.appointmentIDnumbers++;
                        HospitalManagement.appointment.add(app);

                        doctorfound.availability = "Unavailable";
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
            APPOINTMENT found = null;
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

            for(APPOINTMENT app : HospitalManagement.appointment) {
                if(app.appointmentID == appoID) {
                    found = app;
                    System.out.println("Appointment Found.");
                    System.out.println("Patient: " + found.patient.name);
                    System.out.println("Doctor: Dr. " + found.doctor.name);
                    System.out.println("Status: " + found.appointmentStatus);
                }
            }

            if(found == null) {
                System.out.println("Appointment not found.");
                continue;
            }

            if(found.appointmentStatus.equals("Cancelled")) {
                System.out.println("Appointment " + found.appointmentID + " is already cancelled.");
                return;
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
                    found.appointmentStatus = "Cancelled";
                    found.doctor.availability = "Available";

                    System.out.println("Appointment cancelled successfully.");
                    System.out.println("Dr. " + found.doctor.name + " is now available.");
                    return;
                }
                case 2 : {
                    return;
                }
            }
        }
    }
}
