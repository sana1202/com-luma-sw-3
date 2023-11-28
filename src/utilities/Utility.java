package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will send text on elements
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    //*********************Alert methods******************************************
    /**
     * This method will switch to alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    /**
     * This method will accept to alert
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss alert
     */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    /**
     * This method will get text from Alert
     */
    public void getTextFromAlert(){
        driver.switchTo().alert().getText();
    }
    /**
     * This method will sendTextFromAlert
     */
    public void sendTextFromAlert(){
        driver.switchTo().alert().sendKeys("Text");
    }
    //*****************************Select Class Methods*****************************************************
    public void selectByValueFromDropDown(By by,String value){
        WebElement dropDown = driver.findElement(by);
        //Create the object of select class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }
    //****************************Action method*****************************************************
    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    // **************************

    /**
     * This method will display name Alphabetically
     */
    public void displayNameAlphabetically(){
        List<WebElement> nameList = driver.findElements(By.name("Product Name "));//finds all product name and saves into name list variable
        List<String> names = nameList.stream().map(n -> n.getText()).collect(Collectors.toList());//name list gets the value for each name element and creates a list with all name values
        List<String> sortedNames = names;
        Collections.sort(sortedNames);
        boolean areSorted = names.equals(sortedNames);
    }
    /**
     * This method will sort price by low to high
     */
    public void sortPriceLowToHigh(){
        List<WebElement> price = driver.findElements(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]/option[3]"));
        List<String> prices = new ArrayList<>();//get prices from the price elements and store in a list
        for (WebElement e : price) {
            prices.add(e.getText());
        }
        List<String> sortedPrices = new ArrayList<String>(prices);//make a copy of the list
        Collections.sort(sortedPrices);//sort the list
        System.out.println(sortedPrices.equals(prices));//true if prices are sorted
    }
}
