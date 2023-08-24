package demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class WindowHandling {
    WebDriver driver;
    public WindowHandling(){
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
    public void windows() throws InterruptedException, IOException{
//         Navigate to URL  https://www.w3schools.com/jsref/tryit.aspfilename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        WebElement frame = driver.findElement(By.xpath("//div[@id='iframe']/div/iframe"));
        driver.switchTo().frame(frame);
        String main = driver.getWindowHandle();
       // Click on Try it button Using Locator "XPath" //button[text()='Try it']
       driver.findElement(By.xpath("//button[text()='Try it']")).click();
      // List the windows in a list  getWindowHandles()
      Set<String> windows = driver.getWindowHandles();
     // Switch to new window   using Window handles
    // Get the URL of new window  using Window handles
    // Print the URL  getCurrenturl()
    // Get the Title of the window  getTitle()
    // Print the Title  
    for(String window1 : windows) {
        if(!window1.equalsIgnoreCase(main)) {
            driver.switchTo().window(window1);
        Thread.sleep(2000);
        System.out.println("Current url :"+driver.getCurrentUrl());
        System.out.println("Title of page is :"+driver.getTitle());
        }
    }
       // Take the Screenshot  TakeScreenshot()
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        AShot ashot = new AShot();
        Screenshot screenshot = ashot.takeScreenshot(driver);
        String filename = "Screenshot " + timeStamp + ".png";
        ImageIO.write(screenshot.getImage(), "PNG", new File(filename));
            System.out.println("Full page screenshot capture and saved at: " + filename);
      // Close the new window  close()
        driver.close();
      // Switch to parent window  switchTo().window(parent)
        driver.switchTo().window(main);
        Thread.sleep(3000);
    }
}
