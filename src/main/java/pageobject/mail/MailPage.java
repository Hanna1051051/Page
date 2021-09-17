package pageobject.mail;

import io.qameta.allure.Step;
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

    @Step("Открытие сайта")
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

    @Step("Ввод логина {value}")
    public void loginValue(String value) {
        login.sendKeys(value);
    }

    @Step("Ввод пароля {value}")
    public void passwordValue(String value) {
        password.sendKeys(value);
    }

    public void passwordRemember() {
        passwordRemember.click();
    }

    @Step("Подтверждение авторизации")
    public void enter() {
        enter.click();
    }

    //Assertions
    @Step("Сообщение об ошибке")
    public WebElement emailError() {
        return mailError;
    }

    @Step("Сообщение об ошибке")
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
