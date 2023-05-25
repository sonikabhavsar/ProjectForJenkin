package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage {
    //for click on element
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    //for type text
    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
      //for get text from element
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    public static long timestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }
    //Select DropDown element By Text
    public static void selectDropDownElementByText(By by,String text){
        //  Select select =new Select((driver.findElement(by)));
        Select select = new Select(driver.findElement(by));

    }
    public static void selectDropDownElementByValue(By by,String value){
        Select select1 = new Select(driver.findElement(by));
        select1.selectByValue(value);
    }
    //Select DropDown element By Index
    public static void selectDropDownElementByIndex(By by,int  index){
        Select select2 =new Select(driver.findElement(by));
        select2.selectByIndex(index);
    }
    //for get CurrentURL
    public static String getCurrentURL(){
        return driver.getCurrentUrl();
    }
    //Reusable Method for RadioButton
    public static void clickOnRadioButtonElement(By by) {
        driver.findElement(by).click();
    }
    public static String currentTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new
                SimpleDateFormat("ddMMyyhhmmss");
        return sdf.format(date);
    }
    public static void captureScreenshot( String fileName)
    {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File
                SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File destFile=new
                File("src\\test\\Screenshots\\"+fileName+""+currentTimeStamp()+".png");
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, destFile );
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //Wait for ElementPresent
    public static void waitForElementPresent(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        // return driver.findElement(locator);
    }
    // Wait for element visible
    public static void waitForVisibilityOfElement(By by, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("")));
    }
}
