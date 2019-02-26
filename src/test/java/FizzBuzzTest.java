import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void fizzBuzzTestWithGivenNumber(){
        fizzBuzz.printFizzBizz(100);
        assertEquals("Fizz", fizzBuzz.fizzBuzzChecker(3));
        assertEquals("Buzz", fizzBuzz.fizzBuzzChecker(5));
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzzChecker(15));
        assertEquals("28", fizzBuzz.fizzBuzzChecker(28));

    }

}