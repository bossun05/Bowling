import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingTest {
    @Test
    public void testScoreAllStrike(){
        Bowling player = new Bowling("XXXXXXXXXXXX");
        assertEquals(player.computeScore(), 300);
    }
}
