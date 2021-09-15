package pageobject.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CRMTestPage {
    private WebDriver driver;

    public CRMTestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "_username")
    private WebElement userName;
    @FindBy(name = "_password")
    private WebElement password;
    @FindBy(id = "_submit")
    private WebElement submit;
    @FindBy(css = ".title")
    private WebElement title;
    @FindBy(linkText = "Забыли пароль?")
    private WebElement forgetPassword;
    @FindBy(linkText = "Проекты")
    private WebElement project;
    @FindBy(xpath = "//span[contains(.,'Мои проекты')]")
    private WebElement myProject;
    @FindBy(linkText = "Создать проект")
    private WebElement createProject;
    @FindBy(name = "crm_project[name]")
    private WebElement nameProject;
    @FindBy(xpath = "//span[contains(text(),'Укажите организацию')]")
    private WebElement organization;
    @FindBy(xpath = "//div[contains(text(),'1234')]")
    private WebElement selectOrganization;
    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnit;
    @FindBy(xpath = "//option[. = 'Research & Development']")
    private WebElement unitResearch;
    @FindBy(name = "crm_project[curator]")
    private WebElement curator;
    @FindBy(name = "crm_project[rp]")
    private WebElement rp;
    @FindBy(name = "crm_project[administrator]")
    private WebElement administrator;
    @FindBy(name = "crm_project[manager]")
    private WebElement manager;
    @FindBy(xpath = "//select[@name=\"crm_project[contactMain]\"]")
    private WebElement contactMain;
    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    private WebElement saveAndClose;
    //agent
    @FindBy(linkText = "Контрагенты")
    private WebElement contrAgent;
    @FindBy(xpath = "//span[contains(text(),'Контактные лица')]")
    private WebElement person;
    @FindBy(linkText = "Создать контактное лицо")
    private WebElement createPerson;
    @FindBy(name = "crm_contact[lastName]")
    private WebElement contactLastName;
    @FindBy(name = "crm_contact[firstName]")
    private WebElement contactFirstName;
    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement jobTitle;

    //Project
    public CRMTestPage open() {
        driver.get("https://crm.geekbrains.space/user/login");
        return this;
    }

    public CRMTestPage userName() {
        userName.sendKeys("Applanatest1");
        return this;
    }

    public CRMTestPage password() {
        password.sendKeys("Student2020!");
        return this;
    }

    public CRMTestPage submit() {
        submit.click();
        return this;
    }

    public CRMTestPage project() {
        project.click();
        return this;
    }

    public CRMTestPage myProjectClick() {
        myProject.click();
        return this;
    }

    public CRMTestPage createProjectClick() {
        createProject.click();
        return this;
    }

    public CRMTestPage nameProjectFill(String name) {
        nameProject.sendKeys(name);
        return this;
    }

    public CRMTestPage selectOrganization() {
        organization.click();
        selectOrganization.click();
        return this;
    }

    public CRMTestPage selectBusiness() {
        businessUnit.click();
        unitResearch.click();
        return this;
    }

    public CRMTestPage selectCurator() {
        curator.findElement(By.xpath("//option[. = 'Амелин Владимир']")).click();
        return this;
    }

    public CRMTestPage selectRP() {
        rp.findElement(By.xpath("//option[. = 'Авласёнок Денис']")).click();
        return this;
    }

    public CRMTestPage selectAdmin() {
        administrator.findElement(By.xpath("//option[. = 'Исаева Анастасия']")).click();
        return this;
    }

    public CRMTestPage selectManager() {
        Select selectObject = new Select(manager);
        selectObject.selectByVisibleText("Амелин Владимир");
        return this;
    }

    public CRMTestPage selectContactMain() {
        Select selectContact = new Select(contactMain);
        selectContact.selectByVisibleText("Соболев Михаил");
        return this;
    }

    public CRMTestPage saveAndClose() {
        saveAndClose.click();
        return this;
    }

    //Contact
    public CRMTestPage contrAgent() {
        contrAgent.click();
        person.click();
        return this;
    }

    public CRMTestPage createPerson(String lastName, String firstName, String title) {
        createPerson.click();
        contactLastName.sendKeys(lastName);
        contactFirstName.sendKeys(firstName);
        jobTitle.sendKeys(title);
        return this;
    }

    //Assertions
    public String titleName() {
        return title.getText();
    }

    public String loginValue() {
        return userName.getAttribute("value");
    }

    public WebElement forgetPassword() {
        return forgetPassword;
    }

    public String submitValue() {
        return submit.getText();
    }
}
