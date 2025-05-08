import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {

    @Test
    void addNumbers() {
        Calculator calculator = new Calculator(5, 10); //arrange
        double result = calculator.addNumbers(); //act
        assertEquals(15, result); // assert
      }

    @Test
    void subtractNumbers() {
        Calculator calculator = new Calculator(20, 10); //arrange
        double result = calculator.subtractNumbers(); //act
        assertEquals(10, result); //assert
      }
}