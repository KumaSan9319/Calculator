package nl.kuma.calculator.calculator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NumPad {


  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  /**
   * input is the value that the user enters via the keyboard and is shown on the calculator screen.
   */
  private StringBuilder input = new StringBuilder();
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
  /**
   * This method is called when a PropertyChangeListener is added to the calculator.
   * The listener gets called when one of the calculator's properties changes.
   *
   * @param listener
   */
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    pcs.addPropertyChangeListener(listener);
  }

  public String getInput() {
    return input.toString();
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
    pcs.firePropertyChange("input", this.input.toString(), input);
    this.input.replace(0, this.input.length(), input);
  }

  public void setCurrentValue(String currentValue) {
    pcs.firePropertyChange("value", this.currentValue, currentValue);
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
    if (!digit.equals(".") || (digit.equals(".") && !input.toString().contains("."))) {
      String newInput = input.append(digit).toString();
      pcs.firePropertyChange("input", input, newInput);
      input.replace(0, input.length(), newInput);
    }
  }

  /**
   * This method is called when the "Backspace" button is pressed and removes the last digit of
   * input.
   */
  public void backspace() {
    if (!input.isEmpty()) {
      String newInput = input.substring(0, input.length() - 1);
      pcs.firePropertyChange("input", input, newInput);
      input.replace(0, input.length(), newInput);
    }
  }

  /**
   * This method is called from Controller's cReset() method. setCurrentValue() is used to reset
   * currentValue in order to trigger the actionListener and update the textField.
   */
  public void reset() {
    input = new StringBuilder();
    currentOperator = "";
    setCurrentValue("");
  }
}
