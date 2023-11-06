package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DemoQAPage {
    WebDriver webDriver;

    By firstName = By.xpath("//input[@id='firstName']");
    By lastName = By.xpath("//input[@id='lastName']");
    By email = By.xpath("//input[@id='userEmail']");
    By gender = By.xpath("//label[contains(text(),'Female')]");
    By phoneNumber = By.xpath("//input[@id='userNumber']");
    By DOB = By.xpath("//input[@id='dateOfBirthInput']");
    By subject = By.xpath("//input[@id='subjectsInput']");
    By hobby = By.cssSelector("label[for='hobbies-checkbox-1']");
    By picture = By.id("uploadPicture");
    By address = By.xpath("//textarea[@id='currentAddress']");
    By state = By.xpath("//input[@id='react-select-3-input']");
    By city = By.id("react-select-4-input");
    By btnSubmit = By.xpath("//*[@id=\"submit\"]");

    public DemoQAPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openDemoQaPage() {
        webDriver.get("https://demoqa.com/automation-practice-form");
    }

    public void inputName(String firstNameText, String lastNameText){
        //First Name
        webDriver.findElement(firstName).sendKeys(firstNameText);
        //Last Name
        webDriver.findElement(lastName).sendKeys(lastNameText);
    }
    public void inputEmail(String emailText) {
        webDriver.findElement(email).sendKeys(emailText);
    }
    public void selectGender(){
        webDriver.findElement(gender).click();
    }
    public void inputPhoneNumber(String phoneNumberText){
        webDriver.findElement(phoneNumber).sendKeys(phoneNumberText);
    }
    public void inputDateOfBirth(String dateOfBirthText){
        webDriver.findElement(DOB).sendKeys(Keys.CONTROL + "a");
        webDriver.findElement(DOB).sendKeys(dateOfBirthText);
        webDriver.findElement(DOB).sendKeys(Keys.ENTER);
    }
    public void inputSubject(String subjectText){
        webDriver.findElement(subject).sendKeys(subjectText);
        webDriver.findElement(subject).sendKeys(Keys.ENTER);
    }

    public void selectHobbies(By selectHobby){
        webDriver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        webDriver.findElement(hobby).getText();
        webDriver.findElement(selectHobby).click();
    }
    public void inputPicture(String selectPicture){
        webDriver.findElement(picture).sendKeys(selectPicture);
    }
    public void inputAddress(String addressText){
        webDriver.findElement(address).sendKeys(addressText);
    }
    public void inputState(String stateText, By selectState){
        webDriver.findElement(state).sendKeys(stateText);
        webDriver.findElement(selectState).sendKeys(Keys.ENTER);
    }
    public void inputCity(String cityText, By selectCity){
        webDriver.findElement(city).sendKeys(cityText);
        webDriver.findElement(selectCity).sendKeys(Keys.ENTER);
    }
    public void submitForm(){
        webDriver.findElement(btnSubmit).submit();
    }
}
