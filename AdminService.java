package HOSPITALMANAGEMENT;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {
    static Scanner scanner = HospitalManagement.scanner;
    static ArrayList<PATIENT> patient = HospitalManagement.patient;
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

            if(name.equals(HospitalManagement.adminName) && pass.equals(HospitalManagement.adminPassword)) {
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
            double doctoconsultationFee;

            try {
                doctoconsultationFee = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(doctoconsultationFee <= 0.0) {
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
            doctorAdd.doctorFee = doctoconsultationFee;
            doctorAdd.availability = doctorAvailability;
            doctorAdd.doctorID = HospitalManagement.doctorIDnumbers++;
            HospitalManagement.doctor.add(doctorAdd);
            System.out.println("Doctor added successfully.");
            System.out.println("DOCTOR ID: " + "HPMD" + doctorAdd.doctorID);
            return;
        }
    }
    static void REMOVE() {
        while(true) {
            System.out.println("=====REMOVE-DOCTOR=====");

            if(HospitalManagement.doctor.isEmpty()) {
                System.out.println("No doctors assigned at the moment.");
                return;
            }

            for(int i = 0; i < HospitalManagement.doctor.size(); i++) {
                DOCTOR dtr = HospitalManagement.doctor.get(i);
                System.out.println((i + 1) + ".) " 
                + "Dr. " + dtr.name 
                + " | Specialization: " 
                + dtr.specialization
                + " | Availability: " 
                + dtr.availability);
            }

            System.out.println("Select a doctor to remove: ");
            int remove;

            try {
                remove = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(remove < 1 || remove > HospitalManagement.doctor.size()) {
                System.out.println("Out of range.");
                continue;
            }

            HospitalManagement.doctor.remove(remove - 1);
            System.out.println("Doctor removed successfully.");
            return;
        }
    }
    static void UPDATE() {
        while(true) {
            boolean doctorFind = false;
            DOCTOR findDoctor = null;
            System.out.println("=====UPDATE-AVAILABILITY=====");

            if(HospitalManagement.doctor.isEmpty()) {
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
            for(DOCTOR dtr : HospitalManagement.doctor) {
                if(doctorIDinput == dtr.doctorID) {
                    findDoctor = dtr;
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
                findDoctor.availability = "Available";
            }
            else if(status == 2) {
                findDoctor.availability = "Unavailable";
            }
            else if(status == 3) {
                findDoctor.availability = "On-Leave";
            }
            
            System.out.println("Availability updated.");
            return;
        }
    }
    static void REVENUE() {

    }
}
