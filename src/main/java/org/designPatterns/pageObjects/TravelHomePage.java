package org.designPatterns.pageObjects;

import org.designPatterns.pageComponents.FooterBar;
import org.designPatterns.pageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {
    WebDriver driver;
    By footerSectionElement = By.id("traveller-home");
    By headerSectionElement = By.id("buttons");

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
}
