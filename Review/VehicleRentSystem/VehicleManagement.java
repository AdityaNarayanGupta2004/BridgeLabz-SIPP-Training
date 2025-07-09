import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManagement {
    static ArrayList<Customer> customerList = new ArrayList<>();
    public static void calculateRent(Vehicle v, int days) {
        System.out.println("Your total rent is: " + v.getCharge() * days);
    }

    public static void updateCharge(Scanner sc) {
        System.out.println("Enter vehicle to update (Bike, Car, Truck):");
        String type = sc.next();
        System.out.println("Enter new charge:");
        int newCharge = sc.nextInt();

        Vehicle v;
        if (type.equalsIgnoreCase("Bike")) {
            v = new Bike();
        } else if (type.equalsIgnoreCase("Car")) {
            v = new Car();
        } else if (type.equalsIgnoreCase("Truck")) {
            v = new Truck();
        } else {
            System.out.println("Invalid vehicle type.");
            return;
        }

        v.setCharge(newCharge);
        System.out.println(type + " charge updated successfully.");
    }

    public static void showCustomerDetails() {
        if (customerList.isEmpty()) {
            System.out.println("No customer data available.");
        } else {
            for (Customer c : customerList) {
                System.out.println("Name: " + c.name);
                System.out.println("ID: " + c.id);
                System.out.println("Vehicle: " + c.vehicleType);
                System.out.println("Days: " + c.days);
                System.out.println("---------------------------");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nAre you a customer or owner? {0: Customer, 1: Owner, -1: Exit}");
            int role = sc.nextInt();
            sc.nextLine(); 

            if (role == -1) {
                System.out.println("Exiting system.");
                break;
            }

            if (role == 0) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                System.out.print("Enter your Contact Number:");
                String contactNumber = sc.nextLine();

                System.out.print("Enter vehicle to rent (Bike, Car, Truck): ");
                String type = sc.nextLine();

                System.out.print("For how many days: ");
                int days = sc.nextInt();

                Vehicle v;
                if (type.equalsIgnoreCase("Bike")) {
                    v = new Bike();
                } else if (type.equalsIgnoreCase("Car")) {
                    v = new Car();
                } else if (type.equalsIgnoreCase("Truck")) {
                    v = new Truck();
                } else {
                    System.out.println("Invalid vehicle type.");
                    continue;
                }

                calculateRent(v, days);
                customerList.add(new Customer(name,contactNumber, IDGenerator.getId(), v.getType(), days));

            } else if (role == 1) {
                System.out.print("Enter password: ");
                String inputPass = sc.next();

                if (inputPass.equals(new Password().getPassword())) {
                    System.out.println("Welcome, Owner!");
                    System.out.println("1. Show all customer details\n2. Change vehicle charges");
                    int choice = sc.nextInt();

                    if (choice == 1) {
                        showCustomerDetails();
                    } else if (choice == 2) {
                        updateCharge(sc);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                } else {
                    System.out.println("Wrong password!");
                }

            } else {
                System.out.println("Invalid input.");
            }
        }

    }
}
