package neighborhoods;


public class Neighborhood {

    private final String NAME;
    private final String[] NEIGHBORHOOD_MESSAGES = new String[5];
    private String NEIGHBORHOOD_SLOGAN;
    private boolean isSpecialToday;


    public Neighborhood(String name) {
        this.NAME = name;
    }

    public void setNeighborhoodMessages(String[] messages) {
        for (int i = 0; i < NEIGHBORHOOD_MESSAGES.length; i++) {
            NEIGHBORHOOD_MESSAGES[i] = messages[i];
        }
    }

    public void setNeighborhoodSlogan(String slogan) {
        NEIGHBORHOOD_SLOGAN = slogan;
    }

    public String getNeighborhoodSlogan() {
        return NEIGHBORHOOD_SLOGAN;
    }

    public String getName() {
        return NAME;
    }

    public String getOneNeighborhoodMessage(int index) {
        return NEIGHBORHOOD_MESSAGES[index];
    }

    // factor A will have a 40% chance of true, and a bully will steal 30-70% of one candy
    public boolean isCandyLossToday() {
        if (Math.random() < 0.4) {
            return true;
        }
        else {
            return false;
        }
    }

    // factor B will have a 60% chance of true, and your parents will reward you with 30-70% more of one candy
    public boolean isCandyGainToday() {
        if (Math.random() < 0.6) {
            return true;
        }
        else {
            return false;
        }
    }

    // factor C will have a 15% chance of true, and a neighborhood specific will set one candy's quantity to 0
    public boolean isCandyBigLossToday() {
        if (Math.random() < 0.15) {
            return true;
        }
        else {
            return false;
        }
    }

    // factor D will have a 25% chance of true, and a neighborhood specific will multiply one candy's quantity by 4
    public boolean isCandyBigGainToday() {
        if (Math.random() < 0.25) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return this.getName() + ": " + this.getNeighborhoodSlogan();
    }

}
