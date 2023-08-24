package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPrompt {
    WebDriver driver;
    public AlertPrompt(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void alerttext() throws InterruptedException{
        //Navigate to URL https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        Thread.sleep(3000);
        //Locate the frame and switchto the frame
        WebElement frame = driver.findElement(By.xpath("//div[@id='iframe']/div/iframe"));
        driver.switchTo().frame(frame);
        //Click on Try it button by Using Locator "XPath" //button[text()='Try it']
        driver.findElement(By.xpath("//button[@onClick='myFunction()']")).click();
        //Switch to alert and pass the value as your Name
        driver.switchTo().alert().sendKeys("Rajashekar");
        //Accept the alert
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        //Validate the value passed in alert is printed Using "XPath" //p[contains(text(),'Rajashekar')]
        boolean input = driver.findElement(By.xpath("//p[contains(text(),'Rajashekar')]")).isDisplayed();
        System.out.println("Given input is printed : "+input);
    }
}
