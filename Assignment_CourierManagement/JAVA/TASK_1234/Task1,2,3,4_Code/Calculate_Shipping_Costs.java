import java.util.Random;
import java.util.Scanner;

// Develop a function that calculates the shipping cost based on the distance
//between two locations and the weight of the parcel. You can use string inputs for the source and
//destination addresses.
public class Calculate_Shipping_Costs {
    public static void CalculateCost(double weight,double distance,String source,String destination)
    {
        double cost=weight*distance;
        System.out.printf("The Total Shipping Cost to deliver the parcel from %s to %s is %.2f%n", source, destination, cost);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Delivery Available for Only Specific Cities,so Kindly choose within these options:(Madurai,Trichy,Salem,Thanjavur,Theni");
        System.out.println("Enter Delivery Address");
        String destination=sc.nextLine();
        String source="Chennai";
        Random random=new Random();
        double weight=10.0 + (random.nextDouble() * 10.0);
        double distance=0.0;
        if(destination.equalsIgnoreCase("Madurai"))
            distance=462.65;
        else if(destination.equalsIgnoreCase("Trichy"))
            distance=332.95;
        else if(destination.equalsIgnoreCase("Salem"))
            distance=244.80;
        else if(destination.equalsIgnoreCase("Thanjavur"))
            distance=343.45;
        else if(destination.equalsIgnoreCase("Theni"))
            distance=103.54;
        else
            System.out.println("Your Location is not Available for Shipping");


        CalculateCost(weight,distance,source,destination);



    }

}
