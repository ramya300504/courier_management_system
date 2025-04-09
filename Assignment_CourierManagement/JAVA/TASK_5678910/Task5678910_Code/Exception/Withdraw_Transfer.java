package Exception;

import Entities.Courier;

public class Withdraw_Transfer {
    public static void Withdraw(double balance, double amount, Courier courier)throws TrackingNumberNotFoundException {

        String trackingNumber= courier.getTrackingNumber();
        if(amount>balance)
        {
            throw new TrackingNumberNotFoundException("Insufficient Balance to withdraw");
        }
        else
        {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        }
    }

    public static void transfer(double balance,double amount)throws  TrackingNumberNotFoundException{
        if (amount > balance)
        {
            throw new TrackingNumberNotFoundException("Insufficient balance for transfer!");
        }
        else
        {
            balance -= amount;
            System.out.println("Transfer successful! New balance: " + balance);
        }
    }
}
