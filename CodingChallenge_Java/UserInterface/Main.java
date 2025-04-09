package UserInterface;

import DAO.ILoanRepositoryImpl;
import Entity.Customer;
import Entity.Loan;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);

            System.out.println("Enter appropriate Option to perform action");
            System.out.println("Enter 1 : Apply Loan\n" +
                    "Enter 2 : Calculate Interest\n" +
                    "Enter 3 : Get Loan STatus\n" +
                    "Enter 4 : Calculate EMI\n" +
                    "Enter 5 : Loan Repayment\n" +
                    "Enter 6 : Get All Loans\n" +
                    "Enter 7 : Get LOans of Lo3an ID\n" +
                    "Enter 8 : TO Exit");
            int choice = sc.nextInt();
            //instantiation
            ILoanRepositoryImpl service = new ILoanRepositoryImpl();
            //to apply loan
            if (choice == 1) {
                //Gte customer details because of reference object
                System.out.print("Enter Customer ID: ");
                int customerId = sc.nextInt();
                sc.nextLine(); // consume newline

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email Address: ");
                String email = sc.nextLine();

                System.out.print("Enter Phone Number: ");
                String phone = sc.nextLine();

                System.out.print("Enter Address: ");
                String address = sc.nextLine();

                System.out.print("Enter Credit Score: ");
                int creditScore = sc.nextInt();

                // Create Customer object
                Customer customer = new Customer(customerId, name, email, phone, address, creditScore);

                // Get loan details
                System.out.print("Enter Loan ID: ");
                int loanId = sc.nextInt();

                System.out.print("Enter Principal Amount: ");
                double principal = sc.nextDouble();

                System.out.print("Enter Interest Rate: ");
                double interestRate = sc.nextDouble();

                System.out.print("Enter Loan Term (in months): ");
                int term = sc.nextInt();

                // Create Loan object (initial status = "Pending")
                Loan loan = new Loan(loanId, customer, principal, interestRate, term, "Pending");
                if (service.applyLoan(loan)) {
                    System.out.println("Application for Loan is Success");
                } else {
                    System.out.println("Application Failed");
                }
            }
            //to calc interest
            else if (choice == 2) {
                System.out.println("To calculate Interest for your Loan Enter Loa Id:");
                int loanid = sc.nextInt();
                //handles exception
                try {
                    double interest = service.calculateInterest(loanid);
                } catch (InvalidLoanException e) {
                   System.out.println(e.getMessage());
                }
               System.out.println("Interest: " + interest);
            }
            //to get loan statys
            else if (choice == 3) {
                //loan status printed in method
                System.out.println("Enter Loan ID");
                int loanid = sc.nextInt();
                service.loanStatus(loanid);
            }
            //ot calculate emi
            else if (choice == 4) {
                System.out.println("Enter Loan ID");
                int loanid = sc.nextInt();
                //handles exception
                try {
                      double emi = service.calculateEMI(loanid);
                } catch (InvalidLoanException e) {
                   System.out.println(e.getMessage());
                }
              System.out.println("EMI for your Loan is " + emi);
            }
            //loan repayment
            else if (choice == 5) {
                System.out.println("Enter Loan ID");
                int loanid = sc.nextInt();
                System.out.println("Enter Amount");
                double amount = sc.nextDouble();
                service.loanRepayment(loanid, amount);
            }
            //get all loans
            else if (choice == 6) {
                System.out.println("All LOans Available in the database");
                service.getAllLoan();
            }
            //get all loans by loan id
            else if (choice == 7) {
                System.out.println("Enter Loan ID");
                int loanid = sc.nextInt();
                 try {
                      service.getLoanById(loanid);
                } catch (InvalidLoanException e) {
                   System.out.println(e.getMessage());
                }
            }
            //to exit
            else if (choice == 8) {
                return;
            }
            else {
                System.out.println("Invalid Choice,CHoose between 1-8");
            }
        }



}
