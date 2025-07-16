package org.designPatterns;

import org.designPatterns.abstractComponents.SearchFlightAvail;
import org.designPatterns.pageComponents.MultiTrip;
import org.designPatterns.pageComponents.RoundTrip;
import org.designPatterns.pageObjects.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DemoTest {

    @Test
    public void flightTest(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        HashMap<String, String> reservationDetails = new HashMap<>();

        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        travelHomePage.getFooterBar().getFlightAttribute();
        travelHomePage.getNavigationBar().getFlightAttribute();

        travelHomePage.getFooterBar().getLinkCount();
        travelHomePage.getNavigationBar().getLinkCount();

        travelHomePage.setBookingStrategy("multitrip");
//        travelHomePage.setBookingStrategy("roundTrip");

        reservationDetails.put("origin", "MAA");
        reservationDetails.put("destination", "HYD");
        reservationDetails.put("destinationII", "BLR");

        travelHomePage.checkAvail(reservationDetails);
    }
}
