import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GetAndroidDriver {

    public AppiumDriver driver;

    @BeforeTest
    public AppiumDriver getAndroidDriver() throws MalformedURLException {

        File classpathRoot = new File("/Users/marina/Downloads");
        File app = new File(classpathRoot, "vega-dogfood_20150928.01_RC10.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AVD_for_Nexus_One");
        capabilities.setCapability("appPackage", "com.google.android.apps.vega");
        capabilities.setCapability("appActivity", "com.google.android.apps.vega.VegaMainActivity");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Driver started");

        return driver;
    }
}
