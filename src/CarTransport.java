
import java.awt.*;

public class CarTransport extends Trucks {

    String trailerAngle = "Down";

    public CarTransport(int nrDoors, double enginePower, Color color, String modelName) {
        super(2, 100, Color.green, "Car Transport", "North");
    }

    public void trailerUp(){
        boolean b = this.getCurrentSpeed() != 0;
        if (b) {
            System.out.println("Can't move trailer when Truck is in moving");
        }
        trailerAngle = "UP";
    }

}

