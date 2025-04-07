import java.util.Random;
import java.util.Scanner;

//Create a function that generates secure passwords for courier system
//accounts. Ensure the passwords contain a mix of uppercase letters, lowercase letters, numbers, and
//special characters.
public class Password_Generator {
    public static String GeneratePassword(String name)
    {
        StringBuilder str=new StringBuilder();
        int n=name.length();
        str.append(name.substring(n-2));
        str.append(Character.toUpperCase(name.charAt(0)));
        Random random=new Random();
        String specialChars = "!@#$%^&*";
        char specialChar = specialChars.charAt(random.nextInt(specialChars.length()));
        str.append(specialChar);

        int num=random.nextInt(900) + 100;;
        str.append(num);

        return str.toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter User Name");
        String name=sc.nextLine();
        String password=GeneratePassword(name);
        System.out.println("The Suggested Secure Password for the User is "+password);
    }
}
