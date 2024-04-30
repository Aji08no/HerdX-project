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

public class DeleteTag extends Herd{

    String deleteID="";
    //ReasonForDelete
    String selectDeath="Death";
    String selectTheft="Theft";
    String selectMissing="Missing";
    String selectLost="Lost";
    String selectSold="Sold";
    WebDriverWait wait;

    @Test(priority = 0)
    public void deletePenTagID() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1000);
        //total animals
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Total Anima')]"))).click();
        try{
            Thread.sleep(3000);
            //pens content
            WebElement penContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
            String content2 = penContent.getAttribute("content-desc");
            String[] lines2 = content2.split("\\r?\\n");
            System.out.println("PenName : " + lines2[0]);
            System.out.println("PenName : " + lines2[1]);
            if (penContent.isDisplayed()){
                System.out.println("There are tag in a page");
            }
        }
        catch (Exception e){
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
        WebElement penContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]")));
        String content2 = penContent.getAttribute("content-desc");
        String[] lines2 = content2.split("\\r?\\n");
        String totalTag = lines2[1];

        if (Integer.parseInt(totalTag) > 0){
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

            WebElement enter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
            enter.click();
            Random r = new Random();
            int rNumber = r.nextInt(100, 999);
            enter.sendKeys("2" + rNumber);
            driver.hideKeyboard();
            Thread.sleep(1500);

            try {
                boolean condition = false;
                while (!condition){
                    try{
                    WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='View Summary']")));
                    String summeryview = viewButton.getAttribute("enabled");
                    if (summeryview.equals("false")){
                        //enter tag
                        Thread.sleep(500);
                        WebElement enter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@index='1'])[3]")));
                        enter2.click();
                        enter2.clear();
                        Random r2 = new Random();
                        int rNumber2 = r2.nextInt(100, 999);
                        enter2.sendKeys("2" + rNumber2);
                        driver.hideKeyboard();

                    }else {
                        //view summary
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='View Summary']"))).click();
                        //add animals to inventory
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Add Animals to Inventory']"))).click();
                        //yes
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();
                        //pen
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]"))).click();
                        condition=true;
                    }
            }
                    catch (Exception e){
                        e.getMessage();
                    }
                }
            }
            catch (Exception e1) {
                e1.getMessage();
            }
        }
        //tag details
        Thread.sleep(500);
        WebElement tagD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]")));
        String tagValue = tagD.getAttribute("content-desc");
//        System.out.println(tagD.getAttribute("content-desc"));
        Thread.sleep(200);
        String[] line = tagValue.split("\\r?\\n");
        String deleteTag = line[0].substring(4);
        deleteID=deleteTag;

        //tag menu dot
        Thread.sleep(200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[14]//android.widget.ImageView[@index='1']"))).click();
        //delete inventory
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete From Inventory']"))).click();

        //death
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='"+selectTheft+"']"))).click();

        //next
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Next']"))).click();

        //delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Delete']"))).click();
        //verify snackBar
        try{
            WebElement visibleDeleteText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Animal Has Been Deleted')]")));
            if (visibleDeleteText.isDisplayed()){
                System.out.println("TagID Deleted Successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Deleted TagID :"+deleteTag);
    }

    @Test(priority = 1)
    public void deleteVerify() throws InterruptedException {

        //deleted tags
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'Deleted Tags')]"))).click();
        //deleted tags content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[18]"))).click();

        //search enter
        Thread.sleep(200);
        WebElement sEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        sEnter.click();
        sEnter.sendKeys(deleteID.trim());
        driver.hideKeyboard();
        //tag details
        Thread.sleep(200);
        WebElement tagD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]")));
        String tagValue = tagD.getAttribute("content-desc");

        String[] lines = tagValue.split("\\r?\\n");
        String actual = lines[0];
        Assert.assertEquals(actual,deleteID);
        System.out.println("Verified Successfully");

    }

    @Test(priority = 2)
    public void undoDelete() throws InterruptedException {

        Thread.sleep(1500);

        //deleted tag menu dot
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]//android.widget.ImageView[@index='1']"))).click();
        //undo delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Undo Delete']"))).click();

        //pop undo delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@content-desc='Undo Delete'])[2]"))).click();
        //verify snackBar
        try{
            WebElement visibleDeleteText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Undo Delete')]")));
            if (visibleDeleteText.isDisplayed()){
                System.out.println("Undo Deleted Successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //pen tab(//*[contains(@content-desc,'Pens')])[3]
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@content-desc,'Pens')])[3]"))).click();
        //pen content
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[4]"))).click();
        //search enter
        Thread.sleep(200);
        WebElement sEnter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]")));
        sEnter.click();
        sEnter.sendKeys(deleteID.trim());
        driver.hideKeyboard();
        //pen tag details
        Thread.sleep(200);
        WebElement tagD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='0'])[15]")));
        String tagValue = tagD.getAttribute("content-desc");
        String[] line = tagValue.split("\\r?\\n");
        String actual = line[0].substring(4);
        Assert.assertEquals(actual,deleteID);
        System.out.println("Undo Deleted Successfully");
        //back arrow
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
