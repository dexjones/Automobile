/*
Written by Dexter Jones

Pseudocode for Main:

*Call automobile class with parameterized constructor.
*call the method to list the values. Loop through the array and print to the screen.
*Call the remove vehicle method to clear the variables.
*Print the return value.
*Add a new vehicle.
*Print the return value.
*Call the list method and print the new vehicle information to the screen.
*Update the vehicle.
*Print the return value.
*Call the listing method and print the information to the screen.
*Display a message asking if the user wants to print the information to a file (Y or N).
*Use a scanner to capture the response. If "Y", print the file to a predefined location (e.g., C:\Temp\Autos.txt).
Note: you may want to create a method to print the information in the main class.
If "N", indicate that a file will not be printed.

input:
String: make, model, color
int: year, mileage
** and updated attributes of same data types above

output:
String: vehicle attributes (each element of ArrayList vehicle from Inventory.java)

 */
import java.util.*;
public class Main {
    public static boolean isString(String s) { // user input validation - returns true if correct choices input
        String val = s.toUpperCase();
        if (val.equals("Y") || val.equals("N")) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean b = false, save = false;
        String make = "", model = "", color = "", s, leave;
        String newMake, newModel, newColor;
        int year = 0, mileage = 0, choice = 0, update = 0, delete = 0;
        int newYear = 0, newMileage = 0;
        Inventory inventory = new Inventory();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        System.out.println("Dealership Inventory Program\n---------------------------------------");


        while (choice != 6) { // loops through program until user wants to exit

            System.out.println("*Main Menu*\n1: Add Vehicle\n2: Update Vehicle\n3: Delete Vehicle\n4: List Vehicle\n5: Export File\n6: End Program");
            System.out.println("---------------------------------------");
            while (true) { // user validation for menu selection
                System.out.print("Enter from the options above: ");
                s = scnr.nextLine();
                try {
                    choice = Integer.parseInt(s);
                    break;
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                    System.out.print("Please enter a number between 1 and 6: ");
                }
            }
            switch (choice) { // each case is a menu selection
                case 1: // Add Vehicle
                    System.out.println("---------------------------------------");
                    System.out.print("Enter the make of the vehicle: ");
                    make = scnr.nextLine();
                    System.out.print("Enter the model of the vehicle: ");
                    model = scnr.nextLine();
                    System.out.print("Enter the color of the vehicle: ");
                    color = scnr.nextLine();
                    System.out.print("Enter the year of the vehicle: ");

                    while (true) { // try user input until correct input given
                        s = scnr.nextLine();
                        try {
                            year = Integer.parseInt(s);
                            if (year >= 1885 && year <= (currentYear + 1)) {
                                break; // exit loop - input is valid
                            }
                            else {
                                System.out.println("Please enter a year between 1885 and current year plus 1: ");
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid entry. Please enter a number for year of vehicle: ");
                        }
                    }
                    System.out.print("Enter the mileage of the vehicle: ");
                    while (true) { // try user input until correct input given
                        s = scnr.nextLine();
                        try {
                            mileage = Integer.parseInt(s);
                            if (mileage >= 0) {
                                break; // exit loop - input is valid
                            }
                            else {
                                System.out.println("Please enter a number for mileage");
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid entry. Please enter mileage of vehicle");
                        }
                    }
                    Automobile a = new Automobile(make, model, color, year, mileage);
                    Inventory.addVehicle(a);
                    System.out.println("\n**Vehicle added to inventory**\n");
                    Inventory.viewVehicle();
                    save = false; // changes to list
                    break;
                case 2: // Update vehicle
                    Inventory.viewVehicle();
                    System.out.print("Enter the number ID of the vehicle you would like to update: ");
                    while (true) { // try user input until correct input given
                        s = scnr.nextLine();
                        try {
                            update = Integer.parseInt(s);
                            if (Inventory.checkID(update)) {
                                break; // exit loop - input is valid
                            }
                            else {
                                System.out.print("Please enter a correct ID number for vehicle to update: ");
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.print("Invalid entry. Please enter ID of vehicle: ");
                        }
                    }
                    System.out.print("Enter the make of the updated vehicle: ");
                    newMake = scnr.nextLine();
                    System.out.print("Enter the model of the updated vehicle: ");
                    newModel = scnr.nextLine();
                    System.out.print("Enter the color of the updated vehicle: ");
                    newColor = scnr.nextLine();
                    System.out.print("Enter the year of the updated vehicle: ");
                    while (true) { // try user input until correct input given
                        s = scnr.nextLine();
                        try {
                            newYear = Integer.parseInt(s);
                            if (newYear >= 1885 && year <= (currentYear + 1)) {
                                break; // exit loop - input is valid
                            }
                            else {
                                System.out.println("Please enter a year between 1885 and current year plus 1: ");
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid entry. Please enter year of updated vehicle: ");
                        }
                    }
                    System.out.print("Enter the mileage of the updated vehicle: ");
                    while (true) { // try user input until correct input given
                        s = scnr.nextLine();
                        try {
                            newMileage = Integer.parseInt(s);
                            if (newMileage >= 0) {
                                break; // exit loop - input is valid
                            }
                            else {
                                System.out.print("Please enter a number for mileage: ");
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.print("Invalid entry. Please enter mileage of updated vehicle: ");
                        }
                    }
                    Inventory.updateVehicle(update, newMake, newModel, newColor, newYear, newMileage);
                    System.out.println("Updated vehicle...\n");
                    Inventory.viewVehicle();
                    save = false; // changes to list
                    break;
                case 3: // Delete vehicle
                    Inventory.viewVehicle();
                    System.out.print("Which vehicle do you want to delete from the list? ID#:  ");
                        while (true) { // try user input until correct input given
                            s = scnr.nextLine();
                            try {
                                delete = Integer.parseInt(s);
                                if (Inventory.checkID(delete)) {
                                    Inventory.removeVehicle(delete);
                                    System.out.println("\nDeleted vehicle...\n");
                                    break; // exit loop - input is valid
                                }
                                else {
                                    System.out.print("Entry out of bounds or not a valid ID. Please enter a valid number: ");
                                }
                            }
                            catch (NumberFormatException e) {
                                System.out.print("Invalid Entry. Please enter a number for vehicle needing deleted: ");
                            }
                            catch (Exception e) {
                                System.out.print("Invalid entry. Number out of bounds or null ID: ");
                            }
                        }
                    Inventory.viewVehicle();
                    save = false; // changes to list
                    break;
                case 4: // List vehicle list
                    Inventory.viewVehicle();
                    break;
                case 5: // Export file
                    Inventory.inventoryLog("inventory.txt");
                    save = true;
                    break;
                case 6: // End program - check to make sure vehicles saved on file before exiting
                    if (!save) {
                        System.out.println("The vehicle inventory file was never created/updated, save vehicle log before exiting?");
                        System.out.print("Enter 'Y' for yes, 'N' for no: ");
                        while (true) {
                            try {
                                leave = scnr.nextLine();
                                if (isString(leave)) {
                                    break;
                                }
                            }
                            catch (NumberFormatException e) {
                                System.out.println("Invalid entry. Must enter a whole number");
                            }
                            catch (Exception e) {
                                System.out.println("Invalid entry. Must enter 0 or 1");
                            }
                        }
                        if (leave.equalsIgnoreCase("Y")) {
                            Inventory.inventoryLog("inventory.txt");
                            System.out.println("Exiting, goodbye...");
                        }
                        else {
                            System.out.println("Exiting, goodbye...");
                        }
                    }
            }
        }
    }
}
