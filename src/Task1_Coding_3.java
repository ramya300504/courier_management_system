// Implement User Authentication 1. Create a login system for employees and customers using Java
//control flow statements.
import java.util.HashMap;
import java.util.Scanner;

public class Task1_Coding_3
{

    public static void main(String[] args)
    {
        HashMap<String, String> Customers = new HashMap<>();
        HashMap<String, String> employees = new HashMap<>();
        // Datas stored in Database
        employees.put("Divya Shree H", "divya45");
        employees.put("Meena T", "meena@13");
        employees.put("Manoj K", "kmanoj76");
        employees.put("Suresh B", "suresh*9");
        employees.put("Monika S", "smoni9");
        Customers.put("Arun Kumar", "ak47");
        Customers.put("Karthik S", "karthi870");
        Customers.put("Sundar C", "sundar*c01");
        Customers.put("Anitha P", "anitha13");
        Customers.put("Revathi R", "revathisk2");
        // Scanner class to get to know the user is customer or employee
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Login Page of Courier Management System");
        System.out.println(("Enter 'E' for Employee and 'C' for Customer"));
        char input = sc.next().charAt(0);
        // To access Number of attempts done
        int attempts = 0;
        String ename, epassword, cname, cpassword;
        // USed to check Authentication status
        boolean AuthenticationSuccess = false;
        // Code if user is employee
        if (input == 'E')
        {
            while (attempts < 3 && !AuthenticationSuccess)
            {
                System.out.println("Enter Name of the Employee");
                sc.nextLine();
                ename = sc.nextLine();
                System.out.println("Enter Password");
                epassword = sc.nextLine();
                if (input == 'E')
                {
                    AuthenticationSuccess = Validate(ename, epassword, employees);
                }
                if (AuthenticationSuccess)
                {
                    System.out.println("Login Successful!!, Welcome to Home Page");
                } else
                {
                    attempts++;
                    System.out.println("Due to Invalid Data Login Failed");
                    System.out.println("Maximum Number of Attempts:3 Attempts Done: " + attempts);
                }

            }
            //After 3 attempts Authentication not get success
            if (!AuthenticationSuccess)
            {
                System.out.println("Maximum Attempts Over Try Again after 4 Hours");
            }

        }
        // Code if user is customer
        else
        {
            while (attempts < 3 && !AuthenticationSuccess)
            {

                System.out.println("Enter Name of the Customer");
                sc.nextLine();
                cname = sc.nextLine();

                System.out.println("Enter Password");
                cpassword = sc.nextLine();
                if (input == 'C')
                {
                    AuthenticationSuccess = Validate(cname, cpassword, Customers);
                }
                if (AuthenticationSuccess)
                {
                    System.out.println("Login Successful!!, Welcome to Home Page");
                } else
                {
                    attempts++;
                    System.out.println("Due to Invalid Data Login Failed");
                    System.out.println("Maximum Number of Attempts:3 Attempts Done: " + attempts);
                }

            }
            //After 3 attempts Authentication not get success
            if (!AuthenticationSuccess)
            {
                System.out.println("Maximum Attempts Over Try Again after 4 Hours");
            }
        }



    }

    public static boolean Validate(String username, String password, HashMap<String, String> users)
    {
        return users.containsKey(username) && users.get(username).equals(password);
    }

}
