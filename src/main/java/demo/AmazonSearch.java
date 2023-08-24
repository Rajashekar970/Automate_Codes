package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearch {
    WebDriver driver;
    public AmazonSearch(){
        WebDriverManager.chromedriver().setup();
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
    public  void amazonsearch() throws InterruptedException{
      //  Navigate to google home page  https://www.google.com/
      driver.get("https://www.google.com/");
//Enter text in google search text box Using Locator "XPath" //textarea[@type='search'] | sendKeys("amazon")
      driver.findElement(By.xpath("//textarea[@type='search']")).sendKeys("amazon");
//Click on google search button Using Locator "XPath" //input[@value='Google Search']
      driver.findElement(By.xpath("//input[@value='Google Search']")).click();
      Thread.sleep(3000);
//Validate "amazon.in" or amazon.com is displayed Using Locator "XPath" //span[text()='Amazon.in' or text()='Amazon.com']
      boolean result = driver.findElement(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']")).isDisplayed();
      System.out.println("Amazon.in is Displayed: "+result); 
    }
    
}
