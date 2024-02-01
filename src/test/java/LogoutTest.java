import org.example.FirstPage;
import org.example.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest{

    @Test
    public void LogoutUser() {
        MainPage mainPage = new MainPage(driver);
        FirstPage firstPage = new FirstPage(driver);

        var username = "name";
        var password = "Password1*";
        mainPage.typeUserName(username);
        mainPage.typePassword(password);
        mainPage.clickLogin();
        firstPage.clickLogoutLink();
        Assertions.assertEquals("Sėkmingai atsijungėte", mainPage.getLogoutMessageText());

    }
}
