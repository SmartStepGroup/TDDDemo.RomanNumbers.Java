package swing;

import viewModels.ArabicToRomanViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ArabicToRomanView {
    ArabicToRomanViewModel viewModel;
    private JPanel panel;
    private JTextField textArabicNumber;
    private JButton buttonConvert;
    private JTextField textRomanNumber;
    private JTextArea textError;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ArabicToRomanView");
        frame.setContentPane(new ArabicToRomanView().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        viewModel = new ArabicToRomanViewModel();
        textArabicNumber = new JTextField();
        textRomanNumber = new JTextField();
        buttonConvert = new JButton();
        textError = new JTextArea();

        buttonConvert.addActionListener(e -> {
            backBind();
            viewModel.convert();
            bind();
        });

        textArabicNumber.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                backBind();
                bind();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                backBind();
                bind();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                backBind();
                bind();
            }
        });

        bind();
    }

    private void backBind() {
        viewModel.setArabicNumberText(textArabicNumber.getText());
    }

    private void bind() {
        buttonConvert.setEnabled(viewModel.isConvertButtonEnabled());
        textRomanNumber.setText(viewModel.getRomanNumberText());
        textError.setText(viewModel.getErrorMessage());
    }
}
