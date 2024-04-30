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

import java.time.Duration;
import java.util.Random;

public class UserAddedMedicineAddAnimal extends Herd{

     String medicineN ="";
     String medicineT="";
     String tag="";

    WebDriverWait wait;
    @Test(priority = 0)
    public void userMedicineActive() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //settings
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
        //user medicines
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='User Added Medicines']"))).click();

        try {
            //medicine content
            WebElement medicineContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
            if (medicineContent.isDisplayed()){
                System.out.println("Medicines is there");
            }
        }
        catch (Exception e){
            //plus icon
            Thread.sleep(2000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
            //enter  medicines name
            WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
            enterName.click();
            Thread.sleep(200);
            enterName.sendKeys("pain Tablet");
            //medicines type
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='7']"))).click();
            //select medicine type
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
            //back arrow
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        }

        //edit icon
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();

        try {
            WebElement switchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Switch[@index='4']")));
            String verifyButton = switchButton.getAttribute("checked");
            if(verifyButton.equals("false")){
                switchButton.click();
                //save
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
            }
            else {
                Thread.sleep(1000);
                //back arrow
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
            }
        }
        catch (Exception e){
            e.getMessage();
        }

        Thread.sleep(500);
        //add medicines
        WebElement verifyMedicines = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
        String displayName = verifyMedicines.getAttribute("content-desc");
        String[] lines = displayName.split("\\r?\\n");
        String medicineName = lines[1];
        System.out.println("MedicineName : "+medicineName);
        medicineN=medicineName;
        String medicineType = lines[3];
        System.out.println("Actual medicineType : "+medicineType);
        medicineT=medicineType;
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //Dashboard
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Dashboard']"))).click();
    }

    @Test(priority = 1)
    public void addAnimalWithMedicines() throws InterruptedException {
        Thread.sleep(1000);
        //total animals
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Anima')]"))).click();
        //pen content
//        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
//        try{
//
//            //pens content
//            WebElement penContent = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
//            String content2 = penContent.getAttribute("content-desc");
//            String[] lines2 = content2.split("\\r?\\n");
//            System.out.println("PenName : " + lines2[0]);
//            if (penContent.isDisplayed()){
//                penContent.click();
//            }
//        }
//        catch (Exception e){
//            //plus icon
//            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
//            //add pen/pasture
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
//            //enter add pasture
//            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
//            enter.click();
//            Thread.sleep(100);
//            enter.sendKeys("ranger");
//            driver.hideKeyboard();
//            //pen
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
//            //save
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
//            //pen content
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]"))).click();
//        }

        //plus icon
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

        //Add animal to inventory
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

        //Manual Entry
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
        //Manual click
        Thread.sleep(1000);
        //right arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
        //Click Treatment
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
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

        WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
        enter.click();
        Random r = new Random();
        int rNumber = r.nextInt(100, 999);
        enter.sendKeys("3" + rNumber);
        driver.hideKeyboard();
        Thread.sleep(1500);

        try {
            boolean condition = false;
            while (!condition){
                try {
                    WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                    String summerView = viewButton.getAttribute("enabled");
                    if (summerView.equals("false")) {
                        //enter tag
                        Thread.sleep(500);
                        WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                        enter2.click();
                        enter2.clear();
                        Random r2 = new Random();
                        int rNumber2 = r2.nextInt(100, 999);
                        enter2.sendKeys("2" + rNumber2);
                        driver.hideKeyboard();
                    }
                    else {
                        condition=true;
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e1) {
            e1.getMessage();
        }
        //tag id
        WebElement id = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        String tagId = id.getAttribute("content-desc");
        System.out.println("TagID "+id.getAttribute("content-desc"));
        tag=tagId;
        //treatment
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();
        //select treatment type content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
        //treatment search
        Thread.sleep(200);
        WebElement enterTreatment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        enterTreatment.click();
        Thread.sleep(200);
        enterTreatment.sendKeys(medicineT);
        driver.hideKeyboard();
        //select treatment type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='"+medicineT+"']"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();


        //medicine Plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //Select medicine
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Medicine']"))).click();
        //medicine search
        WebElement enterMedicine = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']")));
        enterMedicine.click();
        Thread.sleep(200);
        enterMedicine.sendKeys(medicineN);
        driver.hideKeyboard();
        //select Energy drink
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'"+medicineN+"')]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //scroll
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(501, 1948))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(505, 1709))
                .release()
                .perform();

        //amount
        WebElement enterAmount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        enterAmount.click();
        Thread.sleep(200);
        enterAmount.sendKeys("4");
        driver.hideKeyboard();
        WebElement enterDuration = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
        enterDuration.click();
        Thread.sleep(200);
        enterDuration.sendKeys("2");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        int next = 5;
        for (int i = 0; i < next; i++) {
            Thread.sleep(50);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
        }
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //view summary
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']"))).click();
        //add animals to inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
        //yes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
    }

    @Test(priority = 2)
    public void verifyAddMedicines() throws InterruptedException {

        Thread.sleep(2000);
//unassigned
        try{
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
        }
        catch (Exception e){
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
        }

        //unassigned content
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='0']"))).click();
        //tad search
        Thread.sleep(200);
        WebElement enterTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        enterTag.click();
        Thread.sleep(200);
        enterTag.sendKeys(tag);
        driver.hideKeyboard();
        //menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0']//android.widget.ImageView[@index='1'])[3]"))).click();
        //treat
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treat']"))).click();
        //treat content
        WebElement treat = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
        String verifyTreat = treat.getAttribute("content-desc");
        String[] lines = verifyTreat.split("\\r?\\n");
        String actualMedicineT = lines[3];
        String actualMedicineN = lines[5];
        Assert.assertEquals(actualMedicineT,medicineT);
        System.out.println("Actual MedicineTreatment "+actualMedicineT+" Expected MedicineTreatment "+medicineT);
        Assert.assertEquals(actualMedicineN,medicineN);
        System.out.println("Actual MedicineTreatment "+actualMedicineN+" Expected MedicineTreatment "+medicineN);

        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
