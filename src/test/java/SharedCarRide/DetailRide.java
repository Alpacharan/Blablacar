package SharedCarRide;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DetailRide extends Base {
    String titleName;
    public void selectNumberOfSeats(String seats) {
        WebElement toClear = driver.findElement(By.cssSelector("#new_publication_step2_seatCount"));
        toClear.sendKeys(Keys.CONTROL);
        toClear.sendKeys(Keys.BACK_SPACE);
        toClear.sendKeys(seats);
    }

    public void selectOptions() {
        driver.findElement(By.cssSelector("#new_publication_step2_is_comfort")).click();
    }

    public void rideDetail(String addAboutRide) {
        driver.findElement(By.cssSelector("#new_publication_step2_comment")).sendKeys(addAboutRide);
    }
    public void acceptTermsAndClickContinue(){
        driver.findElement(By.cssSelector("#new_publication_step2_cgu")).click();
        driver.findElement(By.cssSelector("#track-step2-submit")).click();
        }
    public String getTitle(){

        titleName=driver.findElement(By.cssSelector(".kirk-title.theVoice")).getText();
        return titleName;
    }
}
