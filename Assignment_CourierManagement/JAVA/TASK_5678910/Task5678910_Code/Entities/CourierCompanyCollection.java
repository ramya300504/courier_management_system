package Entities;

import java.util.ArrayList;
import java.util.List;

public class CourierCompanyCollection {

    List<CourierCompany> list=new ArrayList<>();

    public CourierCompanyCollection() {
        this.list = new ArrayList<>();
    }

    public List<CourierCompany> getList() {
        return list;
    }

    public void setList(List<CourierCompany> list) {
        this.list = list;
    }
    public void addCourier(CourierCompany courierObj)
    {
        list.add(courierObj);
    }
    public void removeCourierCompany(CourierCompany company) {
        list.remove(company);
    }

    @Override
    public String toString() {
        return "CourierCompanyCollection{" +
                "list=" + list +
                '}';
    }

}
