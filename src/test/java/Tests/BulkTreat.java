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

public class BulkTreat extends Herd{

    String medicineN ="";
    String medicineT="";

    String transferPenName="";

    WebDriverWait wait;
    @Test(priority = 0,enabled = true)
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
    public void addBulkTreat() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        Thread.sleep(4000);
        //total animals
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Anima')]"))).click();
        //pen content
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
        Thread.sleep(500);
        WebElement penContentN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String contentN = penContentN.getAttribute("content-desc");
        String[] linesN = contentN.split("\\r?\\n");
        String penNameActual = linesN[0];
        try{
            Thread.sleep(1000);
            //pens content
            WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content2 = penContent.getAttribute("content-desc");

            if (penContent.isDisplayed()){
                String[] lines2 = content2.split("\\r?\\n");
                System.out.println("PenName : " + lines2[0]);
            }
        }
        catch (Exception e){
            //plus icon
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enter.click();
            Thread.sleep(200);
            enter.sendKeys("ranger");
            driver.hideKeyboard();
            //pen
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
            //pen content
            WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content2 = penContent.getAttribute("content-desc");
            String[] lines2 = content2.split("\\r?\\n");
            System.out.println("PenName : " + lines2[0]);
        }
        Thread.sleep(1000);
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(5));
        try {
            WebElement penContent = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content = penContent.getAttribute("content-desc");
            String[] lines = content.split("\\r?\\n");


            if (Integer.parseInt(lines[1]) > 1) {
                System.out.println("PenName : " + lines[0]);
                System.out.println("No.of PenTag : " + lines[1]);
                penContent.click();
            }

        else {
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
                //click pen/pasture
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
                //right arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
                //select pen/pasture
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
                //select pen
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
                //done
                Thread.sleep(200);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
                //right arrow
                Thread.sleep(200);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
                //right arrow
                Thread.sleep(200);
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
                for (int i = 0; i < 4; i++) {
                    WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                    enter.click();
                    enter.clear();
                    Random r = new Random();
                    int rNumber = r.nextInt(100, 999);
                    enter.sendKeys("2" + rNumber);
                }
                Thread.sleep(1500);

            try {
                //view summary
                WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                if (viewButton.isEnabled()) {
                    viewButton.click();
                } else {
                    //enter tag
                    Thread.sleep(500);
                    WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                    enter2.click();
                    enter2.clear();
                    Random r2 = new Random();
                    int rNumber2 = r2.nextInt(100, 999);
                    enter2.sendKeys("2" + rNumber2);

                    viewButton.click();
                }
                //add animals to inventory
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                //yes
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
                //pen content
                WebElement penContent1 =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
                String content1 = penContent1.getAttribute("content-desc");
                String[] lines1 = content1.split("\\r?\\n");
                System.out.println("PenName : " + lines1[0]);
                System.out.println("No.of PenTag : " + lines1[1]);
                penContent1.click();
            } catch (Exception e1) {
                e1.getMessage();
            }
        }
        }catch (Exception e){
            e.getMessage();
        }
        //menu dot
        Thread.sleep(2000);
        try {
            //menu dot
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
            WebDriverWait waitBack=new WebDriverWait(driver,Duration.ofSeconds(8));
            WebElement manual = waitBack.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]")));
            if (manual.isEnabled()){
                manual.click();
            }

        }catch (Exception e){
            Thread.sleep(200);
//            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            //
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Scrim']"))).click();
            //back arrow
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

            //plus icon create pen
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            Random ran=new Random();
            int outR = ran.nextInt(0,10);
            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enter.click();
            String penName = "0aa"+outR;
            transferPenName=penName;
            Thread.sleep(200);
            enter.sendKeys(transferPenName);
            driver.hideKeyboard();
            //pen
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
            //plus icon create inventory
            Thread.sleep(5000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

            //Add animal to inventory
            Thread.sleep(500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

            //Manual Entry
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
            //Manual click
            Thread.sleep(1000);
            //click pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen / Pasture']"))).click();
            //right arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

            //select pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Select'])[1]"))).click();
            //select pen
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[3]"))).click();
            //done
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
            //right arrow
            Thread.sleep(200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
            //right arrow
            Thread.sleep(200);
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
            for (int i = 0; i < 4; i++) {
                WebElement enter1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                enter1.click();
                enter1.clear();
                Random r = new Random();
                int rNumber = r.nextInt(100, 999);
                enter1.sendKeys("2" + rNumber);
            }
            Thread.sleep(1500);

            try {
                //view summary
                WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                if (viewButton.isEnabled()) {
                    viewButton.click();
                } else {
                    //enter tag
                    Thread.sleep(500);
                    WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                    enter2.click();
                    enter2.clear();
                    Random r2 = new Random();
                    int rNumber2 = r2.nextInt(100, 999);
                    enter2.sendKeys("2" + rNumber2);

                    viewButton.click();
                }
                //add animals to inventory
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                //yes
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
                //pen content
                WebElement penContent1 =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
                String content1 = penContent1.getAttribute("content-desc");
                String[] lines1 = content1.split("\\r?\\n");
                System.out.println("PenName : " + lines1[0]);
                System.out.println("No.of PenTag : " + lines1[1]);

                penContent1.click();
                //menu dot
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
                //select animals-manual
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]"))).click();

            } catch (Exception e1) {
                e1.getMessage();
            }
        }

        //select all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select All']"))).click();
        //quick actions
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
        //treat
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treat']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

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
        touchAction.press(PointOption.point(523, 1867))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(537, 1330))
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
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        //dosage Plus icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='2'])[2]"))).click();
        //Select medicine
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Medicine']"))).click();
        //medicine
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='"+medicineN+"']"))).click();
       //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();

        //serial
        WebElement enterSerial = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='11']")));
        enterSerial.click();
        Thread.sleep(200);
        enterSerial.sendKeys("08");
        driver.hideKeyboard();
        //lot
        WebElement enterLot = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='13']")));
        enterLot.click();
        Thread.sleep(200);
        enterLot.sendKeys("treat");
        driver.hideKeyboard();
        //mfg
        WebElement enterMFG = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='13']")));
        enterMFG.click();
        Thread.sleep(200);
        enterMFG.sendKeys("directory");
        driver.hideKeyboard();
        //scroll
        Thread.sleep(500);
        touchAction.press(PointOption.point(469,1808))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                        .moveTo(PointOption.point(487,1145))
                                .release()
                                        .perform();

        //administered by
        WebElement enterAB = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='10']")));
        enterAB.click();
        Thread.sleep(200);
        enterAB.sendKeys("me");
        driver.hideKeyboard();
        //scroll
        Thread.sleep(500);
        touchAction.press(PointOption.point(469,1808))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(487,1145))
                .release()
                .perform();
        //comment
        WebElement enterComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='13']")));
        enterComment.click();
        Thread.sleep(200);
        enterComment.sendKeys("good");
        driver.hideKeyboard();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        //reminder plus icon (//android.widget.ImageView[@index='6'])
        //pending
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
        //save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
        //pop up save
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();

        //cancel  icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //close
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Close']"))).click();
        //cancel  icon
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

        //pen content
        try {
            WebElement contentName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content1 = contentName.getAttribute("content-desc");
            String[] lines1 = content1.split("\\r?\\n");
            String penNameExpected = lines1[0];
            System.out.println("PenName : " + lines1[0]);
            if (penNameExpected.equals(penNameActual)) {
                contentName.click();
            }
            else {
                System.out.println("under transfer");
                //search bar
                WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='14']")));
                searchBar.click();
                Thread.sleep(200);
                searchBar.sendKeys(transferPenName);
                driver.hideKeyboard();
                //pen content
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[19]"))).click();
            }
        }
        catch (Exception e){
            e.getMessage();
            System.out.println("dddd");
        }
        //content menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]//android.widget.ImageView[@index='1']"))).click();
        //treat
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treat']"))).click();
        //treat content
        WebElement treatment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
        String treatContent = treatment.getAttribute("content-desc");
        String[] line = treatContent.split("\\r?\\n");
        Assert.assertEquals(line[1], medicineT);
        System.out.println("Actual Treatment type : " + line[1] + " Expected Treatment type : " + medicineT);
        Assert.assertEquals(line[3], medicineT);
        System.out.println("Actual Medicine type : " + line[3] + " Expected Medicine type : " + medicineT);
        Assert.assertEquals(line[5], medicineN);
        System.out.println("Actual Treatment type : " + line[5] + " Expected Treatment type : " + medicineN);
    }
}
