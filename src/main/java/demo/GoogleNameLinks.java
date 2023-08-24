package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleNameLinks {
    WebDriver driver;
    public GoogleNameLinks(){
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void endTest(){
        System.out.println("End Test : TestCases");
        driver.close();
        driver.quit();
    }

    public void namelinks() throws InterruptedException{
       // Navigate to URL https://google.com/ 
       driver.get("https://google.com/");
       //Enter the text in Google search text area  Using Locator "XPath" //textarea[@type='search'] | Rajashekar
       driver.findElement(By.xpath("//textarea[@type='search']")).sendKeys("Rajashekar");
       //click on Google search button  Using Locator "XPath" //input[@value='Google Search']
       driver.findElement(By.xpath("//input[@value='Google Search']")).click();
       Thread.sleep(3000);
       //Get all the name links matching to given search and store it in a list Using Locator "XPath" //a[contains(text(),'Rajashekar')]
       List<WebElement> list=driver.findElements(By.xpath("//a[contains(text(),'Rajashekar')]"));
       //Print the count of links  list.size()
       System.out.println("Count of matching name links :"+list.size());
    }
}
