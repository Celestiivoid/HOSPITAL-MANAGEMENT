package HOSPITALMANAGEMENT;
import java.util.Scanner;
import java.util.ArrayList;

public class HospitalManagement {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Patient> patient = new ArrayList<>();
    static ArrayList<Doctor> doctor = new ArrayList<>();
    static ArrayList<Appointment> appointment = new ArrayList<>();
    static ArrayList<Bill> bill = new ArrayList<>();
    static int patientIDnumbers = 1001;
    static int doctorIDnumbers = 101;
    static int appointmentIDnumbers = 501;
    static int billingIDnumbers = 3001;
    static String adminName = "admin";
    static String adminPassword = "admin123";
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
                case 1 -> RegistrationService.REGISTRATION();
                case 2 -> AppointmentService.APPOINTMENTMENU();
                case 3 -> BillingService.BILLINGMENU();
                case 4 -> RECORDS();
                case 5 -> AdminService.ADMINLOGIN();
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
}