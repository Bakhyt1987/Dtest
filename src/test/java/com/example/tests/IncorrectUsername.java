package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IncorrectUsername {
    @Test
    public void incorrectUsername(){
        System.setProperty("webdriver.gecko.driver", "E:\\Soft\\Projects\\libs\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith1");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement logInButton = driver.findElement(By.xpath("//form[@id='login']/button[@class='radius']"));
        logInButton.click();



        WebElement errorMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(errorMessage.isDisplayed(),"error message is visible");

        String expectedMessage = "Your username is invalid!";
        String actualMessage = errorMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        driver.quit();


    }
}
