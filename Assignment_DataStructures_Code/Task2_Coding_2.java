import java.util.Scanner;
//Implement a while loop to track the real-time location of a courier until it reaches its destination.
public class Task2_Coding_2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Start Location ID");
        int s_id=sc.nextInt();
        System.out.println("Enter the Destination Location ID");
        int d_id=sc.nextInt();
        System.out.println("Tracking Real Time Location");
        while(s_id != d_id)
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception occurred");
            }
            if(s_id<d_id)
            {
                s_id++;
            }
            else
            {
                s_id--;
            }
                System.out.println("Current location ID: " + s_id);
                System.out.println("Fetching takes 2 to 3 sec Please Wait");

        }

        System.out.println("The Courier has reached the Destination Location");
    }
}
