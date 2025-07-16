package org.designPatterns.pageComponents;

import org.designPatterns.abstractComponents.AbstractComponent;
import org.designPatterns.abstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

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

    public void makeStateReady(Consumer<MultiTrip> consumer){
        //common pre-requisite code
        System.out.println("MultiTrip Class");
        findElement(multiCity_rdo).click();
        findElement(modalPopUp).click();

        waitForElementToDisappear(modalPopUp);

        //accepts any method mentioned in this - in this case MultiTrip
        consumer.accept(this);
        //execute actual function
        //tear-down method
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {
        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));

        selectOriginCity(reservationDetails.get("origin"));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity(reservationDetails.get("destination"));
    }
}
