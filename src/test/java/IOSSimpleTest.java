import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class IOSSimpleTest {

    public AppiumDriver driver;

    @BeforeTest
    public void setUp(){
        GetIOSDriver getIOSDriver = new GetIOSDriver();
        try {
            driver = getIOSDriver.getIOSDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //Test that currency exchanger application is started with 0 amount entered
    @Test
    public void test(){
        System.out.println("It's working, can't be true!");
        WebElement e = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]"));
        System.out.println(e.getText());
        e.click(); // just for visualization
        Assert.assertEquals(e.getText(), "0.00");
    }
}