package Interface;


import Entities.Courier;
import connectionutil.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CourierUserService implements ICourierUserService {
    public static Connection connection;
    public CourierUserService() {
        try {
            connection = DBConnection.getConnection();
            System.out.println("Driver Loaded Successfully");
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("Error establishing database connection: " + e.getMessage());
        }
    }
    @Override
    public String placeOrder(Courier courier) throws SQLException {
        PreparedStatement pst= connection.prepareStatement("insert into courier(CourierID, SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate)values(?,?,?,?,?,?,?,?,?)");
        pst.setInt(1,courier.getCourierID());
        pst.setString(2, courier.getSenderName());
        pst.setString(3, courier.getSenderAddress());
        pst.setString(4, courier.getReceiverName());
        pst.setString(5, courier.getReceiverAddress());
        pst.setDouble(6,courier.getWeight());
        pst.setString(7, courier.getStatus());
        pst.setString(8, courier.getTrackingNumber());

        return courier.getTrackingNumber();
    }

    @Override
    public String getOrderStatus(Courier courier)  {

        return courier.getStatus();
    }

    @Override
    public boolean cancelOrder(String trackingNumber) {
        if (courier != null && Courier.getTrackingNumber().equals(trackingNumber)) {
            return true; // Order canceled
        }
        return false;
    }


    public Courier[] getAssignedOrder(Courier courierobj, int empid) {
        int[] empIds = new int[100];
        Courier[] couriers = new Courier[100];
         int count = 0;
        empIds[count] = empid;
        couriers[count] = courierobj;

        return couriers;
    }
    //This method is not defined because it is map based implementation,
    // it it defined in CourierUserServiceCollectionImpl
    //@Override
    //public Map<Integer, Courier> getAssignedOrderMap(Courier courierobj, int empid) {
        //return Map.of();}
    @Override
    public  Map<Integer, Courier> getAssignedOrderMap(Courier courierobj, int empid) {
        Map<Integer,Courier> assignedcouriers=new HashMap<>();
        assignedcouriers.put(empid,courierobj);
        return assignedcouriers;

    }
}
