import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidSimpleTest {
    public AppiumDriver driver;

    @BeforeTest
    public void setUp(){
        GetAndroidDriver getAndroidDriver = new GetAndroidDriver();
        try {
            driver = getAndroidDriver.getAndroidDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //Test that GMB application is started with 0 amount entered
    @Test
    public void test() {
        System.out.println("It's working, can't be true!");

        WebElement e = driver.findElement(By.className("android.widget.Button"));
        Assert.assertEquals(e.getText(), "Get started");
    }
}
