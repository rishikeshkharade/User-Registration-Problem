import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationProblemTest {
    @Test
    public void isValidFirstName_HappyCase()throws InvalidFirstNameException {
        User.isValidFirstName("Rishikesh");
    }

    @Test
    public void isValidFirstName_SadCase() {
        assertThrows(InvalidFirstNameException.class, () -> User.isValidFirstName("john"));
        assertThrows(InvalidFirstNameException.class, () -> User.isValidFirstName("jo"));
        assertThrows(InvalidFirstNameException.class, () -> User.isValidFirstName("J"));
    }

    @Test
    public void isValidLastName_HappyCase() throws InvalidLastNameException{
        User.isValidLastName("Kharade");
    }

    @Test
    public void isValidLastName_SadCase() {
        assertThrows(InvalidLastNameException.class, () -> User.isValidLastName("kh"));
        assertThrows(InvalidLastNameException.class, () -> User.isValidLastName("K"));
        assertThrows(InvalidLastNameException.class, () -> User.isValidLastName("kharade"));
    }

    @Test
    public void isValidMail_HappyCase() throws InvalidMailException{
        User.isValidMail("abc.xyz@bl.co.in");
    }

    @Test
    public void isValidMail_SadCase() {
        assertThrows(InvalidMailException.class, () -> User.isValidMail("abc@b1"));
        assertThrows(InvalidMailException.class, () -> User.isValidMail("abc.xyz@.com"));
        assertThrows(InvalidMailException.class, () -> User.isValidMail("abc.xyz@bl@co.in"));
    }

    @Test
    public void isValidMobileNumber_HappyCase() throws InvalidMobileException{
        User.isValidMobileNumber("91 8766866376");
    }

    @Test
    public void isValidMobileNumber_SadCase() {
        assertThrows(InvalidMobileException.class, () -> User.isValidMobileNumber("918766866376"));
        assertThrows(InvalidMobileException.class, () -> User.isValidMobileNumber("91-8766866376"));
        assertThrows(InvalidMobileException.class, () -> User.isValidMobileNumber("91 8766"));
    }

    @Test
    public void isValidPassword_HappyCase() throws InvalidPasswordException {
        User.isValidPassword("Password1@");
    }

    @Test
    public void isValidPassword_SadCase() {
        assertThrows(InvalidPasswordException.class, () -> User.isValidPassword("dracarys@1"));
        assertThrows(InvalidPasswordException.class, () -> User.isValidPassword("Password@"));
        assertThrows(InvalidPasswordException.class, () -> User.isValidPassword("Password1"));
        assertThrows(InvalidPasswordException.class, () -> User.isValidPassword("Password"));
        assertThrows(InvalidPasswordException.class, () -> User.isValidPassword("Pass@1"));
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


