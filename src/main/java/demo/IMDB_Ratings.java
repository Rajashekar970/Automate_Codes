package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDB_Ratings {
    WebDriver driver;
    public IMDB_Ratings(){
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
    public void moviename() throws InterruptedException{
//         Navigate to URL   https://www.imdb.com/chart/top
           driver.get("https://www.imdb.com/chart/top");
         // Locate the dropdown Using Locator "ID" "sort-by-selector"
         WebElement dropdown = driver.findElement(By.id("sort-by-selector"));
         // Create a Select class to select dropdown values  Select select = new Select()
         Select select = new Select(dropdown);
         // Select dropdown value by visible text  select.byVisibleText("IMDb rating")
         select.selectByVisibleText("IMDb rating");
         // Get the top rated movie and print it Using Locator "XPath" (//h3[@class='ipc-title__text'])[2] | getText()
         Thread.sleep(3000);
         WebElement highrated = driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]"));
         System.out.println("Top rated movie in list :"+highrated.getText());
        // List the movies included in table and store in a list Using Locator "XPath" //div[@class='sc-b28259b0-3 bFefGM ipc-page-grid__item ipc-page-grid__item--span-2']/ul/li
        List<WebElement> movielist = driver.findElements(By.xpath("//div[@class='sc-b28259b0-3 bFefGM ipc-page-grid__item ipc-page-grid__item--span-2']/ul/li"));
        // print the count of movies  //div[@class='sc-b28259b0-3 bFefGM ipc-page-grid__item ipc-page-grid__item--span-2']/ul/li
        System.out.println("Count of movies in list :"+movielist.size());
       // Select the Release by from dropdown select.byVisibleText("Release date")
       select.selectByVisibleText("Release date");
       // Click on sort by direction icon Using Locator "XPath" //button[@id='swap-sort-order-button']
       driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        Thread.sleep(3000);
      // Filter by Release date and Get the old movie from list Using Locator "XPath" //ul/li[1]/div[2]/div/div/div[1]
       WebElement oldmovie = driver.findElement(By.xpath("//ul/li[1]/div[2]/div/div/div[1]"));
      // Print the Old movie from list  getText()
      System.out.println("Old movie :"+oldmovie.getText());
     // Click on sort by direction icon Using Locator "XPath" //button[@id='swap-sort-order-button']
      driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
         Thread.sleep(3000);
     // Locate the most recent movie from list Using Locator "XPath" //ul/li[1]/div[2]/div/div/div[1]
      WebElement recentmovie = driver.findElement(By.xpath("//ul/li[1]/div[2]/div/div/div[1]"));
     // Get the most recent movie and print it  getText()
      System.out.println("Newly released movie :"+recentmovie.getText());
     // Select dropdown value "Number of ratings"by visible text   select.byVisibleText("Number of ratings")
     select.selectByVisibleText("Number of ratings");
         Thread.sleep(3000);
     // Locate the most user rating movie Using Locator "XPath" (//h3[@class='ipc-title__text'])[2]
     WebElement mostuserrating = driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]"));
    // Get the most user ratings movie and print it  getText()
    System.out.println("Most user ratings movie :"+mostuserrating.getText());
    }
}
