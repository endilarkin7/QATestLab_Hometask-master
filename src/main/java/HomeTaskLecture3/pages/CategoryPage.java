package HomeTaskLecture3.pages;

import HomeTaskLecture3.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CategoryPage {
    private EventFiringWebDriver driver;

    private By addNewCategoryBtn = By.xpath("//a[@id='page-header-desc-category-new_category']/*[@class='process-icon-new']");
    private By inputCategoryName = By.id("name_1");

    private By categorySubmitBtn = By.id("category_form_submit_btn");
    private By alertSuccess = By.xpath("//*[@class='alert alert-success']");
    private By inputCategoryFilter = By.name("categoryFilter_name");
    private By submitCategotyFilterBtn = By.id("submitFilterButtoncategory");
    private By categoryFilteredName = By.xpath("//tr[contains(@id, 'tr_')]/td[3]");

    private String categoryName = "Category_alg_8";

    public CategoryPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void clickAddNewCategory() {
        GeneralActions wait = new GeneralActions(driver);
        wait.waitForContentLoad(addNewCategoryBtn);
        driver.findElement(addNewCategoryBtn).click();
    }

    public void fillNewCategoryInput() {
        GeneralActions wait = new GeneralActions(driver);
        wait.waitForContentLoad(inputCategoryName);
        driver.findElement(inputCategoryName).sendKeys(categoryName);
    }

    public void clickCategorySubmitBtn() {
        driver.findElement(categorySubmitBtn).click();
    }

    public void isSuccessAlertDisplayed() {
        GeneralActions wait = new GeneralActions(driver);
        wait.waitForContentLoad(alertSuccess);


        System.out.println("*************Alert about creation of new Category is presented - Ok************************");
    }

    public void fillCategoryFilterInput() {
        GeneralActions wait = new GeneralActions(driver);
        wait.waitForContentLoad(alertSuccess);
        driver.findElement(inputCategoryFilter).sendKeys(categoryName);
    }

    public void clickCategotyFilterBtn() {
        driver.findElement(submitCategotyFilterBtn).click();
    }

    public void checkFilteredCategoryName() {
        GeneralActions wait = new GeneralActions(driver);
        wait.waitForContentLoad(categoryFilteredName);

        if (driver.findElement(categoryFilteredName).getText().equals(categoryName)) {
            System.out.println("*********Categories' Names are the same - Ok*************");
        } else {
            System.out.println("*********Categories' Names are NOT the same - NOT Ok***********");
        }

    }


}
