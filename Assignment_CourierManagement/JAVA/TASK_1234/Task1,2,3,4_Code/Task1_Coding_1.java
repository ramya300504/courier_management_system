
//1. Write a program that checks whether a given order is delivered or not based on its status (e.g.,
//"Processing," "Delivered," "Cancelled"). Use if-else statements for this.
import java.util.Scanner;
public class Task1_Coding_1
{

    public static void statuscheck(String status)
    {
        if(status.equals("Delivered") || status.equals("delivered") || status.equals("DELIVERED"))
            System.out.println("The given order is delivered");
        else
            System.out.println("The given order is not yet delivered");
    }
    public static void main(String[] args)
    {
               Scanner sc=new Scanner(System.in);
               System.out.println("Enter the current status of the Courier");
               String status=sc.nextLine();
               statuscheck(status);

    }

}
