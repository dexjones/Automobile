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
    private int id;
    private static ArrayList<Automobile> vehicleList = new ArrayList<>();

    public Automobile() { // default constructor
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
        this.id = 0;
    }
    public Automobile(String make, String model, String color, int year, int mileage) { // parameterized constructor
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.id += 1;
    }
    /*public static void addVehicle(Automobile automobile) {
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
    }*/
    public int getId() {
        return id;
    }
    public String getMake() {
        return this.make;
    }
    public String getModel() {
        return this.model;
    }
    public String getColor() {
        return this.color;
    }
    public int getYear() {
        return this.year;
    }
    public int getMileage() {
        return this.year;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public void updateAttributes(String make, String model, String color, int year, int mileage) {
        if (make != null && !make.isEmpty()) {
            setMake(make);
        }
        if (model != null && !model.isEmpty()) {
            setModel(model);
        }
        if (color != null && !color.isEmpty()) {
            setColor(color);
        }
        if ( year > 0) {
            setYear(year);
        }
        if (mileage >= 0) {
            setMileage(mileage);
        }
    }
    public String toString() { // method for formatting object automobile
        return "ID: " + id + "- Make: " + make + ", Model: " + model + ", Color: " + color + ", Year: " + year + ", Mileage: " + mileage;
    }

}
