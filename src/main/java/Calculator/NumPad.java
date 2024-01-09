package Calculator;

public class NumPad {

  // input is het getal wat op de rekenmachine zichtbaar is en momenteel aangevuld kan worden met
  // button inputs. currentValue is het getal wat de rekenmachine onthoudt nadat er een operator
  // knop is ingedrukt en waarop de berekening toepassing gaat hebben. currentOperator wordt
  // ingevuld wanneer er op de rekenmachine op de +, -, *, of / knop wordt gedrukt.
  private String input = "";
  private String currentValue = "";
  private char currentOperator = ' ';

  public String getInput() {
    return input;
  }

  public String getCurrentValue() {
    return currentValue;
  }

  public char getCurrentOperator() {
    return currentOperator;
  }

  // Setters zijn er vooral voor test doeleinden
  public void setInput(String input) {
    this.input = input;
  }

  public void setCurrentValue(String currentValue) {
    this.currentValue = currentValue;
  }

  public void setCurrentOperator(char currentOperator) {
    this.currentOperator = currentOperator;
  }

  // inputDigit is de method die wordt aangeroepen wanneer er een knop op de rekenmachine wordt
  // ingedrukt met een getal of de komma erop.
  public void inputDigit(String digit) {
    input = input.concat(digit);
  }

  // backspace verwijdert de laatste digit in input wanneer de backspace knop op de rekenmachine
  // wordt ingedrukt
  public void backspace() {
    input = input.substring(0, input.length() - 1);
  }

  // cReset maakt alle huidige waarden weer leeg wanneer de C knop op de rekenmachine wordt
  // ingedrukt
  public void cReset() {
    input = "";
    currentValue = "";
    currentOperator = ' ';
  }

}
