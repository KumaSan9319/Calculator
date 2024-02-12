package nl.kuma.calculator.gui;

import java.awt.Font;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;

public final class CalculatorTextField extends JTextField {

  public CalculatorTextField() {
    setBounds(40, 25, 300, 50);
    setFont(new Font("Sans Serif", Font.PLAIN, 30));
    setEditable(false);
  }

  /**
   * The textField is updated whenever the listeners are triggered on setInput, setCurrentValue,
   * inputDigit and backspace.
   * @param propertyChangeEvent
   */
  public void updateField(PropertyChangeEvent propertyChangeEvent) {
    setText((String) propertyChangeEvent.getNewValue());
  }

}