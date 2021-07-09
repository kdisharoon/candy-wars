import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    private String name;
    private Integer currentMoney;
    private Map<Candy, Integer> candyInventory;
    private Neighborhood currentLocation;
    private Integer currentDebt;
    private Integer currentDay;
    private Integer maxInventory;

    public Player(Integer startingMoney, List<Candy> candyList, Integer startingDebt) {
        this.name = "Default Player";
        this.currentMoney = startingMoney;
        this.candyInventory = this.initialStockCandy(candyList);
        this.currentLocation = null;
        this.currentDebt = startingDebt;
        this.currentDay = 1;
        this.maxInventory = 100;
        //should we set currentLocation to an initial neighborhood value? Does it need to be null?
    }

    private Map<Candy, Integer> initialStockCandy(List<Candy> candyList) {
        Map<Candy, Integer> startingInventory = new HashMap<>();

        for (Candy c: candyList) {
            startingInventory.put(c, 0);
        }

        return startingInventory;
    }

    public void displayCandyInventory() {
        for (Candy c : candyInventory.keySet()) {
            System.out.println(candyInventory.get(c) + " " + c.getName() + " in your bag");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(Integer currentMoney) {
        this.currentMoney = currentMoney;
    }

    public Map<Candy, Integer> getCandyInventory() {
        return candyInventory;
    }

    public void setCandyInventory(Map<Candy, Integer> candyInventory) {
        this.candyInventory = candyInventory;
    }

    public Neighborhood getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Neighborhood currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Integer getCurrentDebt() {
        return currentDebt;
    }

    public void setCurrentDebt(Integer currentDebt) {
        this.currentDebt = currentDebt;
    }

    public Integer getCurrentDay() {
        return currentDay;
    }

    public void incrementCurrentDay() {
        this.currentDay++;
    }

    public Integer getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(Integer maxInventory) {
        this.maxInventory = maxInventory;
    }

    public int getCurrentItemsInInventory() {
        int count = 0;
        for (int value : this.candyInventory.values()) {
            count += value;
        }
        return count;
    }

}
