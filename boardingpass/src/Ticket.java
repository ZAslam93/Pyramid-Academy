public class Ticket {

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

    @Override
    public String toString() {
        return name+" "+email+" "+phone+" "+gender+" "+age+" "+date+" "+origin+" "+destination+" "+departure+" "+cost;
    }
}
