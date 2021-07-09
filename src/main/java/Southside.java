


public class Southside extends Neighborhood {

    private static int totalVisitsToNeighborhood = 0;


    public Southside() {
        super("Southside");

        //index 1 for isCandyLossToday(), index 2 for isCandyGainToday(),
        //index 3 for isCandyBigLossToday(), index 4 for isCandyBigGainToday()
        String slogan = "Get In The Mon!";
        String[] messages = new String[5];
        messages[0] = "Hello from Southside!";
        messages[1] = "Oh no, some drunk suburban kids chased you down Carson St when the bars closed to steal some candy!";
        messages[2] = "Hooray, you found a great sale on chipped ham at Giant Eagle and your parents rewarded you with some candy!";
        messages[3] = "OH NO! You accidentally dropped a bunch of candy over the side of the Hot Metal Bridge!";
        messages[4] = "HOORAY! You found a treasure chest of candy while walking through Southside Riverfront Park!";

        super.setNeighborhoodMessages(messages);
        super.setNeighborhoodSlogan(slogan);
    }

}
