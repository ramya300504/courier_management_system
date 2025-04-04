// Create a program that generates an order confirmation email. The email
//should include details such as the customer's name, order number, delivery address, and expected
//delivery date.
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;

public class Order_Confirmation_Email {

    public static void generateemail(String name,String address)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        Date deliverydate=new Date(System.currentTimeMillis()+7*24*60*60*1000);
        String date=dateFormat.format(deliverydate);
        String orderid=generateOrderid();
        System.out.println("Your Order has placed Successfully and Here are your Order Details");
        System.out.println("Customer's Name: "+name+"\nOrder Number: "+orderid+"\nDelivery Address: "+address+"\nExpected Delivery Date: "+date);
        System.out.println("Happy Shopping!!!");

    }
    public static String generateOrderid()
    {
        Random r=new Random();
        int num = 1000 + r.nextInt(9000);
        return "ORD-ID"+num;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name:");
        String name=sc.nextLine();
        System.out.println("Enter Delivery Address");
        String address=sc.nextLine();

        generateemail(name,address);

    }

}
