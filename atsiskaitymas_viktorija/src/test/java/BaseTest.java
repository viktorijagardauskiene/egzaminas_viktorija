import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class BaseTest {
    protected WebDriver driver;
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(1000);
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
    }
    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
