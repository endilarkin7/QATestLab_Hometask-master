package HomeTaskLecture3.tests;

import HomeTaskLecture3.BaseScript;
import HomeTaskLecture3.pages.CategoryPage;
import HomeTaskLecture3.pages.DashboardPage;
import HomeTaskLecture3.pages.LogginPage;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        EventFiringWebDriver driver = getConfiguredDriver();
        LogginPage logginPage = new LogginPage(driver);

        logginPage.open();
        logginPage.fillEmailInput();
        logginPage.fillPassInput();
        logginPage.clickLoginBtn();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.selectCategoryItem();

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.clickAddNewCategory();
        categoryPage.fillNewCategoryInput();
        categoryPage.clickCategorySubmitBtn();
        categoryPage.isSuccessAlertDisplayed();
        categoryPage.fillCategoryFilterInput();
        categoryPage.clickCategotyFilterBtn();

        categoryPage.checkFilteredCategoryName();

        quiteDriver(driver);


    }
}
