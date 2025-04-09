package Entities;
import java.util.*;

public class CourierCompany {
    private String companyName;
    private List<Courier> courierDetails;
    private List<Employee> employeeDetails;
    private List<Location> locationDetails;
    private Courier[] couriers=new Courier[70];
    private int courierCount=0;

    public CourierCompany() {}

    public CourierCompany(String companyName, List<Courier> courierDetails, List<Employee> employeeDetails, List<Location> locationDetails) {
        this.companyName = companyName;
        this.courierDetails = courierDetails;
        this.employeeDetails = employeeDetails;
        this.locationDetails = locationDetails;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Courier> getCourierDetails() {
        return courierDetails;
    }

    public void setCourierDetails(List<Courier> courierDetails) {
        this.courierDetails = courierDetails;
    }

    public List<Employee> getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(List<Employee> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public List<Location> getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(List<Location> locationDetails) {
        this.locationDetails = locationDetails;

    }
    public Courier[] getCouriers() {
        return couriers;
    }

    public void setCouriers(Courier[] couriers) {
        this.couriers = couriers;
    }

    @Override
    public String toString() {
        return companyName + ", Couriers: " + courierDetails.size() + ", Employees: " + employeeDetails.size() + ", Locations: " + locationDetails.size();
    }

    public int getCourierCount() {
        return courierCount;
    }

    public void setCourierCount(int courierCount) {
        this.courierCount = courierCount;
    }
}
