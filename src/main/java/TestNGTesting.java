import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class TestNGTesting {

   // ChromeDriver driver;

    @Test(priority = 0)
    void OpenBrowser() throws MalformedURLException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VenD\\Desktop\\chromedriver.exe");
        System.setProperty( ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        DesiredCapabilities cap=DesiredCapabilities.chrome();
        cap.setPlatform( Platform.WINDOWS);
        URL url=new URL("http://localhost:4444/wd/hub");
        WebDriver driver=new RemoteWebDriver(url, cap);

     //   driver = new ChromeDriver();
        driver.get("https://test-tvs.dnow.com/login");
        driver.manage().window().maximize();


    }

    @Test(priority = 1,dependsOnMethods = {"OpenBrowser"})
    void Login() throws InterruptedException, MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VenD\\Desktop\\chromedriver.exe");
        System.setProperty( ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        DesiredCapabilities cap=DesiredCapabilities.chrome();
        cap.setPlatform( Platform.WINDOWS);
        URL url=new URL("http://localhost:4444/wd/hub");
        WebDriver driver=new RemoteWebDriver(url, cap);
        driver.get("https://test-tvs.dnow.com/login");
        driver.manage().window().maximize();


        WebElement element = driver.findElement( By.cssSelector( "#username" ));
        element.sendKeys( "sadmin" );
        WebElement pass = driver.findElement(By.cssSelector( "#password" ));
        pass.sendKeys( "Dnow!2345" );
        driver.findElement( By.tagName( "button" ) ).click();
        sleep( 20000 );
    }

    @Test(priority = 2,dependsOnMethods = {"Login"})
    void Successfull() throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VenD\\Desktop\\chromedriver.exe");
        System.setProperty( ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        DesiredCapabilities cap=DesiredCapabilities.chrome();
        cap.setPlatform( Platform.WINDOWS);
        URL url=new URL("http://localhost:4444/wd/hub");
        WebDriver driver=new RemoteWebDriver(url, cap);
        driver.get("https://test-tvs.dnow.com/login");
        driver.manage().window().maximize();

        Assert.assertEquals( "success",driver.findElement(By.xpath( "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]" )).getText() );

    }

    @Test(priority = 3)
    void Landing(){
        System.out.println("Preparing to land");
    }
    @Test(priority = 4)
    void EngineStop(){
        System.out.println("Engine Stops");
    }

    @Test(priority = 5,alwaysRun = true)
    void Ticketbooking(){
        System.out.println("Book tickets");
    }

}