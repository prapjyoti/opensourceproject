package opensource;
/*
https://opensource-demo.orangehrmlive.com/
( Username : Admin | Password : admin123 )
Enter username
Enter password
Click login
Verify that the text “Welcome Paul”
After Paul one symbol there so click on symbol for logout.
Verify that the below text.
LOGIN Panel
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class Opensource_1 {
    WebDriver driver;//global variable is declare

    @Before
    public void setUp() {//launch a browser and open Url
        String baseUrl = "https://opensource-demo.orangehrmlive.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void verifyUserShouldLoginSuccessfully() {
        //driver.get("https://Admin:admin123@opensource-demo.orangehrmlive.com/");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        //verify the text
        String text1 = "Welcome Paul";
        String text2 = driver.findElement(By.xpath("//a[@id='welcome']")).getText();

        if (text1.equals(text2)) {
            System.out.println("Passed");
        } else {
            System.out.println("Fail");
        }
        driver.findElement(By.xpath("//div[@id='branding']/a[2]")).click();
        driver.findElement(By.linkText("Logout")).click();
        //verify the login panel message
        String expectedText = "LOGIN Panel";
        WebElement text = driver.findElement(By.xpath("//div[@id='logInPanelHeading']"));
        String actualText = text.getText();
        Assert.assertEquals("Login Panel message not displayed", expectedText, actualText);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
