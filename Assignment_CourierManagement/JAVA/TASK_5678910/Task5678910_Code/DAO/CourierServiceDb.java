package DAO;
import connectionutil.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CourierServiceDb {
    public static Connection connection;

    // Constructor to initialize the connection
    public CourierServiceDb() {
        try {
            connection = DBConnection.getConnection();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("Error establishing database connection: " + e.getMessage());
        }
    }
    public static void main(String[] args) throws SQLException {

          CourierServiceDb csd=new CourierServiceDb();
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter 1:Insertion of Record\nEnter 2:Updation of Record" +
         "\nEnter 3:Retrieval of Record\nEnter 4:TO Get Delivery History\nEnter 5:To Get Shipment Status Report" +
         "\nEnter 6:To Get Revenue Report");
         int value = sc.nextInt();
        switch (value) {
        case 1:
            insert_record(connection);
            break;
        case 2:
            update_record(connection);
            break;
        case 3:
            retrieve_record(connection);
            break;
        case 4:
            delivery_history(connection);
            break;
        case 5:
            shipment_status_report(connection);
            break;
        case 6:
            revenue_report(connection);
            break;
        case 7:
            System.out.println("Invalid Option");
    }
}
public static void insert_record(Connection connection) throws SQLException {
    PreparedStatement ps = connection.prepareStatement("insert into courier(courierID, senderName, senderAddress, receiverName, receiverAddress, weight, status, trackingNumber, deliveryDate) values (?,?,?,?,?,?,?,?,?)");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Courier ID: ");
    int courierID = sc.nextInt();
    sc.nextLine();

    System.out.println("Enter Sender Name: ");
    String senderName = sc.nextLine();

    System.out.println("Enter Sender Address: ");
    String senderAddress = sc.nextLine();

    System.out.println("Enter Receiver Name: ");
    String receiverName = sc.nextLine();

    System.out.println("Enter Receiver Address: ");
    String receiverAddress = sc.nextLine();

    System.out.println("Enter Package Weight (kg): ");
    double weight = sc.nextDouble();
    sc.nextLine();

    System.out.println("Enter Courier Status: ");
    String status = sc.nextLine();

    System.out.println("Enter Tracking NUmber: ");
    String tnum = sc.nextLine();

    System.out.println("Enter Delivery Date: ");
    String deli_date = sc.nextLine();

    ps.setInt(1,courierID);
    ps.setString(2,senderName);
    ps.setString(3,senderAddress);
    ps.setString(4,receiverName);
    ps.setString(5,receiverAddress);
    ps.setDouble(6,weight);
    ps.setString(7,status);
    ps.setString(8,tnum);
    ps.setString(9,deli_date);
    int c=ps.executeUpdate();
    System.out.println("Number of Rows Inserted: "+c);
}

public static void update_record(Connection connection) throws SQLException {
    PreparedStatement ps= connection.prepareStatement("update courier set status=? where courierID=?");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter New Status to be updated for specific courier ID");
    String  status=sc.next();
    System.out.println("Enter Courier ID");
    int courierID=sc.nextInt();
    ps.setString(1,status);
    ps.setInt(2,courierID);
    int c= ps.executeUpdate();
    System.out.println("Status Updated as "+status+" for Courier ID "+courierID);

}

public static void retrieve_record(Connection connection) throws SQLException {
    Statement st=connection.createStatement();
    ResultSet rs=st.executeQuery("select courierID,senderName from courier");
    while(rs.next())
    {
        System.out.println(rs.getInt(1)+" "+rs.getString(2));
    }
}

public static void delivery_history(Connection connection) throws SQLException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Courier ID to view Delivery History");
    int cid=sc.nextInt();
    PreparedStatement pst= connection.prepareStatement("select status from courier where courierID=?");
    pst.setInt(1,cid);
    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
        System.out.println("The delivery history of Courier ID " + cid + " is: " + rs.getString("status"));
    } else {
        System.out.println("No delivery history found for Courier ID " + cid);
    }

}
public static void shipment_status_report(Connection connection) throws SQLException {
    Map<String,Integer> statusCount=new HashMap<>();
    Statement st= connection.createStatement();
    ResultSet rs= st.executeQuery("select status from courier");

    while (rs.next()) {
        String status = rs.getString("status");
        statusCount.put(status, statusCount.getOrDefault(status, 0) + 1);
    }

    // Find the max count status
    String maxStatus = null;
    int maxCount = 0;
    for (Map.Entry<String, Integer> entry : statusCount.entrySet()) {
        if (entry.getValue() > maxCount) {
            maxCount = entry.getValue();
            maxStatus = entry.getKey();
        }
    }

    // Print the report
    System.out.println("----Shipment Status Report----");
    System.out.println("Huge Number of Courier's Status are Obtained as"+maxStatus);


}
public static void revenue_report(Connection connection) throws SQLException {
    Statement st= connection.createStatement();
    ResultSet rs=st.executeQuery("select avg(amount) from payment where paymentdate between '2025-01-01' and '2025-03-06'");
    if (rs.next()) {
        double avgRevenue = rs.getDouble(1);
        System.out.println("The Revenue Report of All Existing Couriers from Start Date to End Date\n" + avgRevenue);
    }
}
}



