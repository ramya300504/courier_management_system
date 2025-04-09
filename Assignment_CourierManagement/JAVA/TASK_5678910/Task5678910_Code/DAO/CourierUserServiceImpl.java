package DAO;

import Entities.Courier;
import Entities.CourierCompany;
import Interface.ICourierUserService;

import java.util.Map;

public class CourierUserServiceImpl implements ICourierUserService {

    CourierCompany companyObj=new CourierCompany();
    public CourierUserServiceImpl(CourierCompany companyObj) {
        this.companyObj = companyObj;
    }
    //This class mainly implements all the methods based on arrays

    @Override
    public String placeOrder(Courier courier) {
        // Add courier to array in companyObj
        Courier[] couriers = companyObj.getCouriers();
        int count = companyObj.getCourierCount();

        if (count < couriers.length) {
            couriers[count] = courier;
            companyObj.setCourierCount(count + 1);
            return courier.getTrackingNumber();
        } else {
            return "Courier list is full.";
        }
    }
    @Override
    public String getOrderStatus(Courier courier) {
        return courier.getStatus();
    }

    @Override
    public boolean cancelOrder(Courier courier, String trackingNumber) {
        if (courier != null && courier.getTrackingNumber().equals(trackingNumber)) {
                return true;
            }
            return false;
    }

    @Override
    public Courier[] getAssignedOrder(Courier courierobj, int empid) {
        Courier[] assigned = new Courier[1];
        assigned[0] = courierobj;
        return assigned;
    }
    //This Method is not used here because it's implementation is based on map

    @Override
    public Map<Integer, Courier> getAssignedOrderMap(Courier courierobj, int empid) {
        return Map.of();
    }


}
