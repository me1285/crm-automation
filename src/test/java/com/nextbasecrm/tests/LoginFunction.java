package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriver_Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginFunction {
    //1TC for login
    /*
    1. go to login page
    2. write username
    3 write password
    4 click login button
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriver_Factory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.sleep(3);
        driver.close();
    }

    @Test
    public void  login_with_valid_credentials_with_login_btn() {
        // 2-write username
        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys(ConfigurationReader.getProperty("username"));
        //     * 3-write password
        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        //     * 4-click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        BrowserUtils.sleep(3);
        loginBtn.click();
        // 5 verify title
        String expectedTitle="Portal";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void login_with_valid_credentials_with_enter_btn() {
        // 2-write username
        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys(ConfigurationReader.getProperty("username"));
        //     * 3-write password
        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys(ConfigurationReader.getProperty("password")+ Keys.ENTER);
        //     * 4-click login button
        // 5 verify title
        String expectedTitle="Portal";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}