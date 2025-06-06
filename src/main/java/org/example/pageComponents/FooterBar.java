package org.example.pageComponents;

import org.example.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterBar extends AbstractComponent {
    WebDriver driver;

    By flights = By.cssSelector("[title='Flights']");

    public FooterBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement); //when we inherit parent class, we invoke parent class constructor in the child constructor
    }

    public void selectFlight(){
        // creating custom find element, restricting search scope
        findElement(flights).click();
    }
}
