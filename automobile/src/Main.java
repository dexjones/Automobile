import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean b = false;
        String make, model, color;
        int year = 0, mileage = 0, choice = 0, update = 0;

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
                    while (!b) { // try user input until correct input given
                        try {
                            year = scnr.nextInt();
                            assert year >= 1885;
                            b = true;
                        }
                        catch (Exception e) {
                            System.out.println("Invalid entry. Please enter year of vehicle");
                        }
                    }
                    b = false; // reset value
                    System.out.print("Enter the mileage of the vehicle: ");
                    while (!b) { // try user input until correct input given
                        try {
                            mileage = scnr.nextInt();
                            assert mileage >= 0;
                            b = true;
                        }
                        catch (Exception e) {
                            System.out.println("Invalid entry. Please enter mileage of vehicle");
                        }
                    }
                    Automobile a = new Automobile(make, model, color, year, mileage);
                    Automobile.addVehicle(a);
                    System.out.println("\n**Vehicle added to inventory**\n");
                    b = false; // reset value
                case 2: // Update vehicle

                    while (!b) {
                        try {
                            update = scnr.nextInt();
                            assert update >= 0 && update <= a.viewVehicle().length;
                            a.
                        }
                    }
            }
        }
    }
}
