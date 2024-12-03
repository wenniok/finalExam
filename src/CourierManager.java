import java.util.ArrayList;
import java.util.Comparator;

public class CourierManager {
    ArrayList<Package> packages;

    CourierManager () {
        packages = new ArrayList<>();
    }

    public void addPackage(Package p) {
        if (p.validateTrackingID()) {
            if (p.validateDestination()) {
                packages.add(p);
                System.out.println("Package added successfully!\n");
            } else {
                System.out.println("\nInvalid Destination\n");
            }
        } else {
            System.out.println("\nInvalid TrackID!\n");
        }
    }

    public void displayAllPackages() {
        if (packages.size() <= 0) { System.out.println("There is no package registered!\n"); }
        for (Package p: packages){
            System.out.format("Tracking ID: %s | Destination: %s | Weight: %.2f | Cost: $%.2f\n", p.getTrackingID(), p.getDestination(), p.getWeight(), p.calculateShippingCost());
        }
    }


}
