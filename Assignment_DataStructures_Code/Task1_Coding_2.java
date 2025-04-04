//2. Implement a switch-case statement to categorize parcels based on their weight into "Light,"
//"Medium," or "Heavy."
import java.util.Scanner;

public class Task1_Coding_2
{
    public static void Weight_check(double weight)
    {
        int specified_number;
        if(weight<1.5)
            specified_number=1;
        else if(weight<2.5 && weight>1.5)
            specified_number=2;
        else
            specified_number=3;

        switch (specified_number) {
            case 1:
                System.out.println("The parcel is Light");
                break;
            case 2:
                System.out.println("The parcel is  Medium");
                break;
            case 3:
                System.out.println("The parcel is Heavy");
                break;
            default:
                System.out.println("Entered Weight is Invalid");
        }

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Weight of the Courier");
        double weight=sc.nextDouble();
        Weight_check(weight);
    }
}
