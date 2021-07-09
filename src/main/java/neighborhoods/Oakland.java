package neighborhoods;


public class Oakland extends Neighborhood {

    private static int totalVisitsToNeighborhood = 0;


    public Oakland() {
        super("neighborhoods.Oakland");

        //index 1 for isCandyLossToday(), index 2 for isCandyGainToday(),
        //index 3 for isCandyBigLossToday(), index 4 for isCandyBigGainToday()
        String slogan = "Pitt Is It!";
        String[] messages = new String[5];
        messages[0] = "Hello from neighborhoods.Oakland!";
        messages[1] = "Oh no, some drunk Pitt students chased you down Forbes Ave to steal some candy!";
        messages[2] = "Hooray, you got good grades this semester at Pitt and your parents rewarded you with some candy!";
        messages[3] = "OH NO! Your slumlord on Atwood St let the roof leak and ruined a bunch of your candy!";
        messages[4] = "HOORAY! You found a treasure chest of candy while walking through Schenley Plaza!";

        super.setNeighborhoodMessages(messages);
        super.setNeighborhoodSlogan(slogan);
    }

}
