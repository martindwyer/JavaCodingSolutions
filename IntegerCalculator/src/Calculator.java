/**
 * Gui for four-function integer calculator.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Martin Dwyer
 * 
 */
public class Calculator extends JFrame {
    private Font font = new Font("Trebuchet", Font.PLAIN, 24);
    private JTextField display;
    private boolean clearOnEntry = true;
    private JPanel buttonPanel;
    private ButtonListener buttonListener = new ButtonListener();
    private CalculatorLogic logic = new CalculatorLogic();
    private boolean debugging = false;

    /**
     * Implements a simple four-function calculator.
     * @param args Unused.
     */
    public static void main(String[] args) {
        new Calculator().run();
    }

    private void run() {
        createGui();
        pack();
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createGui() {
        display = new JTextField();
        display.setFont(font);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);
        display.setEnabled(false);
        makeButtonPanel();
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void makeButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(51, 32, 0));
        buttonPanel.setLayout(new GridLayout(5, 4));
        
        JButton button;
        addButton("C", "c");
        addButton("CE", "e");
        addButton("+/-", "n");
        addButton("\u00F7", "/");
        
        addButton("7");
        addButton("8");
        addButton("9");
        addButton("\u00D7", "*");
        
        addButton("4");
        addButton("5");
        addButton("6");
        addButton("-");
        
        addButton("1");
        addButton("2");
        addButton("3");
        addButton("+");

        buttonPanel.add(new JLabel(""));
        addButton("0");
        buttonPanel.add(new JLabel(""));
        addButton("=");       
    }

    private void addButton(String buttonLabel) {
        addButton(buttonLabel, buttonLabel);
    }

    private void addButton(String buttonLabel, String code) {
        JButton button = new JButton(buttonLabel);
        button.setFont(font);
        button.setName(code);
        buttonPanel.add(button);
        button.addActionListener(buttonListener);
    }
    
    private void extendDisplay(char num) {
        if (clearOnEntry) {
            clear();
            clearOnEntry = false;
        }
        display.setText(display.getText() + num);
    }

    private void clear() {
        display.setText("");
    }
    
    // ------------------- Inner classes -------------------

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            char code = ((JButton)e.getSource()).getName().charAt(0);
            String result = logic.process(code);
            display.setText(result);
            if (debugging) System.out.println(code + "-> " + result);
        }
    }
}
