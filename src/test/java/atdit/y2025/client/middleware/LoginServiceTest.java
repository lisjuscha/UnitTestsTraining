package atdit.y2025.client.middleware;

import atdit.y2025.client.domain.LoginFailedException;
import atdit.y2025.client.domain.ServiceException;
import atdit.y2025.client.domain.User;
import atdit.y2025.server.LoginRequestHandler;
import atdit.y2025.server.Server;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginServiceTest {
    @Test
    public void ifPasswordIsInitial__throwLoginFailedException() {
        try {
            new LoginService().login( "admin", "" );
            Assertions.fail("Expected LoginFailedException");
        } catch( ServiceException e ) {
            Assertions.fail("Expected LoginFailedException");
        } catch( LoginFailedException e ) {
            //expected
        }
    }

    @Test
    void ifCorrectCredentials__createUserObject( ) {
        var server = new Server( new LoginRequestHandler( ) );
        server.start( ); //this makes it an integration test, but not a unit test!!!

        User user = null;

        try {
            var cut = new LoginService( );
            user = cut.login( "admin", "admin" );
        } catch( ServiceException | LoginFailedException e ) {
            Assertions.fail("No exception expected");
        }

        Assertions.assertNotNull( user );
    }

    @Test
    public void ifUserAndPasswordAreNull__throwLoginFailedException() {
        try {
            new LoginService().login(null, null);
            Assertions.fail("Expected LoginFailedException");
        } catch (ServiceException e) {
            Assertions.fail("Expected LoginFailedException");
        } catch (LoginFailedException e) {
            // expected
        }
    }

    @Test
    public void ifUserFilledAndPasswordEmpty__throwLoginFailedException() {
        try {
            new LoginService().login("admin", "");
            Assertions.fail("Expected LoginFailedException");
        } catch (ServiceException e) {
            Assertions.fail("Expected LoginFailedException");
        } catch (LoginFailedException e) {
            // expected
        }
    }

    @Test
    public void ifUserFilledAndPasswordNull__throwLoginFailedException() {
        try {
            new LoginService().login("admin", null);
            Assertions.fail("Expected LoginFailedException");
        } catch (ServiceException e) {
            Assertions.fail("Expected LoginFailedException");
        } catch (LoginFailedException e) {
            // expected
        }
    }

    @Test
    public void ifUserEmptyAndPasswordFilled__throwLoginFailedException() {
        try {
            new LoginService().login("", "password");
            Assertions.fail("Expected LoginFailedException");
        } catch (ServiceException e) {
            Assertions.fail("Expected LoginFailedException");
        } catch (LoginFailedException e) {
            // expected
        }
    }

    @Test
    public void ifUserNullAndPasswordFilled__throwLoginFailedException() {
        try {
            new LoginService().login(null, "password");
            Assertions.fail("Expected LoginFailedException");
        } catch (ServiceException e) {
            Assertions.fail("Expected LoginFailedException");
        } catch (LoginFailedException e) {
            // expected
        }
    }
}