//: Create a program that allows users to input a parcel tracking number.Store the
//tracking number and Status in 2d String Array. Initialize the array with values. Then, simulate the
//tracking process by displaying messages like "Parcel in transit," "Parcel out for delivery," or "Parcel
//delivered" based on the tracking number's status.

import java.util.Scanner;

public class Parcel_Tracking {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Parcel Tracking Number(Example: TrcID4005");
        String T_id=sc.next();
        String[][] Values= {
                {"TrcID2356", "Delivered" },
                {"TrcID3001", "In Transit" },
                {"TrcID4985", "Out for Delivery" },
                {"TrcID5402", "Delivered" },
                {"TrcID6503", "In Transit" },
                {"TrcID8675", "Canceled"}
        };
        String status="";
        for(int i=0;i< Values.length;i++)
        {
            if(T_id.equalsIgnoreCase(Values[i][0]))
            {
                status=Values[i][1];
            }
        }
        if(status.equals("Delivered"))
            System.out.println("Parcel Delivered");
        else if(status.equals("Out for Delivery"))
            System.out.println("Parcel Out for Delivery");
        else if(status.equals("In Transit"))
            System.out.println("Parcel in Transit");
        else
            System.out.println("Parcel Cancelled");



    }

}
