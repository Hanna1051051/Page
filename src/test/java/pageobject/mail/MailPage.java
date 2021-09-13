package pageobject.mail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage {
    WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "login")
    private WebElement login;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Ввести пароль')]")
    private WebElement passwordPass;

    @FindBy(xpath = "//label[contains(text(),'Запомнить')]")
    private WebElement passwordRemember;

    @FindBy(css = "[class=\"second-button svelte-1tib0qz\"]")
    private WebElement enter;
    @FindBy(xpath = "//div[contains(text(),'Введите имя ящика')]")
    private WebElement mailError;
    @FindBy(xpath = "//div[contains(text(),'Введите пароль')]")
    private WebElement passwordError;
    @FindBy(id = "sideBarContent")
    private WebElement sideBar;
    @FindBy(css = "[href=\"/inbox/\"]")
    private WebElement inbox;

    public void open() {
        driver.get("https://mail.ru/");
    }

    public void login() {
        login.click();
    }

    public void password() {
        password.click();
    }

    public void passwordPass() {
        passwordPass.click();
    }

    public void loginValue(String value) {
        login.sendKeys(value);
    }

    public void passwordValue(String value) {
        password.sendKeys(value);
    }

    public void passwordRemember() {
        passwordRemember.click();
    }

    public void enter() {
        enter.click();
    }

    //Assertions
    public WebElement emailError() {
        return mailError;
    }

    public WebElement passwordError() {
        return passwordError;
    }

    public WebElement sideBar() {
        return sideBar;
    }

    public WebElement inbox() {
        return inbox;
    }
}
