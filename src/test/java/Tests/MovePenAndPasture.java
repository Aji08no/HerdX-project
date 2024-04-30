package Tests;

import Tests.Herd;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class MovePenAndPasture extends Herd {

    //    @BeforeClass
    public void homePage() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']")));
//        WebElement location = driver.findElement(By.xpath("//*[@content-desc='Abi test']"));
        String locate = location.getText();
        if (locate.contains("Abi test")) {
            System.out.println(locate);
        } else {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@index='1']"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Am test"))).click();
        }
    }

    @Test(priority = 0, enabled = true)
    public void multipleMove() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            // Locate the element
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));

            // Perform actions on the element
            element.click(); // For example, clicking on the element
        } catch (StaleElementReferenceException ex) {
            // If the element is stale, re-locate it and perform actions again
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]")));
            element.click();
        }
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
        try {
            WebElement unassignedContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='0']")));
            String content = unassignedContent.getAttribute("content-desc");

            String[] lines = content.split("\\r?\\n");
            System.out.println("No.of UnassignedTag : " + lines[1]);

            if (Integer.parseInt(lines[1]) > 3) {
                unassignedContent.click();
            } else {
                //plus icon
                Thread.sleep(5000);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

                //Add animal to inventory
                Thread.sleep(500);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

                //Manual Entry
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
                //Manual click
                Thread.sleep(4000);
                //Click Treatment
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
                //right arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

                //treatment
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();
                //select treatment type content
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
                //select treatment type
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
                //back arrow
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

                for (int j = 0; j < 2; j++) {
                    //right arrow
                    Thread.sleep(50);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
                }
                Thread.sleep(1500);
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
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //add animals to inventory
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                //yes
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
                //unassigned
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='2']"))).click();
                //unassigned content
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@content-desc,'Unassigned') and @index='0']"))).click();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
//search bar
//        WebElement searchTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
//        searchTag.click();
//        searchTag.sendKeys("102");
//        driver.hideKeyboard();
//menu dot
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
//select animals-manual
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Select Animals - M')]"))).click();
//select all
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select All']"))).click();
//quick actions
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Quick Actions']"))).click();
//move to pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move to Pen / Pasture']"))).click();
//confirm
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Confirm']"))).click();
//select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(5));
        try{

            //pens content
            WebElement pastureContent = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]")));
            String content2 = pastureContent.getAttribute("content-desc");
            String[] lines2 = content2.split("\\r?\\n");
            System.out.println("PenName : " + lines2[0]);
            System.out.println("No.of PenTag : " + lines2[1]);
            if (pastureContent.isDisplayed()){
                pastureContent.click();
            }
        }
        catch (Exception e){
            //plus icon
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enter.click();
            Thread.sleep(100);
            enter.sendKeys("cartoon");
            driver.hideKeyboard();
            //pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
            //pen content
            WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]")));
            String verifycontent = penContent.getAttribute("content-desc");
            String[] pen = verifycontent.split("\\r?\\n");
            System.out.println("PenName : " + pen[0]);
            System.out.println("No.of PenTag : " + pen[1]);
            if (penContent.isDisplayed()){
                penContent.click();
            }
        }
//done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
//move
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move']"))).click();
    }

    @Test(priority = 1, enabled = true)
    public void singleMove() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Animals')]"))).click();
        //pen content
        Thread.sleep(1000);

        try {
            WebElement penContent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content = penContent.getAttribute("content-desc");
            String[] lines = content.split("\\r?\\n");
            System.out.println("PenName : " + lines[0]);
            System.out.println("No.of PenTag : " + lines[1]);


            if (Integer.parseInt(lines[1]) > 0) {
                penContent.click();
            }
        }
        catch (Exception e) {
            //plus icon
            Thread.sleep(5000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

            //Add animal to inventory
            Thread.sleep(500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

            //Manual Entry
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
            //Manual click
            Thread.sleep(4000);
            //Click Treatment
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Treatments']"))).click();
            //right arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();

            //treatment
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add']"))).click();
            //select treatment type content
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select Treatment Type']"))).click();
            //select treatment type
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Antibiotics']"))).click();
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
            //back arrow
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();

            for (int j = 0; j < 2; j++) {
                //right arrow
                Thread.sleep(50);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='3']"))).click();
            }
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
            enter.sendKeys("2" + rNumber);
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

                    //pen content
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='1'])[4]"))).click();

                }
            } catch (Exception e1) {
                e1.getMessage();
            }
        }

        Thread.sleep(3000);
        //pen tag
        WebElement penTag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@index='0'])[14]")));
        String content3 = penTag.getAttribute("content-desc");
        String[] lines3 = content3.split("\\r?\\n");
        System.out.println("Pen to Pasture TagId : " + lines3[0].substring(4));
        //pen content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0']//android.widget.ImageView[@index='1'])[3]"))).click();
        //move to pen/pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move to Pen / Pasture']"))).click();
        //select
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Select']"))).click();
        //pasture
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Pastures')]"))).click();
        try{
            //a pas
            WebElement pastureContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
            String content2 = pastureContent.getAttribute("content-desc");
            String[] lines2 = content2.split("\\r?\\n");
            System.out.println("PastureName : " + lines2[0]);
            System.out.println("No.of PastureTag : " + lines2[1]);
            if (pastureContent.isDisplayed()){
                pastureContent.click();
            }

        }
        catch (Exception e){
            //plus icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='2']"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enter.click();
            Thread.sleep(100);
            enter.sendKeys("cartoonP");
            driver.hideKeyboard();
            //pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pasture']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
            //pasture tab
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Pastures')]"))).click();
            WebElement pastureContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content2 = pastureContent.getAttribute("content-desc");
            String[] lines2 = content2.split("\\r?\\n");
            System.out.println("PastureName : " + lines2[0]);
            System.out.println("No.of PastureTag : " + lines2[1]);
            if (pastureContent.isDisplayed()){
                pastureContent.click();
            }
        }
        //done
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Done']"))).click();
        //move
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Move']"))).click();
        //a pas
        WebElement pastureContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String content2 = pastureContent.getAttribute("content-desc");
        String[] lines2 = content2.split("\\r?\\n");
//        System.out.println("PastureName : " + lines2[0]);
        System.out.println("No.of PastureTag : " + lines2[1]);
        System.out.println("============================================================");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

}