package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Men Menu
        mouseHoverElement(By.xpath("//span[normalize-space()='Men']"));
        //Mouse hover on Bottoms
        mouseHoverElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        //Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        //Mouse hover on product name 'cronus yoga pant' and click on size 32 and click on colour 'Black' & Click on 'Add to Cart'
        mouseHoverElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        clickOnElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));
//Verify the text 'You added Cronus Yoga Pant to your shopping cart.'
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expectedText,actualText);
        //Click on 'Shopping cart' link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //verify the text 'Shopping cart'
        String expectedText1 = "Shopping Cart";
        String actualText1 =getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals(expectedText1,actualText1);
        //verify the product name 'Cronus Yoga Pant'
        String expectedText2 = "Cronus Yoga Pant";
        String actualText2 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals(expectedText2,actualText2);
        //verify the product size '32'
        String expectedText3 = "32";
        String actualText3 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals(expectedText3,actualText3);
        //verify the product colour 'Black'
        String expectedText4 = "Black";
        String actualText4 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals(expectedText4,actualText4);
        Thread.sleep(10);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
