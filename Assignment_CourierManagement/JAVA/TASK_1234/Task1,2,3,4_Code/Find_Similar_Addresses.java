import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Implement a function that finds similar addresses in the system. This can be
//useful for identifying duplicate customer entries or optimizing delivery routes.Use string functions to
//implement this.
public class Find_Similar_Addresses {

    private int courierID;
    private String SenderName;
    private String senderAddress;

    Find_Similar_Addresses(int courierID,String SenderName,String senderAddress)
    {
        this.courierID=courierID;
        this.SenderName=SenderName;
        this.senderAddress=senderAddress;
    }
    public String getSenderAddress() {
        return senderAddress;
    }

    public static void main(String[] args) {

        List<Find_Similar_Addresses> check=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Courier ID");
        int cid=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Sender Name");
        String sname=sc.nextLine();
        System.out.println("Enter Sender Address");
        String sadd=sc.nextLine();
        Find_Similar_Addresses address1=new Find_Similar_Addresses(12,"Fathima","Villapuram Madurai");
        check.add(address1);
        Find_Similar_Addresses address2=new Find_Similar_Addresses(14,"Fahad","Porur Chennai");
        check.add(address2);
        Find_Similar_Addresses addresses=new Find_Similar_Addresses(cid,sname,sadd);
        if (addresses.check_similar(check, addresses)) {
            System.out.println("Similar address found!");
        } else {
            System.out.println("No similar address found.");
        }



    }

    public boolean check_similar(List<Find_Similar_Addresses> check,Find_Similar_Addresses addresses)
    {
        for(Find_Similar_Addresses f:check)
        {
            if (f.getSenderAddress().toLowerCase().contains(addresses.getSenderAddress().toLowerCase()))
            {
                return true;
            }

        }
        return false;
    }
}
