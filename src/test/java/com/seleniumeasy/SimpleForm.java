package com.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleForm {
    WebDriver driver;

    public SimpleForm(WebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
    }

    public void clickOnTextBox(String text)
    {

        driver.findElement(By.xpath("//input[@id='user-message']")).click();
        driver.findElement(By.xpath("//input[@id='user-message']")).clear();
        driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(text);
        driver.findElement(By.xpath("//button[@onclick='showInput();']")).click();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void totalAB(String a, String b)
    {

        driver.findElement(By.xpath("//input[@id='sum1']")).sendKeys(a);
        driver.findElement(By.xpath("//input[@id='sum2']")).sendKeys(b);
        driver.findElement(By.xpath("//button[@onclick='return total()']")).click();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertion(){
        Assert.assertTrue(driver.getPageSource().contains("37"));
        Assert.assertTrue(driver.getPageSource().contains("TEST"));
    }
}
