package HOSPITALMANAGEMENT;
import java.util.ArrayList;
import java.util.Scanner;

public class BillingService {
    static Scanner scanner = HospitalManagement.scanner;
    static ArrayList<PATIENT> patient = HospitalManagement.patient;
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
            APPOINTMENT found = null;
            System.out.println("=====GENERATE-BILL=====");
            System.out.println("Enter Appointment ID: ");
            int generateAppo;

            try {
                generateAppo = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(generateAppo < 500 || generateAppo > 999) {
                System.out.println("3 Digits only.");
            }

            for(APPOINTMENT app : HospitalManagement.appointment) {
                if(app.appointmentID == generateAppo) {
                found = app;
                System.out.println("Appointment ID found.");
                break;
                }
            }

            if(found == null) {
                System.out.println("Appointment ID not found.");
                continue;
            }

            for(BILL bl : HospitalManagement.bill) {
                if(bl.appointment == found) {
                    System.out.println("Billing for Appointment ID " + bl.appointment.appointmentID + " already exist.");
                    return;
                }
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
            System.out.println("Consultation Fee: " + found.doctor.doctorFee);
            System.out.println("Medicine Fee:" + medFee);
            System.out.println("Laboratory Fee: " + labFee);
            System.out.println("=========================");
            total = found.doctor.doctorFee + medFee + labFee;
            System.out.println("TOTAL: " + total);
            System.out.println("Payment Status: Unpaid");

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
                    BILL bl = new BILL();
                    bl.billID = HospitalManagement.billingIDnumbers++;
                    bl.medicineFee = medFee;
                    bl.appointment = found;
                    bl.laboratoryFee = labFee;
                    bl.totalAmount = total;
                    bl.consultationFee = found.doctor.doctorFee;
                    bl.status = "Unpaid";

                    HospitalManagement.bill.add(bl);

                    System.out.println("Bill generated successfully.");
                    System.out.println("Bill ID: " + "HPM" + bl.billID);
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
            BILL billFound = null;
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

            for(BILL bl: HospitalManagement.bill) {
                if(bl.billID == billingID) {
                billFound = bl;
                System.out.println("Bill Found.");
                System.out.println("Total Amount: " + billFound.totalAmount);
                System.out.println("===BREAKDOWN-OF-PAYMENT===");
                System.out.println("Medicine Fee: " + billFound.medicineFee);
                System.out.println("Laboratory Fee: " + billFound.laboratoryFee);
                System.out.println("=========================");
                System.out.println("Payment Status: " + billFound.status);
                }
            }

            if(billFound == null) {
                System.out.println("Bill not Found.");
                continue;
            }

            if(billFound.status.equals("Paid")) {
                System.out.println("This bill is already paid.");
                return;
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

            if(payment < billFound.totalAmount) {
                System.out.println("Insufficient payment.");
                continue;
            }

            change = payment - billFound.totalAmount;
            billFound.status = "Paid";
            System.out.println("Payment successful.");
            System.out.println("Change: " + change);
            return;
        }
    }
}
