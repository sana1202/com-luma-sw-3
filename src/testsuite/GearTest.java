package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        //Mouse hover on Gear Menu
        mouseHoverElement(By.cssSelector("a[id='ui-id-6'] span:nth-child(2)"));
        //click on Bags
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        //click on product name 'overnight Duffle'
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        // Verify the text ''overnight Duffle'
        String expectedText = "Overnight Duffle";
        String actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals(expectedText,actualText);
        //change qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");
        //click on '‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));
        //verify the text 'You added Overnight Duffle to your shopping cart.'
        String expectedText1 = "You added Overnight Duffle to your shopping cart.";
        String actualText1  = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expectedText1,actualText1);
        //click on 'shopping cart' link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //verify the product name 'Cronus Yoga Pant'
        String expectedText2 = "Overnight Duffle";
        String  actualText2 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        Assert.assertEquals(expectedText2,actualText2);
        //verify the qty is 3
        String expectedText3 = "3";
        String actualText3 = driver.findElement(By.xpath("//input[@value='3']")).getAttribute("value");
        Assert.assertEquals(expectedText3,actualText3);
        //Verify the product price '$135.00'
        String expectedText4 = "$135.00";
        String actualText4 = getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));
        Assert.assertEquals(expectedText4,actualText4);
        //change qty to '5'
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendTextToElement(By.xpath("//input[@class='input-text qty']"),"5");
        //click on 'update shopping cart' button
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));
        //verify the product price '$225.00'
        String expectedText5 = "$225.00";
        String actualText5 = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']")).getAttribute("value");
        Assert.assertEquals(expectedText4,actualText4);

    }
    public void tearDown(){
        closeBrowser();
    }

}
