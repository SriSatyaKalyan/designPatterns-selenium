package org.designPatterns.pageComponents;

import org.designPatterns.abstractComponents.AbstractComponent;
import org.designPatterns.abstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

    private By modalPopUp = By.id("MultiCityModelAlert");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By submit = By.id("ctl00_mainContent_btn_FindFlights");
    private By multiCity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By destination_2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(String origin, String destination) {
        System.out.println("MultiTrip Class: " + origin + ", " + destination);
        findElement(multiCity_rdo).click();
        findElement(modalPopUp).click();
        selectOriginCity(origin);
        selectDestinationCity(destination);
        selectDestinationCity("BLR");
    }

    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }

    public void selectDestinationCityII(String destination_2){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination_2 + "'])[3]")).click();
    }
}
