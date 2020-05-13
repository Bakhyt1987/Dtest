package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PositiveTests {

  @Test
  public  void loginTests(){


    System.setProperty("webdriver.gecko.driver", "E:\\Soft\\Projects\\libs\\geckodriver.exe");
    WebDriver  driver = new FirefoxDriver();

    String url = "https://the-internet.herokuapp.com/";
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(3,)

    WebElement testPage = driver.findElement(By.linkText("Form Authentication"));
    testPage.click();

    driver.quit();

  }
}
