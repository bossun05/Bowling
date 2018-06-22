import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingTest {
    @Test
    public void testScoreAllStrike(){
        Bowling player = new Bowling("XXXXXXXXXXXX");
        assertEquals(player.computeScore(), 300);
    }

    @Test
    public void testScoreAllSpare() {
        Bowling player = new Bowling("6/4/3/2/1/7/5/9/0/4/3");
        assertEquals(player.computeScore(), 138);
    }

    @Test
    public void testScoreAllNormal(){
        Bowling player = new Bowling("12345123451234512345");
        assertEquals(player.computeScore(), 60);
    }

    @Test
    public void testHeartbreak(){
        Bowling player = new Bowling("9-9-9-9-9-9-9-9-9-9-");
        assertEquals(player.computeScore(),90);
    }

    @Test
    public void testZeroEverySecondRoll(){
        Bowling player = new Bowling("1-2-3-4-5-6-7-8-9-1-");
        assertEquals(player.computeScore(), 46);
    }

    @Test
    public void testCombination(){
        Bowling player = new Bowling("X9/--52X5/71X52X81");
        assertEquals(player.computeScore(), 125);
    }
}
