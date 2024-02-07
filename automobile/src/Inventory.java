import java.util.ArrayList;

public class Inventory {
    private static ArrayList<Automobile> vehicles;
    public Inventory() { // default constructor
        vehicles = new ArrayList<Automobile>();
    }
    public void addVehicle(Automobile a) {
        vehicles.add(a);
    }
    public static String[] viewVehicle() {
        String[] vehicleInfo = new String[vehicles.size()];
        int num = 0;
        for (Automobile automobile : vehicles) {
            vehicleInfo[num++] = automobile.toString();
            System.out.println(automobile.toString());
        }
        return vehicleInfo;
    }
    public static void removeVehicle(Automobile a) {
        vehicles.remove(a);
    }
    public boolean updateVehicle(int id, String make, String model, String color, int year, int mileage) {
        for (Automobile automobile : vehicles) {
            if (automobile.getId() == id) {
                automobile.updateAttributes(make, model, color, year, mileage);
                return true;
            }
        }
        return false;
    }
}
