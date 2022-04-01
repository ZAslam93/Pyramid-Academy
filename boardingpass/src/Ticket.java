import java.io.*;

/* From the technical document:
        ⦁	Boarding Pass Number (UNIQUE), Date, Origin, Destination, Estimated time of arrival (ETA), Departure Time
        ⦁	Name, Email, Phone Number, Gender, Age
        ⦁	Total Ticket Price
*/
public class Ticket {
    public static String id;
    public static String name;
    public static String email;
    public static String phone;
    public static String gender;
    public static int age;
    public static String date;
    public static String origin;
    public static String destination;
    public static String departure;
    public static double cost;
    public static String eta;


    @Override
    public String toString() {
        return id+" "+name+" "+email+" "+phone+" "+gender+" "+age+" "+date+" "+origin+" "+destination+" "+departure+" "+eta+" "+cost;
    }

    // After information is saved, write to tickets.csv
    public void writeTicket() throws IOException {
        FileWriter ticketWriter = new FileWriter("resources/tickets.csv",true);
        BufferedWriter buffWrite = new BufferedWriter(ticketWriter);
        //FileReader included for possible use later in lifecycle, to pull tickets based upon number.
        //FileReader ticketReader = new FileReader("resources\tickets.csv");
        try {
            buffWrite.newLine();
            buffWrite.write(id+","+name+","+email+","+phone+","+gender+","+age+","+date+","+origin+","+destination+","+departure+","+eta+","+cost);
            buffWrite.close();} catch (IOException e) {
            System.out.println("Error writing to CSV");
        }
    }
}
