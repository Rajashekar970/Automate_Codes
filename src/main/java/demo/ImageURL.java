package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageURL {
        WebDriver driver;
        public ImageURL(){
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

        public void imgurl() throws InterruptedException{
//             Navigate to URL https://in.bookmyshow.com/explore/home/chennai  
               driver.get("https://in.bookmyshow.com/explore/home/chennai");
            // Get the image URLs of all Recommended movies and store it in a list Using Locator "XPath" //div/div/div[1]/div/div/div/div[2]/div/div/div/a/div/div[2]/div/img
            List<WebElement> imageurls =driver.findElements(By.xpath("//div/div/div[1]/div/div/div/div[2]/div/div/div/a/div/div[2]/div/img"));
            // Use for loop and print each image url  getAttribute("src")
            for(WebElement recommendurl : imageurls) {
                System.out.println(recommendurl.getAttribute("src"));
            }
            Thread.sleep(3000);
            try{
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,1300)", "");
            Thread.sleep(10000);
            //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
            //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div/div/div[5]/div/div/div/div[2]/div/div/div[2]/a/div/div[3]"))));
    
            // Print Movie Name of the 2nd item in the “Premiere” list Using Locator "XPath" //h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]/a/div/div[3]/div[1] | getText()
            WebElement premiermoviename = driver.findElement(By.xpath("//h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]/a/div/div[3]/div[1]"));
            System.out.println(premiermoviename.getText());
            // Print Language of the 2nd item in the “Premiere” list Using Locator "XPath" //div/div/div[5]/div/div/div/div[2]/div/div/div[2]/a/div/div[3]/div[2] | getText()
            WebElement premiermovielanguage = driver.findElement(By.xpath("//div/div/div[5]/div/div/div/div[2]/div/div/div[2]/a/div/div[3]/div[2]"));
		    System.out.println(premiermovielanguage.getText());
            }catch(Exception e){
                System.out.println("Ignore scrolling exception");
            }
         }
    }
