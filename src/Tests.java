public class Tests {

    public static void main(String[] args) {
        CourierManager courierManager = new CourierManager();

        // Add standard package
        System.out.println("-----Add standard package");
        Package standard01 = new StandardPackage("PKG12345", "123 home", 3.0);
        courierManager.addPackage(standard01);
        courierManager.displayAllPackages();

        // Add Express package
        System.out.println("\n-----Add Express package");
        Package express01 = new ExpressPackage("PKG54321", "123 home", 3.0);
        courierManager.addPackage(express01);
        courierManager.displayAllPackages();

        // Try to add package with incorrect packageID
        System.out.println("\n-----Try to add package with incorrect packageID");
        Package express02 = new ExpressPackage("PKG543210", "123 home", 4.0);
        courierManager.addPackage(express02);
        courierManager.displayAllPackages();

        // Try to add package with incorrect destination
        System.out.println("\n-----Try to add package with incorrect destination");
        Package standard02 = new StandardPackage("PKI54321", "home sweet home", 3.5);
        courierManager.addPackage(standard02);
        courierManager.displayAllPackages();

        // Add new standard package
        System.out.println("\n-----Add new standard package");
        Package standard03 = new StandardPackage("PKG10101", "123 home", 6.0);
        courierManager.addPackage(standard03);
        courierManager.displayAllPackages();

        // Add newExpress package
        System.out.println("\n-----Add newExpress package");
        Package express03 = new ExpressPackage("PYG54321", "10 home", 5.3);
        courierManager.addPackage(express03);
        courierManager.displayAllPackages();

        // Sorting package by weight using bubleSort
        System.out.println("\n-----Sorting package by weight using bubleSort");
        courierManager.sortPackages();

        // Searching package by trackingID using binarySearch
        System.out.println("\n-----Searching package by trackingID using binarySearch");
        courierManager.searchPackageByTrackingID("PKG54321");
    }

}
