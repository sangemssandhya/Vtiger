package mavenPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowserTest {
	WebDriver driver=null;
	String browser=System.getProperty("Browser");
	String url=System.getProperty("URL");

    @Test
	public void launchBrowser() throws InterruptedException {
		
	
	switch(browser)
	{
	case "chrome":
		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
	default:
		System.out.println("Invalid browser info");
		
	
	
	}
	driver.manage().window().maximize();
	driver.get(url);
	Thread.sleep(3000);
	driver.close();
	
}
}
