import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) {
        // TODO Create a data structure to hold passenger information
        /* From the technical document:
        ⦁	Boarding Pass Number (UNIQUE), Date, Origin, Destination, Estimated time of arrival (ETA), Departure Time
        ⦁	Name, Email, Phone Number, Gender, Age
        ⦁	Total Ticket Price
         Some info will be generated via SignUp

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
