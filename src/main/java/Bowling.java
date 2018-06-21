import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bowling {

    private List<String> scorePerFrame = new ArrayList<String>();
    private List<String> statusPerFrame = new ArrayList<String>();
    private Map<String, Integer> replaceStrikeSpare = new HashMap<String, Integer>();
    private int totalScore;


    public Bowling(String scoreAllFrames) {
        for (int n = 0; n < scoreAllFrames.length(); n++) {
            this.scorePerFrame.add(Character.toString(scoreAllFrames.charAt(n)));
            this.statusPerFrame.add(checkStatus(Character.toString(scoreAllFrames.charAt(n))));
            this.scorePerFrame.set(n, "10");
        }

    }

    public int computeScore() {
        int currentScore;
        int y = 0;
        for (int n = 0; n <= 19; n++){
            if (this.statusPerFrame.get(y) == "Strike"){
                currentScore = Integer.valueOf(this.scorePerFrame.get(y)) + Integer.valueOf(this.scorePerFrame.get(y+1)) + Integer.valueOf(this.scorePerFrame.get(y+2));
                totalScore = totalScore + currentScore;
            n++;
            y++;
            }
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
