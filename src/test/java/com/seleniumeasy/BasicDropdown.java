package com.seleniumeasy;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasicDropdown {

    WebDriver driver;


    public BasicDropdown(WebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
    }

    public void chooseDay(){
        WebElement element = driver.findElement(By.id("select-demo"));
        Select se = new Select(element);
        se.selectByValue("Wednesday");
    }

    public void multipleSelect(){
        String[] stateOptions = {"Texas", "California", "New Jersey"};
        WebElement element = driver.findElement(By.id("multi-select"));
        Select dropdown = new Select(element);
        List<WebElement> options = dropdown.getOptions();
        Actions builder = new Actions(driver);
        boolean isMultple = dropdown.isMultiple();
        if(isMultple){
            dropdown.deselectAll();
        }
        builder.keyDown(Keys.LEFT_CONTROL);
        for(String stateOption : stateOptions){
            for(WebElement option : options){
                String optionText = option.getText().trim();
                if(optionText.equalsIgnoreCase(stateOption)){
                    if(isMultple){
                        if(!option.isSelected()){
                            builder.click(option);
                        }
                    } else{
                        option.click();
                    }
                    break;
                }
            }
        }
        builder.keyUp(Keys.LEFT_CONTROL).build().perform();

        driver.findElement(By.xpath("//button[@id='printMe']")).click();

        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//button[@id='printAll']")).click();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void assertion(){
        Assert.assertTrue(driver.getPageSource().contains("Day selected :- Wednesday"));
        Assert.assertTrue(driver.getPageSource().contains("Options selected are : Texas,California,New Jersey"));
    }


}
