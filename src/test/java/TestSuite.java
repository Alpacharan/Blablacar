import SharedCarRide.DetailRide;
import SharedCarRide.HeaderPage;
import SharedCarRide.RideSearchPage;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestSuite extends Hooks {
    HeaderPage headerPage = new HeaderPage();
    RideSearchPage rideSearchPage=new RideSearchPage();
    DetailRide detailRide=new DetailRide();
    @Test
    public void regression() {
        headerPage.findOrOfferRide("Offer a ride");
        rideSearchPage.searchRideFrom("Wembley, UK");
        rideSearchPage.clickSeeMoreAndSelectPickup("Alperton");
        rideSearchPage.searchRideto("Aberdeen, UK");
        rideSearchPage.selectDropOff("Sunnybank School, Aberdeen");
        rideSearchPage.selectStopOver("Coventry, UK");
        rideSearchPage.selectTravelDateAndTime("07/04/2018","07","30");
        rideSearchPage.selectReturnDateAndTime("14/04/2018","07","30");
        detailRide.selectNumberOfSeats("2");
        detailRide.selectOptions();
        detailRide.rideDetail("Please come on time at pickup point");
        detailRide.acceptTermsAndClickContinue();
        String pageTitle=detailRide.getTitle();
        System.out.println(pageTitle);
        assertThat(pageTitle,is(equalTo("Already a member?")));
        }
}
