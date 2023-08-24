package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedinPost {
    WebDriver driver;
    public LinkedinPost(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void post() throws InterruptedException{
         // Navigate to URL   https://in.linkedin.com/ 
        driver.get("https://in.linkedin.com/");
        //Enter username in username text field Using Locator "XPath" //input[@autocomplete='username'] | sendKeys("email")
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("email");
        //Enter password in password text field Using Locator "XPath" //input[@autocomplete='current-password'] | sendKeys("password")
        driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("password");
        //click on signin button Using Locator "XPath" //button[normalize-space()='Sign in']
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        Thread.sleep(3000);
        //Get number of profile views
        String profileviews = driver.findElement(By.xpath("(//li/a/div/div[2]/span/strong)[1]")).getText();
        System.out.println("Who viewed your profile " + profileviews);
        //Get the impressions count
        String impressions = driver.findElement(By.xpath("(//li/a/div/div[2]/span/strong)[2]")).getText();
        System.out.println("Impressions of post: " + impressions);
        //Click on Start a Post in home page Using Locator "XPath" //span[text()='Start a post']
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
        Thread.sleep(3000);
        //Click on Username Dropdown Using Locator "XPath" //span[@class='text-body-large-bold truncate']
        driver.findElement(By.xpath("//span[@class='text-body-large-bold truncate']")).click();
        Thread.sleep(3000);
        //Click on Select Connections-ONLY radio buttion Using Locator "XPath" (//span[@class='sharing-shared-generic-list__text-wrapper'])[2]
        driver.findElement(By.xpath("(//span[@class='sharing-shared-generic-list__text-wrapper'])[2]")).click();
        //Click on Done button Using Locator "XPath" //span[text()='Done']
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(3000);
        //Enter text in editor box Using Locator "XPath" //div[@data-placeholder='What do you want to talk about?'] | sendKeys("Hi all")
        driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']")).sendKeys("Hai all");
        // Click on Post button Using Locator "XPath" //span[text()='Post']
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(3000);
        //Validate the Post successful message Using Locator "XPath" //span[text()='Post successful.']
        boolean message = driver.findElement(By.xpath("//span[text()='Post successful.']")).isDisplayed();
        System.out.println("Message displayed: "+ message);
    }
}
