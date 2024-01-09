package Calculator;

public class Controller {

  private NumPad numPad;

  public Controller() {
    this.numPad = new NumPad();
  }

  public NumPad getNumPad() {
    return numPad;
  }

  public void selectOperator(char operatorInput) {
    getNumPad().setCurrentOperator(operatorInput);
    getNumPad().setCurrentValue(getNumPad().getInput());

    equals();
  }

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
