import Calculator.NumPad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumPadTest {

  @Test
  void testDigitInput() {
    // test object maken
    NumPad testNumPad = new NumPad();

    // toepassen van de inputDigit methode om te testen
    testNumPad.inputDigit("1");
    testNumPad.inputDigit("2");
    testNumPad.inputDigit("3");

    // output van de methode vergelijken met verwachte resultaat
    Assertions.assertEquals("123", testNumPad.getInput());
  }

  @Test
  void testBackspace() {
    // test object maken
    NumPad testNumPad = new NumPad();

    // Maak eerst een input met inputDigit en pas daarna backspace method toe om te testen
    testNumPad.inputDigit("1");
    testNumPad.inputDigit("2");
    testNumPad.inputDigit("3");
    testNumPad.inputDigit("4");
    testNumPad.inputDigit("5");

    testNumPad.backspace();
    testNumPad.backspace();

    // output van methods vergelijken met verwachte resultaat
    Assertions.assertEquals("123", testNumPad.getInput());
  }

  @Test
  void testCReset() {
    // test object maken
    NumPad testNumPad = new NumPad();

    // waardes aanmaken om cReset mee te testen
    testNumPad.setInput("12345");
    testNumPad.setCurrentValue("6789");
    testNumPad.setCurrentOperator('+');

    // test cReset
    testNumPad.cReset();

    // output van method vergelijken met verwachte resultaten
    Assertions.assertEquals("", testNumPad.getInput());
    Assertions.assertEquals("", testNumPad.getCurrentValue());
    Assertions.assertEquals(' ', testNumPad.getCurrentOperator());
  }

}
