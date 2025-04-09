package Exception;

import java.util.Set;

public class IDCheck {

    public static void checkEmployeeid(int empid,Set<Integer> employeeidset) throws InvalidEmployeeIdException
    {

        if(!employeeidset.contains(empid))
        {
            throw new InvalidEmployeeIdException("Entered Employee Id is not an Existing One, Kindly check the ID");
        }
        else
        {
            System.out.println("Entered ID is an Existing one and Valid");
        }

    }
}
