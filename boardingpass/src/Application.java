import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) {
        // TODO Create a data structure to hold passenger information
        /* From the technical document:
        ⦁	Boarding Pass Number (UNIQUE), Date, Origin, Destination, Estimated time of arrival (ETA), Departure Time
        ⦁	Name, Email, Phone Number, Gender, Age
        ⦁	Total Ticket Price
         Most info will be generated via SignUp
        */

         // TODO use passenger data structure and write to a file
         // Should be user friendly (maybe a CSV with good spacing?)
        // COMPLETED Create a GUI that will get passenger data

        // TODO ensure proper input as per these specifications:
            /*
            ALL FIELDS are required for successful form submission
            -Names should have alpha chars possibly with whitespaces. Max chars for the name field is 30
            -Emails should end in @[domain name].com, with some chars preceding it.
            -Phone numbers should take the form XXX-XXX-XXXX, only digits
            -Radio buttons should be selected
            -Date should be formatted XX/XX/XXXX, only digits
            -Origin and Destination should be different
            -Time should be formatted XX:XX, with a "max" time of 23:59 (using 24 hour format for timekeeping)
            -If tests fail, maybe avoid writing to the file?
             */

        JFrame frame = new JFrame("SignUp");
        frame.setContentPane(new SignUp().mainPanel);
        frame.setPreferredSize(new Dimension(850, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        System.out.println("HI");
    }
}
