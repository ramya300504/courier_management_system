package Interface;

import Entities.Courier;

import java.sql.SQLException;
import java.util.Map;

public interface ICourierUserService {

    /* @param courierObj Courier object created using values entered by users
       @return The unique tracking number for the courier order*/

           String placeOrder(Courier courier) throws SQLException;

    /*@param trackingNumber The tracking number of the courier order.
      @return The status of the courier order*/

           String getOrderStatus(Courier courier);

     /* @param trackingNumber The tracking number of the courier order to be canceled.
        @return True if the order was successfully canceled, false otherwise.*/

           boolean cancelOrder(Courier courier,String trackingNumber);

     /* @param courierStaffId The ID of the courier staff member.
      * @return A list of courier orders assigned to the staff member.*/

          //For Array implementation
          Courier[] getAssignedOrder(Courier courierobj, int empid);

          //For Collection Implementation
          Map<Integer, Courier> getAssignedOrderMap(Courier courierobj, int empid);

}


