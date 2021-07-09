import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CandyApp {

    private Scanner keyboard = new Scanner(System.in);
    private List<Neighborhood> neighborhoods = new ArrayList<>();
    private List<Candy> candies = new ArrayList<>();
    private Player thisPlayer;

    public CandyApp() {
        initializeNeighborhoods();
        initializeCandies();
        thisPlayer = new Player(50, candies, 55);
    }

    //displayWelcomeMenu only runs once, at the very start of the program
    private void displayWelcomeMenu() {
        System.out.println("Welcome to Candy Wars!\n");

        System.out.println("Put instructions here.\n");
    }

    //displayTodaysMenu runs at the start of each day, showing player their current statistics and prompting for them
    //to choose a neighborhood to visit today
    private void displayTodaysMenu(int currentDay) {
        System.out.println("\nToday is day " + currentDay + ".");

        thisPlayer.displayCandyInventory();
        System.out.println("You have $" + thisPlayer.getCurrentMoney() + " on hand.");
        System.out.println("You still owe the bank $" + thisPlayer.getCurrentDebt() + ".\n");

        System.out.println("Which neighborhood would you like to visit today?");
        printMenuOptionsToScreen(neighborhoods);
        System.out.print("Please choose an option between 1 and " + neighborhoods.size() + " >>> ");
    }

    private <T> void printMenuOptionsToScreen(List<T> listToPrint) {
        if (listToPrint != null) {
            int i = 1;
            for (T t : listToPrint) {
                System.out.println(i + ") " + t);
                i++;
            }
            System.out.println();
        }
    }

    //can add/remove neighborhoods here easily to change how many neighborhoods will be in each game
    private void initializeNeighborhoods() {
        neighborhoods.add(new Southside());         //index 0
        neighborhoods.add(new Lawrenceville());     //index 1
        neighborhoods.add(new Oakland());           //index 2
    }

    //can add/remove candies here easily to change how many candies will be in each game
    private void initializeCandies() {
        candies.add(new Jellybeans());              //index 0
        candies.add(new StarlightMints());          //index 1
        candies.add(new Gumdrops());                //index 2
    }

    //choose a random number between 0 (inclusive) and the size of the candy list (exclusive) to apply factors to
    private int chooseARandomCandy() {
        Random r = new Random();
        return r.nextInt(candies.size());
    }

    private void setTodaysCandyPrices() {
        int candySpecialHighToday = chooseARandomCandy();
        int candySpecialLowToday;
        do {
            candySpecialLowToday = chooseARandomCandy();
        } while (candySpecialLowToday == candySpecialHighToday);

        for (Candy c : candies) {
            if (candySpecialHighToday == candies.indexOf(c)) {
                c.setTodaysPriceSpecialHigh();
            }
            else if (candySpecialLowToday == candies.indexOf(c)) {
                c.setTodaysPriceSpecialLow();
            }
            else {
                c.setTodaysPriceNormal();
            }
        }
    }

    private void displayTodaysCandyPrices() {
        for (Candy c : candies) {
            System.out.println(c.getName() + " cost " + c.getTodaysPrice() + " today." +
                    " Usual price ranges from " + c.getMinPrice() + " to " + c.getMaxPrice());
        }
    }
    
    private void setAndDisplaySpecialNeighborhoodFactors(Neighborhood n) {
        if (n.isCandyLossToday()) {
            System.out.println(n.getOneNeighborhoodMessage(1));
        }

        if (n.isCandyGainToday()) {
            System.out.println(n.getOneNeighborhoodMessage(2));
        }

        if (n.isCandyBigLossToday()) {
            System.out.println(n.getOneNeighborhoodMessage(3));
        }

        if (n.isCandyBigGainToday()) {
            System.out.println(n.getOneNeighborhoodMessage(4));
        }
    }

    private void oneDayInNeighborhood(Neighborhood thisNeighborhood) {

        System.out.println("Day " + thisPlayer.getCurrentDay() + " in " + thisNeighborhood);

        setTodaysCandyPrices();
        displayTodaysCandyPrices();
        setAndDisplaySpecialNeighborhoodFactors(thisNeighborhood);


        boolean isPlayerBuyingOrSelling = true;
  //      do {
            // displayCandyMenu() showing prices for each candy today

            // boolean userChoiceValid = false;
            // do try purchaseChoice = getUserChoice(), catch custom exception while userChoiceValid = false;

            // boolean userChoiceValid = false;
            // do try whichCandyPurchaseChoice = getUserChoice(), catch custom exception while userChoiceValid = false;

            // boolean userChoiceValid = false;
            // do try candyQuantityPurchaseChoice = getUserChoice(), catch custom exception while userChoiceValid = false;

            //check if they have enough money, check if they have enough inventory, and if so, make purchase
            //subtract money from player
            //add quantity purchased to the value for that candy's key in the inventory map

  //      } while (isPlayerBuyingOrSelling);

    }

    //method to take user input and error-check to ensure valid input between min and max int values.
    private int getUserChoice (int minValidValue, int maxValidValue) {

        boolean validChoice = false;
        int userChoice = 999;

        while (!validChoice) {
            try {
                userChoice = Integer.parseInt(keyboard.nextLine());
            }
            catch (NumberFormatException e) {
                userChoice = 999;
            }

            if (userChoice >= minValidValue && userChoice <= maxValidValue) {
                validChoice = true;
            }
            else {
                System.out.print("That's not valid input. Please choose an option between " + minValidValue + " and " + maxValidValue + " >>> ");
            }
        }

        return userChoice;
    }

    public void run(int currentDay) {

        displayTodaysMenu(currentDay);

        int todaysNeighborhoodChoice = getUserChoice(1, neighborhoods.size());

        //pass the chosen neighborhood into the oneDayInNeighborhood method.
        //neighborhoods list starts at index 0, hence the -1
        oneDayInNeighborhood(neighborhoods.get(todaysNeighborhoodChoice - 1));

        // want to pay any debt back?

        thisPlayer.incrementCurrentDay();
    }

    public static void main(String[] args) {

        CandyApp c = new CandyApp();

        c.displayWelcomeMenu();

        //Get the player's name, thisPlayer.setName() and any other info we want to add

        //days set at 5 for testing, set back to 30 to play game later
        for (int currentDay = 1; currentDay <= 5; currentDay++) {

            c.run(currentDay);


        }

    }
}
