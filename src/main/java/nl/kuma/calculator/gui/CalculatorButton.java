package nl.kuma.calculator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import nl.kuma.calculator.calculator.Controller;

public class CalculatorButton extends JButton {

  private String buttonName;
  private Controller controller = Controller.getInstance();

  public CalculatorButton(String text) {
    super(text);
    buttonName = text;
    this.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        switch (buttonName) {
          case "+", "-", "*", "/" -> controller.selectOperator(buttonName);
          case "=" -> controller.equals();
          case "Backspace" -> controller.getNumPad().backspace();
          case "C" -> controller.cReset();
          default -> controller.getNumPad().inputDigit(buttonName);
        }
      }
    });
  }
}
