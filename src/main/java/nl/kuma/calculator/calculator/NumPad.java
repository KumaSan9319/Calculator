package nl.kuma.calculator.calculator;

public class NumPad {

  /**
   * input is the value that the user enters via the keyboard and is shown on the calculator screen.
   */
  private String input = "";
  /**
   * currentValue is the number that calculations are performed on with input. After a calculation
   * is done, currentValue will always be equal to the answer of the last calculation.
   */
  private String currentValue = "";
  /**
   * currentOperator is set when the "+", "-", "*" or "/" button is pressed on the keyboard.
   */
  private String currentOperator = "";

  /**
   * equalsMemory is a value that is set after a calculation is performed. When you press "="
   * repeatedly without entering any other input, this value makes it possible for the calculator
   * to repeat the last calculation.
   */
  private double equalsMemory;

  public String getInput() {
    return input;
  }

  public String getCurrentValue() {
    return currentValue;
  }

  public String getCurrentOperator() {
    return currentOperator;
  }

  public double getEqualsMemory() {
    return equalsMemory;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public void setCurrentValue(String currentValue) {
    this.currentValue = currentValue;
  }

  public void setCurrentOperator(String currentOperator) {
    this.currentOperator = currentOperator;
  }

  public void setEqualsMemory(double equalsMemory) {
    this.equalsMemory = equalsMemory;
  }

  /**
   * This method is called when the user presses a button on the keyboard representing a digit or
   * the ".". Its main use is to enter "input".
   *
   * @param digit
   */
  public void inputDigit(String digit) {
    if (!digit.equals(".") || (digit.equals(".") && !input.contains("."))) {
      input = input.concat(digit);
    }
  }

  /**
   * This method is called when the "Backspace" button is pressed and removes the last digit of
   * input.
   */
  public void backspace() {
    if (input.isEmpty()) {

    } else {
      input = input.substring(0, input.length() - 1);
    }
  }

}
