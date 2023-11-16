import java.util.ArrayList;
import java.util.List;

public class CarShop <T> { //T är en viss typparamenter eftersom vissa verkstäder endast kunde ta emot vissa modeller.

    List<T> carsInShop;
    private int maxNrCars;

    //sätter ett maxantal bilar och skapar en ny arraylist i carshop
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
        int x = -1;
        for ( int i = 0 ; i < carsInShop.size(); i++){
            if ( vehicle == carsInShop.get(i))
            { x = i;} //för varje itteration av loopen
        }
        return x;
    }

    public void unloadCarsInShop (T vehicle) {
        int x = checkIfCarIsInShop(vehicle);
        if (x != -1){
            carsInShop.remove(x);
        }
        else{
            System.out.println("Car is not here, try another shop");
        }
    }
}





