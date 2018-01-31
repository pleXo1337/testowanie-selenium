package com.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputForm {

    WebDriver driver;

    public InputForm(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/input-form-demo.html");
    }

    public void fillForm(){
        WebElement name = driver.findElement(By.xpath("//input[@name='first_name']"));
        name.sendKeys("John");
        Assert.assertEquals(name.getAttribute("value"), "John");

        WebElement surname = driver.findElement(By.xpath("//input[@name='last_name']"));
        surname.sendKeys("Smith");
        Assert.assertEquals(surname.getAttribute("value"), "Smith");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("email@email.com");
        Assert.assertEquals(email.getAttribute("value"), "email@email.com");

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("(512)152-3151");
        Assert.assertEquals(phone.getAttribute("value"), "(512)152-3151");

        WebElement address = driver.findElement(By.xpath("//input[@name='address']"));
        address.sendKeys("Pabianicka");
        Assert.assertEquals(address.getAttribute("value"),"Pabianicka");

        WebElement city =  driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys("Lodz");
        Assert.assertEquals(city.getAttribute("value"),"Lodz");

        driver.findElement(By.name("state")).click();
        driver.findElement(By.xpath("//option[text()='Texas']")).click();

        WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
        zip.sendKeys("5125");
        Assert.assertEquals(zip.getAttribute("value"),"5125");

        WebElement website = driver.findElement(By.xpath("//input[@name='website']"));
        website.sendKeys("www.www.com");
        Assert.assertEquals(website.getAttribute("value"),"www.www.com");

        driver.findElement(By.xpath("//input[@value='yes']")).click();

        WebElement comment = driver.findElement(By.xpath("//textarea[@name='comment']"));
        comment.sendKeys("Very important message");
        Assert.assertEquals(comment.getAttribute("value"),"Very important message");

        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
