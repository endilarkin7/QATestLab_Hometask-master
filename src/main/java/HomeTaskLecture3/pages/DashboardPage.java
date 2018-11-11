package HomeTaskLecture3.pages;

import HomeTaskLecture3.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private EventFiringWebDriver driver;

    private By profileImg = By.xpath("//img[(@class='imgm img-thumbnail')]");
    private By logoutBtn = By.id("header_logout");
    private By catalogueTab = By.xpath("//*[@id='subtab-AdminCatalog']");
    private By categoriesSubTab = By.id("subtab-AdminCategories");


    public DashboardPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }


    public void clickOnProfileImg() {
//        WebDriverWait wait = new WebDriverWait(driver, 4);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(profileImg));
        GeneralActions wait = new GeneralActions (driver);
        wait.waitForContentLoad(profileImg);
        driver.findElement(profileImg).click();
    }

    public void clickOnLogoutBtn() {
//        WebDriverWait wait = new WebDriverWait(driver, 4);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
        GeneralActions wait = new GeneralActions (driver);
        wait.waitForContentLoad(logoutBtn);
        driver.findElement(logoutBtn).click();
    }

    public void selectCategoryItem() {
//        WebDriverWait wait = new WebDriverWait(driver, 4);
//        wait.until(ExpectedConditions.elementToBeClickable(profileImg));
        GeneralActions wait = new GeneralActions (driver);
        wait.waitForContentLoad(profileImg);
        WebElement catalogueTabElement = driver.findElement(catalogueTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogueTabElement).build().perform();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesSubTab));
        wait.waitForContentLoad(categoriesSubTab);

        catalogueTabElement.findElements(By.cssSelector("li")).get(1).click();
    }


}
