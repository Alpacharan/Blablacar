package SharedCarRide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderPage extends Base {
    public void findOrOfferRide(String rideOption) {
        List<WebElement> allOptions = driver.findElements(By.cssSelector(".Home-button"));
        for (WebElement option : allOptions) {
            if (option.getText().contains(rideOption)) {
                option.click();
                break;
            }
        }
    }
}

