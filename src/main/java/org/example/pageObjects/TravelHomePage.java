package org.example.pageObjects;

import org.example.pageComponents.FooterBar;
import org.example.pageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {
    WebDriver driver;
    By sectionElement = By.id("traveller-home");

    public NavigationBar getNavigationBar(){
        return new NavigationBar();
    }

    public FooterBar getFooterBar(){
        return new FooterBar(driver, sectionElement);
    }
}
