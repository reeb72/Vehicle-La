package vehicle;
public abstract class GasPoweredCar extends Car {
    /**
     * Note: Start with a full tank of gas
     * 
     * @throws IllegalArgumentException if mpg or fuelCapacityGallons are
     *                                  non-positive.
     */

    private double mpg;
    private double fuelCapacityGallons;
    private double fuel;

    public GasPoweredCar(String make, String model, double startingOdometerValue, double mpg,
            double fuelCapacityGallons) {
        super(make, model, startingOdometerValue);
        this.mpg = mpg;
        this.fuelCapacityGallons = fuelCapacityGallons;

        if (mpg <= 0 || fuelCapacityGallons <= 0) {
            throw new IllegalArgumentException("Cannot accept any negative values");
        }
    }

    /**
     * Defaults startingOdometerValue to 0.
     * 
     * @throws IllegalArgumentException if mpg or fuelCapacityGallons are
     *                                  non-positive.
     */
    public GasPoweredCar(String make, String model, double mpg, double fuelCapacityGallons) {
        super(make, model);
        this.mpg = mpg;
        this.fuelCapacityGallons = fuelCapacityGallons;

        if (mpg <= 0 || fuelCapacityGallons <= 0) {
            throw new IllegalArgumentException("Cannot accept any negative values");
        }

    }

    /**
     * Drives the full given number of miles.
     * 
     * @throws IllegalArgumentException if miles is negative.
     * @throws IllegalArgumentException if miles is too high given the
     *                                  current fuel.
     */
    public void drive(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Yo cannot rive negative miles");
        }
        if (miles > (mpg * fuel)) {
            throw new IllegalArgumentException("You cannot drive this far... Not enough fuel");
        }

        if (canDrive(miles)) {
            this.decreaseFuelLevel(miles / mpg);
            addMiles(miles);
        }

    }

    /** Returns how many miles can be driven on one gallon of gas. */
    public double getMPG() {
        return mpg;
    }

    /** Returns how many gallons of fuel are currently in the car. */
    public double getFuelLevel() {
        return fuel;
    }

    /** Returns how many gallons of fuel the car can hold at max. */
    public double getFuelCapacity() {
        return fuelCapacityGallons;
    }

    /** Refuels the car to max fuel capacity. */
    public void refillTank() {
        fuel = fuelCapacityGallons;
    }

    /**
     * Returns how many more miles the car can currently go without
     * refueling.
     */
    public double getRemainingRange() {
        return fuel * mpg;
    }

    /**
     * Attempt to refuel the car with additional gallons.
     * 
     * @throws IllegalArgumentException if gallons is negative OR gallons
     *                                  would overfill the tank.
     */
    public void refillTank(double gallons) {
        if (0 > gallons) {
            throw new IllegalArgumentException("No negative gallons");
        } else if (fuel + gallons > fuelCapacityGallons) {
            throw new IllegalArgumentException("Too much gas!!!");
        }

        fuel += gallons;
    }

    /**
     * Decreases the amount of fuel in the gas tank based upon
     * mpg and the number of miles passed as an argument.
     */
    protected void decreaseFuelLevel(double miles) {
        fuel -= miles;
    }
}