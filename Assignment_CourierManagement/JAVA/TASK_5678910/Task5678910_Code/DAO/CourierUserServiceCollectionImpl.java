package DAO;

import Entities.Courier;
import Entities.CourierCompanyCollection;
import Interface.ICourierUserService;

import java.util.HashMap;
import java.util.Map;

public class CourierUserServiceCollectionImpl implements ICourierUserService {

    private CourierCompanyCollection courierObj;

    public CourierUserServiceCollectionImpl(CourierCompanyCollection courierObj) {
        this.courierObj = courierObj;
    }

    public CourierCompanyCollection getCourierObj() {
        return courierObj;
    }

    public void setCourierObj(CourierCompanyCollection courierObj) {
        this.courierObj = courierObj;
    }


    @Override
    public String placeOrder(Courier courier) {
        return "";
    }

    @Override
    public String getOrderStatus(Courier courier) {
        return "";
    }

    @Override
    public boolean cancelOrder(Courier courier, String trackingNumber) {
        return false;
    }

    @Override
    public Courier[] getAssignedOrder(Courier courierobj, int empid) {
        return new Courier[0];
    }

    // This is the implementation for Collection type
    //In CourierUserService Class implementation is done based on arrays
    @Override
    public  Map<Integer, Courier> getAssignedOrderMap(Courier courierobj, int empid) {
        Map<Integer,Courier> assignedcouriers=new HashMap<>();
        assignedcouriers.put(empid,courierobj);
        return assignedcouriers;

    }

}

