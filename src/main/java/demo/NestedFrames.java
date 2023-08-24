package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {
    WebDriver driver;
    public NestedFrames(){
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

    public void frames(){
       // Navigate to URL   https://the-internet.herokuapp.com/nested_frames
       driver.get("https://the-internet.herokuapp.com/nested_frames");
       //Switch to Top frame  switchTo().frame("frame-top")
       driver.switchTo().frame("frame-top");
        //Switch to Left frame within the top frame  switchTo().frame("frame-left")
       driver.switchTo().frame("frame-left");
    //Print the text of the Left frame Using Locator "Tag Name" body | getText()
       WebElement left = driver.findElement(By.tagName("body"));
       System.out.println("Frame text is: "+ left.getText());
     //Switch back to parent frame  switchTo().parentframe()
       driver.switchTo().parentFrame();
    //Switch to middle frame within the top frame  switchTo().frame("frame-middle")
       driver.switchTo().frame("frame-middle");
     //Print the text of the middle frame Using Locator "Tag Name" body | getText()
     WebElement middle = driver.findElement(By.tagName("body"));
     System.out.println("Frame text is: "+ middle.getText());
     //Switch back to parent frame   switchTo().parentframe()
     driver.switchTo().parentFrame();
     //Switch to right frame within the top frame  switchTo().frame("frame-right")
     driver.switchTo().frame("frame-right");
      //Get the text of the right frame Using Locator "Tag Name" body | getText()
      WebElement right = driver.findElement(By.tagName("body"));
      //Print the text of the right frame  
     System.out.println("Frame text is: "+ right.getText());
      //Switch to DefaultContent  switchTo().defaultContent()
      driver.switchTo().defaultContent();
      //Switch to Bottom frame  switchTo().frame("frame-bottom")
      driver.switchTo().frame("frame-bottom");
      //Get the text of the bottom frame Using Locator "Tag Name" body
      WebElement bottom = driver.findElement(By.tagName("body"));
      //Print the text of the bottom frame  getText()
      System.out.println("Frame text is: "+ bottom.getText());
    }
}
