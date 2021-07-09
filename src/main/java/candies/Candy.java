package candies;

import java.util.Random;

public class Candy {

    private final String NAME;
    private final int MIN_PRICE;
    private final int MAX_PRICE;
    private final int SPECIAL_HIGH_MIN_PRICE;
    private final int SPECIAL_HIGH_MAX_PRICE;
    private final int SPECIAL_LOW_MIN_PRICE;
    private final int SPECIAL_LOW_MAX_PRICE;

    private int todaysPrice;


    // Each time a subclass calls this constructor, it will pass in these high and low constraints.
    // Methods in the candies.Candy class will choose a random value between these ranges when called upon.
    public Candy(String name, int minPrice, int maxPrice, int specialHighMinPrice, int specialHighMaxPrice,
                                                          int specialLowMinPrice, int specialLowMaxPrice) {
        this.NAME = name;
        this.MIN_PRICE = minPrice;
        this.MAX_PRICE = maxPrice;
        this.SPECIAL_HIGH_MIN_PRICE = specialHighMinPrice;
        this.SPECIAL_HIGH_MAX_PRICE = specialHighMaxPrice;
        this.SPECIAL_LOW_MIN_PRICE = specialLowMinPrice;
        this.SPECIAL_LOW_MAX_PRICE = specialLowMaxPrice;

    }

    public String getName() {
        return NAME;
    }

    public int getMinPrice() {
        return MIN_PRICE;
    }

    public int getMaxPrice() {
        return MAX_PRICE;
    }

    public int getSpecialHighMinPrice() {
        return SPECIAL_HIGH_MIN_PRICE;
    }

    public int getSpecialHighMaxPrice() {
        return SPECIAL_HIGH_MAX_PRICE;
    }

    public int getSpecialLowMinPrice() {
        return SPECIAL_LOW_MIN_PRICE;
    }

    public int getSpecialLowMaxPrice() {
        return SPECIAL_LOW_MAX_PRICE;
    }

    // call this to set today's price normally
    public void setTodaysPriceNormal() {
        Random r = new Random();
        todaysPrice = r.nextInt(MAX_PRICE - MIN_PRICE + 1) + MIN_PRICE;
    }

    // call this to set today's price if this candy is at a special high price today
    public void setTodaysPriceSpecialHigh() {
        Random r = new Random();
        todaysPrice = r.nextInt(SPECIAL_HIGH_MAX_PRICE - SPECIAL_HIGH_MIN_PRICE + 1) + SPECIAL_HIGH_MIN_PRICE;
    }

    // call this to set today's price if this candy is at a special low price today
    public void setTodaysPriceSpecialLow() {
        Random r = new Random();
        todaysPrice = r.nextInt(SPECIAL_LOW_MAX_PRICE - SPECIAL_LOW_MIN_PRICE + 1) + SPECIAL_LOW_MIN_PRICE;
    }

    public int getTodaysPrice() {
        return todaysPrice;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
