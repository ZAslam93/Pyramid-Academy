import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    //Takes information from SignUp class and assigns them to the Ticket class to be saved to a file
    public static void saveInfo(String id,
            String n, String e, String p, String g, int a, String d, String start, String finish,
            String t, String eta, double price){
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
        System.out.println("Good Job.");
    }

    //ensures phone numbers are set to a 3 digit, 3 digit, 4 digit format
    public static boolean checkPhoneFormat(String input) {
        final String REGEX = "\\d{3}-\\d{3}-\\d{4}";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher((input));

        return m.matches();
    }

    //ensures that emails have a domain. Allows for a variety of domains, at the potential of an invalid email being used.
    public static boolean checkEmailFormat(String text) {
        final String REGEX = "\\S+@\\S+[.]\\S+";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(text);

        return m.matches();
    }

    //Checks to make sure that time field is formatted in HH:mm format. HH ensures 24hour time
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
        if (time == null) {
            return false;
        } else {
            return true;
        }
    }

    //checks for date formatting in MM/dd/yyyy, 'cause America.
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
        if (date == null) {
            return false;
        } else {
            return true;
        }
    }
}
