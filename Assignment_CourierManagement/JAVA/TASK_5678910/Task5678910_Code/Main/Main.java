package Main;

import Entities.Courier;
import Entities.Employee;
import Exception.InvalidEmployeeIdException;
import Exception.TrackingNumberNotFoundException;
import Exception.Withdraw_Transfer;
import Interface.CourierAdminService;
import Interface.CourierUserService;
import Interface.ICourierAdminService;
import Interface.ICourierUserService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import static Exception.IDCheck.checkEmployeeid;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome!!\nBoth User service and Admin service are available");
        System.out.println("USER\n1.Place Order\n2.Get Order Status\n3.Cancel Order\n4.Get Details of Assigned Order" +
                           "\nADMIN\n1.Add New Courier Staff");
            //Instantiation of CourierUserService to Interface
            ICourierUserService service = new CourierUserService();

            //Usage of Place Order Method
            System.out.println("Enter Courier ID: ");
            int courierID = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Sender Name: ");
            String senderName = sc.nextLine();

            System.out.println("Enter Sender Address: ");
            String senderAddress = sc.nextLine();

            System.out.println("Enter Receiver Name: ");
            String receiverName = sc.nextLine();

            System.out.println("Enter Receiver Address: ");
            String receiverAddress = sc.nextLine();

            System.out.println("Enter Package Weight (kg): ");
            double weight = sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter Courier Status: ");
            String status = sc.nextLine();
            String trackingNumber = null;


            //Formatting date after 7 days from current date
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
            Date deliverydate = new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000);
            String date = dateFormat.format(deliverydate);

            Courier courier = new Courier(courierID, senderName, senderAddress, receiverName, receiverAddress, weight, status, trackingNumber, deliverydate);

            System.out.println("Your Order has been Placed Successfully!!\n Here is your Order Tracking Number " + service.placeOrder(courier));
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            //Calendar class should only be called using getInstance Method
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(2024, Calendar.DECEMBER, 20);
            Date deliveryDate1 = calendar1.getTime();

            Courier courier1 = new Courier(
                    2, "Vikram R", "KK Nagar, Madurai, Tamil Nadu",
                    "Divya Shree", "Sathyamangalam, Erode, Tamil Nadu",
                    1.75, "Delivered", null, deliveryDate1);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------
            //Usage of Get Order Status Method

            System.out.println("The Order Status of the Placed Order is " + service.getOrderStatus(courier));

            System.out.println("---------------------------------------------------------------------------------------------------------------");

            //Usage of cancel order method

            System.out.println("It seems like you are not Interested to Continue the Delivery Process.\nIf you want to cancel the Order then Enter the Tracking Number)");
            trackingNumber = sc.next();
            //checks for boolean value from cancelOrder()
            if (service.cancelOrder(courier, trackingNumber))
                System.out.println("Your Order has been Cancelled");
            else
                System.out.println("The Tracking Number not found.Please Enter Correct Number");
            System.out.println("---------------------------------------------------------------------------------------------------------------");

            //Method to get details of the assigned Order

            Employee employee1 = new Employee(101, "Arun B", "arun156@email.com", "9876543210", "Admin", 90000.00);
            Employee employee2 = new Employee(102, "Raj Velan K", "raj@email.com", "9868454898", "Courier Manager", 70000.00);

            System.out.println("The Couriers assigned to specific Employee is Listed Below");
            System.out.println(service.getAssignedOrderMap(courier, employee1.getEmployeeID()));
            System.out.println(service.getAssignedOrderMap(courier1, employee1.getEmployeeID()));
            System.out.println("---------------------------------------------------------------------------------------------------------------");


        //Instantiation of  CourierAdminService to Interface
        ICourierAdminService adminservice=new CourierAdminService();

        //Adding new Courier Staff

        Employee newemp= new Employee(0,"Ragavi S",null,"8403958498",null,0.0);
        System.out.println("Employee ID for new Employee: "+adminservice.addCourierStaff(newemp));
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        //Checks for InvalidEmployeeIdException
        Set<Integer> employeeidset=new HashSet<>();
        employeeidset.add(employee1.getEmployeeID());
        employeeidset.add(employee2.getEmployeeID());

        System.out.println("Enter Employee ID to fetch Employee Details");
        int empid=sc.nextInt();
        try
        {

            checkEmployeeid(empid,employeeidset);
        }
        catch (InvalidEmployeeIdException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Employee ID validation process completed.");
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        //Checks for Tracking Number not found exception
        System.out.println("Select Any one Option Withdraw or Transfer\nEnter 1 for Withdraw\nEnter 2 for Transfer");
        int num=sc.nextInt();
        double balance = 14000;
        //Withdrawing
        if(num==1) {
            System.out.println("Your Balance is " + balance + "Enter the amount for Withdraw: ");
            double amount = sc.nextDouble();
            try {
                Withdraw_Transfer.Withdraw(balance, amount, courier);
            } catch (TrackingNumberNotFoundException e) {
                System.out.println(e.getMessage());
            }finally {
                System.out.println("Withdrawal process completed.");
            }
        }
        //Transfering
        else {
            System.out.println("Your Balance is " + balance + "Enter the amount for Transfer: ");
            double amount1 = sc.nextDouble();
            try {
                Withdraw_Transfer.transfer(balance, amount1);

            } catch (TrackingNumberNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Transfer process completed.");
            }
        }
    }
}
