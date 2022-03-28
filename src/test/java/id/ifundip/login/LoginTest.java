package id.ifundip.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginTest {
	 Login login;

	    @BeforeEach
	    public void setUp() {
	        login = new Login();
	    }

	    @Test
	    public void shouldAttemptFailWhenEmailIsEmpty() {
	        login.setEmail("");
	        login.setPassword("jane");
	        assertFalse(login.attempt());
	    }

	    @Test
	    public void shouldAttemptFailWhenPasswordIsEmpty() {
	        login.setEmail("jane@gmail.com");
	        login.setPassword("");
	        assertFalse(login.attempt());
	    }

	    @Test
	    public void shouldAttemptFailWhenEmailIsNotFound() {
	        login.setEmail("jones@gmail.com");
	        login.setPassword("jane");
	        assertFalse(login.attempt());
	    }

	    @Test
	    public void shouldAttemptFailWhenPasswordIsIncorrect() {
	        login.setEmail("jane@gmail.com");
	        login.setPassword("john");
	        assertFalse(login.attempt());
	    }

	    @Test
	    public void shouldAttemptSuccess() {
	        login.setEmail("jane@gmail.com");
	        login.setPassword("jane");
	        assertTrue(login.attempt());
	    }

}
