package com.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JQueryDownloadBar {

    WebDriver driver;

    public JQueryDownloadBar(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
    }

    public void startDownload(){
        driver.findElement(By.xpath("//button[@id='downloadButton']")).click();
        try{
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertion(){
        Assert.assertTrue(driver.getPageSource().contains("Complete!"));
    }

    public void finishDownload(){
        driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']")).click();
    }

}
