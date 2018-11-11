package HomeTaskLecture3.pages;

import HomeTaskLecture3.GeneralActions;
import HomeTaskLecture3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogginPage {

    private EventFiringWebDriver driver;

    private By emailInput = By.id("email");
    private By passInput = By.id("passwd");
    private By loginBtn = By.name("submitLogin");
    private String email = "webinar.test@gmail.com";
    private String password = "Xcg7299bnSmMuRLp9ITw";




    public LogginPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void fillEmailInput() {
        GeneralActions wait = new GeneralActions (driver);
        wait.waitForContentLoad(emailInput);
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPassInput() {
        driver.findElement(passInput).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void open() {
        driver.get(Properties.getBaseAdminUrl());


    }


}
