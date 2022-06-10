package week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html"); 
		
		//Click button to open home page in New Window
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windowHandles);
		System.out.println(driver.switchTo().window(windowsList.get(1)).getTitle());
		driver.switchTo().window(windowsList.get(0));
		
		//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println(windowHandles1.size());
		
		//Close all except this window
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windowsList2 = new ArrayList<String>(windowHandles2);
		windowsList2.remove(0);
		for(int i=0; i< windowsList2.size() ; i++)
		{
			System.out.println(driver.switchTo().window(windowsList2.get(i)).getTitle());
			driver.close();
		}
		
		
		driver.switchTo().window(windowsList.get(0));
		
		//Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
	}

}
