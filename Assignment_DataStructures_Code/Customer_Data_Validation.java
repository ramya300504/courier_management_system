//Write a function which takes 2 parameters, data-denotes the data and
//detail-denotes if it is name address or phone number.Validate customer information based on
//following critirea. Ensure that names contain only letters and are properly capitalized, addresses do not
//contain special characters, and phone numbers follow a specific format (e.g., ###-###-####).

import java.util.Scanner;

public class Customer_Data_Validation {

    public static boolean ValidateName(String data,String details)
    {
        for(int i=0;i<details.length();i++)
        {
           if(!Character.isUpperCase(details.charAt(0)))
               return false;
           if(!Character.isDigit(details.charAt(i)))
               return false;
        }
        return true;
    }
    public static boolean ValidateAddress(String data,String details)
    {
        for (char c : details.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == ' ' || c == ',')) {
                return false;
            }
        }
        return true;
    }
    public static boolean ValidatePhoneno(String data,String details)
    {
        if(details.length()<12)
            return false;
        else
        {
            for(int i=0;i<12;i++)
            {
                if(i==3 || i==5)
                {
                    if(details.charAt(i)!='-')
                        return false;
                }
                if(!Character.isDigit(details.charAt(i)))
                return false;
            }
            return  true;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Customer Information Name or Address or Phone Number");
        System.out.println("For Name Enter: 1 \nFor Address Enter:2 \nFor Phone Number Enter: 3");
        int num=sc.nextInt();
        System.out.println("Enter Data of Selected Type");
        String details=sc.next();
        if(num==1) {
            if(ValidateName("Name", details))
            System.out.println("Entered Name passed the Validation Test");
            else
                System.out.println("Invalid Name Format");
        }
        else if (num==2) {
            if(ValidateAddress("Address", details))
            System.out.println("Entered Address passed the Validation Test");
            else
                System.out.println("Invalid Address Format");
        }
        else if(num==3) {
            if(ValidatePhoneno("Phone Number", details))
            System.out.println("Entered Phone Number passed the Validation Test");
            else
                System.out.println("Invalid Phone Number Format");
        }
        else
            System.out.println("Invalid Choice");
    }
}
