package nl.kuma.calculator.calculator;

public class NumPad {

  /**
   *   input is het getal wat op de rekenmachine zichtbaar is en momenteel aangevuld kan worden met
   *   button inputs.
   */
  private String input = "";
  /**
   *    currentValue is het getal wat de rekenmachine onthoudt nadat er een operator
   *    knop is ingedrukt en waarop de berekening toepassing gaat hebben.
   */
  private String currentValue = "";
  /**
   *    currentOperator wordt ingevuld wanneer er op de rekenmachine op de +, -, *, of / knop
   *    wordt gedrukt.
   */
  private String currentOperator = "";

  public String getInput() {
    return input;
  }

  public String getCurrentValue() {
    return currentValue;
  }

  public String getCurrentOperator() {
    return currentOperator;
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

  /**
   *    inputDigit is de method die wordt aangeroepen wanneer er een knop op de rekenmachine wordt
   *    ingedrukt met een getal of de komma erop.
   *    @param digit
   */
  public void inputDigit(String digit) {
    if (!digit.equals(".") || (digit.equals(".") && !input.contains("."))) {
      input = input.concat(digit);
    }
  }

  /**
   *   backspace verwijdert de laatste digit in input wanneer de backspace knop op de rekenmachine
   *   wordt ingedrukt
   */
  public void backspace() {
    if (input.isEmpty()) {

    } else {
      input = input.substring(0, input.length() - 1);
    }
  }

}
