/*
public static void viewVehicle(Array of automobile information) {
    try:
    for length of automobile array
    print object in array element
catch:
    print exception message
}
public static void addAutomobile(Automobile automobile) {
try:
    add automobile to array
catch:
    print exception message
}

public static void removeAutomobile(int vehicle) {
    try:
    remove vehicle from array[vehicle]
catch:
    print exception message
}

public static void updateVehicle (vehicle attributes) {
    try:
        add new information for vehicle from user
        set new information for vehicle
    catch:
        print exception message
}
public static boolean checkID(int id) {
    try:
        iterate through vehicles to make sure ID is valid
        return true
    catch:
        print exception message
    return false

public static void inventoryLog(String file) {
    try:
        open file writer and write each element to file
    catch:
        print exception message
*/
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    private static ArrayList<Automobile> vehicles;
    public Inventory() { // default constructor
        try {
            vehicles = new ArrayList<Automobile>();
        }
        catch (Exception e) {
            System.out.println("Error. Unable to construct ArrayList.");
            System.out.println(e.getMessage());
        }
    }
    public static void addVehicle(Automobile a) {
        try {
            vehicles.add(a);
        }
        catch (Exception e) {
            System.out.println("Error. Unable to add vehicle.");
            System.out.println(e.getMessage());
        }
    }
    public static void viewVehicle() {
        try {
            System.out.println("---------------------------------------");
            System.out.println("Current Inventory:");
            for (Automobile automobile : vehicles) {
                System.out.println(automobile.toString());
            }
            System.out.println("---------------------------------------");
        }
        catch (Exception e) {
            System.out.println("Error. Unable to view inventory");
            System.out.println(e.getMessage());
        }
    }
    public static void removeVehicle(int id) {
        try {
            Iterator<Automobile> iterator = vehicles.iterator(); // Iterator to iterate through 'vehicles'
            while (iterator.hasNext()) {
                Automobile automobile = iterator.next();
                if (automobile.getId() == id) { //If object ID equals given ID, remove current object
                    iterator.remove();
                    return;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error. Unable to remove vehicle.");
            System.out.println(e.getMessage());
        }
    }
    public static void updateVehicle(int id, String make, String model, String color, int year, int mileage) {
        try {
            for (Automobile automobile : vehicles) { // Iterates through vehicles
                if (automobile.getId() == id) { // If ID's match, update attributes with given attributes
                    automobile.updateAttributes(make, model, color, year, mileage);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error. Unable to update vehicle.");
            System.out.println(e.getMessage());
        }
    }
    public static boolean checkID(int id) {
        try {
            for (Automobile automobile : vehicles) {
                if (automobile.getId() == id) {
                    return true;
                }
            }
        }
        catch (Exception e) {
            System.out.println("ID is out of bounds or null.");
        }
        return false;
    }
    public static void inventoryLog(String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) { //Opens file writer
            for (Automobile a : vehicles) { // Iterates through vehicles, writing each element to file
                fw.write(a.toString());
                fw.write("\n");
            }
            System.out.println("Inventory has been logged to " + fileName + " in the file directory.\n");
        }
        catch (IOException e) {
            System.out.println("Error. Unable to write file.");
            System.out.println(e.getMessage());
        }
    }
}
