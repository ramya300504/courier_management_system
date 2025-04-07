//5. Write a Java program that uses a for loop to display all the orders for a specific customer.
import java.util.*;
class Order
{
    int orderID;
    String CustomerName;
    String Product;
    Order(int orderID,String CustomerName, String Product)
    {
        this.orderID=orderID;
        this.CustomerName=CustomerName;
        this.Product=Product;
    }
}
public class Task2_Coding_1 {

    public static void main(String[] args)
    {
        Order[] order ={
                new Order(40,"Ramya","Laptop"),
                new Order(86,"Yadav","Projector"),
                new Order(13,"Kailash","Smart Watch"),
                new Order(15,"Ramya","Keyboard"),
                new Order(17,"Sarav","MacBook"),
                new Order(50,"Sarav","Tripod")
        };
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Customer's Name");
        String cname=sc.next();
        System.out.println("All the Orders of "+cname+" are listed below");
        for(Order o:order)
        {
            if(o.CustomerName.equalsIgnoreCase(cname)) {
                System.out.println("Order ID: " + o.orderID);
                System.out.println("Product Name: "+o.Product);
            }
        }


    }
}
