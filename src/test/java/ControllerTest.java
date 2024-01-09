import Calculator.Controller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ControllerTest {

  @Test
  void testEquals() {
    // test objecten maken
    Controller test1 = new Controller();
    Controller test2 = new Controller();
    Controller test3 = new Controller();
    Controller test4 = new Controller();
    Controller test5 = new Controller();

    // test waarden vaststellen en te testen method uitvoeren
    test1.getNumPad().setCurrentValue("22");
    test1.getNumPad().setCurrentOperator('+');
    test1.getNumPad().setInput("7");
    test1.equals();

    test2.getNumPad().setCurrentValue("22");
    test2.getNumPad().setCurrentOperator('-');
    test2.getNumPad().setInput("7");
    test2.equals();

    test3.getNumPad().setCurrentValue("22");
    test3.getNumPad().setCurrentOperator('*');
    test3.getNumPad().setInput("7");
    test3.equals();

    test4.getNumPad().setCurrentValue("22");
    test4.getNumPad().setCurrentOperator('/');
    test4.getNumPad().setInput("2");
    test4.equals();

    test5.getNumPad().setCurrentValue("22");
    test5.getNumPad().setInput("7");
    test5.equals();

    // Assertions
    Assertions.assertEquals("29.0", test1.getNumPad().getCurrentValue());
    Assertions.assertEquals("15.0", test2.getNumPad().getCurrentValue());
    Assertions.assertEquals("154.0", test3.getNumPad().getCurrentValue());
    Assertions.assertEquals("11.0", test4.getNumPad().getCurrentValue());
    Assertions.assertEquals("7.0", test5.getNumPad().getCurrentValue());

  }

}
