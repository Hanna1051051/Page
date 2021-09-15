package pageobject.CRM;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CRMTest {
    public static CRMTestPage crmTestPage;
    public static WebDriver driver;


    @BeforeEach
    void start() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
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

    @Test
    public void crm2() {
        crmTestPage.submit()
                .contrAgent()
                .createPerson("Bron", "Hanna", "Manager")
                .selectOrganization()
                .saveAndClose();
    }
}
