import org.example.CreateAccountPage;
import org.example.FirstPage;
import org.example.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateAccountTest extends BaseTest {
    @Test
    public void createNewAccount() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        FirstPage firstPage = new FirstPage(driver);

        var username = "name" + randomInt;
        mainPage.goToCreateAnAccount();
        createAccountPage.typeUserName(username);
        createAccountPage.typePassword("Password1*");
        createAccountPage.confirmPassword("Password1*");
        createAccountPage.clickSubmit();
        Assertions.assertEquals("Logout, "+username, firstPage.getLogoutText());
    }

    @Test
    public void createAccountPasswordError() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        var username = "name" + randomInt;
        mainPage.goToCreateAnAccount();
        createAccountPage.typeUserName(username);
        createAccountPage.typePassword("Password1*");
        createAccountPage.confirmPassword("slaptazodis");
        createAccountPage.clickSubmit();
        Assertions.assertEquals("Įvesti slaptažodžiai nesutampa", createAccountPage.getPasswordErrorText());
    }
}
