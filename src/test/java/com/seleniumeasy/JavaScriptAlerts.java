package com.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlerts {
    WebDriver driver;

    public JavaScriptAlerts(WebDriver driver) { this.driver = driver; }

    public void navigateTo() { driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html"); }

    public void clickAlertBox() {
        driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
        Assert.assertTrue(driver.getPageSource().contains("I am an alert box!"));
        driver.switchTo().alert().accept();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickConfirmBox() {
        driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.getPageSource().contains("You pressed Cancel!"));

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickPromptBox() {
        driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
        driver.switchTo().alert().sendKeys("Bartlomiej");
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.getPageSource().contains("You have entered 'Bartlomiej' !"));

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
