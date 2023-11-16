import java.util.ArrayList;
import java.util.List;

public class CarShop <T> {

    List<T> carsInShop;
    private int maxNrCars;

    public CarShop(int maxNrCars) {
        this.maxNrCars = maxNrCars;
        this.carsInShop = new ArrayList<>(maxNrCars);

    }

    public void loadCarsInShop(T vehicle) {
        if (vehicle instanceof CarShop) {
            System.out.println("The shop can't fix another car shop");
        } else if (carsInShop.size() == maxNrCars) {
            System.out.println("The shop is full");
        } else {
            carsInShop.add(vehicle);

        }
    }

    private int checkIfCarIsInShop(T vehicle){
        int x = 10;
        for ( int i = 0 ; i < carsInShop.size(); i++){
            if ( vehicle == carsInShop.get(i))
            { x = i;}
        }
        return x;
    }

    public void unloadCarsInShop (T vehicle) {
        int x = checkIfCarIsInShop(vehicle);
        if (x != 10){
            carsInShop.remove(x);
        }
        else{
            System.out.println("Car is not here, try another shop");
        }
    }
}

/*

        public void unloadCarsFromShop(T vehicle){
            int carInList = checkIfCarIsInList(car);
            if (carInList == 10) {
                System.out.println("Car not on truck");
            }
            else if (carInList == getNrOfCarsInTruck() -1){
                carIsShop.remove(carInList);
                car.setPosY(this.getPosY() + 0.1);
                car.setPosX(this.getPosX() + 0.1);
            }
        }
*/




/*    public void unloadCar(Cars car) {
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
    }*/





