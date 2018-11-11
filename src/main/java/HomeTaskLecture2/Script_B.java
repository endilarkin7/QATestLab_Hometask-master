package HomeTaskLecture2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Script_B {
    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("webinar.test@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Xcg7299bnSmMuRLp9ITw");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement submitLoginBtn = driver.findElement(By.name("submitLogin"));
        submitLoginBtn.click();


//        DASHBOARD
        checkLeftSideMenu(driver, "//li[@id='tab-AdminDashboard']", "//*[@class='page-title']");

//        ORDERS
        checkLeftSideMenu(driver, "//li[@id='subtab-AdminParentOrders']", "//*[@class='page-title']");

//        CATALOG
        checkLeftSideMenu(driver, "//*[@id='subtab-AdminCatalog']", "//*[@id='main-div']/div[1]/h2");

//        CUSTOMERS
        checkLeftSideMenu(driver, "//li[5]/a/span", "//*[@class='page-title']");

//        SERVICE
        checkLeftSideMenu(driver, "//li[@id='subtab-AdminParentCustomerThreads']", "//*[@class='page-title']");

//        STATISTICS
        checkLeftSideMenu(driver, "//li[@id='subtab-AdminStats']", "//*[@class='page-title']");

//        MODULES
        checkLeftSideMenu(driver, "//li[@id='subtab-AdminParentModulesSf']", "//*[@id='main-div']/div[1]/h2");

//        DESIGN
        checkLeftSideMenu(driver, "//li[10]/a/span", "//*[@class='page-title']");

//        SHIPPING
        checkLeftSideMenu(driver, "//li[@id='subtab-AdminParentShipping']", "//*[@class='page-title']");

//        PAYMENT
        checkLeftSideMenu(driver, "//li[@id='subtab-AdminParentPayment']", "//*[@class='page-title']");

//        INTERNATIONAL
        checkLeftSideMenu(driver, "//li[@id='subtab-AdminInternational']", "//*[@class='page-title']");

//        SHOP PARAMETERS
        checkLeftSideMenu(driver, "//li[@id='subtab-ShopParameters']", "//*[@class='page-title']");

//        ADVANCED PARAMETERS
        checkLeftSideMenu(driver, "//li[@id='subtab-AdminAdvancedParameters']", "//*[@class='page-title']");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }


    public static void checkLeftSideMenu(WebDriver driver, String menuButtonLocator, String titleLocator) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement dashBoardBtn = driver.findElement(By.xpath(menuButtonLocator));
        dashBoardBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement titleSubMenu = driver.findElement(By.xpath(titleLocator));
        String titleSubMenuText = titleSubMenu.getText();
        System.out.println(titleSubMenuText);

        driver.navigate().refresh();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement titleSubMenu_new = driver.findElement(By.xpath(titleLocator));
        String titleSubMenuNewTextText = titleSubMenu_new.getText();

        if (titleSubMenuNewTextText.equals(titleSubMenuText)) {
            System.out.println(titleSubMenuText + "   is equial  " + titleSubMenuNewTextText + "  after page refresh");
        } else {
            System.out.println(titleSubMenuText + "   is NOT equial   " + titleSubMenuNewTextText);
        }
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}

