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

public class UserAddedMedicines extends Herd{
    WebDriverWait wait;
    @Test(priority = 0)
    public void createMedicines() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
        //settings
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
        //protocols
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='User Added Medicines']"))).click();
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

        //add medicines
        WebElement verifyMedicines = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
        String displayName = verifyMedicines.getAttribute("content-desc");
        String[] lines = displayName.split("\\r?\\n");
        Assert.assertEquals(lines[1],"pain Tablet");
        System.out.println("Actual medicineName : "+lines[1]+" Expected medicineName :"+"pain Tablet");
        Assert.assertEquals(lines[3],"Antibiotics");
        System.out.println("Actual medicineType : "+lines[3]+" Expected medicineType :"+"Antibiotics");
        System.out.println("Medicines created successfully");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
   }
   @Test(priority = 1)
   public void editMedicines() throws InterruptedException {
       //settings
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
       //medicines
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='User Added Medicines']"))).click();
       //edit icon
       Thread.sleep(200);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[2]"))).click();
       //enter  medicines name
       WebElement enterName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
       enterName.click();
       Thread.sleep(200);
       enterName.clear();
       enterName.sendKeys("calcium");
       //medicines type
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='7']"))).click();
       //select medicine type
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Hormones']"))).click();
       //back arrow
       Thread.sleep(500);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']"))).click();
       //save
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Save']"))).click();
       //medicine content
       WebElement verifyMedicines = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@index='1'])[2]")));
       String displayName = verifyMedicines.getAttribute("content-desc");
       String[] lines = displayName.split("\\r?\\n");
       Assert.assertEquals(lines[1],"calcium");
       System.out.println("Actual medicinesName : "+lines[1]+" Expected medicinesName : "+"calcium");
       Assert.assertEquals(lines[3],"Hormones");
       System.out.println("Actual medicineType : "+lines[3]+" Expected medicineType :"+"Hormones");
       System.out.println("Medicines edited successfully");
       driver.pressKey(new KeyEvent(AndroidKey.BACK));
   }

   @Test(priority =2)
   public void deleteMedicines() throws InterruptedException {
       //settings
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Settings']"))).click();
       //medicines
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='User Added Medicines']"))).click();
       //delete icon
       Thread.sleep(200);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='1'])[2]"))).click();
       //yes
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Yes']"))).click();

       //delete pop
       WebElement verifyDelete = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Medicine Deleted Successfully']")));
       String displayPop = verifyDelete.getAttribute("content-desc");
       Assert.assertEquals(displayPop,"Medicine Deleted Successfully");
       System.out.println("Medicine Deleted Successfully");

       //back arrow
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
       //back arrow
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@index='0'])[1]"))).click();
       driver.pressKey(new KeyEvent(AndroidKey.BACK));
   }
}
