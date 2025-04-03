//7. Create an array to store the tracking history of a parcel, where each entry represents a location
//update.
import java.util.Scanner;

public class Task3_Coding_1 {
    String location;
    String status;

    Task3_Coding_1(String location, String status) {
        this.location = location;
        this.status = status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Task3_Coding_1[] tracking = new Task3_Coding_1[15];
        tracking[0] = new Task3_Coding_1("Salem", "Not Packed");
        tracking[1] = new Task3_Coding_1("Dindugal", "Shipped");
        tracking[2] = new Task3_Coding_1("Chennai", "Out for Delivery");
        int count=3;
        System.out.println("Enter number of updates to add:");
        int updates = sc.nextInt();
        sc.nextLine();

        // Loop to get Entry from User
        for (int i = 0; i < updates; i++) {

            System.out.println("Enter Location:");
            String location = sc.nextLine();
            System.out.println("Enter Status:");
            String status = sc.nextLine();
            tracking[count] = new Task3_Coding_1(location, status);
            count++;
        }
        //Loop to display the updated tracking History

        System.out.println("Tracking History");
        for (int i = 0; i < count; i++) {
            System.out.println((i+1)+". Location "+tracking[i].location+"Status "+tracking[i].status);
        }

    }
}