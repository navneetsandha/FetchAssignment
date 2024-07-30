import org.fetch.CommonFunctions;
import org.fetch.DriverSetup;
import org.fetch.PageClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseSetup {
    static WebDriver driver;
    public static PageClass pageClass;
    public static CommonFunctions commonFunctions;

    @BeforeSuite
    public void setUp() {
        driver = DriverSetup.setupDriver();
        pageClass = new PageClass(driver);
        commonFunctions = new CommonFunctions(driver);
        driver.get("http://sdetchallenge.fetch.com");
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}

