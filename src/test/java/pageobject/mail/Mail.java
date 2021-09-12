package pageobject.mail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class Mail extends SettingsMail{

    @Test
    public void emptyMailBox() {
        MailPage mailPage = PageFactory.initElements(driver, MailPage.class);
        mailPage.open();
        mailPage.login();
        mailPage.passwordPass();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Введите имя ящика')]")).isDisplayed());
    }

    @Test
    public void emptyPassword() {
        MailPage mailPage = PageFactory.initElements(driver, MailPage.class);
        mailPage.open();
        mailPage.login();
        mailPage.loginValue("11111@MAIL.RU");
        mailPage.passwordPass();
        mailPage.password();
        mailPage.passwordRemember();
        mailPage.enter();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Введите пароль')]")).isDisplayed());
    }

    @Test
    public void emailAuthoriz() {
        MailPage mailPage = PageFactory.initElements(driver, MailPage.class);
        mailPage.open();
        mailPage.login();
        mailPage.loginValue("pupkina_antoninka@mail.ru");
        mailPage.passwordPass();
        mailPage.password();
        mailPage.passwordValue("mer1051051mer");
        mailPage.passwordRemember();
        mailPage.enter();
        Assertions.assertTrue(driver.findElement(By.id("sideBarContent")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"/inbox/\"]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"/inbox/\"]")).isEnabled());
    }

    @Test
    public void emailContains() {
        MailPage mailPage = PageFactory.initElements(driver, MailPage.class);
        mailPage.open();
        Assertions.assertTrue(driver.getCurrentUrl().contains("mail"));
        Assertions.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Mail.ru')]")).isEnabled());
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"//news.mail.ru/\"]")).isDisplayed());
        Assertions.assertEquals(driver.findElement(By.linkText("Новости")).getText(), "Новости");
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"http://news.mail.ru/inworld/\"]")).isDisplayed());
        Assertions.assertEquals(driver.findElement(By.linkText("В мире")).getText(), "В мире");
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"//sportmail.ru/\"]")).isDisplayed());
        Assertions.assertEquals(driver.findElement(By.linkText("Спорт")).getText(), "Спорт");
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"//lady.mail.ru/\"]")).isDisplayed());
        Assertions.assertEquals(driver.findElement(By.linkText("Леди")).getText(), "Леди");
    }
}
