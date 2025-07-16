package org.designPatterns.pageObjects;

import org.designPatterns.abstractComponents.SearchFlightAvail;
import org.designPatterns.abstractComponents.StrategyFactor;
import org.designPatterns.pageComponents.FooterBar;
import org.designPatterns.pageComponents.MultiTrip;
import org.designPatterns.pageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    WebDriver driver;
    By footerSectionElement = By.id("traveller-home");
    By headerSectionElement = By.id("buttons");
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver, headerSectionElement);
    }

    public FooterBar getFooterBar(){
        return new FooterBar(driver, footerSectionElement);
    }

    public void setBookingStrategy(String strategyType){
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        this.searchFlightAvail = strategyFactor.createStrategy(strategyType);
    }

    public void checkAvail(HashMap<String, String> reservationDetails){
        searchFlightAvail.checkAvail(reservationDetails);
    }
}
