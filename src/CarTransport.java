
import java.awt.*;
import java.util.Arrays;

public class CarTransport extends Trucks {

    Boolean trailerUp = false;

    Cars[] carsOnTruck = new Cars[2];

    public CarTransport(int nrDoors, double enginePower, Color color, String modelName) {
        super(2, 100, Color.green, "Car Transport", "North");
    }

    public void trailerUp() {
        boolean b = this.getCurrentSpeed() != 0;
        if (b) {
            System.out.println("Can't move trailer when Truck is in moving");
        } else {
            trailerUp = true;
        }
    }

    public void trailedDown() {
        boolean b = this.getCurrentSpeed() != 0;
        if (b) {
            System.out.println("Can't move trailer when Truck is in moving");

        } else {
            trailerUp = false;
        }
    }

    public void loadCar(Cars car){
        if (car instanceof CarTransport){
            System.out.println("The truck can't carry another car transport");
        }

        else if (carsOnTruck.length == 3 && trailerUp == false){
            System.out.println("The truck is full or the trailer is up");
        }

        else if (Math.abs(this.getPosY() - car.getPosY()) <1 && Math.abs(this.getPosX() - car.getPosX()) <1 ){
            carsOnTruck[carsOnTruck.length] = car;
            car.setPosY(this.getPosY());
            car.setPosX(this.getPosX());

        }
    }

    private int checkIfCarIsInList(Cars car){
        int x = 0;
        for ( int i = 0 ; i< carsOnTruck.length; i++){
            if ( car == carsOnTruck[i])
            { x = i;}
            else {x=10;}
        }
        return x;
    }

    public void unloadCar(Cars car) {
        int carInList = checkIfCarIsInList(car);
        if (carInList == 10) {
            System.out.println("Car not on truck");
        }
        else if (carInList == carsOnTruck.length -1){
            carsOnTruck[carsOnTruck.length - 1] = null;
            car.setPosY(this.getPosY() + 0.1);
            car.setPosX(this.getPosX() + 0.1);
        }
    }

    @Override
    public void move(){
        String direction = getDirection();
        double posY = getPosY();
        double posX = getPosX();
        double currentSpeed = getCurrentSpeed();

            switch (direction) {
                case "North":
                    setPosY(posY + currentSpeed);
                    for (int i = 0; i< carsOnTruck.length; i++) {
                        carsOnTruck[i].setPosY(posY + currentSpeed);
                    }
                    break;
                case "South":
                    setPosY( posY - currentSpeed);
                    for (int i = 0; i< carsOnTruck.length; i++) {
                        carsOnTruck[i].setPosY(posY + currentSpeed);
                    }
                    break;
                case "West":
                    setPosX( posX - currentSpeed);
                    for (int i = 0; i< carsOnTruck.length; i++) {
                        carsOnTruck[i].setPosX(posX + currentSpeed);
                    }
                    break;
                case "East":
                    setPosX( posX + currentSpeed);
                    for (int i = 0; i< carsOnTruck.length; i++) {
                        carsOnTruck[i].setPosX(posX + currentSpeed);
                    }
                    break;
            }
        }

    }





}

