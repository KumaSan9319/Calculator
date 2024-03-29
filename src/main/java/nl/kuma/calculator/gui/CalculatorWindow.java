package nl.kuma.calculator.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import nl.kuma.calculator.calculator.Controller;

public class CalculatorWindow {

  private JFrame frame;
  private JPanel panel;
  private final Controller controller = Controller.getControllerInstance();

  public CalculatorWindow() {
    initializeFrame();
    initializeTextField();
    initializePanel();
    createAndBindButtons();
  }

  /**
   * Initializes the main frame of the calculator window.
   */
  private void initializeFrame() {
    frame = new JFrame();
    frame.setTitle("Kuma's Calculator");
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.setSize(395,550);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setLayout(null);

    frame.setVisible(true);
  }

  /**
   * Initializes the text field of the calculator window.
   */
  private void initializeTextField(){
    CalculatorTextField textField = new CalculatorTextField();
    //add listener to update textField. updateField will be called when numPad "input" or "value"
    //changes
    controller.getNumPad().addPropertyChangeListener(textField::updateField);
    frame.add(textField);
  }

  /**
   * Initializes the panel of the calculator window.
   */
  private void initializePanel(){
    panel = new JPanel();
    panel.setBounds(40, 100,300,300);
    panel.setLayout(new GridLayout(4, 4, 10, 10));
    frame.add(panel);
  }

  /**
   * Creates a button with the given name and action listener.
   * @param buttonName the name of the button
   * @param listener the action listener for the button
   * @return the created button
   */
  private JButton createButton(String buttonName, ActionListener listener){
    JButton button = new JButton(buttonName);
    button.setFont(new Font("Sans Serif", Font.PLAIN, 30));
    button.setFocusable(false);
    button.addActionListener(listener);
    return button;
  }

  /**
   * Creates and binds the buttons of the calculator window.
   */
  private void createAndBindButtons(){
    String[] buttonNames = {"1", "2", "3", "+", "4", "5", "6", "-",
        "7", "8", "9", "*", ".", "0", "=", "/"};

    //add buttons
    for (String button : buttonNames) {
      JButton calculatorButton = switch (button) {
        case "+", "*", "/" -> createButton(button, (ActionEvent e) -> controller.selectOperator(button));
        case "-" -> createButton(button, (ActionEvent e) -> controller.verifyMinus());
        case "=" -> createButton(button, (ActionEvent e) -> controller.equals());
        default ->  createButton(button, (ActionEvent e) -> controller.getNumPad().inputDigit(button));
      };
      panel.add(calculatorButton);
    }

    //add backspaceButton
    JButton backspace = createButton("Backspace",
        (ActionEvent e) -> controller.getNumPad().backspace());
    backspace.setBounds(40, 430, 145, 50);
    backspace.setFont(new Font("Sans Serif", Font.PLAIN, 20));
    frame.add(backspace);

    //add C button
    JButton cButton = createButton("C",
        (ActionEvent e) -> controller.cReset());
    cButton.setBounds(195, 430, 145, 50);
    frame.add(cButton);
  }

}
