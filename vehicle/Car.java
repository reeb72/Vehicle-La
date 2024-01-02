package vehicle;
import java.util.List;

public abstract class Car {

    private String make;
    private String model;
    private double startingOdometerValue;

    /**
     * Creates a car with starting total miles on the odometer.
     * 
     * @throws IllegalArgumentException if startingOdometerValue is negative
     */
    public Car(String make, String model, double startingOdometerValue) throws IllegalArgumentException {
        if (startingOdometerValue < 0) {
            throw new IllegalArgumentException("Odometer Cannot have a negative value");
        }

        this.make = make;
        this.model = model;
        this.startingOdometerValue = startingOdometerValue;
    }

    /** Defaults startingOdometerValue to 0. */
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.startingOdometerValue = 0;
    }

    /**
     * If able to drive the full given number of miles, returns true. If
     * not, returns false. (Determination is based upon how far the car can
     * drive given the remaining fuel/energy reserves.)
     * 
     * @throws IllegalArgumentException if miles is negative.
     */
    public boolean canDrive(double miles) throws IllegalArgumentException {
        if (miles < 0) {
            throw new IllegalArgumentException("No negative miles chap");
        }
        return getRemainingRange() >= miles;
    }

    /**
     * Drives the full given number of miles.
     * 
     * @throws IllegalArgumentException if miles is negative or if miles is
     *                                  too high given the current fuel.
     */
    public abstract void drive(double miles);

    /**
     * Gives String representation of Car as
     * "<make and model> (<miles> mi)"
     * Odometer miles should be rounded to 1 decimal place. If miles is a
     * whole number, ".0" should still display.
     */
    public String toString() {
        return String.format("%s %s (%.1f mi)", getMake(), getModel(), getOdometerMiles());
    }

    /** Returns how many miles have been driven so far (odometer). */
    public double getOdometerMiles() {
        return this.startingOdometerValue;
    }

    /** Returns the make of the car. */
    public String getMake() {
        return make;
    }

    /** Returns the model of the car. */
    public String getModel() {
        return model;
    }

    /**
     * Returns how many more miles the car can currently go given the
     * remaining fuel/energy reserves.
     */
    public abstract double getRemainingRange();

    /**
     * Adds miles to the odometer.
     * 
     * @throws IllegalArgumentException if miles is negative.
     */
    protected void addMiles(double miles) throws IllegalArgumentException {
        if (miles < 0) {
            throw new IllegalArgumentException("No negative miles chap");
        }
        startingOdometerValue += miles;
    }

    /**
     * The car attempts to drive, in order, each of the daily number of
     * miles in the list milesEachDay. Once the car cannot drive one of the
     * day’s distance, no more days are attempted. Returns the number of
     * days successfully driven.
     * 
     * @throws IllegalArgumentException if miles is negative for any of the
     *                                  attempted days. The exception check should
     *                                  occur prior to any driving
     *                                  is attempted.
     */
    public int roadTrip(List<Double> milesEachDay) {
        int days = 0; 

        for (int i = 0; i < milesEachDay.size(); i++) {
            if (milesEachDay.get(i) < 0) {
                    throw new IllegalArgumentException("No negative miles you whippersnapper");
            }
            if(canDrive(milesEachDay.get(i))){
                days++;
            }
        }

        return days;
    }
}