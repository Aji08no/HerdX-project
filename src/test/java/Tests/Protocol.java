package Tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Protocol extends Herd{

    @Test(enabled = true,priority = 0)
    public void createProtocols() throws InterruptedException {
        //menuBar
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //settings
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
        //protocols
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Protocols']"))).click();
        //add ICon
        Thread.sleep(1000);
        try {
            Thread.sleep(200);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        }
        catch (Exception e){
            Thread.sleep(200);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        }
        String protocolName = "qa";
        //enter Protocol
        WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='4' and @class='android.widget.EditText']")));
        enterPName.click();
        Thread.sleep(200);
        enterPName.sendKeys(protocolName);
        //enter description
        WebElement enterPDescription = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='6' and @class='android.widget.EditText']")));
        enterPDescription.click();
        Thread.sleep(200);
        enterPDescription.sendKeys("ruby");
        driver.hideKeyboard();
        // protocol activity
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Add Activity"))).click();
        //medicine add icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='4' and @class='android.widget.ImageView']"))).click();
        //select treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Select Treatment Type"))).click();
        //select treatment type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Vaccine']"))).click();
        //select medicine
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Select Medicine"))).click();
        //select medicine type
//        driver.findElement(By.xpath("//*[@content-desc='BOVILIS® COVEXIN® 8']")).click();
        WebElement scroll = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='BOVILIS® COVEXIN® 8']")));
        scroll.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Save"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Done"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Save"))).click();
        Thread.sleep(6000);
        //verify
        WebElement pName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
        String displayName = pName.getAttribute("content-desc");
        Assert.assertEquals(displayName.substring(0,2),protocolName);
        System.out.println("Actual protocolName : "+displayName.substring(0,2)+" Expected protocolName :"+protocolName);
        System.out.println("Successfully created protocol");

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
    @Test(priority = 1,enabled = true)
    public void editProtocol() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        Thread.sleep(2000);
        //settings
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
        //protocols
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Protocols']"))).click();

        String eProtocol = "pain";
        //edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]//android.widget.ImageView[@index='0']"))).click();
        //enter Protocol
        WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='4' and @class='android.widget.EditText']")));
        enterPName.click();
        Thread.sleep(200);
        enterPName.clear();
        enterPName.sendKeys(eProtocol);
        //enter description
        String eProtocolDescription = "Distressing feeling";
        WebElement enterPDescription = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='6' and @class='android.widget.EditText']")));
        enterPDescription.click();
        Thread.sleep(200);
        enterPDescription.clear();
        enterPDescription.sendKeys(eProtocolDescription);
        driver.hideKeyboard();

        //add treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='8']"))).click();

        //medicine edit icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //treatment type
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

        String treatmentType = "Pain Management";
        //select treatment type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='"+treatmentType+"']"))).click();

        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //medicine
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='5']"))).click();

        //select medicine
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Banamine']"))).click();

        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //back arrow
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        try {
            WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
            //protocols
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Protocols']"))).click();
        }
        catch (Exception e){
            e.getMessage();
        }
        //protocol content details
        WebElement verifyEditProtocol = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
        String displayName = verifyEditProtocol.getAttribute("content-desc");
        String[] lines = displayName.split("\\r?\\n");
        Assert.assertEquals(lines[0],eProtocol);
        System.out.println("Actual protocolName : "+lines[0]+" Expected protocolName :"+eProtocol);
        Assert.assertEquals(lines[1],eProtocolDescription);
        System.out.println("Actual protocolDescription : "+lines[1]+" Expected protocolDescription :"+eProtocolDescription);
        Assert.assertEquals(lines[3],treatmentType);
        System.out.println("Actual protocolTreatmentType : "+lines[3]+" Expected protocolTreatmentType :"+treatmentType);
        System.out.println("Successfully edited protocol");
        Thread.sleep(500);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

    @Test(priority = 2,enabled = true)
    public void deleteProtocol() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        Thread.sleep(2000);


        //settings
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
        //protocols
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Protocols']"))).click();
       //delete icon
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]//android.widget.ImageView[@index='1']"))).click();

        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

        //delete pop
        WebElement verifyDelete = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Protocol Deleted Successfully']")));
        String displayPop = verifyDelete.getAttribute("content-desc");
        Assert.assertEquals(displayPop,"Protocol Deleted Successfully");
        System.out.println("Successfully deleted protocol");

        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
