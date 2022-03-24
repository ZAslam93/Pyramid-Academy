import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//  	The user will be required to enter their Name, Email, Phone Number, Gender, Age, Date,
//      Origin Destination, and Departure Time into the console or GUI (teams’ preference).


public class SignUp {
    protected JPanel mainPanel;
    private JLabel titleLabel;
    private JPanel formPanel;
    private JPanel buttonPanel;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JRadioButton maleRadioButton;
    private JTextField dateTextField;
    private JTextField departureTimeTextField;
    private JButton submitButton;
    private JTextField estimatedPriceTextField;
    private JRadioButton otherRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton clearButton;
    private JComboBox<String> originComboBox;
    private JComboBox<String> destinationComboBox;
    private JLabel leftImage;
    private JLabel rightImage;
    private JLabel railImage;
    private JSlider ageSlider;
    private JTextField ageLabel;
    private final double PRICE = 20;
    private int age;


    public SignUp() {
        // submitButton will "save" all the data after ensuring proper input
        submitButton.addActionListener(e -> {
            // Consider providing useful error messages like "Name required" or "Invalid format" somewhere in GUI
            // If all tests pass, display success
            // Save field values into a data structure, then handle file writing
            titleLabel.setText("Success! You may now close this window");
        });

        // clearButton will clear all form entries
        clearButton.addActionListener(e -> {
            nameTextField.setText("");
            emailTextField.setText("");
            phoneTextField.setText("");
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);
            otherRadioButton.setSelected(false);
            dateTextField.setText("");
            originComboBox.setSelectedIndex(0);
            destinationComboBox.setSelectedIndex(0);
            dateTextField.setText("");
            estimatedPriceTextField.setText("");
            departureTimeTextField.setText("");
        });

        ageSlider.addChangeListener(e -> {
            age = ageSlider.getValue();
            ageLabel.setText(String.valueOf(age));
            if (age <= 12) estimatedPriceTextField.setText(String.valueOf(PRICE * 0.50));
            else if (age >= 60) estimatedPriceTextField.setText(String.valueOf(PRICE * 0.40));
            else if (femaleRadioButton.isSelected()) estimatedPriceTextField.setText(String.valueOf(PRICE * 0.75));
            else estimatedPriceTextField.setText(String.valueOf(PRICE));
        });

        femaleRadioButton.addActionListener(e -> {
            if (femaleRadioButton.isSelected() &&
                    (age > 12 && age < 60)) {
                estimatedPriceTextField.setText(String.valueOf(PRICE * 0.75));
            }
        });
        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (maleRadioButton.isSelected() &&
                        (age > 12 && age < 60)) {
                    estimatedPriceTextField.setText(String.valueOf(PRICE));
                }
            }
        });
        otherRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (otherRadioButton.isSelected() &&
                        (age > 12 && age < 60)) {
                    estimatedPriceTextField.setText(String.valueOf(PRICE));
                }
            }
        });
    }

    private void createUIComponents() {
        // Render images, needs the main method for them to be visible
        leftImage = new JLabel(new ImageIcon(new ImageIcon("images/train.png").
                getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        rightImage = new JLabel(new ImageIcon(new ImageIcon("images/train.png").
                getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        railImage = new JLabel(new ImageIcon(new ImageIcon("images/rail.png").
                getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH)));
    }
}
