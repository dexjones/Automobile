import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean b = false;
        String make, model, color;
        String newMake, newModel, newColor;
        int year = 0, mileage = 0, choice = 0, update = 0, delete = 0;
        int newYear = 0, newMileage = 0;

        System.out.println("Dealership Inventory Program\n----------------------------------");
        System.out.println("*Main Menu*\n1: Add Vehicle\n2: Update Vehicle\n3: Delete Vehicle\n4: List Vehicle\n5: Export File\n6: End Program");

        while (choice != 6) {
            while (!b) {
                try {
                    choice = scnr.nextInt();
                    assert choice >= 1 && choice <= 6;
                    b = true;
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                    System.out.println("Please enter a number between 1 and 6: ");
                }
            }
            b = false; // reset value
            switch (choice) {
                case 1: // Add Vehicle
                    System.out.println("-----------------------------------");
                    System.out.print("Enter the make of the vehicle: ");
                    make = scnr.nextLine();
                    System.out.print("Enter the model of the vehicle: ");
                    model = scnr.nextLine();
                    System.out.print("Enter the color of the vehicle: ");
                    color = scnr.nextLine();
                    System.out.print("Enter the year of the vehicle: ");
                    while (!scnr.hasNextInt() && year <= 1885) { // try user input until correct input given
                            year = scnr.nextInt();
                            System.out.println("Invalid entry. Please enter year of vehicle");
                    }
                    System.out.print("Enter the mileage of the vehicle: ");
                    while (!scnr.hasNextInt() && mileage <= 0) { // try user input until correct input given
                            mileage = scnr.nextInt();
                            System.out.println("Invalid entry. Please enter mileage of vehicle");
                    }
                    Automobile a = new Automobile(make, model, color, year, mileage);
                    Inventory.addVehicle(a);
                    System.out.println("\n**Vehicle added to inventory**\n");
                case 2: // Update vehicle
                    Inventory.viewVehicle();
                    System.out.print("Enter the number ID of the vehicle you would like to update: ");
                    while (!scnr.hasNextInt() && update < 0) {
                        update = scnr.nextInt();
                            System.out.println("Invalid entry. Please enter a number for the ID.\n");
                    }
                    System.out.print("Enter the make of the updated vehicle: ");
                    newMake = scnr.nextLine();
                    System.out.print("Enter the model of the updated vehicle: ");
                    newModel = scnr.nextLine();
                    System.out.print("Enter the color of the updated vehicle: ");
                    newColor = scnr.nextLine();
                    System.out.print("Enter the year of the updated vehicle: ");
                    while (!scnr.hasNextInt() && newYear < 1885) { // try user input until correct input given
                        newYear = scnr.nextInt();
                        System.out.println("Invalid entry. Please enter the year of the updated vehicle");
                    }
                    System.out.print("Enter the mileage of the updated vehicle: ");
                    while (!scnr.hasNextInt() && newMileage < 0) { // try user input until correct input given
                        newMileage = scnr.nextInt();
                        System.out.println("Invalid entry. Please enter mileage of the updated vehicle");
                    }
                    Inventory.updateVehicle(update, newMake, newModel, newColor, newYear, newMileage);
                    System.out.println("Updated vehicle...\n");
                    Inventory.viewVehicle();
                case 3: // Delete vehicle
                    Inventory.viewVehicle();
                    while (!scnr.hasNextInt()) {
                        try {
                            delete = scnr.nextInt();
                            Inventory.removeVehicle(delete);
                            System.out.println("Deleted vehicle...\n");
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid Entry. Please enter a number for vehicle needing deleted.");
                        }
                        catch (Exception e) {
                            System.out.println("Invalid entry. Number out of bounds or null ID");
                        }
                    }
                    Inventory.viewVehicle();
            }
        }
    }
}
