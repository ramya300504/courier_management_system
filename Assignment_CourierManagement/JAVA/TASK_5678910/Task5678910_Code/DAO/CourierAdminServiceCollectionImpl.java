package DAO;

import Entities.CourierCompanyCollection;
import Entities.Employee;
import Interface.ICourierAdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class CourierAdminServiceCollectionImpl extends CourierUserServiceCollectionImpl implements ICourierAdminService {

    public CourierAdminServiceCollectionImpl(CourierCompanyCollection companyObj) {
        super(companyObj);
    }

    @Override
    public int addCourierStaff(Employee emp) {
        Random random=new Random();
        int empid=random.nextInt(41)+120;
        //This method logic is same as method in CourierAdminService class,
        // But it is specifically used for Collection based implementation
        List<Employee> newaddedemp=new ArrayList<>();
        newaddedemp.add(emp);
        return empid;
    }
}
