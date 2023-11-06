package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    static WebDriver webdriver;
    String keyword;

    @BeforeClass
    public static void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "D:\\Aplikasi\\chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.get("https://wikipedia.org");
    }

    @Test
    public void searchApple(){

        keyword ="Apple";

        WebElement webElement = webdriver.findElement(By.xpath("//input[@id='searchInput']"));
        webElement.sendKeys(keyword);

        webdriver.findElement(By.xpath("//i[contains(text(),'Search')]")).click();

        WebElement pagetitle = webdriver.findElement(By.xpath("//*[@id=\"firstHeading\"]"));
        assertEquals("Page is not Apple", keyword, pagetitle.getText());
        System.out.println("Page is " + keyword);
    }
    @Test
    public void searchBanana(){

        keyword ="Banana";

        WebElement webElement = webdriver.findElement(By.xpath("//input[@id='searchInput']"));
        webElement.sendKeys(keyword);

        webdriver.findElement(By.xpath("//input[@id='searchButton']")).click();

        WebElement pagetitle = webdriver.findElement(By.xpath("//*[@id=\"firstHeading\"]"));
        assertEquals("Page is not Banana", keyword, pagetitle.getText());
        System.out.println("Page is " + keyword);
    }
    @Test
    public void searchKiwifruit(){

        keyword = "Kiwifruit";

        WebElement webElement = webdriver.findElement(By.xpath("//input[@id='searchInput']"));
        webElement.sendKeys(keyword);

        webdriver.findElement(By.xpath("//input[@id='searchButton']")).click();

        WebElement pagetitle = webdriver.findElement(By.xpath("//*[@id=\"firstHeading\"]"));
        assertEquals("Page is not Kiwifruit", keyword, pagetitle.getText());
        System.out.println("Page is " + keyword);
    }

    @AfterClass
    public static void afterClass(){
        webdriver.close();
    }

//    @BeforeClass
//    public static void beforeClassMethod(){
//        System.out.println("ini method BeforeClass");
//    }
//
//    @Before
//    public void beforeMethod(){
//        System.out.println("ini method Before");
//    }
//
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        System.out.println("Method Compare String");
//        String hasilTest = "makan";
//        String expected = "makan";
//        assertEquals( "tidak cocok", expected, hasilTest);
//    }
//    @Test
//    public void testEvenNumber()
//    {
//        System.out.println("Method Number");
//        int num =2;
//        boolean value = checkEvenNumber(num);
//        assertTrue("value not true", value);
//    }
//    public boolean checkEvenNumber(int num){
//        return(num%2==0);
//    }
//    @Test
//    public void habisDibagiTiga()
//    {
//        int num1 =6;
//        int num2 =2;
//        int hasil;
//        hasil = num1 + num2;
//        boolean value = checkNumber(hasil);
//        assertTrue("value not true", value);
//        System.out.println("Habis dibagi 3");
//    }
//    public boolean checkNumber(int num){
//        return(num%3==0);
//    }
//
//    @Test(timeout = 2000)
//    public void testWait() throws InterruptedException {
//        Thread.sleep(2000);
//        assertTrue("False", true);
//    }
//
//    @After
//    public void  methodAfter(){
//        System.out.println("Ini method After");
//    }
//
//    @AfterClass
//    public static void methodAfterClass(){
//        System.out.println("Ini method AfterClass");
//    }


}
