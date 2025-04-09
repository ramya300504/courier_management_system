package DAO;

import Entities.Employee;
import Entities.CourierCompany;
import Interface.ICourierAdminService;

import java.util.Random;

public class CourierAdminServiceImpl extends CourierUserServiceImpl implements ICourierAdminService {

    public CourierAdminServiceImpl(CourierCompany companyObj) {
        super(companyObj);
    }

    @Override
    public int addCourierStaff(Employee emp) {
        Random random=new Random();
        int empid=random.nextInt(41)+120;
        //This method logic is same as methodin CourierAdminService class,
        // But it is specifically used for Array based implementation
        Employee[] newaddedemp=new Employee[15];
        int count=0;
        newaddedemp[count++]=emp;
        return empid;
    }
}
