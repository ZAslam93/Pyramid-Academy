import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        // Creates and configures new JFrame via SignUp.form, opens new window
        JFrame frame = new JFrame("SignUp");
        frame.setContentPane(new SignUp().mainPanel);
        frame.setPreferredSize(new Dimension(850, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        System.out.println("Application is running...");
    }

    // Takes information from SignUp class and assigns them to the Ticket class to be saved to a file
    public static void saveInfo(String id,
                                String n, String e, String p, String g, int a, String d, String start, String finish,
                                String t, String eta, double price) {
        Ticket.id = id;
        Ticket.name = n;
        Ticket.email = e;
        Ticket.phone = p;
        Ticket.gender = g;
        Ticket.age = a;
        Ticket.date = d;
        Ticket.origin = start;
        Ticket.destination = finish;
        Ticket.departure = t;
        Ticket.eta = eta;
        Ticket.cost = price;
        System.out.println(price);
        System.out.println("Good Job.");
    }

    // Ensures phone numbers are set to a 3 digit, 3 digit, 4 digit format
    public static boolean checkPhoneFormat(String input) {
        final String REGEX = "\\d{3}-\\d{3}-\\d{4}";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher((input));
        return m.matches();
    }

    // Ensures that emails have a domain. Allows for a variety of domains, at the potential of an invalid email being used.
    public static boolean checkEmailFormat(String text) {
        final String REGEX = "\\S+@\\S+[.]\\S+";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(text);
        return m.matches();
    }

    // Checks to make sure that time field is formatted in HH:mm format. HH ensures 24hour time
    public static boolean checkTimeField(String text) {
        Date time = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            time = sdf.parse(text);
            if (!text.equals(sdf.format(time))) {
                time = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return time != null;
    }

    // Checks for date formatting in MM/DD/YYYY, 'cause America.
    public static boolean checkDateFormat(String text) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            date = sdf.parse(text);
            if (!text.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
