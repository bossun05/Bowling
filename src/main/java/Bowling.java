import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bowling {

    private List<String> scorePerRoll = new ArrayList<String>();
    private List<String> statusPerRoll = new ArrayList<String>();
    private Map<String, Integer> replaceStrikeSpare = new HashMap<String, Integer>();
    private int totalScore;


    public Bowling(String scoreAllFrames) {
        for (int n = 0; n < scoreAllFrames.length(); n++) {
            this.scorePerRoll.add(Character.toString(scoreAllFrames.charAt(n)));
            this.statusPerRoll.add(checkStatus(Character.toString(scoreAllFrames.charAt(n))));
            if (this.statusPerRoll.get(n).equals("Strike")) {
                this.scorePerRoll.set(n, "10");
            }
            if (this.statusPerRoll.get(n).equals("Spare")){
                this.scorePerRoll.set(n, String.valueOf(10 - Integer.valueOf(this.scorePerRoll.get(n-1))));
            }

            if (this.scorePerRoll.get(n).equals("-")){
                this.scorePerRoll.set(n, "0");
            }
        }

    }

    public int computeScore() {
        int currentScore;
        int rollPlace = 0;
        for (int rollCount = 0; rollCount <= 19; rollCount++){
            if (this.statusPerRoll.get(rollPlace) == "Strike"){
                currentScore = Integer.valueOf(this.scorePerRoll.get(rollPlace)) + Integer.valueOf(this.scorePerRoll.get(rollPlace+1)) + Integer.valueOf(this.scorePerRoll.get(rollPlace+2));
                totalScore = totalScore + currentScore;
                rollCount++;
            }
            else if (this.statusPerRoll.get(rollPlace) == "Spare"){
                currentScore = Integer.valueOf(this.scorePerRoll.get(rollPlace)) + Integer.valueOf(this.scorePerRoll.get(rollPlace+1));
                totalScore = totalScore + currentScore;
            }
            else if (this.statusPerRoll.get(rollPlace) == "Normal"){
                currentScore = Integer.valueOf(this.scorePerRoll.get(rollPlace));
                totalScore = totalScore + currentScore;
            }
            rollPlace++;
        }

        return totalScore;
    }

    public String checkStatus(String rollScore){

        if (rollScore.equals("X"))
            return "Strike";
        else if (rollScore.equals("/"))
            return "Spare";
        else
            return "Normal";
    }

}
