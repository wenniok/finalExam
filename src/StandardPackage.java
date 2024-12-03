public class StandardPackage extends Package{

    public StandardPackage(String trackingID, String destination, double weight) {
        super(trackingID, destination, weight);
    }

    @Override
    public double calculateShippingCost() {
        return this.getWeight() * 2.5;
    }

}
