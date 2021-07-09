package neighborhoods;


public class Lawrenceville extends Neighborhood {

    private static int totalVisitsToNeighborhood = 0;


    public Lawrenceville() {
        super("neighborhoods.Lawrenceville");

        //index 1 for isCandyLossToday(), index 2 for isCandyGainToday(),
        //index 3 for isCandyBigLossToday(), index 4 for isCandyBigGainToday()
        String slogan = "Can't afford a house here anymore!";
        String[] messages = new String[5];
        messages[0] = "Hello from neighborhoods.Lawrenceville!";
        messages[1] = "Oh no, some hipsters chased you down Butler St to steal some candy!";
        messages[2] = "Hooray, your parents sold an old row house for an obscene sum and rewarded you with some candy!";
        messages[3] = "OH NO! You accidentally dropped a bunch of candy over the side of the 40th St Bridge!";
        messages[4] = "HOORAY! You found a treasure chest of candy while walking through Allegheny Cemetery!";

        super.setNeighborhoodMessages(messages);
        super.setNeighborhoodSlogan(slogan);
    }

}
