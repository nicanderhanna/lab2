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
                System.out.println("The truck is full");
            } else {
                carsInShop.add(vehicle);

            }
        }
    }



