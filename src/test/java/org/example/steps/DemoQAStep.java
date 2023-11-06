package org.example.steps;

import org.example.pages.DemoQAPage;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class DemoQAStep {
    static WebDriver webdriver;

    DemoQAPage demoQaPage;
    String firstName = "QA";
    String lastName = "Tester";
    String email = "qatester@gmail.com";
    String phoneNumber = "0123456789";
    String DOB = "2000 08 27";
    String subject = "Math";
    By hobby = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label");
    String picture = "D:\\\\ddd.png";
    String address = "Surabaya";
    String stateText = "n";
    By stateSelect = By.xpath("//input[@id='react-select-3-input']");
    String cityText = "d";
    By citySelect = By.id("react-select-4-input");

    @BeforeClass
    public static void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "D:\\Aplikasi\\chromedriver.exe");
        webdriver = new ChromeDriver();
    }

    @Test
    public void shouldAnswerWithTrue(){
        demoQaPage = new DemoQAPage(webdriver);
        demoQaPage.openDemoQaPage();
        demoQaPage.inputName(firstName,lastName);
        demoQaPage.inputEmail(email);
        demoQaPage.selectGender();
        demoQaPage.inputPhoneNumber(phoneNumber);
        demoQaPage.inputDateOfBirth(DOB);
        demoQaPage.inputSubject(subject);
//        demoQaPage.selectHobbies(hobby);
        demoQaPage.inputPicture(picture);
        demoQaPage.inputAddress(address);
        demoQaPage.inputState(stateText, stateSelect);
        demoQaPage.inputCity(cityText, citySelect);
        demoQaPage.submitForm();
        assertEquals(email, webdriver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText());
//        webdriver.quit();
    }
    @AfterClass
    public static void afterClass(){
        webdriver.close();
    }
}
