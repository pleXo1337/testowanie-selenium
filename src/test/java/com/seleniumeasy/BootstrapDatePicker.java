package com.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BootstrapDatePicker {
    WebDriver driver;

    public BootstrapDatePicker(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    }

    public void dateExample() {
        driver.findElement(By.xpath("//input[@class='form-control']")).click();
        driver.findElement(By.xpath("//th[@class='prev']")).click();
        driver.findElement(By.xpath("//th[@class='datepicker-switch']")).click();
        driver.findElement(By.xpath("//span[text()='Apr']")).click();
        driver.findElement(By.xpath("//td[text()='24']")).click();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dateRangeExample() {
        driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Start date']")).click();
        driver.findElement(By.xpath("//td[text()='1']")).click();
        driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='End date']")).click();
        driver.findElement(By.xpath("//td[text()='25']")).click();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dateAssertion() {
        WebElement element = driver.findElement(By.xpath("//input[@class='form-control']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String date = (String) jse.executeScript("return arguments[0].value", element);
        Assert.assertEquals("24/04/2017", date);
    }

    public void dateAssertionStart() {
        WebElement element = driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Start date']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String date = (String) jse.executeScript("return arguments[0].value", element);
        Assert.assertEquals("01/01/2018", date);
    }

    public void dateAssertionEnd() {
        WebElement element = driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='End date']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String date = (String) jse.executeScript("return arguments[0].value", element);
        Assert.assertEquals("25/01/2018", date);
    }
}
