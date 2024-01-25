package nl.kuma.calculator.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import nl.kuma.calculator.calculator.Controller;

public class CalculatorButton extends JButton {

  private Controller controller = Controller.getControllerInstance();
  private CalculatorTextField textField = CalculatorTextField.getFieldInstance();
  private String buttonName;

  public CalculatorButton(String text) {
    super(text);
    buttonName = text;

    this.setFont(new Font("Sans Serif", Font.PLAIN, 30));
    this.setFocusable(false);

    this.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        switch (buttonName) {
          case "+", "-", "*", "/" -> {
            controller.selectOperator(buttonName);
            textField.updateField();
          }
          case "=" -> {
            controller.equals();
            textField.updateFieldEquals();
          }
          case "Backspace" -> {
            controller.getNumPad().backspace();
            textField.updateField();
          }
          case "C" -> {
            controller.cReset();
            textField.updateField();
          }
          default -> {
            controller.getNumPad().inputDigit(buttonName);
            textField.updateField();
          }
        }
      }
    });
  }
}
