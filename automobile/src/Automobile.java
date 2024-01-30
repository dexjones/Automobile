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
catch: print exception message
}

public addAutomobile(Automobile automobile) {
try:
    add automobile to array
catch:
    print exception message
}

public String listAutomobiles(Array of automobile information) {
try:
    for length of automobile array
        vehicle information added
catch:
    print exception message
return string array
}
public removeAutomobile(int vehicle) {
 remove vehicle from array[vehicle]
}
public updateVehicle (vehicle) {
add new information for vehicle from user
set new information for vehicle
}

 */
public class Automobile {
}
