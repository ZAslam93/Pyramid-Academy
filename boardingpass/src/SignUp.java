import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//  	The user will be required to enter their Name, Email, Phone Number, Gender, Age, Date,
//      Origin Destination, and Departure Time into the console or GUI (teams’ preference).

// Configure SignUp class via SignUp.form
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

    // Create a String array of stations for access via comboBox index
    private final String[] stations =
            {"", "Alphonse Station", "Brego Station", "Charlotte Station", "Dumas Station", "Elgar Station", "Fiona Station"};

    // Main functionality of SignUp GUI begins here
    public SignUp() {

        // Create a new Ticket object to handle SignUp form data
        Ticket ticket = new Ticket();

        // submitButton will "save" all the data after ensuring proper input
        submitButton.addActionListener(e -> {
            // If all tests pass, display success
            // Save field values into ticket object
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
                // If all fields meet required formatting, and aren't empty, call on main class's saveInfo() method.
                String gender = null;
                if(maleRadioButton.isSelected())
                    gender = "Male";
                else if(femaleRadioButton.isSelected())
                    gender = "Female";
                else if(otherRadioButton.isSelected())
                    gender = "Other";
                try {
                    Application.saveInfo(getUniqueID(),
                            nameTextField.getText(),
                            emailTextField.getText(),
                            phoneTextField.getText(),
                            gender, age,
                            dateTextField.getText(),
                            stations[originComboBox.getSelectedIndex()],
                            stations[destinationComboBox.getSelectedIndex()],
                            departureTimeTextField.getText(),
                            calculateETA(),
                            Double.parseDouble(estimatedPriceTextField.getText()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // After saving info, generate unique ID for the ticket
                try {
                    getUniqueID();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    ticket.writeTicket();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                titleLabel.setText("Success! You may now close this window");
                System.out.println(ticket);
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

        // ageSlider ranges from 1 to 100, applies ticket discounts accordingly
        ageSlider.addChangeListener(e -> {
            age = ageSlider.getValue();
            ageLabel.setText(String.valueOf(age));
            if (age <= 12) {
                estimatedPriceTextField.setText(String.valueOf(PRICE * 0.50));
            }
            else if (age >= 60) {
                estimatedPriceTextField.setText(String.valueOf(PRICE * 0.40));
            }
            else if (femaleRadioButton.isSelected()) estimatedPriceTextField.setText(String.valueOf(PRICE * 0.75));
            else estimatedPriceTextField.setText(String.valueOf(PRICE));
        });

        // Apply the greatest discount only
        femaleRadioButton.addActionListener(e -> {
            if (femaleRadioButton.isSelected() &&
                    (age > 12 && age < 60)) {
                estimatedPriceTextField.setText(String.valueOf(PRICE * 0.75));
            }
        });

        // Male and Other do not get discounts on account of gender
        maleRadioButton.addActionListener(e -> {
            if (maleRadioButton.isSelected() &&
                    (age > 12 && age < 60)) {
                estimatedPriceTextField.setText(String.valueOf(PRICE));
            }
        });
        otherRadioButton.addActionListener(e -> {
            if (otherRadioButton.isSelected() &&
                    (age > 12 && age < 60)) {
                estimatedPriceTextField.setText(String.valueOf(PRICE));
            }
        });
    }

    // Add custom UI components (Images)
    private void createUIComponents() {
        // Render images, needs the main method for them to be visible
        leftImage = new JLabel(new ImageIcon(new ImageIcon("images/train.png").
                getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        rightImage = new JLabel(new ImageIcon(new ImageIcon("images/train.png").
                getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        railImage = new JLabel(new ImageIcon(new ImageIcon("images/rail.png").
                getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH)));
    }

    // Stations are separated by an hour each (Alphonse to Charlotte is a 2-hour journey)
    public String calculateETA() {
        int timeStart = Integer.parseInt(departureTimeTextField.getText().substring(0,2));
        int factoredTime = (timeStart + (Math.abs(originComboBox.getSelectedIndex() - destinationComboBox.getSelectedIndex()))) % 24;
        System.out.println(factoredTime);
        if (factoredTime < 10) return "0"+factoredTime + departureTimeTextField.getText().substring(2,5);
        return factoredTime + departureTimeTextField.getText().substring(2,5);
    }

    // IDs are auto-incremented starting from 0
    public String getUniqueID() throws IOException {
        List<String> data = Files.readAllLines(Paths.get("resources/tickets.csv"));
        int newID = Integer.parseInt(data.get(data.size() - 1).split(",")[0]) + 1;
        //System.out.println("Unique ID for this user: " + newID);
        return String.valueOf(newID);
    }
}
