/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test.com;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author helen
 */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)

//@TestMethodOrder(OrderAnnotation.class) 
//@OrderWith(OrderAnnotation.class) not working , setup problem
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@OrderWith(Alphanumeric.class)  not working,  setup problem
public class CostcoStore {

    private static WebDriver driver;
    private static String baseUrl;

    public CostcoStore() {
    }

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
//        driver = new ChromeDriver();
//        baseUrl = "https://www.google.com/";
//        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    // @Order(1)
    //@Order(1)
    @Test
    public void testA_CostcoSearch() throws Exception {
        System.out.println("first");

        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
// Search
        driver.get("https://www.costco.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("search-field")).click();
        driver.findElement(By.id("search-field")).clear();
        driver.findElement(By.id("search-field")).sendKeys("dell laptop");
        driver.findElement(By.id("formcatsearch")).submit();
        //Thread.sleep(6000);
    }
//Add to cart
    // @Order(2)

    @Test

    public void testB_AddToCart() throws Exception {
        //   System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");   
        //   driver = new ChromeDriver();
        System.out.println("second");
        Thread.sleep(6000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 200)");

        driver.findElement(By.xpath("//a[@automation-id=\"productDescriptionLink_0\"]")).click();
        //driver.findElement(By.xpath("//a[@automation-id=\"productImageLink_0\"]")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@automation-id=\"addToCartButton\"]")).click();
        //Thread.sleep(15000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='costcoModal']/div/div/div/button/span")));

        WebElement elem2 = driver.findElement(By.xpath("//div[@id='costcoModal']/div/div/div/button/span"));
        elem2.click();
        //driver.findElement(By.xpath("//div[@id='costcoModal']/div/div/div/button/span")).click();

        //Go to cart        
        driver.findElement(By.xpath("//a[@id=\"cart-d\"]")).click();

        Thread.sleep(5000);

        js.executeScript("window.scrollTo(0, 300)");
        driver.findElement(By.xpath("//input[@automation-id=\"shopCartCheckoutButton\"]")).click();

        // Thread.sleep(5000);
    }
// Login   
    // @Order(3)

    @Test

    public void testC_LogIn() throws Exception {

        //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   close
        Thread.sleep(5000);
        driver.findElement(By.id("signInName")).sendKeys("liliana4.d.s@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Infotek123@");
        driver.findElement(By.xpath("//button[@id=\"next\"]")).click();
        Thread.sleep(15000);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));  close
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 200)");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@id=\"shopAsNonMemberBtn\"]")).click();

        // driver.findElement(By.xpath("//*[@id=\"shopAsNonMemberBtn\"]")).click();   close
        Thread.sleep(3000);
        // driver.close();    close

    }

}
