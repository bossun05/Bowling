import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/*
TASKS:
should not give discount given 1 book
should give 5% discount given 2 different titles
should give 10% discount given 3 different titles
should give 20% discount given 4 different titles
should give 25% discount given 5 different
should give 10% discount given 3 book a, 1 book b, 1 book c
 */


public class PotterTest {

    Potter potter = new Potter();

    @Test
    public void noDiscountTest(){
        potter.setBookA(3);
        assertEquals(24, potter.computePrice(),0.1);
    }

    @Test
    public void twoBooksDiscountTest(){
        potter.setBookA(3);
        potter.setBookB(3);
        assertEquals(45.6, potter.computePrice(),0.1);
    }

    @Test
    public void threeBooksDiscountTest(){
        potter.setBookA(3);
        potter.setBookB(3);
        potter.setBookC(3);
        assertEquals(64.8, potter.computePrice(),0.1);
    }

    @Test
    public void fourBooksDiscountTest(){
        potter.setBookA(3);
        potter.setBookB(3);
        potter.setBookC(3);
        potter.setBookD(3);
        assertEquals(76.8, potter.computePrice(),0.1);
    }

    @Test
    public void fiveBooksDiscountTest(){
        potter.setBookA(3);
        potter.setBookB(3);
        potter.setBookC(3);
        potter.setBookD(3);
        potter.setBookE(3);
        assertEquals(96, potter.computePrice(),0.1);
    }

    @Test
    public void differentBooksOrderDiscountTest(){
        potter.setBookA(3);
        potter.setBookB(1);
        potter.setBookC(1);
        potter.setBookD(4);
        potter.setBookE(2);
        assertEquals(76.8, potter.computePrice(),0.1);
    }

}