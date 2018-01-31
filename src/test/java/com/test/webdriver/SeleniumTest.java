package com.test.webdriver;

import com.seleniumeasy.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.seleniumeasy.BasicCheckbox;

public class SeleniumTest {

    public WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","C:/geckodriver-v0.19.1-win64/geckodriver.exe");
        driver = new FirefoxDriver();
    }


    @Test
    public void testSelenium1(){
        SimpleForm object = new SimpleForm(driver);

        object.navigateTo();
        object.clickOnTextBox("TEST");
        object.totalAB("10","27");
        object.assertion();
        driver.quit();
    }

    @Test
    public void testSelenium2(){
        BasicCheckbox object = new BasicCheckbox(driver);

        object.navigateTo();
        object.clickOnCheckBox();
        object.clickOnCheckBoxButton();
        object.assertion();
        driver.quit();

    }

    @Test
    public void testSelenium3(){
        BasicRadiobutton object = new BasicRadiobutton(driver);

        object.navigateTo();
        object.singleRadio();
        object.groupRadio();
        object.assertion();
        driver.quit();
    }

    @Test
    public void testSelenium4(){
        BasicDropdown object = new BasicDropdown(driver);

        object.navigateTo();
        object.chooseDay();
        object.multipleSelect();
        object.assertion();
        driver.quit();
    }

    @Test
    public void testSelenium5(){
        DataListFilter object = new DataListFilter(driver);

        object.navigateTo();
        object.searchForName("Brenda");
        object.sleep();
        object.searchForEmail("test3");
        object.sleep();
        object.searchForPhone("1111");
        object.sleep();
        driver.quit();

    }


    @Test
    public void testSelenium6(){
        InputForm object = new InputForm(driver);

        object.navigateTo();
        object.fillForm();
        driver.quit();
    }

    @Test
    public void testSelenium7(){
        BootstrapDatePicker object = new BootstrapDatePicker(driver);

        object.navigateTo();
        object.dateExample();
        object.dateAssertion();
        object.dateRangeExample();
        object.dateAssertionStart();
        object.dateAssertionEnd();

        driver.quit();
    }

    @Test
    public void testSelenium8(){
        JQueryDownloadBar object = new JQueryDownloadBar(driver);

        object.navigateTo();
        object.startDownload();
        object.assertion();
        object.finishDownload();
        driver.quit();
    }

    @Test
    public void testSelenium9(){
        TableSearchFilter object = new TableSearchFilter(driver);

        object.navigateTo();
        object.filter();
        object.assertion();
        driver.quit();
    }

    @Test
    public void testSelenium10(){
        JavaScriptAlerts object = new JavaScriptAlerts(driver);

        object.navigateTo();
        object.clickAlertBox();
        object.clickConfirmBox();
        object.clickPromptBox();
        driver.quit();
    }

}
