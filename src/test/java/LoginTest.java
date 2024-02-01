import org.example.CreateAccountPage;
import org.example.FirstPage;
import org.example.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    public void LoginUser() {
        MainPage mainPage = new MainPage(driver);
        FirstPage firstPage = new FirstPage(driver);

        var username = "name";
        var password = "Password1*";
        mainPage.typeUserName(username);
        mainPage.typePassword(password);
        mainPage.clickLogin();
        Assertions.assertEquals("Logout, name", firstPage.getLogoutText());
    }

    @Test
    public void LoginUserPasswordError() {
        MainPage mainPage = new MainPage(driver);

        var username = "name";
        var password = "slaptazodis";
        mainPage.typeUserName(username);
        mainPage.typePassword(password);
        mainPage.clickLogin();
        Assertions.assertEquals("Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi", mainPage.getCredentialsErrorMessageText());
    }
}
