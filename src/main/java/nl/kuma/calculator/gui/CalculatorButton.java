package nl.kuma.calculator.gui;

import java.awt.Font;
import javax.swing.JButton;

public class CalculatorButton extends JButton {

  public CalculatorButton(String text) {
    super(text);

    setFont(new Font("Sans Serif", Font.PLAIN, 30));
    setFocusable(false);
  }

}
