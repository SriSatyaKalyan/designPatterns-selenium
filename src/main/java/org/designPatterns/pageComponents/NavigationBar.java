package org.designPatterns.pageComponents;

import org.designPatterns.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public void getFlightAttribute(){
        // creating custom find element, restricting search scope
        System.out.println("header class attribute is: " + findElement(flights).getAttribute("class"));
    }

    public void getLinkCount(){
        System.out.println("The number of links in header are: " + findElements(links).size());
    }
}
