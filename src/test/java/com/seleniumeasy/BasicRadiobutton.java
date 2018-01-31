package com.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicRadiobutton {
    WebDriver driver;



    public BasicRadiobutton(WebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
    }

    public void singleRadio() {
        driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']")).click();
        driver.findElement(By.id("buttoncheck")).click();
    }

    public void groupRadio(){
        driver.findElement(By.xpath("//input[@value='Female' and @name='gender']")).click();
        driver.findElement(By.xpath("//input[@value='15 - 50' and @name='ageGroup']")).click();
        driver.findElement(By.xpath("//button[@onclick='getValues();' and @type='button']")).click();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertion(){
        Assert.assertTrue(driver.getPageSource().contains("Radio button 'Male' is checked"));
        Assert.assertFalse(driver.getPageSource().contains("Radio button 'Female' is checked"));

        Assert.assertTrue(driver.getPageSource().contains("Sex : Female"));
        Assert.assertTrue(driver.getPageSource().contains("Age group: 15 - 50"));
    }

}
