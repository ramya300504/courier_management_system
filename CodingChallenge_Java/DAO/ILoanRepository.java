package DAO;

import Entity.Loan;

import java.sql.SQLException;
import java.util.List;

public interface ILoanRepository {
    boolean applyLoan(Loan loan) throws SQLException;

    void loanStatus(int loanId) throws SQLException;

    double calculateInterest(int loanId) throws SQLException;

    List<Loan> getAllLoan() throws SQLException;

    void getLoanById(int loanId) throws SQLException;

    void loanRepayment(int loanId, double amount) throws SQLException;

    double calculateEMI(int loanId) throws SQLException;
}
