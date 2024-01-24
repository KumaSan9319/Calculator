package nl.kuma.calculator.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorWindow {

  private JFrame frame;
  private JPanel panel;

  public CalculatorWindow() {
    initialize();
  }

  private void initialize() {
    frame = new JFrame();
    frame.setTitle("Kuma's Calculator");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(420,550);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);

    panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

    frame.add(panel, BorderLayout.CENTER);

    frame.setVisible(true);
  }

}
