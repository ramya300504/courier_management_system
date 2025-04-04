import java.util.Scanner;

//Develop a function that takes an address as input (street, city, state, zip code)
//and formats it correctly, including capitalizing the first letter of each word and properly formatting the
//zip code.
public class Address_Formatting {
    public static void FormatData(String street,String city,String state,String zip)
    {
        String streetnew=format(street);
        String citynew=format(city);
        String statenew=format(state);
        String zipnew=zipformat(zip);
        System.out.println("Formatted Address : "+streetnew+" "+citynew+" "+statenew+" "+zipnew);

    }
    public static String format(String address)
    {
        String[] arr=address.split(" ");
        StringBuilder str=new StringBuilder();
        for(String s:arr)
        {
            if(!s.isEmpty())
            {
                str.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase()).append(" ");
            }
        }
        return str.toString();
    }
    public static String zipformat(String zip)
    {
        StringBuilder st=new StringBuilder();
        int length=zip.length();
        for(int i=0;i<length;i++)
        {
            if(Character.isDigit(zip.charAt(i)))
                st.append(zip.charAt(i));
        }
        return st.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Address Details");
        System.out.println("Enter Street Name : ");
        String street=sc.nextLine();
        System.out.println("Enter City Name");
        String city=sc.nextLine();
        System.out.println("Enter State Name");
        String state=sc.nextLine();
        System.out.println("Enter Zip Code");
        String zip=sc.nextLine();
        FormatData(street,city,state,zip);
    }
}
