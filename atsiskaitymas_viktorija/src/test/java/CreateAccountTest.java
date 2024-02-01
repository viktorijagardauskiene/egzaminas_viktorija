import org.example.CreateAccountPage;
import org.example.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class CreateAccountTest extends BaseTest {
    @Test
    public void createNewAccount() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        MainPage mainPage = new MainPage(driver);

        var username = "name" + randomInt;
        mainPage.goToCreateAnAccount();
        createAccountPage.typeFirstName(username);
        createAccountPage.typePassword("Password1*");
        createAccountPage.confirmPassword("Password1*");
        createAccountPage.clickSubmit();
       //Assertions.assertEquals("Skaičiuotuvas", createAccountPage.getHeaderText());
    }

    @Test
    public void createAccountPasswordError() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        var username = "name" + randomInt;
        mainPage.goToCreateAnAccount();
        createAccountPage.typeFirstName(username);
        createAccountPage.typePassword("Password1*");
        createAccountPage.confirmPassword("slaptazodis");
        createAccountPage.clickSubmit();
        Assertions.assertEquals("Įvesti slaptažodžiai nesutampa", createAccountPage.getPasswordErrorText());
    }
}
