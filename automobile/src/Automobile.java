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
try:
    make = ""
    model = ""
    color = ""
    year = 0
    mileage = 0
    id = ++id
catch:
    Print exception message
}

public Automobile(string make, string model, string color, int year, int mileage) { // parameterized constructor
try:
    make = make
    model = model
    color = color
    year = year
    mileage = mileage
    id = ++id
catch:
    print exception message
}
public int getId() {
    return id
}

public void setMake(String make) {
    this make = make
}
public void setModel(String model) {
    this model = model
}
public void setColor(String color) {
    this color = color
}
public void setYear(int year) {
    this year = year
}
public void setMileage(int mileage) {
    this.mileage = mileage;
}
public void updateAttributes(String make, String model, String color, int year, int mileage) {
    try:
        set all attributes
    catch:
        print exception message
 */
public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    private int id;
    private static int idCounter = 0;
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    public Automobile() { // default constructor
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
        this.id = ++idCounter;
    }
    public Automobile(String make, String model, String color, int year, int mileage) { // parameterized constructor
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.id = ++idCounter;
    }
    public int getId() {
            return id;
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
        try {
            if (make != null && !make.isEmpty()) {
                setMake(make);
            }
            if (model != null && !model.isEmpty()) {
                setModel(model);
            }
            if (color != null && !color.isEmpty()) {
                setColor(color);
            }
            if ( year >= 1885 && year <= (currentYear + 1)) {
                setYear(year);
            }
            if (mileage >= 0) {
                setMileage(mileage);
            }
        }
        catch (Exception e) {
            System.out.println("Error. Unable to update attributes.");
            System.out.println(e.getMessage());
        }
    }
    public String toString() { // method for formatting object automobile
        return String.format("ID# %d - Make: '%s', Model: '%s', Color: '%s', Year: %d, Mileage: %,d", id, make,model,color,year,mileage);
    }

}
