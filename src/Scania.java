
import java.awt.*;

public class Scania extends Trucks {

    public double trailerAngle;


    public Scania() {
        super(2, 400, Color.blue, "Scania",
                "North");
        trailerAngle = 0;
    }

    public double speedFactor() {
        return 0;
    }

    public double getTrailerAngle(){
        return trailerAngle;
    }


    public void trailerUp(double amount) {
        boolean b = this.getCurrentSpeed() != 0;
        if (b) {
            System.out.println("Can't move trailer when Truck is in moving");
        }

        else if (trailerAngle + amount > 70) {
            trailerAngle = 70;
        }
        else{trailerAngle = trailerAngle + amount;}

    }

    public void trailerDown(double amount) {
        boolean b = this.getCurrentSpeed() != 0;
        if (b) {
            System.out.println("Can't move trailer when Truck is in moving");
        }
        else if (trailerAngle - amount < 0) {
            trailerAngle = 0;
        }
        else {trailerAngle = trailerAngle - amount;}
    }



    public void truckMove(){
        if (trailerAngle > 0){
            System.out.println("Truck can't move while trailer is up");
        }
        else{
            this.move();
        }
    }











/*    @Override
    public void move() {
        double posX = getPosX();
        //double posY = getPosY();
        double currentSpeed = getCurrentSpeed();
        String direction = getDirection();
        if (trailerAngle > 0) {
            System.out.println("Truck can't move while trailer is up");
        }
        else {
            switch (direction) {
                case "North":
                    double posY = getPosY() + currentSpeed;
                    break;
                case "South":
                    posY = posY - currentSpeed;
                    break;
                case "West":
                    posX = posX - currentSpeed;
                    break;
                case "East":
                    posX = posX + currentSpeed;
                    break;
            }
        }
    }*/

}
