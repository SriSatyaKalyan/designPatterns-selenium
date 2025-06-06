package org.designPatterns.pageComponents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.designPatterns.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterBar extends AbstractComponent {
    private static final Logger log = LogManager.getLogger(FooterBar.class);
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement); //when we inherit parent class, we invoke parent class constructor in the child constructor
    }

    public void getFlightAttribute(){
        // creating custom find element, restricting search scope
        System.out.println("footer class attribute is: " + findElement(flights).getAttribute("class"));
    }

    public void getLinkCount(){
        System.out.println("The number of links in footer are: " + findElements(links).size());
    }
}
