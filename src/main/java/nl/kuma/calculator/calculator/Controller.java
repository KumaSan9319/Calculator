package nl.kuma.calculator.calculator;

public class Controller {

  private NumPad numPad;
  private static Controller controllerInstance;

  private Controller() {
    this.numPad = new NumPad();
  }

  public NumPad getNumPad() {
    return numPad;
  }

  /**
   * We only need one instance of controller to make the calculator work, and we also want
   * calculatorButton to have access to the methods inside of controller, which is why it is
   * turned into a singleton.
   *
   * @return
   */
  public static Controller getControllerInstance() {
    if (controllerInstance == null) {
      controllerInstance = new Controller();
    }

    return controllerInstance;
  }

  /**
   * This method sets currentOperator to the value of the operator button that was pressed. It then
   * runs code based on the state of the other values of numPad. If currentValue is empty, this
   * method simply sets its value to the current value of input and resets input to be empty. If
   * there is already a currentValue but input is still empty, the method doesn't do anything other
   * than setting the currentOperator. If both currentValue and input are set, this method calls
   * equals() to make a calculation, so you can keep doing calculations without having to press the
   * "=" button in between.
   *
   * @param operatorInput
   */
  public void selectOperator(String operatorInput) {
    numPad.setCurrentOperator(operatorInput);

    if (numPad.getCurrentValue().isEmpty()) {
      numPad.setCurrentValue(numPad.getInput());
      numPad.setInput("");
    } else if (numPad.getInput().isEmpty()) {

    } else {
      equals();
    }
  }

  /**
   * This method parses relevant values to doubles and makes a calculation based on what
   * currentOperator is set to. There is a check to see if there is user input to make the method
   * decide if the calculation is going to happen with the current input, or with input from a
   * former calculation. This system exists so you can keep pressing "=" to repeat your last
   * calculation.
   */
  public void equals() {
    double parsedCurrentValue = Double.parseDouble(numPad.getCurrentValue());
    double parsedInput = 0;
    double modifier = numPad.getEqualsMemory();

    if (!numPad.getInput().isEmpty()) {
      parsedInput = Double.parseDouble(numPad.getInput());
      modifier = parsedInput;
    }

    double sum = switch(numPad.getCurrentOperator()) {
      case "+" -> parsedCurrentValue + modifier;
      case "-" -> parsedCurrentValue - modifier;
      case "*" -> parsedCurrentValue * modifier;
      case "/" -> parsedCurrentValue / modifier;
      default -> parsedInput;
    };

    numPad.setCurrentValue(Double.toString(sum));
    numPad.setEqualsMemory(modifier);
    numPad.setInput("");
  }

  /**
   * This method replaces the current instance of cReset with a fresh one to reset the values.
   */
  public void cReset() {
    numPad = new NumPad();
  }

}
