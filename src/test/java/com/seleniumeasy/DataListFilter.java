package com.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataListFilter {
    WebDriver driver;

    public DataListFilter(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(){ driver.get("http://www.seleniumeasy.com/test/data-list-filter-demo.html"); }

    public void searchForName(String name) {
        WebElement field = driver.findElement(By.xpath("//input[@id='input-search']"));
        field.sendKeys(name);
        field.clear();
        Assert.assertTrue(driver.getPageSource().contains(name));
    }

    public void searchForEmail(String email) {
        WebElement field = driver.findElement(By.xpath("//input[@id='input-search']"));
        field.sendKeys(email);
        field.clear();
        Assert.assertTrue(driver.getPageSource().contains(email));
    }

    public void searchForPhone(String number) {
        WebElement field = driver.findElement(By.xpath("//input[@id='input-search']"));
        field.sendKeys(number);
        field.clear();
        Assert.assertTrue(driver.getPageSource().contains(number));
    }

    public void sleep() {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
