package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedInImagePost {
    WebDriver driver;
    public LinkedInImagePost(){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.manage().window().maximize();

    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    public void imagepost() throws InterruptedException{
        // Navigate to URL   https://in.linkedin.com/ 
        driver.get("https://in.linkedin.com/");
        //Enter username in username text field Using Locator "XPath" //input[@autocomplete='username'] | sendKeys("email")
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("email");
        //Enter password in password text field Using Locator "XPath" //input[@autocomplete='current-password'] | sendKeys("password")
        driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("password");
        //click on signin button Using Locator "XPath" //button[normalize-space()='Sign in']
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        Thread.sleep(3000);
        //Click on Start a Post in home page Using Locator "XPath" //span[text()='Start a post']
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
		Thread.sleep(3000);
        //Click on Username Dropdown Using Locator "XPath" //span[@class='text-body-large-bold truncate']
        driver.findElement(By.xpath("//span[@class='text-body-large-bold truncate']")).click();
        //Click on Select Connections-ONLY radio buttion Using Locator "XPath" (//span[@class='sharing-shared-generic-list__text-wrapper'])[2]
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='sharing-shared-generic-list__text-wrapper'])[2]")).click();
        //Click on Done button Using Locator "XPath" //span[text()='Done']
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(3000);
        //Enter text in editor box Using Locator "XPath" //div[@data-placeholder='What do you want to talk about?'] | sendKeys("Hi all")
        driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']")).sendKeys("Hai all");
        //Click on image icon to add photo Using Locator "XPath" //button[@aria-label='Add a photo']/span[@class='share-promoted-detour-button__icon-container']
		driver.findElement(By.xpath("//button[@aria-label='Add a photo']/span[@class='share-promoted-detour-button__icon-container']")).click();
		Thread.sleep(4000);
        //Locate the image destination Webelement Using Locator "XPath" //input[@name='file']  
		WebElement image = driver.findElement(By.xpath("//input[@name='file']")); 
				//driver.findElement(By.xpath("//label[@class='artdeco-button artdeco-button--tertiary']"));
        //Select the image from local machine and store the image path in a String  sendKeys("image path")      
		String imagepath = "C:\\Users\\shekar\\OneDrive\\Pictures\\Screenshots\\test.png";
		image.sendKeys(imagepath);
		Thread.sleep(3000);
        
		
       // Click on done button Using Locator "XPath" //span[text()='Done']

		driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(3000);
       // Click on Post button Using Locator "XPath" //span[text()='Post']
       driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(40000);
       //Validate the Post successful message Using Locator "XPath" //span[text()='Post successful.']
       boolean message = driver.findElement(By.xpath("//span[text()='Post successful.']")).isDisplayed();
       System.out.println("Message displayed for post successful: "+ message);
    } 
}
