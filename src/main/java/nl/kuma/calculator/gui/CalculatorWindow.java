package nl.kuma.calculator.gui;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorWindow {

  private JFrame frame;
  private CalculatorTextField textField;
  private JPanel panel;
  private CalculatorButton[] buttons = new CalculatorButton[16];
  private String[] buttonNames = {"1", "2", "3", "+", "4", "5", "6", "-",
                                  "7", "8", "9", "*", ".", "0", "=", "/"};
  private CalculatorButton backspace = new CalculatorButton("Backspace");
  private CalculatorButton c = new CalculatorButton("C");

  public CalculatorWindow() {
    initialize();
  }

  private void initialize() {
    frame = new JFrame();
    frame.setTitle("Kuma's Calculator");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(395,550);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setLayout(null);

    textField = CalculatorTextField.getFieldInstance();

    panel = new JPanel();
    panel.setBounds(40, 100,300,300);
    panel.setLayout(new GridLayout(4, 4, 10, 10));

    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new CalculatorButton(buttonNames[i]);
      panel.add(buttons[i]);
    }

    backspace.setBounds(40, 430, 145, 50);
    backspace.setFont(new Font("Sans Serif", Font.PLAIN, 20));
    c.setBounds(195, 430, 145, 50);

    frame.add(textField);
    frame.add(panel);
    frame.add(backspace);
    frame.add(c);

    frame.setVisible(true);
  }

}
