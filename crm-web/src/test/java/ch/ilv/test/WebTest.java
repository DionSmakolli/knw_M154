package ch.ilv.test;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTest {
	
	String name = "Banane";
	
	@Test
	public void testGoogle() {
        System.setProperty("webdriver.chrome.driver", "C:/Dev/Tools/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver=new ChromeDriver(options);
        
        driver.get("http://localhost:7070/products");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement productText = driver.findElement(By.name("description"));
		productText.sendKeys(name);
		
		warten();
		
		productText.submit();
		
		warten();
		
		WebElement productIdText = driver.findElement(By.name("id"));
		productIdText.sendKeys("0");
		
		warten();
		
		productIdText.submit();
		
		warten();
		
		List<WebElement> profile = driver.findElements(By.xpath("//span"));
		
		if(profile != null && profile.size() == 2) {
			Assert.assertEquals("Description: " + name, profile.get(1).getText());
		}
		
		driver.close();
	}
	
	public void warten() {
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
