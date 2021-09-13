package pageobject.CRM;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class CRMTest extends Settings {
    public static CRMTestPage crmTestPage;

    @BeforeEach
    void start() {
        crmTestPage = PageFactory.initElements(driver, CRMTestPage.class);
        crmTestPage.open()
                .userName()
                .password();
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
