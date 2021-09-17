package pageobject.mail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SettingsMail {
    public static WebDriver driver;
    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MailPage mailPage = PageFactory.initElements(driver, MailPage.class);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
