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

  @Test
  void testOperatorScenario1() {
    // In deze eerste test gaan we kijken wat er gebeurt als je herhaaldelijk op een operator knop
    // blijft drukken zonder extra input te geven
    Controller controller = new Controller();

    controller.getNumPad().setInput("14");

    controller.selectOperator('+');
    controller.selectOperator('+');
    controller.selectOperator('+');
    controller.selectOperator('*');
    controller.selectOperator('-');

    // Omdat de selectOperator de input omzet naar currentValue als die leeg is verwachten we hier
    // een currentValue van 14
    Assertions.assertEquals("14", controller.getNumPad().getCurrentValue());
  }

  @Test
  void testOperatorScenario2() {
    // In deze test kijken we of je correct door kan rekenen met nieuwe input waardes zonder
    // tussendoor op '=' te hoeven drukken.
    Controller controller = new Controller();

    controller.getNumPad().setInput("14");
    controller.selectOperator('+');
    controller.getNumPad().setInput("7");
    controller.selectOperator('+');
    controller.selectOperator('+');

    controller.selectOperator('+');
    controller.getNumPad().setInput("7");
    controller.selectOperator('+');
    controller.selectOperator('+');

    // Omdat we bij twee berekeningen een input van 7 meegeven en de rekenmachine de andere +
    // inputs zou moeten negeren verwachten we hier een antwoord van 28
    Assertions.assertEquals("28.0", controller.getNumPad().getCurrentValue());
  }

  @Test
  void testOperatorScenario3() {
    // Hier testen we of de equals methode de ingevoerde input en operator onthoudt en je zoals
    // in moderne calculator apps op '=' kan blijven drukken om de vorige berekening te blijven
    // herhalen
    Controller controller = new Controller();

    controller.getNumPad().setInput("14");
    controller.selectOperator('+');
    controller.getNumPad().setInput("7");

    controller.equals();
    controller.equals();
    controller.equals();

    // Omdat we de berekening drie keer uitvoeren verwachten we hier een resultaat van 35
    Assertions.assertEquals("35.0", controller.getNumPad().getCurrentValue());
  }

}
