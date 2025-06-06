package org.designPatterns;

import org.designPatterns.pageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class demoTest {

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
    }
}
