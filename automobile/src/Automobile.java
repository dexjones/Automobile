import java.util.*;

/*
Written by Dexter Jones

Pseudocode:

Create an automobile class that will be used by a dealership as a vehicle inventory program.
The following attributes should be present in your automobile class:

private string make
private string model
private string color
private int year
private int mileage
Your program should have appropriate methods such as:

default constructor
parameterized constructor
add a new vehicle  method
list vehicle information (return string array)
remove a vehicle method
update vehicle attributes method

Automobile() - creates vehicle attributes and initializes vehicle // default constructor
public Automobile() {
make = ""
model = ""
color = ""
year = 0
mileage = 0
}

public Automobile(string make, string model, string color, int year, int mileage) { // parameterized constructor
try:
    make = make
    model = model
    color = color
    year = year
    mileage = mileage
catch:
    print exception message
}

public addAutomobile(Automobile automobile) {
try:
    add automobile to array
catch:
    print exception message
}

public String viewAutomobiles(Array of automobile information) {
try:
    for length of automobile array
        vehicle information added
catch:
    print exception message
return string array
}
public removeAutomobile(int vehicle) {
try:
    remove vehicle from array[vehicle]
catch:
    print exception message
}

public updateVehicle (vehicle) {
try:
    add new information for vehicle from user
    set new information for vehicle
catch:
    print exception message
}

 */
public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    private static ArrayList<Automobile> vehicleList = new ArrayList<>();

    public Automobile() { // default constructor
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }
    public Automobile(String make, String model, String color, int year, int mileage) { // parameterized constructor
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }
    public static void addVehicle(Automobile automobile) {
        vehicleList.add(automobile);
    }
    public static String[] viewVehicle() {
        String[] vehicleInfo = new String[vehicleList.size()];
        int num = 0;
        for (Automobile automobile : vehicleList) {
            vehicleInfo[num++] = automobile.toString();
            System.out.println(automobile.toString());
        }
        return vehicleInfo;
    }
    public static void removeVehicle(Automobile automobile) {
        vehicleList.remove(automobile);
    }
    public void updateVehicle(String make, String model, String color, int year, int mileage) {
        if (make != null && !make.isEmpty()) {
            this.make = make;
        }
        if (model != null && !model.isEmpty()) {
            this.model = model;
        }
        if (color != null && !color.isEmpty()) {
            this.color = color;
        }
        if ( year > 0) {
            this.year = year;
        }
        if (mileage >= 0) {
            this.mileage = mileage;
        }
    }
    public String toString() { // method for formatting object automobile
        return "Make: " + make + ", Model: " + model + ", Color: " + color + ", Year: " + year + ", Mileage: " + mileage;
    }

}
