package Interface;


import Entities.Employee;

import java.util.Random;

public class CourierAdminService implements ICourierAdminService {

    @Override
    public int addCourierStaff(Employee emp) {

        Random random=new Random();
        int empid=random.nextInt(41)+120;
        return empid;


    }
}
