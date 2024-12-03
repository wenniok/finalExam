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

    public void sortPackages() {
        System.out.println("Packages unsorted!");
        this.displayAllPackages();
        // Buble sort -- start
        int n = packages.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (packages.get(j).getWeight() > packages.get(j + 1).getWeight()) {
                    Package temp = packages.get(j);
                    packages.set(j, packages.get(j + 1));
                    packages.set(j + 1, temp);
                }
            }
        }
        // Buble sort -- end
        System.out.println("\nPackages sorted by weight!");
        this.displayAllPackages();
    }

    public void searchPackageByTrackingID(String trackingID) {

        packages.sort(Comparator.comparing(p -> p.getTrackingID()));
        boolean found = false;
        int left = 0, right = packages.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Package midPackage = packages.get(mid);
            if (midPackage.getTrackingID().equals(trackingID)) {
                System.out.println("Package Found:");
                System.out.format("Tracking ID: %s | Destination: %s | Weight: %.2f | Cost: $%.2f\n", midPackage.getTrackingID(), midPackage.getDestination(), midPackage.getWeight(), midPackage.calculateShippingCost());
                found = true;
                break;
            } else if (midPackage.getTrackingID().compareTo(trackingID) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (!found) {
            System.out.println("Package Not Found!");
        }
    }
}
