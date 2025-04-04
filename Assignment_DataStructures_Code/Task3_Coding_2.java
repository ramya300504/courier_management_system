public class Task3_Coding_2 {
//. Implement a method to find the nearest available courier for a new order using an array of couriers.
    int id;
    double distance; // Distance from a fixed origin
    boolean available;

    Task3_Coding_2(int id, double distance, boolean available) {
        this.id = id;
        this.distance = distance;
        this.available = available;
    }
}


    class NearestCourier {

        public static Task3_Coding_2 findNearest(Task3_Coding_2[] couriers, double orderDistance) {
            Task3_Coding_2 nearest = null;
            double minDistanceDiff = Double.MAX_VALUE;

            if (couriers == null || couriers.length == 0) {
                return null;
            }

            for (Task3_Coding_2 c : couriers) {
                if (c.available) {
                    double distanceDiff = Math.abs(c.distance - orderDistance); // Absolute distance difference
                    if (distanceDiff < minDistanceDiff) {
                        minDistanceDiff = distanceDiff;
                        nearest = c;
                    }
                }
            }
            return nearest;
        }

        public static void main(String[] args) {
            Task3_Coding_2[] couriers = {
                    new Task3_Coding_2(1, 10.0, true),
                    new Task3_Coding_2(2, 11.0, true),
                    new Task3_Coding_2(3, 15.0, false),
                    new Task3_Coding_2(4, 9.0, true)
            };

            Task3_Coding_2 nearest = findNearest(couriers, 13);

            if (nearest != null) {
                System.out.println("Nearest courier ID: " + nearest.id);
            } else {
                System.out.println("No available couriers.");
            }
        }
    }

