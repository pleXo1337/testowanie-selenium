package com.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicCheckbox {
    WebDriver driver;

    public BasicCheckbox(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }

    public  void clickOnCheckBox(){
        driver.findElement(By.id("isAgeSelected")).click();
    }

    public void clickOnCheckBoxButton(){
        driver.findElement(By.xpath("//input[@value='Check All']")).click();

        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@value='Uncheck All']")).click();

        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//input[@value='Check All']")).click();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertion(){
        Assert.assertTrue(driver.getPageSource().contains("Success - Check box is checked"));
    }
}
