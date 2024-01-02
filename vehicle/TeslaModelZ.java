package vehicle;
public class TeslaModelZ extends ElectricCar implements SelfDriving {

    private int modelNum;

    /**
     * modelNum specifies the model number. Tesla cares about that
     * stuff. Tesla Model Z’s have a 340 mile range on a full charge.
     * For a Tesla, the make is Tesla. The model is Z. The model number is
     * an additional value.
     */
    public TeslaModelZ(double startingOdometerValue, int modelNum) {
        super("Tesla", "Z", startingOdometerValue, 340);
        this.modelNum = modelNum;
    }

    /** Defaults startingOdometerValue to 0. */
    public TeslaModelZ(int modelNum) {
        this(0, modelNum);
    }

    /** Returns the model number. */
    public int getModelNum() {
        return modelNum;
    }

    /**
     * Returns the model and model number concatenated together. For
     * example, returns "Z70" for modelNum 70.
     */
    public String getModel() {
        return super.getModel() + modelNum;
    }

    /**
     * Prints out the make, model, model number, and odometer miles.
     * Ex: "Tesla Z70 (30.0 mi)"
     * You may not need to implement this method depending on how you
     * implement Car.toString()
     */
    public String toString() {
        return super.toString();
    }

    /**
     * Driving autonomously works the same as regular driving does.
     * Very convenient! Except it doesn’t deal with fueling at all – if you
     * can’t make it all the way, it drives as far as it can before running
     * out of fuel.
     * 
     * @throws IllegalArgumentException if miles is negative.
     */
    public void driveAutonomously(double miles) {
        if (miles < 0){
            throw new IllegalArgumentException("PLEASE just make the miles positive omg");
        }

        if(getRemainingRange() < miles){
            drive(getRemainingRange());
        }
        else{
            drive(miles);
        }
        
    }
}
