package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']/button[@class='radius']"));
    loginButton.click();


    driver.quit();

  }
}
