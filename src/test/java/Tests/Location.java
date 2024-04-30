package Tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Location extends Herd{


    @Test(priority = 0,enabled = true)
    public void createLocation() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String path = "C:\\Users\\E-7\\IdeaProjects\\HerdX_Automation\\src\\main\\resources\\TestsDetails.properties";
        FileInputStream file = new FileInputStream(path);
        Properties pro = new Properties();
        pro.load(file);
        Thread.sleep(6000);
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //settings
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
        //manage sites
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Sites']"))).click();
        //add icon
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //enter name
        WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        name.click();
        Thread.sleep(200);
        name.sendKeys(pro.getProperty("lName"));
        //enter mail
        WebElement mail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        mail.click();
        Thread.sleep(200);
        mail.sendKeys(pro.getProperty("email"));
        //address
        WebElement address = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        address.click();
        Thread.sleep(200);
        address.sendKeys(pro.getProperty("address"));
        driver.hideKeyboard();
        //state
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select maryland
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='"+pro.getProperty("state")+"']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[1]"))).click();
        //city
        WebElement city = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='9']")));
        city.click();
        Thread.sleep(200);
        city.sendKeys(pro.getProperty("lCity"));
        driver.hideKeyboard();
        //scroll
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(510,1944))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                        .moveTo(PointOption.point(510,1628))
                                .release()
                                        .perform();
        //zip code
        WebElement zipCode = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        zipCode.click();
        Thread.sleep(200);
        zipCode.sendKeys(pro.getProperty("zipCode"));
        driver.hideKeyboard();

        //sava
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //search location
        WebElement searchLocation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        searchLocation.click();
        Thread.sleep(200);
        searchLocation.sendKeys(pro.getProperty("lName"));
        driver.hideKeyboard();

        //menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[11]//android.widget.ImageView[@index='0']"))).click();
        //edit location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Location']"))).click();
        //get name
        WebElement verifyName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        String createName = verifyName.getText();
        Assert.assertEquals(createName,pro.getProperty("lName"));
        System.out.println("Actual name :"+createName+"  Expected name :"+pro.getProperty("lName"));
        //get mail
        WebElement verifyMail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        String createMail = verifyMail.getText();
        Assert.assertEquals(createMail,pro.getProperty("email"));
        System.out.println("Actual mail :"+createMail+"  Expected mail :"+pro.getProperty("email"));
        //get address
        WebElement verifyAddress = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        String createAddress = verifyAddress.getText();
        Assert.assertEquals(createAddress,pro.getProperty("address"));
        System.out.println("Actual address :"+createAddress+"  Expected address :"+pro.getProperty("address"));
        //get state
        WebElement verifyState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]")));
        String createState = verifyState.getAttribute("content-desc");
        Assert.assertEquals(createState,pro.getProperty("state"));
        System.out.println("Actual state :"+createState+"  Expected state :"+pro.getProperty("state"));
        //get city
        WebElement verifyCity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='9']")));
        String createCity = verifyCity.getText();
        Assert.assertEquals(createCity,pro.getProperty("lCity"));
        System.out.println("Actual city :"+createCity+"  Expected city :"+pro.getProperty("lCity"));
        //scroll
        touchAction.press(PointOption.point(510,1944))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(510,1628))
                .release()
                .perform();
        //get zip code
        WebElement verifyZipCode = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));

        String createZipCode = verifyZipCode.getText();
        Assert.assertEquals(createZipCode,pro.getProperty("zipCode"));
        System.out.println("Actual zipCode :"+createZipCode+"  Expected zipCode :"+pro.getProperty("zipCode"));

        System.out.println("======created successfully======");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

    @Test(priority = 1,enabled = true)
    public void editLocation() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String path = "C:\\Users\\E-7\\IdeaProjects\\HerdX_Automation\\src\\main\\resources\\TestsDetails.properties";
        FileInputStream file = new FileInputStream(path);
        Properties pro = new Properties();
        pro.load(file);
        Thread.sleep(6000);

        //manage sites
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Sites']"))).click();

        WebElement searchLocation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        searchLocation.click();
        searchLocation.sendKeys(pro.getProperty("lName"));
        try {
            WebElement menuDot = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]")));
            String verifyMenuDot = menuDot.getAttribute("clickable");
            if(verifyMenuDot.equals("true")){
                menuDot.click();
            }
            else {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
            }
        }
        catch (Exception e){
            e.getMessage();
        }
        //edit location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Location']"))).click();
        //enter name
        WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        name.click();
        Thread.sleep(200);
        name.clear();
        name.sendKeys(pro.getProperty("eName"));
        //enter mail
        WebElement mail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        mail.click();
        Thread.sleep(200);
        mail.clear();
        mail.sendKeys(pro.getProperty("eEmail"));
        //address
        WebElement address = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        address.click();
        Thread.sleep(200);
        address.clear();
        address.sendKeys(pro.getProperty("eAddress"));
        driver.hideKeyboard();
        //state
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //select maryland
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='"+pro.getProperty("eState")+"']"))).click();
        //back arrow
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[1]"))).click();
        //city
        WebElement city = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='9']")));
        city.click();
        Thread.sleep(200);
        city.clear();
        city.sendKeys(pro.getProperty("eCity"));
        driver.hideKeyboard();
        //scroll
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(510,1944))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(510,1628))
                .release()
                .perform();
        //zip code
        WebElement zipCode = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        zipCode.click();
        Thread.sleep(200);
        zipCode.clear();
        zipCode.sendKeys(pro.getProperty("eZipCode"));
        driver.hideKeyboard();
        //sava
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        WebElement searchLocation2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        searchLocation2.click();
        searchLocation2.clear();
        searchLocation2.sendKeys(pro.getProperty("eName"));

        try {
            WebElement menuDot = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]")));
            String verifyMenuDot = menuDot.getAttribute("clickable");
            if(verifyMenuDot.equals("true")){
                menuDot.click();
            }
            else {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
            }
        }
        catch (Exception e){
            e.getMessage();
        }
        //edit location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Edit Location']"))).click();
        //get name
        WebElement verifyName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        String editName = verifyName.getText();
        Assert.assertEquals(editName,pro.getProperty("eName"));
        System.out.println("Actual name :"+editName+"  Expected name :"+pro.getProperty("eName"));
        //get mail
        WebElement verifyMail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        String editMail = verifyMail.getText();
        Assert.assertEquals(editMail,pro.getProperty("eEmail"));
        System.out.println("Actual mail :"+editMail+"  Expected mail :"+pro.getProperty("eEmail"));
        //get address
        WebElement verifyAddress = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        String editAddress = verifyAddress.getText();
        Assert.assertEquals(editAddress,pro.getProperty("eAddress"));
        System.out.println("Actual address :"+editAddress+"  Expected address :"+pro.getProperty("eAddress"));
        //get state
        WebElement verifyState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]")));
        String editState = verifyState.getAttribute("content-desc");
        Assert.assertEquals(editState,pro.getProperty("eState"));
        System.out.println("Actual state :"+editState+"  Expected state :"+pro.getProperty("eState"));
        //get city
        WebElement verifyCity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='9']")));
        String editCity = verifyCity.getText();
        Assert.assertEquals(editCity,pro.getProperty("eCity"));
        System.out.println("Actual city :"+editCity+"  Expected city :"+pro.getProperty("eCity"));
        //scroll
        touchAction.press(PointOption.point(510,1944))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(510,1628))
                .release()
                .perform();
        //get zip code
        WebElement verifyZipCode = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));

        String editZipCode = verifyZipCode.getText();
        Assert.assertEquals(editZipCode,pro.getProperty("eZipCode"));
        System.out.println("Actual zipCode :"+editZipCode+"  Expected zipCode :"+pro.getProperty("eZipCode"));


        System.out.println("======Edited successfully======");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
    @Test(priority = 2,enabled = true)
    public void deleteLocation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //manage sites

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Sites']"))).click();
        WebElement searchLocation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        searchLocation.click();
        searchLocation.sendKeys("B test");
        //delete location menu
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //delete location
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete Location']"))).click();
        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();

        //cancel icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //manage sites
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Manage Sites']"))).click();
        //search location

        WebElement searchLocation1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']")));
        searchLocation1.click();
        searchLocation1.sendKeys("B test");

        try {
            WebElement display = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'No Location Found')]")));
            if (display.isDisplayed()){
                System.out.println("======Deleted successfully======");
            }
        }
        catch (Exception e){
            e.getMessage();
        }
        driver.hideKeyboard();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(200);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

}
