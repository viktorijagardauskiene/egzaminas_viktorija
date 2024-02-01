package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class MainPage extends BasePage {
    @FindBy(linkText = "Sukurti naują paskyrą")
    private WebElement linkCreateAccount;
    public void goToCreateAnAccount() {
        linkCreateAccount.click();
    }
    public MainPage(WebDriver driver) {
        super(driver);
    }
}