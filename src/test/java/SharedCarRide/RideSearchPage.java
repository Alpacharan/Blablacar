package SharedCarRide;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RideSearchPage extends Base {
    public void searchRideFrom(String pickUp) {
        driver.findElement(By.cssSelector(".js-legoInput-input")).sendKeys(pickUp);
        List<WebElement> allOptions = driver.findElements(By.cssSelector(".js-autocomplete-suggestionLink"));
        for (WebElement option : allOptions) {
            if (option.getText().contains(pickUp)) {
                option.click();
                break;
            }
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickSeeMoreAndSelectPickup(String pickUp) {
        driver.findElement(By.cssSelector(".js-meetingPointsInfo-pointsMapLink")).click();
        List<WebElement> allOptions = driver.findElements(By.cssSelector(".MeetingPointsMapSidebar-point"));
        for (WebElement option : allOptions) {
            if (option.getText().contains(pickUp)) {
                option.click();
                break;
            }
        }
        selectConfirmButton();
    }

    public void selectConfirmButton() {
        driver.findElement(By.cssSelector(".MeetingPointsMapSidebar-confirm")).click();
    }

    public void searchRideto(String dropOff) {
        driver.findElement(By.cssSelector(".to.js-legoInput-input")).sendKeys(dropOff);
        List<WebElement> allOptions = driver.findElements(By.cssSelector(".js-autocomplete-suggestionLink"));
        for (WebElement option : allOptions) {
            if (option.getText().contains(dropOff)) {
                option.click();
                break;
            }
        }
    }

    public void selectDropOff(String option) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> element = driver.findElements(By.cssSelector("div[class=\"MeetingPointsInfo-wrapper\"]>div>ul>li>a"));
        for (WebElement elements : element) {
            if (elements.getText().contains(option)){
                elements.click();
                break;
            }
        }
    }
    public void selectStopOver(String stop){
        driver.findElement(By.cssSelector("#new_publication_step1_stopovers_0_name")).sendKeys(stop);
        List<WebElement> allOptions = driver.findElements(By.cssSelector(".js-autocomplete-suggestionLink"));
        for (WebElement option : allOptions) {
            if (option.getText().contains(stop)) {
                option.click();
                break;
            }
        }
    }
    public void selectTravelDateAndTime(String date,String hour,String minute){
        driver.findElement(By.cssSelector("#new_publication_step1_departureDate_date")).sendKeys(date);
        driver.findElement(By.cssSelector("#new_publication_step1_departureDate_date")).sendKeys(Keys.TAB);
        Select hours=new Select(driver.findElement(By.name("new_publication_step1[departureDate][time][hour]")));
        hours.selectByVisibleText(hour);
        Select minutes=new Select(driver.findElement(By.name("new_publication_step1[departureDate][time][minute]")));
        minutes.selectByVisibleText(minute);
        }
    public void selectReturnDateAndTime(String date,String hour,String minute){
        driver.findElement(By.cssSelector("#new_publication_step1_returnDate_date")).sendKeys(date);
        driver.findElement(By.cssSelector("#new_publication_step1_returnDate_date")).sendKeys(Keys.TAB);
        Select hours=new Select(driver.findElement(By.name("new_publication_step1[returnDate][time][hour]")));
        hours.selectByVisibleText(hour);
        Select minutes=new Select(driver.findElement(By.name("new_publication_step1[returnDate][time][minute]")));
        minutes.selectByVisibleText(minute);
        driver.findElement(By.cssSelector("Button.Button--primary.Button--big.u-right.apply-btn-loader.js-realSubmit")).click();
    }
}