package id.ifundip.login;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginSessionTest {
	LoginSession session;

    @BeforeEach
    public void setUp() {
        session = new LoginSession();
    }

    @Test
    public void shouldCheckReturnFalseWhenEmailIsEmpty() {
        session.setEmail("");
        assertFalse(session.check());
    }

    @Test
    public void shouldCheckReturnTrue() {
        session.setEmail("jane@gmail.com");
        assertTrue(session.check());
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenLoginAttemptIsFail() {
        Login login = mock(Login.class);
        when(login.attempt()).thenReturn(false);
        assertThrows(RuntimeException.class, () -> {
        	session.storeData(login);
        });
    }
}
