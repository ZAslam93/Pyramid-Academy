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
            if(nameTextField.getText().isEmpty()) {
                titleLabel.setText("Please type a name.");
            } else if(emailTextField.getText().isEmpty()&&phoneTextField.getText().isEmpty()) {
               titleLabel.setText("Please enter either a phone number or email.");
            } else if(!maleRadioButton.isSelected()&&!femaleRadioButton.isSelected()&&!otherRadioButton.isSelected()){
                titleLabel.setText("Please select a gender.");
            } else if(!Application.checkEmailFormat(emailTextField.getText())){
                titleLabel.setText("Please enter an email ending in @[domain]");
            } else if(!Application.checkPhoneFormat(phoneTextField.getText())){
                titleLabel.setText("Please enter a 10 digit phone number, separated by dashes.");
            } else if(dateTextField.getText().isEmpty()){
                titleLabel.setText("Please enter the date of your trip.");
            } else if(!Application.checkDateFormat(dateTextField.getText())){
                titleLabel.setText("Please enter the date in MM/DD/YYYY format.");
            } else if(departureTimeTextField.getText().isEmpty()){
                titleLabel.setText("Please select a departure time.");
            } else if(!Application.checkTimeField(departureTimeTextField.getText())){
                titleLabel.setText("Please enter your departure time in 24 hour HH:MM format.");
            } else {
                // if all fields meet required formatting, and aren't empty, call on main class's saveInfo() method.
                Application.saveInfo();
                titleLabel.setText("Success! You may now close this window");
            }
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

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JPanel getFormPanel() {
        return formPanel;
    }

    public void setFormPanel(JPanel formPanel) {
        this.formPanel = formPanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JTextField getPhoneTextField() {
        return phoneTextField;
    }

    public void setPhoneTextField(JTextField phoneTextField) {
        this.phoneTextField = phoneTextField;
    }

    public JRadioButton getMaleRadioButton() {
        return maleRadioButton;
    }

    public void setMaleRadioButton(JRadioButton maleRadioButton) {
        this.maleRadioButton = maleRadioButton;
    }

    public JTextField getDateTextField() {
        return dateTextField;
    }

    public void setDateTextField(JTextField dateTextField) {
        this.dateTextField = dateTextField;
    }

    public JTextField getDepartureTimeTextField() {
        return departureTimeTextField;
    }

    public void setDepartureTimeTextField(JTextField departureTimeTextField) {
        this.departureTimeTextField = departureTimeTextField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JTextField getEstimatedPriceTextField() {
        return estimatedPriceTextField;
    }

    public void setEstimatedPriceTextField(JTextField estimatedPriceTextField) {
        this.estimatedPriceTextField = estimatedPriceTextField;
    }

    public JRadioButton getOtherRadioButton() {
        return otherRadioButton;
    }

    public void setOtherRadioButton(JRadioButton otherRadioButton) {
        this.otherRadioButton = otherRadioButton;
    }

    public JRadioButton getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public void setFemaleRadioButton(JRadioButton femaleRadioButton) {
        this.femaleRadioButton = femaleRadioButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JComboBox<String> getOriginComboBox() {
        return originComboBox;
    }

    public void setOriginComboBox(JComboBox<String> originComboBox) {
        this.originComboBox = originComboBox;
    }

    public JComboBox<String> getDestinationComboBox() {
        return destinationComboBox;
    }

    public void setDestinationComboBox(JComboBox<String> destinationComboBox) {
        this.destinationComboBox = destinationComboBox;
    }

    public JLabel getLeftImage() {
        return leftImage;
    }

    public void setLeftImage(JLabel leftImage) {
        this.leftImage = leftImage;
    }

    public JLabel getRightImage() {
        return rightImage;
    }

    public void setRightImage(JLabel rightImage) {
        this.rightImage = rightImage;
    }

    public JLabel getRailImage() {
        return railImage;
    }

    public void setRailImage(JLabel railImage) {
        this.railImage = railImage;
    }

    public JSlider getAgeSlider() {
        return ageSlider;
    }

    public void setAgeSlider(JSlider ageSlider) {
        this.ageSlider = ageSlider;
    }

    public JTextField getAgeLabel() {
        return ageLabel;
    }

    public void setAgeLabel(JTextField ageLabel) {
        this.ageLabel = ageLabel;
    }

    public double getPRICE() {
        return PRICE;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
