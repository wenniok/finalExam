import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Package {
    private String trackingID;
    private String destination;
    private double weight;

    public Package(String trackingID, String destination, double weight) {
        this.trackingID = trackingID;
        this.destination = destination;
        this.weight = weight;
    }

    public abstract double calculateShippingCost();

    public boolean validateTrackingID() {
        Pattern pattern = Pattern.compile("^[A-Z]{3}[0-9]{5}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.getTrackingID());
        return matcher.find();
    }
    public boolean validateDestination() {
        Pattern pattern = Pattern.compile("^[0-9]+ [a-zA-z]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.getDestination());
        return matcher.find();
    }

    public String getTrackingID() {
        return trackingID;
    }

    public void setTrackingID(String trackingID) {
        this.trackingID = trackingID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
