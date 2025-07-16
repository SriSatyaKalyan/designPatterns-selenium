package org.designPatterns;

import org.designPatterns.abstractComponents.SearchFlightAvail;
import org.designPatterns.pageComponents.MultiTrip;
import org.designPatterns.pageComponents.RoundTrip;
import org.designPatterns.pageObjects.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class demoTest {

    By sectionElement = By.id("flightSearchContainer");
    @Test
    public void flightTest(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        travelHomePage.getFooterBar().getFlightAttribute();
        travelHomePage.getNavigationBar().getFlightAttribute();

        travelHomePage.getFooterBar().getLinkCount();
        travelHomePage.getNavigationBar().getLinkCount();

        // strategy design pattern
        SearchFlightAvail multiTrip = new MultiTrip(driver, sectionElement);
        SearchFlightAvail roundTrip = new RoundTrip(driver, sectionElement);

        travelHomePage.setBookingStrategy(multiTrip);
//        travelHomePage.setBookingStrategy(roundTrip);
        travelHomePage.checkAvail("MAA", "HYD");
    }
}
