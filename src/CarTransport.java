
import java.awt.*;

public class CarTransport extends Trucks {

    Boolean trailerUp = false;

    Cars[] carsOnTruck = new Cars[3];

    public CarTransport() {
        super(2, 100, Color.green, "Car Transport", "North");
    }

    public void trailerUp() {
        //boolean b = this.getCurrentSpeed() != 0;
        if (this.getCurrentSpeed() != 0) {
            System.out.println("Can't move trailer when Truck is in moving");
        } else {
            trailerUp = true;
        }
    }

    public void trailerDown() {
        //boolean b = this.getCurrentSpeed() != 0;
        if (this.getCurrentSpeed() != 0) {
            System.out.println("Can't move trailer when Truck is in moving");

        }
        else {
            trailerUp = false;
        }
    }

    public int getNrOfCarsInTruck() {
        int x = 0;
        for (int i = 0; i < carsOnTruck.length; i++) {
            if (carsOnTruck[i] != null) {
                x= x+ 1;
            }
        }
        return x;
    }

    public void loadCar(Cars car){
        if (car instanceof CarTransport){
            System.out.println("The truck can't carry another car transport");
        }

        else if (getNrOfCarsInTruck() == 3){
            System.out.println("The truck is full");
        }

        else if (trailerUp == true){
            System.out.println("The truck is up");
        }

        else if (Math.abs(this.getPosY() - car.getPosY()) <1 && Math.abs(this.getPosX() - car.getPosX()) <1 ){
            carsOnTruck[getNrOfCarsInTruck()] = car;
            car.setPosY(this.getPosY());
            car.setPosX(this.getPosX());

        }
    }

    private int checkIfCarIsInList(Cars car){
        int x = 10;
        for ( int i = 0 ; i < carsOnTruck.length; i++){
            if ( car == carsOnTruck[i])
            { x = i;}
        }
        return x;
    }

    public void unloadCar(Cars car) {
        int carInList = checkIfCarIsInList(car);
        if (carInList == 10) {
            System.out.println("Car not on truck");
        }
        else if (carInList == getNrOfCarsInTruck() -1){
            carsOnTruck[getNrOfCarsInTruck()-1] = null;
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
                    for (int i = 0; i< getNrOfCarsInTruck(); i++) {
                        carsOnTruck[i].setPosY(posY + currentSpeed);
                    }
                    break;
                case "South":
                    setPosY( posY - currentSpeed);
                    for (int i = 0; i< getNrOfCarsInTruck(); i++) {
                        carsOnTruck[i].setPosY(posY + currentSpeed);
                    }
                    break;
                case "West":
                    setPosX( posX - currentSpeed);
                    for (int i = 0; i< getNrOfCarsInTruck(); i++) {
                        carsOnTruck[i].setPosX(posX + currentSpeed);
                    }
                    break;
                case "East":
                    setPosX( posX + currentSpeed);
                    for (int i = 0; i< getNrOfCarsInTruck(); i++) {
                        carsOnTruck[i].setPosX(posX + currentSpeed);
                    }
                    break;
            }
        }

    }







