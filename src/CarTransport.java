
import java.awt.*;

public class CarTransport extends Cars { //Är en subklass till cars

    Boolean trailerUp = false; //har bara två lägen. Den är antingen uppe eller nere. Börjar nere.

    Cars[] carsOnTruck = new Cars[3]; //vektor, går från 0 till 2 i detta fall. Kan ej lägga till fler element.

    public CarTransport() {
        super(2, 100, Color.green, "Car Transport", "North");
    }

    public void trailerUp() {
        if (this.getCurrentSpeed() != 0) {
            System.out.println("Can't move trailer when Truck is in moving");
        } else {
            trailerUp = true;
        }
    }

    public void trailerDown() {
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

                x = x + 1;
            }
        }
        return x;
        //sätter en variabel x = 0. Kör en for loop som går igenom alla element tills ett element är tomt.
        //om alla plater är fulla returnerar den 3. Annars returnerar den den plats som är tom och sätter det som x.
        //om det är den tredje som är tom så blir i 2 eftersom den går igeonom alla elemnent 0 till 2.
    }

    public void loadCar(Cars car){
        if (car instanceof CarTransport){
            System.out.println("The truck can't carry another car transport");
            //vi kollar så att det inte får vara en car transport object som lastas.
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
            //om det inte skiljer sig mer än 1 i både y och x led mellan distansen av car transport och bilen som ska
            //lastas så kan den lastas.
            //man lägger in car i listan på den sista lediga positionen.
            //ger car samma position som cartransport.

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
        int carInList = checkIfCarIsInList(car); //int carInList får värdet av metod checkIfCarIsInList.
        if (carInList == 10) {
            System.out.println("Car not on truck"); //om värdet är 10
        }
        else if (carInList == getNrOfCarsInTruck() -1){ //Ex. säg att vi har bilen Bob som är på sista positionen. Då
            // kommer getNrOfCarsInTruck() returnera 3. Vi vill i detta fallet att den ska returnera 2 eftersom
            // bob är på element 2.
            carsOnTruck[carInList] = null; //tömmer platsen bilen stod på.
            car.setPosY(this.getPosY() + 0.1);
            car.setPosX(this.getPosX() + 0.1);
        }
    }



    public double speedFactor() {
        if (carsOnTruck[0] == null) {
            return 55;
        }
        else if (carsOnTruck[0] != null && carsOnTruck[1] == null ) {
            return 40;
        }
        else {
            return 25;
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
                    for (int i = 0; i< getNrOfCarsInTruck();  i++){
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
                    //den här metoden gör så att bilarna åker med biltransporten.
            }
        }

    }







