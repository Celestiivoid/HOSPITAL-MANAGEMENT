package HOSPITALMANAGEMENT;
import java.util.Scanner;

public class RecordService {
    static Scanner scanner = new Scanner(System.in);

    static void RECORDS() {
        while(true) {
            System.out.println("=====VIEW-RECORDS=====");
            System.out.println("[1] View Patients");
            System.out.println("[2] View Doctors");
            System.out.println("[3] View Appointments");
            System.out.println("[4] View Bills");
            System.out.println("[5] Back");

            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > 5) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> VIEWPATIENT();
                case 2 -> VIEWDOCTORS();
                case 3 -> VIEWAPPOINTMENTS();
                case 4 ->VIEWBILLS();
                case 5 -> {
                    return;
                }
            }
        }
    }
    static void VIEWPATIENT() {
            System.out.println("=====PATIENT-RECORDS=====");

            if(HospitalManagement.patient.isEmpty()) {
                System.out.println("No patient records at the moment.");
                return;
            }

            for(int i = 0; i < HospitalManagement.patient.size(); i++) {
                Patient ptt = HospitalManagement.patient.get(i);
                System.out.println((i + 1) + ".) " + " ID: HPM-" + ptt.patientID + " | " + ptt.name + " | " + ptt.age);
            }
    }
    static void VIEWDOCTORS() {
        System.out.println("=====DOCTOR-RECORDS=====");

        if(HospitalManagement.doctor.isEmpty()) {
            System.out.println("No doctor records at the moment.");
            return;
        }
        
        for(int i = 0; i < HospitalManagement.doctor.size(); i++) {
            Doctor dtr = HospitalManagement.doctor.get(i);
            System.out.println((i + 1) + ".) " + " Dr. " + dtr.name + " | " + dtr.specialization + " | " + dtr.availability);
        }
    }
    static void VIEWAPPOINTMENTS() {
        Appointment app = null;
        System.out.println("=====VIEW-APPOINTMENTS-RECORDS=====");

        if(HospitalManagement.appointment.isEmpty()) {
            System.out.println("No appointment records at the moment.");
            return;
        }

        for(int i = 0; i < HospitalManagement.appointment.size(); i++) {
            app = HospitalManagement.appointment.get(i);
            System.out.println((i + 1) + ".) " + " Appointment ID: " + app.appointmentID 
            + "\n Patient: " + app.patient.name
            + "\nDoctor: " + app.doctor.name
            + "\nStatus: " + app.appointmentStatus);
        }
    }
    static void VIEWBILLS() {
        Bill bl = null;
        Appointment app = null;
        double overallTotal = 0.0;
        double unpaidTotal = 0.0;
        double paidTotal = 0.0;
        System.out.println("=====BILLING-RECORDS=====");

        if(HospitalManagement.bill.isEmpty()) {
            System.out.println("No billing records at the moment.");
            return;
        }

        for(int i = 0; i < HospitalManagement.bill.size(); i++) {
            app = HospitalManagement.appointment.get(i);
            bl = HospitalManagement.bill.get(i);
            System.out.println((i + 1) + ".) " 
            + "\n Bill ID: " + bl.billID
            + "\n Patient ID: " + app.patient.patientID 
            + "\n Appointment ID: " + app.appointmentID
            + "\n Total: " + bl.totalAmount 
            + "\n Status: " + bl.status);
        }

        for(Bill bll : HospitalManagement.bill) {
            if(bll.status.equals("Unpaid")) {
                unpaidTotal += bl.totalAmount;
            }
        }
        for(Bill bll : HospitalManagement.bill) {
            if(bll.status.equals("Paid")) {
                paidTotal += bl.totalAmount;
            }
        }
        overallTotal = unpaidTotal += paidTotal;
        System.out.println("=========================");
        System.out.println("UNPAID TOTAL: " + unpaidTotal);
        System.out.println("PAID TOTAL: " + paidTotal);
        System.out.println("OVERALL TOTAL: " + overallTotal);
        System.out.println("=========================");
    }
}
