package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Load the URL https://www.amazon.in/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//search as oneplus 9 pro 
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus 9 pro");
		search.sendKeys(Keys.ENTER);
		
		//Get the price of the first product
		//Print the number of customer ratings for the first displayed product
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(price);
		System.out.println(driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText());
		
		//Click the first text link of the first image
		driver.findElement(By.linkText("Samsung Galaxy S22 Ultra 5G (Burgundy, 12GB, 512GB Storage) + Samsung Galaxy Watch4")).click();
		
		// Take a screen shot of the product displayed
		File source = driver.getScreenshotAs(OutputType.FILE);
		File amazon = new File("./amazon.png");
		FileUtils.copyFile(source, amazon);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		
		//Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		

		Thread.sleep(3000);
		
		// Get the cart subtotal and verify if it is correct.
		if( driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText().contains(price))
			System.out.println("Price is correct");
		
		
		//close the browser
		//driver.close();
	}

}
