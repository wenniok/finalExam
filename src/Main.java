import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        CourierManager courierManager = new CourierManager();
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int option = 0;
        while (option != 5) {
            System.out.println("===============================");
            System.out.println("Welcome to Delivery Dilemmas!");
            System.out.println("===============================");
            System.out.println("Please select an option:\n");
            System.out.println("1. Add a new package");
            System.out.println("2. Display all packages and shipping costs");
            System.out.println("3. Sort packages by weight");
            System.out.println("4. Search for a package by Tracking ID");
            System.out.println("5. Exit\n");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter package type (Standard/Express): ");
                    String packageType = scanner.next();
                    System.out.print("Enter tracking ID: ");
                    String trackingID = scanner.next();
                    System.out.print("Enter destination: ");
                    String destination = br.readLine();
                    System.out.print("Enter weight: ");
                    double weight = scanner.nextDouble();
                    if (packageType.equals("Standard")) {
                        courierManager.addPackage(new StandardPackage(trackingID, destination, weight));
                    } else if (packageType.equals("Express")) {
                        courierManager.addPackage(new ExpressPackage(trackingID, destination, weight));
                    } else {
                        System.out.println("Invalid package type. Please, try again!");
                    }
                    break;
                case 2:
                    courierManager.displayAllPackages();
                    break;
                case 3:
                    courierManager.sortPackages();
                    break;
                case 4:
                    System.out.print("Enter Tracking ID: ");
                    String trackid = scanner.next();
                    courierManager.searchPackageByTrackingID(trackid);
                    break;
                case 5:
                    System.out.println("Thank you for using Delivery Dilemmas!");
                    break;
            }
        }











    }
}