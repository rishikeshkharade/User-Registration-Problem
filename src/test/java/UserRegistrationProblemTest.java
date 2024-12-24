import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationProblemTest {
    @Test
    public void isValidFirstName_HappyCase(){
        User.isValidFirstName.validate("Rishikesh");
    }

    @Test
    public void isValidFirstName_SadCase() {
        assertThrows(InvalidFirstNameException.class, () -> {
            if (!User.isValidFirstName.validate("john")) throw new InvalidFirstNameException("Invalid first name.");
        });
        assertThrows(InvalidFirstNameException.class, () -> {
            if (!User.isValidFirstName.validate("jo")) throw new InvalidFirstNameException("Invalid first name.");
        });
        assertThrows(InvalidFirstNameException.class, () -> {
            if (!User.isValidFirstName.validate("J")) throw new InvalidFirstNameException("Invalid first name.");
        });
    }

    @Test
    public void isValidLastName_HappyCase(){
        User.isValidLastName.validate("Kharade");
    }

    @Test
    public void isValidLastName_SadCase() {
        assertThrows(InvalidLastNameException.class, () -> {
            if (!User.isValidLastName.validate("kh")) throw new InvalidLastNameException("Invalid last name.");
        });
        assertThrows(InvalidLastNameException.class, () -> {
            if (!User.isValidLastName.validate("K")) throw new InvalidLastNameException("Invalid last name.");
        });
        assertThrows(InvalidLastNameException.class, () -> {
            if (!User.isValidLastName.validate("kharade")) throw new InvalidLastNameException("Invalid last name.");
        });
    }

    @Test
    public void isValidMail_HappyCase(){
        User.isValidMail.validate("abc.xyz@bl.co.in");
    }

    @Test
    public void isValidMail_SadCase() {
        assertThrows(InvalidMailException.class, () -> {
            if (!User.isValidMail.validate("abc@b1")) throw new InvalidMailException("Invalid email.");
        });
        assertThrows(InvalidMailException.class, () -> {
            if (!User.isValidMail.validate("abc.xyz@.com")) throw new InvalidMailException("Invalid email.");
        });
        assertThrows(InvalidMailException.class, () -> {
            if (!User.isValidMail.validate("abc.xyz@bl@co.in")) throw new InvalidMailException("Invalid eamil.");
        });
    }

    @Test
    public void isValidMobileNumber_HappyCase(){
        User.isValidMobileNumber.validate("91 8766866376");
    }

    @Test
    public void isValidMobileNumber_SadCase() {
        assertThrows(InvalidMobileException.class, () -> {
            if (!User.isValidMobileNumber.validate("918766866376")) throw new InvalidMobileException("Invalid mobile number.");
        });
        assertThrows(InvalidMobileException.class, () -> {
            if (!User.isValidMobileNumber.validate("91-8766866376")) throw new InvalidMobileException("Invalid mobile number.");
        });
        assertThrows(InvalidMobileException.class, () -> {
            if (!User.isValidMobileNumber.validate("91 8766")) throw new InvalidMobileException("Invalid mobile number.");
        });
    }

    @Test
    public void isValidPassword_HappyCase(){
        User.isValidPassword.validate("Password1@");
    }

    @Test
    public void isValidPassword_SadCase() {
        assertThrows(InvalidPasswordException.class, () -> {
            if (!User.isValidPassword.validate("darcarys@1")) {
                throw new InvalidPasswordException("Invalid Password.");
            }
        });
        assertThrows(InvalidPasswordException.class, () -> {
            if (!User.isValidPassword.validate("Password@")) {
                throw new InvalidPasswordException("Invalid Password.");
            }
        });
        assertThrows(InvalidPasswordException.class, () -> {
            if (!User.isValidPassword.validate("Password1")) {
                throw new InvalidPasswordException("Invalid Password.");
            }
        });
        assertThrows(InvalidPasswordException.class, () -> {
            if (!User.isValidPassword.validate("Password")) {
                throw new InvalidPasswordException("Invalid Password.");
            }
        });
        assertThrows(InvalidPasswordException.class, () -> {
            if (!User.isValidPassword.validate("Pass@1")) {
                throw new InvalidPasswordException("Invalid Password.");
            }
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc+100@gmail.com",
            "abc-100@abc.net",
            "abc-100@yahoo.com",
            "abc.100@abc.com.au",
            "abc.100@yahoo.com",
            "abc111@abc.com",
            "abc@1.com",
            "abc@gmail.com.com",
            "abc@yahoo.com"
    })
    void testValidEmails(String email){
        assertTrue(User.MailChecker(email), "Email should be valid: "+email);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "abc@.com.my",
            "abc123@gmail.a",
            "abc123@.com",
            "abc123@.com.com",
            ".abc@abc.com",
            "abc()*@gmail.com",
            "abc@%*.com",
            "abc..2002@gmail.com",
            "abc.@gmail.com",
            "abc@abc@gmail.com",
            "abc@gmail.com.1a",
            "abc@gmail.com.aa.au"
    })
    void testInValidEmails(String email){
        assertFalse(User.MailChecker(email), "Email are Invalid: "+email);
    }
}


