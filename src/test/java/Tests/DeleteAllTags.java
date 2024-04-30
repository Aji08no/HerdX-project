package Tests;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class DeleteAllTags extends Herd{
    WebDriverWait wait;

    @Test(priority = 0)
    public void deleteAllPenTags() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1000);
        //total animals
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Anima')]"))).click();
        try {
            Thread.sleep(8000);
            //pens content
            WebElement penContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content2 = penContent.getAttribute("content-desc");
            String[] lines2 = content2.split("\\r?\\n");
            System.out.println("PenName : " + lines2[0]);
            System.out.println("No.of PenTags : " + lines2[1]);
            if (penContent.isDisplayed()) {
                System.out.println("There are pen in a page");
            }
        } catch (Exception e) {
            //plus icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
            //add pen/pasture
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Pen / Pasture']"))).click();
            //enter add pasture
            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            enter.click();
            Thread.sleep(100);
            enter.sendKeys("cartoon");
            driver.hideKeyboard();
            //pen
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Pen']"))).click();
            //save
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
//            //pen content
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[17]"))).click();
        }
        Thread.sleep(200);
        //pen tag
        try {

        WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String content2 = penContent.getAttribute("content-desc");
        String[] lines2 = content2.split("\\r?\\n");
        String totalTag = lines2[1];
        if (Integer.parseInt(totalTag) > 3) {
            penContent.click();
        } else {
            //plus icon
            Thread.sleep(5000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();

            //Add animal to inventory
            Thread.sleep(500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@index='0' and @class='android.widget.ImageView']"))).click();

            //Manual Entry
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Manual Entry')]"))).click();
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
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //add animals to inventory
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
            //yes
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
            //pen content
            WebElement content = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
            String verifyContent = content.getAttribute("content-desc");
            String[] lines = verifyContent.split("\\r?\\n");
            System.out.println("After created Tags in Pen");
            System.out.println("PenName : "+lines[0]);
            System.out.println("No.of PenTags : "+lines[1]);
            content.click();
          }
        }catch (Exception e){
            e.getMessage();
        }

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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete From Inventory']"))).click();
        //accidental scan
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Accidental Scan']"))).click();
        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();
        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
        try {
            //delete
            WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(8));
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
        }
        catch (Exception e){
            e.getMessage();
        }
        //delete pop up
        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Animals Has Been Deleted')]")));
        System.out.println("Successfully tags was deleted");
    }

    @Test(priority = 1)
    public void verifyAllDeletedTags(){
        //pen content
        WebElement content = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String verifyContent = content.getAttribute("content-desc");
        String[] lines = verifyContent.split("\\r?\\n");
        System.out.println("After deleted Tags in Pen");
        System.out.println("PenName : "+lines[0]);
        System.out.println("No.of PenTags : "+lines[1]);
        Assert.assertEquals(lines[1],"0");
        System.out.println("Successfully deleted all tags in pen");
        System.out.println("Actual penTag : "+lines[1]+" Expected penTag : 0");

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
}
