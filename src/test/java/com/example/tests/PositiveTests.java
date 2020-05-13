package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PositiveTests {

  @Test
  public  void loginTests(){


    System.setProperty("webdriver.gecko.driver", "E:\\Soft\\Projects\\libs\\geckodriver.exe");
    WebDriver  driver = new FirefoxDriver();

    String url = "https://the-internet.herokuapp.com/";
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    driver.manage().window().maximize();

    WebElement testPage = driver.findElement(By.linkText("Form Authentication"));
    testPage.click();

    WebElement username = driver.findElement(By.id("username"));
    username.sendKeys("tomsmith");

    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("SuperSecretPassword!");

    WebElement logInButton = driver.findElement(By.xpath("//form[@id='login']/button[@class='radius']"));
    logInButton.click();


    String expectedUrl = "https://the-internet.herokuapp.com/secure";
    String actualUrl =driver.getCurrentUrl();
    Assert.assertEquals(actualUrl,expectedUrl,"wrong url");

    WebElement logOutButton = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']/i[@class='icon-2x icon-signout']"));
    Assert.assertTrue(logOutButton.isDisplayed(),"log out button not visible");

    driver.quit();

  }
}
