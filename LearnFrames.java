package week4.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver"); 
		
		//Fill Topic
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input")).sendKeys("Learning Frames");
		
		//select inner frame check box
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		
		//driver.switchTo().parentFrame();
		//driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		
		//choose Animals
		WebElement selectElement = driver.findElement(By.xpath("//select"));
		Select s=new Select(selectElement);
		s.selectByValue("babycat");
	}

}
