import java.util.Scanner;
import java.util.regex.*;
public class User {
    public static boolean isValidFirstName(String firstName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return Pattern.matches(regex, firstName);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to User Registration Problem");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name: ");
        String firstName = sc.nextLine();
        if (isValidFirstName(firstName)) {
            System.out.println("Valid first name.");
        } else {
            System.out.println("Invalid first name. It must start with a capital letter and have at least 3 characters.");
        }

    }
}
