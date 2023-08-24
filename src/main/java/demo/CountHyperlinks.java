package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountHyperlinks {
    WebDriver driver;
    public CountHyperlinks(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest(){
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
    public void hyperlinks() throws InterruptedException{
      //  Navigate to URL   https://in.bookmyshow.com/explore/home/chennai
      driver.get("https://in.bookmyshow.com/explore/home/chennai");
      Thread.sleep(3000);
//List all the hyperlinks in the bookmyshow page and store it in a list Using Locator "Tag Name" a
      List<WebElement> list = driver.findElements(By.tagName("a"));
//Print the count of hyperlinks  list.size()
      System.out.println("Count of hyperlinks is " + list.size());

    }
    
}
