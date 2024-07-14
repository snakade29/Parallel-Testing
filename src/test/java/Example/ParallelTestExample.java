package Example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ParallelTestExample {
	
	
	WebDriver driver;
	@Test
	public void Test1 () throws MalformedURLException
	{
		 
	ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--remote-allow-origins=*");
    chromeOptions.setCapability("browserVersion", "119.0");
    chromeOptions.setCapability("platformName", "linux");

    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
   
    driver.get("https://www.google.co.in/");
 	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("Performing Google search...");
	driver.quit();	
		
	}
	
	@Test
	public void Test2 () throws MalformedURLException
	{
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--remote-allow-origins=*");
		edgeOptions.setCapability("browserVersion", "119.0");
		edgeOptions.setCapability("platformName", "linux");

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), edgeOptions);

		driver.get("https://www.bing.com/");
		try {
		    Thread.sleep(10000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		System.out.println("Performing Bing search...");

		driver.quit();	
		
	}
	@Test
	public void Test3 () throws MalformedURLException
	{
		 
		try {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("browserVersion", "119.0");
            firefoxOptions.setCapability("platformName", "linux");

            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);

            driver.get("https://www.amazon.in/");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Performing Amazon search...");

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}

}
