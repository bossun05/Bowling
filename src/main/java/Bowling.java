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
        int y = 0;
        for (int n = 0; n <= 19; n++){
            if (this.statusPerRoll.get(y) == "Strike"){
                currentScore = Integer.valueOf(this.scorePerRoll.get(y)) + Integer.valueOf(this.scorePerRoll.get(y+1)) + Integer.valueOf(this.scorePerRoll.get(y+2));
                totalScore = totalScore + currentScore;
            n++;
            }
            else if (this.statusPerRoll.get(y) == "Spare"){
                currentScore = Integer.valueOf(this.scorePerRoll.get(y)) + Integer.valueOf(this.scorePerRoll.get(y+1));
                totalScore = totalScore + currentScore;
            }
            else if (this.statusPerRoll.get(y) == "Normal"){
                currentScore = Integer.valueOf(this.scorePerRoll.get(y));
                totalScore = totalScore + currentScore;
            }
            y++;
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
