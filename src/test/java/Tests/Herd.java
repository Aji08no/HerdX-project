package Tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Herd {
    static AndroidDriver driver;

    @BeforeTest
    public void openApp() throws MalformedURLException, InterruptedException {

        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("13");
        options.setDeviceName("Galaxy Note20");
        options.setUdid("RZ8N81X10EH");
        options.setAppPackage("com.herdx.herdviewnewapp");
        options.setAppActivity("com.herdx.herdviewnewapp.MainActivity");

        URL url=new URL("http://0.0.0.0:4723/wd/hub");

        driver=new AndroidDriver(url,options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))).click();

        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        Thread.sleep(500);
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();

        WebElement mail =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.EditText'])[1]")));
        mail.click();
        Thread.sleep(1000);
        mail.sendKeys("gangappan@pro17analytics.com");

        try {
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.EditText'])[2]")));
            password.click();
            Thread.sleep(100);
            password.sendKeys("Otis@2023");
            driver.findElement(By.xpath("(//*[@content-desc='Log In'])[2]")).click();

        }
        catch (Exception e){
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.EditText'])[2]")));
            password.click();
            Thread.sleep(100);
            password.sendKeys("Otis@2023");
            driver.findElement(By.xpath("(//*[@content-desc='Log In'])[2]")).click();
        }

    }
}
