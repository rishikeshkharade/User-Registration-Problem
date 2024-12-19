import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationProblemTest {
    @Test
    public void isValidFirstName_HappyCase() {
        assertTrue(User.isValidFirstName("Rishikesh"));
    }

    @Test
    public void isValidFirstName_SadCase() {
        assertFalse(User.isValidFirstName("john"));
        assertFalse(User.isValidFirstName("jo"));
        assertFalse(User.isValidFirstName("J"));
    }

    @Test
    public void isValidLastName_HappyCase() {
        assertTrue(User.isValidLastName("Kharade"));
    }

    @Test
    public void isValidLastName_SadCase() {
        assertFalse(User.isValidLastName("kh"));
        assertFalse(User.isValidLastName("K"));
        assertFalse(User.isValidLastName("kharade"));
    }

    @Test
    public void isValidMail_HappyCase() {
        assertTrue(User.isValidMail("abc.xyz@bl.co.in"));
    }

    @Test
    public void isValidMail_SadCase() {
        assertFalse(User.isValidMail("abc@b1"));
        assertFalse(User.isValidMail("abc.xyz@.com"));
        assertFalse(User.isValidMail("abc.xyz@bl@co.in"));
    }

    @Test
    public void isValidMobileNumber_HappyCase() {
        assertTrue(User.isValidMobileNumber("91 8766866376"));
    }

    @Test
    public void isValidMobileNumber_SadCase() {
        assertFalse(User.isValidMobileNumber("918766866376"));
        assertFalse(User.isValidMobileNumber("91-8766866376"));
        assertFalse(User.isValidMail("91 8766"));
    }

    @Test
    public void isValidPassword_HappyCase() {
        assertTrue(User.isValidPassword("Password1@"));
    }

    @Test
    public void isValidPassword_SadCase() {
        assertFalse(User.isValidPassword("password@1"));
        assertFalse(User.isValidPassword("Password@"));
        assertFalse(User.isValidPassword("Password1"));
        assertFalse(User.isValidPassword("Password"));
        assertFalse(User.isValidPassword("Pass@1"));
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


