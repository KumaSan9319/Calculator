package nl.kuma.calculator.gui;

import java.awt.Font;
import javax.swing.JTextField;
import nl.kuma.calculator.calculator.Controller;

public class CalculatorTextField extends JTextField {

  private Controller controller = Controller.getControllerInstance();
  private static CalculatorTextField textFieldInstance;

  private CalculatorTextField() {
    this.setBounds(40, 25, 300, 50);
    this.setFont(new Font("Sans Serif", Font.PLAIN, 30));
    this.setEditable(false);
  }

  public static CalculatorTextField getFieldInstance() {
    if (textFieldInstance == null) {
      textFieldInstance = new CalculatorTextField();
    }

    return textFieldInstance;
  }

  public void updateField() {
    this.setText(controller.getNumPad().getInput());
  }

  public void updateFieldEquals() {
    this.setText(controller.getNumPad().getCurrentValue());
  }

}
