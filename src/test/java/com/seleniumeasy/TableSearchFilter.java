package com.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TableSearchFilter {

    WebDriver driver;

    public TableSearchFilter(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/table-search-filter-demo.html");
    }

    public void filter(){
        driver.findElement(By.xpath("//input[@id='task-table-filter']")).sendKeys("Browser Issues");

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//button[@class='btn btn-default btn-xs btn-filter']")).click();
        driver.findElement(By.xpath("//input[@placeholder='#']")).sendKeys("5");

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertion(){
        //Assert.assertFalse(driver.getPageSource().contains("Bootstrap 3"));
        Assert.assertTrue(driver.getPageSource().contains("chrisford"));
    }
}
