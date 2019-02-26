import java.util.*;
import java.util.function.Supplier;

public class Bowling {

    private List<String> scorePerRoll = new ArrayList<String>();
//    private List<String> statusPerRoll = new ArrayList<String>();
    private Map<String, Integer> replaceStrikeSpare = new HashMap<String, Integer>();
    private Optional<Type> type;

    private int totalScore;


    public Bowling(String scoreAllFrames) {
        for (int n = 0; n < scoreAllFrames.length(); n++) {
            this.scorePerRoll.add(Character.toString(scoreAllFrames.charAt(n)));
            type = Type.from(this.scorePerRoll.get(n));

//            this.statusPerRoll.add(checkStatus(Character.toString(scoreAllFrames.charAt(n))));

//            if (this.statusPerRoll.get(n).equals("Strike")) {
//                this.scorePerRoll.set(n, "10");
//            }
//            if (this.statusPerRoll.get(n).equals("Spare")) {
//                this.scorePerRoll.set(n, String.valueOf(10 - Integer.valueOf(this.scorePerRoll.get(n - 1))));
//            }
//
//            if (this.scorePerRoll.get(n).equals("-")) {
//                this.scorePerRoll.set(n, "0");
//            }
        }

    }


    public int computeScore() {
        int rollPlace = 0;
        for (int rollCount = 0; rollCount <= 19; rollCount++) {
            if (this.type.get().equals(2)) {
                rollCount++;
            }

            totalScore = totalScore + Integer.valueOf(this.scorePerRoll.get(rollPlace)) + getBonusScore(rollPlace);
            rollPlace++;
        }

        return totalScore;
    }

    private int getBonusScore(int rollPlace) {

        int score = 0;

        if (this.type.isPresent()) {
            for (int i = 1; i <= type.get().bonusRoll; i++) {
                score += Integer.valueOf(this.scorePerRoll.get(rollPlace + i));
            }
        }
        return score;

//        if (this.statusPerRoll.get(rollPlace).equals("Strike")) {
//            return Integer.valueOf(this.scorePerRoll.get(rollPlace + 1)) + Integer.valueOf(this.scorePerRoll.get(rollPlace + 2));
//        } else if (this.statusPerRoll.get(rollPlace).equals("Spare")) {
//            return Integer.valueOf(this.scorePerRoll.get(rollPlace + 1));
//        } else {
//            return 0;
//        }
    }

//    public String checkStatus(String rollScore) {
//
//        if (rollScore.equals("X"))
//            return "Strike";
//        else if (rollScore.equals("/"))
//            return "Spare";
//        else
//            return "Normal";
//    }

    enum Type {
        STRIKE("X", 2), SPARE("/", 1);

        private final String symbol;
        private final int bonusRoll;

        int bonusRoll() {
            return bonusRoll;
        }

        Type(String symbol, int bonusRoll) {
            this.symbol = symbol;
            this.bonusRoll = bonusRoll;
        }

        static Optional<Type> from(String symbol) {
            return Arrays.stream(values())
                    .filter(type -> type.symbol.equals(symbol))
                    .findFirst();
        }
    }

}
