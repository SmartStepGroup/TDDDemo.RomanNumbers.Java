package swing;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ArabicToRomanView {
    private JPanel panel;
    private JTextField textArabicNumber;
    private JButton buttonConvert;
    private JLabel labelError;
    private JTextField textRomanNumber;
    private JTextArea textError;

    public ArabicToRomanView() {
        ArabicToRomanNumberConverter converter = new ArabicToRomanNumberConverter();

        buttonConvert.addActionListener(e -> {
            String romanNumber = converter.Convert(Integer.parseInt(textArabicNumber.getText()));
            this.textRomanNumber.setText(romanNumber);
        });
        textArabicNumber.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validate();
            }
        });
    }

    private void validate() {
        if (textArabicNumber.getText().matches("\\d+")) {
            if (Integer.parseInt(textArabicNumber.getText()) >= 4000) {
                textError.setText("Only numbers from interval [0...3999] are allowed");
                buttonConvert.setEnabled(false);
            } else {
                textError.setText("");
                buttonConvert.setEnabled(true);
            }
        } else {
            textError.setText("Only digits are allowed");
            buttonConvert.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ArabicToRomanView");
        frame.setContentPane(new ArabicToRomanView().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        buttonConvert = new JButton();
        buttonConvert.setEnabled(false);
    }
}
