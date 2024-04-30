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
import java.util.Random;

public class OfflineAddInventory extends Herd{
    String penName="";
    String TagId="";

    WebDriverWait wait;
    TouchAction touchAction;

    @Test(enabled = true,priority = 0)
    public void selectThreeCommonAndSpecific() throws InterruptedException, IOException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(10000);
        touchAction = new TouchAction(driver);
        String path = "C:\\Users\\E-7\\IdeaProjects\\HerdX\\src\\main\\resources\\Imformation.properties";
        FileInputStream file = new FileInputStream(path);
        Properties pro = new Properties();
        pro.load(file);
        //scroll down
        touchAction.press(PointOption.point(334,108))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                                .moveTo(PointOption.point(406,1064))
                                        .release()
                                                .perform();
        Thread.sleep(4000);
        //scroll up
        touchAction.press(PointOption.point(541,2223))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(541,582))
                .release()
                .perform();
        //ok
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='OK']"))).click();

        Thread.sleep(3000);
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        totalAnimals.click();

        try {
            Thread.sleep(3000);
            //penContent
            WebElement penContent = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
            if (penContent.isDisplayed()) {
                String verifyPenContent = penContent.getAttribute("content-desc");
                String[] line = verifyPenContent.split("\\r?\\n");
                System.out.println("Before no.of tags : "+line[1]);
                // plus icon
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
                element.click();
            }

        } catch (Exception e) {
            //plus icon
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
            element.click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enterPName.click();
            Thread.sleep(100);
            enterPName.sendKeys("Titans");
            driver.hideKeyboard();
            //pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

            //penContent
            WebElement penContent = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));

            String verifyPenContent = penContent.getAttribute("content-desc");
            String[] line = verifyPenContent.split("\\r?\\n");
            System.out.println("Before no.of tags : "+line[1]);
            try {
                Thread.sleep(500);
                // plus icon
                WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
                element1.click();
            }catch (Exception e1) {
                Thread.sleep(500);
                // plus icon
                WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
                element1.click();
            }
        }
        //Add animal to inventory
        try {
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

        } catch (Exception e) {
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();
        }
        //Manual Entry
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
        //Manual click

        //click pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
        //click weight
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Weight']"))).click();
        //click sex/type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Sex / Type']"))).click();
        //click breeder
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Breeder']"))).click();

        // Right Arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();

        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
        try {
            WebElement penContent = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]")));
            if (penContent.isDisplayed()) {
                penContent.click();
            }
        } catch (Exception e) {
            e.getMessage();
            //plus icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[1]"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enterPName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enterPName.click();
            Thread.sleep(100);
            enterPName.sendKeys("Titans");
            driver.hideKeyboard();
            //pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //weight
        WebElement enterWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterWeight.click();
        Thread.sleep(200);
        enterWeight.sendKeys("186");
        driver.hideKeyboard();

        //weight date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //sex/type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select bull
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Bull']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();


        //breeder
        WebElement enterBreeder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterBreeder.click();
        Thread.sleep(100);
        enterBreeder.sendKeys("second");
        driver.hideKeyboard();

        //right arrow
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        try {
            wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Continue']"))).click();
        } catch (Exception e) {
            e.getMessage();
        }

        //secondary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Secondary Id']"))).click();
        //usda
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='USDA 840 Tag']"))).click();
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //EPC Prefix
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //EPC Prefix dropdown select
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='E26878434']"))).click();
        //select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[3]"))).click();
        //select dropDown
        Thread.sleep(100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='99977149481']"))).click();
        //enter tag
        Thread.sleep(500);
        Random r = new Random();
        int rNumber = r.nextInt(100, 999);
        String tagId = "5" + rNumber;
        TagId=tagId;
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
        enter.click();
        Thread.sleep(100);
        enter.sendKeys(tagId);
        try {
            Thread.sleep(4000);
            WebElement epc = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
            if (epc.isEnabled()) {
                WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                enter2.click();
                enter2.clear();
                Thread.sleep(100);
                enter2.sendKeys(tagId);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        //secondary id
        WebElement enterSecdaryId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterSecdaryId.click();
        enterSecdaryId.sendKeys(pro.getProperty("secondaryID"));
        driver.hideKeyboard();

        //usda tag

        WebElement enterUsdaTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
        enterUsdaTag.click();
        enterUsdaTag.sendKeys(pro.getProperty("USDA840Tag"));
        driver.hideKeyboard();


        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        Thread.sleep(500);
        //view summary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
        Thread.sleep(500);
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();


        //pen
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]"))).click();
        //search enter
        Thread.sleep(200);
        WebElement sEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        sEnter.click();
        sEnter.sendKeys(TagId);
        driver.hideKeyboard();
        //tag
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        System.out.println("Created Tag Id: " + TagId);

        //tag details
        Thread.sleep(200);
        WebElement tagD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='4']")));
        String tagValue = tagD.getAttribute("content-desc");
        String[] lines = tagValue.split("\\r?\\n");
        Assert.assertEquals(lines[3], pro.getProperty("secondaryID"));
        System.out.println("Actual secondaryId :" + lines[3] + "Expected secondaryId :" + pro.getProperty("secondaryID"));
        Assert.assertEquals(lines[5], pro.getProperty("USDA840Tag"));
        System.out.println("Actual USDA 840 Tag :" + lines[5] + "  Expected USDA 840 Tag :" + pro.getProperty("USDA840Tag"));
        Assert.assertEquals(lines[7], "second");
        System.out.println("Actual breeder :" + lines[7] + "  Expected breeder :" + "second");

        System.out.println("Successfully created for offline inventory");
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //pen content
        WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String verifyPenContent = penContent.getAttribute("content-desc");
        String[] line = verifyPenContent.split("\\r?\\n");
        penName = line[0];
        String penCount = line[1];
        System.out.println("After no.of tags : "+line[1]);

    }

    @Test(priority = 1,enabled = true)
    public void verifyToSwitchOnline() throws InterruptedException {
        Thread.sleep(4000);

        //scroll down
        touchAction.press(PointOption.point(334,108))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(406,1064))
                .release()
                .perform();
        Thread.sleep(4000);
        //scroll up
        touchAction.press(PointOption.point(541,2223))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(541,582))
                .release()
                .perform();

        //pen search bar
        Thread.sleep(200);
        WebElement penSearchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        penSearchBar.click();
        Thread.sleep(200);
        penSearchBar.sendKeys(penName);
        driver.hideKeyboard();
        //pen content

        WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[19]")));
        String verifyPenContent = penContent.getAttribute("content-desc");
        String[] line = verifyPenContent.split("\\r?\\n");
        String penCount = line[1];
        System.out.println("After switchToOnline no.of tags : "+penCount);
        penContent.click();

        //tag search bar(//android.widget.ImageView[@index='1'])[2]
        Thread.sleep(200);
        WebElement tagSearchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        tagSearchBar.click();
        Thread.sleep(200);
        tagSearchBar.sendKeys(TagId);
        driver.hideKeyboard();
        //tag content
        WebElement tagContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]")));
        String verifyTagContent = tagContent.getAttribute("content-desc");
        String[] line1 = verifyTagContent.split("\\r?\\n");
        String tagCount = line1[0];
        System.out.println(tagCount.substring(5));

        Assert.assertEquals(tagCount.substring(5),TagId);

        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
}
