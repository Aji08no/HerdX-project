package Tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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

public class AddInventory extends Herd {

    @Test(priority = 0)
    public void createSingleTag() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(5));
        TouchAction touchAction = new TouchAction(driver);
        String path="C:\\Users\\E-7\\IdeaProjects\\HerdX_Automation\\src\\main\\resources\\TestsDetails.properties";
        FileInputStream file=new FileInputStream(path);
        Properties pro=new Properties();
        pro.load(file);
        Thread.sleep(5000);
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        totalAnimals.click();

        try {
            Thread.sleep(3000);
            // plus icon
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
            element.click();
        } catch (StaleElementReferenceException ex) {
            //plus icon
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
            element.click();
        }
        //Add animal to inventory
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

        //Manual Entry
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
        //Manual click
        Thread.sleep(4000);
        //click pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
        //click weight
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Weight']"))).click();
        //click sex/type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Sex / Type']"))).click();
        //click breeder
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Breeder']"))).click();
        //click lot id
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Lot Id']"))).click();
        //click breed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Breed']"))).click();
        //click sire
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Sire']"))).click();
        //click dam
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Dam']"))).click();
        //Click Treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
        //click receiving
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Date Received']"))).click();
        //click purchase date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Purchase Date']"))).click();
        //purchase price
        touchAction.press(PointOption.point(469, 1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519, 547))
                .release()
                .perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Purchase Price']"))).click();
        //order buyer
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Order Buyer']"))).click();
        // Right Arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();

        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
        try {
            WebElement penContent = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]")));
            if (penContent.isDisplayed()) {
                penContent.click();
            }
        }
        catch (Exception e) {
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

            //try
            try {
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Added Successfully')]")));
            }
            catch (Exception e1){
                boolean addCondition = true;
                while (addCondition){
                    WebElement editText = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
                    if (editText.isDisplayed()){
                        editText.click();
                        Thread.sleep(200);
                        editText.clear();
                        Random r=new Random();
                        int rNumber = r.nextInt(0, 99);
                        Thread.sleep(100);
                        editText.sendKeys("Titans"+rNumber);
                        driver.hideKeyboard();

                        //pasture
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
                        //save
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

                        try {
                            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Enclosure Name Already Exists')]")));
                        }catch (Exception e2){
                            addCondition = false;
                        }

                    }

                }
            }
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
        //done
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //lot id
        WebElement enterLodId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterLodId.click();
        enterLodId.sendKeys(pro.getProperty("lotID"));
        driver.hideKeyboard();

        //breed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
        //select breed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //weight
        WebElement enterWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterWeight.click();
        enterWeight.sendKeys("186");
        driver.hideKeyboard();

        //weight date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //sex/type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select bull
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //scroll
        touchAction.press(PointOption.point(537, 1899))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(523, 1610))
                .release()
                .perform();

        //breeder
        WebElement enterBreeder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterBreeder.click();
        enterBreeder.sendKeys("second");
        driver.hideKeyboard();

        //sire//android.widget.EditText[@index='4']
        WebElement enterSire = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterSire.click();
        enterSire.sendKeys("one");
        driver.hideKeyboard();

        //dam//android.widget.EditText[@index='4']
        WebElement enterDam = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='4']")));
        enterDam.click();
        enterDam.sendKeys("dam");
        driver.hideKeyboard();

        //treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();


//                // select treatment
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatment']//*[@class='android.widget.ImageView']"))).click();
        //select treatment type content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
        //select treatment type
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
        //medicineContent
        try{
            Thread.sleep(3000);
            WebElement textVerify = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='No Medicines Added Yet']")));
            if (textVerify.isDisplayed()) {
                Thread.sleep(500);
                //medicine Plus icon
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
                //Select medicine
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Medicine']"))).click();
                //select painkiller
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

                //scroll
                touchAction.press(PointOption.point(501, 1948))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                        .moveTo(PointOption.point(505, 1709))
                        .release()
                        .perform();

                //amount
                WebElement enterAmount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
                enterAmount.click();
                enterAmount.sendKeys("4");
                driver.hideKeyboard();
                //duration
                WebElement enterDuration = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
                enterDuration.click();
                enterDuration.sendKeys("2");
                driver.hideKeyboard();
                //save
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
                int next = 5;
                for (int i = 0; i < next; i++) {
                    Thread.sleep(50);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
                }
            }
        }
        catch (Exception e){
            Thread.sleep(500);
            int next=5;
            for(int i=0;i < next;i++){
                Thread.sleep(100);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
            }
        }

        //receiving date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        touchAction.press(PointOption.point(469, 1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519, 547))
                .release()
                .perform();
        //purchase date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Enter Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //purchase price
        WebElement enterPurchasePrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterPurchasePrice.click();
        Thread.sleep(200);
        enterPurchasePrice.clear();
        enterPurchasePrice.sendKeys("290");
        driver.hideKeyboard();

        touchAction.press(PointOption.point(469, 1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519, 547))
                .release()
                .perform();

        //order buyer//android.widget.EditText[@index='6']
        Thread.sleep(1000);
        WebElement enterOder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='6']")));
        enterOder.click();
        enterOder.sendKeys("good");
        driver.hideKeyboard();

        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        try {
            wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Continue']"))).click();
        } catch (Exception e) {
            e.getMessage();
        }
        //pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
        //secondary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Secondary Id']"))).click();
        //usda
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='USDA 840 Tag']"))).click();
        //date of birth
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Date of Birth']"))).click();
        //treatments
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
        //weaning date & weight
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Weaning Date & Weight']"))).click();
        Thread.sleep(2500);
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

        try{
            //EPC Prefix
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'No tags assigned to this organization')]")));
            System.out.println("No tags assigned to this organization! Please contact HerdX support.");
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

            //close pop up
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Close']"))).click();
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        } catch (Exception e) {
            e.getMessage();
        }
        //EPC Prefix
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
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
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
        enter.click();
        Thread.sleep(100);
        enter.sendKeys(tagId);
        driver.hideKeyboard();
        try {
            boolean condition = false;

            while (!condition) {
                //view summary
                WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                String summary = viewButton.getAttribute("enabled");
                if (summary.equals("false")){
                    enter.click();
                    Thread.sleep(200);
                    enter.clear();
                    int rNumber2 = r.nextInt(100, 999);
                    String tagId2 = "4" + rNumber2;
                    enter.sendKeys(tagId2);
                    driver.hideKeyboard();
                }
                else {
                    condition = true;
                }
            }
        }
        catch (Exception e){
            e.getMessage();
        }
        //getTagID
        WebElement getTagID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]")));
        String verifyTagID = getTagID.getAttribute("content-desc");
        //select pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //select bull

        try {
            Thread.sleep(2000);
            WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]")));
            if (penContent.isDisplayed()) {
                penContent.click();
            } else {
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
        } catch (Exception e) {
            e.getMessage();

        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

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

        //date of birth
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();

        //treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();
        //select treatment type content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
        //select treatment type
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        touchAction.press(PointOption.point(469, 1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519, 547))
                .release()
                .perform();

        //weaning weight
        WebElement enterWeaningWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
        enterWeaningWeight.click();
        enterWeaningWeight.sendKeys("404");
        driver.hideKeyboard();
        touchAction.press(PointOption.point(469, 1885))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(519, 547))
                .release()
                .perform();
        //weaning date
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Date']"))).click();
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();


        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        Thread.sleep(1000);
        //view summary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
        Thread.sleep(1000);
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'1 Animal Added to Inventory Successfully')]")));
        System.out.println("Successfully created new tag");


        //pen
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]"))).click();
        //search enter
        Thread.sleep(200);
        WebElement sEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        sEnter.click();
        sEnter.sendKeys(verifyTagID);
        driver.hideKeyboard();
        //tag
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]"))).click();
        System.out.println("Tag Id: "+verifyTagID);
        //tag details
        Thread.sleep(200);
        WebElement tagD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='4']")));
        String tagValue = tagD.getAttribute("content-desc");
        Thread.sleep(200);
        String[] lines = tagValue.split("\\r?\\n");
        Assert.assertEquals(lines[1],pro.getProperty("lotID"));
        System.out.println("Actual lotId :"+lines[1]+" Expected lotId :"+pro.getProperty("lotID"));
//        System.out.println("No.of UnassignedTag : " + lines[1]);
//        System.out.println(tagD.getAttribute("content-desc"));

        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Test(enabled = true)
    public void selectThreeCommonAndSpecific() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(5000);
        TouchAction touchAction = new TouchAction(driver);
        String path = "C:\\Users\\E-7\\IdeaProjects\\HerdX_Automation\\src\\main\\resources\\TestsDetails.properties";
        FileInputStream file = new FileInputStream(path);
        Properties pro = new Properties();
        pro.load(file);
        Thread.sleep(3000);
        WebElement totalAnimals = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[5]")));
        //driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[5]")).click();
        totalAnimals.click();

        try {
            Thread.sleep(3000);
            // plus icon
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
            element.click();
        } catch (StaleElementReferenceException ex) {
            //plus icon
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
            element.click();
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
        Thread.sleep(4000);
        //click pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
        //click weight
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

            //try
            try {
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Added Successfully')]")));
            }
            catch (Exception e1){
                boolean addCondition = true;
                while (addCondition){
                    WebElement editText = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
                    if (editText.isDisplayed()){
                        editText.click();
                        Thread.sleep(200);
                        editText.clear();
                        Random r=new Random();
                        int rNumber = r.nextInt(0, 99);
                        Thread.sleep(100);
                        editText.sendKeys("Titans"+rNumber);
                        driver.hideKeyboard();

                        //pasture
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
                        //save
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

                        try {
                            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Enclosure Name Already Exists')]")));
                        }catch (Exception e2){
                            addCondition = false;
                        }

                    }

                }
            }
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]"))).click();
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
        //treatments
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

        try{
            //EPC Prefix
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'No tags assigned to this organization')]")));
            System.out.println("No tags assigned to this organization! Please contact HerdX support.");
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

            //close pop up
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Close']"))).click();
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        } catch (Exception e) {
            e.getMessage();
        }
        //EPC Prefix
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
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
        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
        enter.click();
        Thread.sleep(100);
        enter.sendKeys(tagId);
        driver.hideKeyboard();
        try {
            boolean condition = false;

            while (!condition) {
                //view summary
                WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                String summary = viewButton.getAttribute("enabled");
                if (summary.equals("false")) {
                    enter.click();
                    Thread.sleep(200);
                    enter.clear();
                    int rNumber2 = r.nextInt(100, 999);
                    String tagId2 = "4" + rNumber2;
                    enter.sendKeys(tagId2);
                    driver.hideKeyboard();
                } else {
                    condition = true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        //getTagID
        WebElement getTagID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]")));
        String verifyTagID = getTagID.getAttribute("content-desc");
        //secondary id
        WebElement enterSecdaryId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        enterSecdaryId.click();
        enterSecdaryId.sendKeys(pro.getProperty("secondaryID"));
        driver.hideKeyboard();

        //usda tag

        WebElement enterUsdaTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
        enterUsdaTag.click();
        enterUsdaTag.sendKeys(pro.getProperty("USDA840Tag"));
        driver.hideKeyboard();

        //treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();
        //select treatment type content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
        //select treatment type
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        Thread.sleep(1000);
        //view summary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
        Thread.sleep(1000);
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'1 Animal Added to Inventory Successfully')]")));
        System.out.println("Successfully created new tag");


        //pen
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]"))).click();
        //search enter
        Thread.sleep(200);
        WebElement sEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        sEnter.click();
        sEnter.sendKeys(verifyTagID);
        driver.hideKeyboard();
        //tag
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]"))).click();
        System.out.println("Tag Id: " + verifyTagID);

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

        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
}
