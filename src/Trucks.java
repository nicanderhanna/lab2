
import java.awt.*;

public class Trucks<T> extends Cars {

    public abstract void trailerUp();

    public Trucks(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }


    @Override
    public double speedFactor() {
        return 0;
    }
}
