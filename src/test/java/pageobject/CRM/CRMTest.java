package pageobject.CRM;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

@Epic( "Тестирование сайта \"https://crm.geekbrains.space/user/login\"")
@DisplayName("Site 'https://crm.geekbrains.space/user/login' ")

public class CRMTest {
    public static CRMTestPage crmTestPage;
    public static WebDriver driver;

    @BeforeEach
    void start() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        crmTestPage = PageFactory.initElements(driver, CRMTestPage.class);
        crmTestPage.open()
                .userName()
                .password();
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }


    @DisplayName("Создание проекта ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void crm1() {
        Assertions.assertEquals(crmTestPage.titleName(), ("Логин"));
        Assertions.assertEquals(crmTestPage.loginValue(), ("Applanatest1"));
        Assertions.assertTrue(crmTestPage.forgetPassword().isDisplayed());
        Assertions.assertEquals(crmTestPage.submitValue(), ("Войти"));
        crmTestPage.submit()
                .project()
                .myProjectClick()
                .createProjectClick()
                .nameProjectFill("MyOffice")
                .selectOrganization()
                .selectBusiness()
                .selectCurator()
                .selectRP()
                .selectAdmin()
                .selectManager()
                .selectContactMain()
                .saveAndClose();
    }

    @DisplayName("Создание контактного лица")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void crm2() {
        crmTestPage.submit()
                .contrAgent()
                .createPerson("Bron", "Hanna", "Manager")
                .selectOrganization()
                .saveAndClose();
    }
}
