package nl.kuma.calculator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CalculatorButton extends JButton {

  private String buttonName;

  public CalculatorButton(String text) {
    super(text);
    buttonName = text;
    this.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (buttonName.equals("=")) {

        }
      }
    });
  }
}
