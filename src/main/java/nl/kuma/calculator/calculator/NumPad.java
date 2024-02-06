package nl.kuma.calculator.calculator;

public class NumPad {

  /**
   * Input is het getal wat op de rekenmachine zichtbaar is en momenteel aangevuld kan worden met
   * button inputs.
   */
  private StringBuilder input = new StringBuilder();
  /**
   * currentValue is het getal wat de rekenmachine onthoudt nadat er een operator
   * knop is ingedrukt en waarop de berekening toepassing gaat hebben.
   */
  private double currentValue = 0;
  /**
   * currentOperator wordt ingevuld wanneer er op de rekenmachine op de +, -, *, of / knop
   * wordt gedrukt.
   */
  private String currentOperator = "";

  public StringBuilder getInput() {
    return input;
  }

  public double getCurrentValue() {
    return currentValue;
  }

  public String getCurrentOperator() {
    return currentOperator;
  }

  public void setInput(StringBuilder input) {
    this.input = input;
  }

  public void setCurrentValue(double currentValue) {
    this.currentValue = currentValue;
  }

  public void setCurrentOperator(String currentOperator) {
    this.currentOperator = currentOperator;
  }

  /**
   * inputDigit is de method die wordt aangeroepen wanneer er een knop op de rekenmachine wordt
   * ingedrukt met een getal of de komma erop.
   *
   * @param digit
   */
  public void inputDigit(String digit) {
    if (!digit.equals(".") || (digit.equals(".") && !input.toString().contains("."))) {
      input.append(digit);
    }
  }

  /**
   * Backspace verwijdert de laatste digit in input wanneer de backspace knop op de rekenmachine
   * wordt ingedrukt
   */
  public void backspace() {
    if (input.isEmpty()) {

    } else {
      input.setLength(input.length() - 1);
    }
  }

}
