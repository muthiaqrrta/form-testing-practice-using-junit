package org.example;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class form {
    static WebDriver webdriver;

    @BeforeClass
    public static void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "D:\\Aplikasi\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        webdriver = new ChromeDriver(options);
        webdriver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void practiceForm(){

        //First Name
        WebElement username = webdriver.findElement(By.xpath("//input[@id='firstName']"));
        username.sendKeys("QA");

        //Last Name
        WebElement password = webdriver.findElement(By.xpath("//input[@id='lastName']"));
        password.sendKeys("Tester");

        //Email
        WebElement email = webdriver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("qatester@gmail.com");

        // Gender
        webdriver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();

        //Phone Number
        WebElement phoneNumber = webdriver.findElement(By.xpath("//input[@id='userNumber']"));
        phoneNumber.sendKeys("0123456789");

        //Date of Birth
        WebElement DOB = webdriver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        DOB.sendKeys(Keys.CONTROL + "a");
        DOB.sendKeys("2000 08 27");
        DOB.sendKeys(Keys.ENTER);

        //Subject
        WebElement subject = webdriver.findElement(By.xpath("//input[@id='subjectsInput']"));
        subject.sendKeys("Math");
        subject.sendKeys(Keys.ENTER);

        //Hobbies
        webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String hobby = webdriver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']")).getText();
        webdriver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")).click();

        //Picture
        webdriver.findElement(By.id("uploadPicture")).sendKeys("D:\\aaa.png");

        //Address
        WebElement address = webdriver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys("Surabaya");

        //State
        webdriver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys("n");
        webdriver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys(Keys.ENTER);

        //City
        webdriver.findElement(By.id("react-select-4-input")).sendKeys("d");
        webdriver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);

        //submit
        webdriver.findElement(By.xpath("//*[@id=\"submit\"]")).submit();
        Assert.assertEquals(hobby, webdriver.findElement(By.xpath("//tbody/tr[7]/td[2]")).getText());
    }


    @AfterClass
    public static void afterClass(){
        webdriver.close();
    }
}
