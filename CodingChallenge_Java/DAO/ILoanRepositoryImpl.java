package DAO;

import Entity.Customer;
import Entity.Loan;
import Util.DBUtil;
import Exception.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ILoanRepositoryImpl implements ILoanRepository{
    public static Connection connection;

    public ILoanRepositoryImpl() {
        try {
            connection = DBUtil.getConnection();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("Error establishing database connection: " + e.getMessage());
        }
    }
    public  boolean applyLoan(Loan loan) throws SQLException {
        Scanner sc = new Scanner(System.in);
        boolean applied=false;
        System.out.println("Do you want to submit the loan application? (Yes/No): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
            
            PreparedStatement pst = connection.prepareStatement("INSERT INTO loan (loan_id, customer_id, principal_amount, interest_rate, loan_term, loan_status) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setInt(1, loan.getLoanId());
            pst.setInt(2, loan.getCustomer().getCustomer_ID());
            pst.setDouble(3, loan.getPrincipalAmount());
            pst.setDouble(4, loan.getInterestRate());
            pst.setInt(5, loan.getLoanTerm());
            pst.setString(6, loan.getLoanStatus());
            int rows=pst.executeUpdate();
            if(rows>0)
            {
                applied=true;
            }
                return applied;
        }
          return false;
    }
    public void loanStatus(int loanId) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("SELECT c.credit_score FROM loan l, customer c WHERE l.customer_id = c.customer_id AND l.loan_id = ?");
        pst.setInt(1, loanId);

        ResultSet rs = pst.executeQuery();

        if (rs.next())
        {
            int creditScore = rs.getInt("credit_score");
            String status;

            // Check if credit score is above 650
            if (creditScore > 650) {
                status = "Approved";
                System.out.println("Loan " + status);
            } else {
                status = "Rejected";
                System.out.println("Loan " + status);
            }

            // Update loan status in loans table

            PreparedStatement updatePst = connection.prepareStatement("UPDATE loan SET loan_status = ? WHERE loan_id = ?");
            updatePst.setString(1, status);
            updatePst.setInt(2, loanId);

            int rows = updatePst.executeUpdate();

        } else {
            System.out.println("Loan ID not found.");
        }
    }
    public double calculateInterest(int loanId) throws SQLException {
        double interest = 0;

        //Fetch loan details
        PreparedStatement pst = connection.prepareStatement("SELECT principal_amount, interest_rate, loan_term FROM loan WHERE loan_id = ?");
        pst.setInt(1, loanId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            double principal = rs.getDouble("principal_amount");
            double rate = rs.getDouble("interest_rate");
            int months = rs.getInt("loan_term");

            //Calculate interest
            interest = (principal * rate * months) / 12;

        } else {
            throw new InvalidLoanException("Loan ID " + loanId + " not found.");
        }
        return interest;
    }

    public double calculateEMI(int loanId) throws SQLException {
        double emi = 0;
        // Fetch loan details
        String query = "SELECT principal_amount, interest_rate, loan_term FROM loan WHERE loan_id = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, loanId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            double principal = rs.getDouble("principal_amount");
            double annualRate = rs.getDouble("interest_rate");
            int months = rs.getInt("loan_term");

            // Convert annual rate to monthly rate
            double monthlyRate = annualRate / 12;

            // EMI Formula
            double r = monthlyRate;
            double numerator = principal * r * Math.pow(1 + r, months);
            double denominator = Math.pow(1 + r, months) - 1;
            emi = numerator / denominator;

        } else {
            throw new InvalidLoanException("Loan ID " + loanId + " not found.");
        }
        return emi;
    }



    public List<Loan> getAllLoan() throws SQLException {
         List<Loan> loanList = new ArrayList<>();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM loan");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int loanId = rs.getInt("loan_id");
                double principal = rs.getDouble("principal_amount");
                double rate = rs.getDouble("interest_rate");
                int term = rs.getInt("loan_term");
                String status = rs.getString("loan_status");

                Customer customer = new Customer(); //here enitire customer object is not used only customer id is used

                Loan loan = new Loan(loanId, customer, principal, rate, term, status);
                loanList.add(loan);
            }

            for (Loan loan : loanList) {
                System.out.println("Loan ID: " + loan.getLoanId());
                System.out.println("Customer ID: " + loan.getCustomer().getCustomer_ID()); // assumes getter exists
                System.out.println("Principal Amount: " + loan.getPrincipalAmount());
                System.out.println("Interest Rate: " + loan.getInterestRate());
                System.out.println("Loan Term: " + loan.getLoanTerm());
                System.out.println("Loan Status: " + loan.getLoanStatus());
                System.out.println("----------------------------");
            }

        return loanList;
    }

    public void getLoanById(int loanId) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("SELECT * FROM loan WHERE loan_id = ?");
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int customerId = rs.getInt("customer_id");
            double principal = rs.getDouble("principal_amount");
            double rate = rs.getDouble("interest_rate");
            int term = rs.getInt("loan_term");
            String status = rs.getString("loan_status");

            //here enitire customer object is not used only customer id is used
            Customer customer = new Customer();

            Loan loan = new Loan(loanId, customer, principal, rate, term, status);


            System.out.println("Loan ID: " + loan.getLoanId());
            System.out.println("Customer ID: " + customerId);
            System.out.println("Principal Amount: " + loan.getPrincipalAmount());
            System.out.println("Interest Rate: " + loan.getInterestRate());
            System.out.println("Loan Term: " + loan.getLoanTerm());
            System.out.println("Loan Status: " + loan.getLoanStatus());
        } else {
            throw new InvalidLoanException("Loan with ID " + loanId + " not found.");
        }

    }

    public void loanRepayment(int loanId, double amount) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("SELECT principal_amount, interest_rate, loan_term FROM loan WHERE loan_id = ?");
        pst.setInt(1, loanId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            double p = rs.getDouble("principal_amount");
            double r = rs.getDouble("interest_rate") / 12;
            int n = rs.getInt("loan_term");

            double emi = (p * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);

            int NoofemiCanPay = (int) (amount / emi);

            if (NoofemiCanPay < 1) {
                System.out.println("Payment rejected. Amount is less than one EMI.");
            } else {
                int newTerm = n - NoofemiCanPay;

                PreparedStatement updatePst = connection.prepareStatement("UPDATE loan SET loan_term = ? WHERE loan_id = ?");
                updatePst.setInt(1, newTerm);
                updatePst.setInt(2, loanId);
                updatePst.executeUpdate();

                System.out.println(NoofemiCanPay + " EMI(s) paid. Remaining term: " + newTerm + " months.");
                updatePst.close();
            }
        } else {
            System.out.println("Loan ID not found.");
        }
    }


}
