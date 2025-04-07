// Implement Courier Assignment Logic 1. Develop a mechanism to assign couriers to shipments based
//on predefined criteria (e.g., proximity, load capacity) using loops.
class Courier {
    int CourierID;
    double distance;
    int capacity;

    Courier( int CourierID, double distance, int capacity){
        this.CourierID = CourierID;
        this.distance = distance;
        this.capacity = capacity;
    }
}
class Shipment {
    String id;
    int requiredCapacity;

    public Shipment(String id, int requiredCapacity) {
        this.id = id;
        this.requiredCapacity = requiredCapacity;
    }
}
public class Task1_Coding_4 {
    public static void main(String[] args) {
        Courier[] courier = {
                new Courier(12, 2.56, 23),
                new Courier(9, 3.4, 8),
                new Courier(6, 9.865, 10)

        };
        Shipment[] shipment = {
                new Shipment("SID03", 5),
                new Shipment("SID08", 7),
                new Shipment("SID17", 15)
        };
        for (Shipment s : shipment) {
            boolean assigned = false;

            for (Courier c : courier) {
                if (c.capacity >= s.requiredCapacity) {
                    System.out.println("Shipment " + s.id + " assigned to Courier " + c.CourierID);
                    c.capacity -= s.requiredCapacity; // Update courier capacity
                    assigned = true;
                    break;  // Move to the next shipment after assigning
                }
            }
            if (!assigned) {
                System.out.println("Shipment " + s.id + " could not be assigned");
            }

        }
    }
}
