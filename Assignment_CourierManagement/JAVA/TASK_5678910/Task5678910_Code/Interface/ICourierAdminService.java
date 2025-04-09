package Interface;

import Entities.Employee;

public interface ICourierAdminService {

    /*Add a new courier staff member to the system.
     * @param name The name of the courier staff member.
     * @param contactNumber The contact number of the courier staff member.
     * @return The ID of the newly added courier staff member.
     */
    int addCourierStaff(Employee emp);
}
