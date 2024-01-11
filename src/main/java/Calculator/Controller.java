package Calculator;

public class Controller {

  private NumPad numPad;

  public Controller() {
    this.numPad = new NumPad();
  }

  public NumPad getNumPad() {
    return numPad;
  }

  // Als deze method correct werkt zet hij de currentOperator field om naar de ingedrukte knop op
  // de rekenmachine en gebeurt er dan iets gebaseerd op de staat van de andere waarden. Als
  // currentValue leeg is was dit de eerste keer dat de operator werd gebruikt en zet hij
  // simpelweg de waarde van input naar currentValue en wordt input weer gereset zodat je verder
  // kan rekenen. Als er al wel een currentValue is, maar input niet is ingevuld gebeurt er niks
  // en kan je gewoon verder rekenen. Als de operator wordt ingedrukt met een ingevulde input EN
  // currentValue fungeert hij als een soort equals knop zoals moderne rekenmachine apps zodat je
  // zonder tussendoor op equals te hoeven drukken kan doorrekenen.
  public void selectOperator(char operatorInput) {
    getNumPad().setCurrentOperator(operatorInput);

    if (getNumPad().getCurrentValue().isEmpty()) {
      getNumPad().setCurrentValue(getNumPad().getInput());
      getNumPad().setInput("");
    } else if (getNumPad().getInput().isEmpty()) {

    } else {
      equals();
      getNumPad().setInput("");
    }
  }

  // De equals method maakt double versies van currentValue en input en lost de berekening op met
  // de ingevulde waardes.
  public void equals() {
    double parsedCurrentValue = Double.parseDouble(numPad.getCurrentValue());
    double parsedInput = Double.parseDouble(numPad.getInput());

    switch(numPad.getCurrentOperator()) {
      case '+' -> numPad.setCurrentValue(Double.toString(parsedCurrentValue + parsedInput));
      case '-' -> numPad.setCurrentValue(Double.toString(parsedCurrentValue - parsedInput));
      case '*' -> numPad.setCurrentValue(Double.toString(parsedCurrentValue * parsedInput));
      case '/' -> numPad.setCurrentValue(Double.toString(parsedCurrentValue / parsedInput));
      default -> numPad.setCurrentValue(Double.toString(parsedInput));
    }


  }

}
