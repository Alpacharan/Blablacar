import SharedCarRide.Base;
import SharedCarRide.Utils;
import cucumber.api.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    Base base = new Base();
    WebDriver driver;
    Utils utils = new Utils();


    @Before
    public void setUp() {
        base.openBrowser();
        base.maximiseBrowser();
        base.navigateTo("https://www.blablacar.co.uk/");
        base.applyImpWaits();
    }

    @After
    public void quitDriver() {

      /*  if (.isFailed()) {
            utils.capScreenshot(driver,.getName());
        }*/
    }
}
