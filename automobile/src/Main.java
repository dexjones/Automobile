import java.util.*;
import java.io.*;

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

        System.out.println("Dealership Inventory Program\n---------------------------------------");


        while (choice != 6) {

            System.out.println("*Main Menu*\n1: Add Vehicle\n2: Update Vehicle\n3: Delete Vehicle\n4: List Vehicle\n5: Export File\n6: End Program");
            System.out.println("---------------------------------------");
            while (true) {
                System.out.print("Enter from the options above: ");
                s = scnr.nextLine();
                try {
                    choice = Integer.parseInt(s);
                    break;
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                    System.out.print("Please enter a number between 1 and 6:");
                }
            }
            switch (choice) {
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
                            if (year > 1885) {
                                break; // exit loop - input is valid
                            }
                            else {
                                System.out.println("Please enter a year greater than 1885");
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid entry. Please enter year of vehicle");
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
                    System.out.println("---------------------------------------");
                    save = false; // changes to list
                    break;
                case 2: // Update vehicle
                    System.out.println("---------------------------------------");
                    Inventory.viewVehicle();
                    System.out.println("---------------------------------------");
                    System.out.print("Enter the number ID of the vehicle you would like to update: ");
                    while (true) { // try user input until correct input given
                        s = scnr.nextLine();
                        try {
                            update = Integer.parseInt(s);
                            if (update >= 0) {
                                // *****************************CHECK IF ID IS EVEN IN USE WITH SEPARATE METHOD
                                break; // exit loop - input is valid
                            }
                            else {
                                System.out.println("Please enter a correct ID number for vehicle to update");
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid entry. Please enter year of vehicle");
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
                            if (newYear > 1885) {
                                break; // exit loop - input is valid
                            }
                            else {
                                System.out.println("Please enter a year greater than 1885");
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid entry. Please enter year of updated vehicle");
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
                                System.out.println("Please enter a number for mileage");
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid entry. Please enter mileage of updated vehicle");
                        }
                    }
                    System.out.println("---------------------------------------");
                    Inventory.updateVehicle(update, newMake, newModel, newColor, newYear, newMileage);
                    System.out.println("Updated vehicle...\n");
                    Inventory.viewVehicle();
                    System.out.println("---------------------------------------");
                    save = false; // changes to list
                    break;
                case 3: // Delete vehicle
                    System.out.println("---------------------------------------");
                    Inventory.viewVehicle();
                    System.out.println("---------------------------------------");
                    System.out.print("Which vehicle do you want to delete from the list? ID#:  ");
                        while (true) { // try user input until correct input given
                            s = scnr.nextLine();
                            try {
                                delete = Integer.parseInt(s);
                                if (delete >= 0) {
                                    Inventory.removeVehicle(delete);
                                    System.out.println("\nDeleted vehicle...\n");
                                    break; // exit loop - input is valid
                                }

                            }
                            catch (NumberFormatException e) {
                                System.out.println("Invalid Entry. Please enter a number for vehicle needing deleted.");
                            }
                            catch (Exception e) {
                                System.out.println("Invalid entry. Number out of bounds or null ID");
                            }
                        }
                    System.out.println("---------------------------------------");
                    Inventory.viewVehicle();
                    System.out.println("---------------------------------------");
                    save = false; // changes to list
                    break;
                case 4: // List vehicle list
                    System.out.println("---------------------------------------");
                    Inventory.viewVehicle();
                    System.out.println("---------------------------------------");
                    break;
                case 5: // Export file
                    Inventory.inventoryLog("inventory.txt");
                    System.out.println("Inventory has been logged to inventory.txt in file directory.\n");
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
                        if (leave.equals("Y")) {
                            Inventory.inventoryLog("inventory.txt");
                            choice = 6;
                            System.out.println("Inventory has been logged to inventory.txt in file directory.\n");
                            System.out.println("Exiting, goodbye...");
                        }
                        else {
                            choice = 6;
                            System.out.println("Exiting, goodbye...");
                        }
                    }
            }
        }
    }
}
