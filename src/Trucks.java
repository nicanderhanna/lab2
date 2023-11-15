
import java.awt.*;

public class Trucks extends Cars {

    public Trucks(int nrDoors, double enginePower, Color color, String modelName, String direction) {
        super(nrDoors, enginePower, color, modelName, direction);
    }


    @Override
    public double speedFactor() {
        return 0;
    }
}
