package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//Click on Widget of From Contact		
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a//img[@src='/images/fieldlookup.gif']")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> listhandles = new ArrayList<String>(handles);
		System.out.println(listhandles.size());
		
		for (int i = 0; i < listhandles.size(); i++) {
			driver.switchTo().window(listhandles.get(i));
			System.out.println(driver.getTitle());
	
		}
		
		//Click on First Resulting Contact
	 	driver.switchTo().window(listhandles.get(1));
	 	driver.findElement(By.xpath("//a[@class='linktext']")).click();
	 	
	 	// Click on Widget of To Contact
	 	driver.switchTo().window(listhandles.get(0));
	 	driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a//img[@src='/images/fieldlookup.gif']")).click();
		
		Set<String> handles1 = driver.getWindowHandles();
	 	List<String> listhandles1 = new ArrayList<String>(handles1);
		System.out.println(listhandles1.size());
		
		for (int i = 0; i < listhandles1.size(); i++) {
			driver.switchTo().window(listhandles1.get(i));
		//	System.out.println(driver.getTitle());
	
		}
		// Click on Second Resulting Contact
	 	Thread.sleep(3000);
	 	driver.switchTo().window(listhandles1.get(1));
	 	driver.findElement(By.xpath("//div[@class='x-grid3-row    x-grid3-row-alt']//table[@class='x-grid3-row-table']//tr//a")).click();
	 	driver.switchTo().window(listhandles1.get(0));
	 	
	 	//Click on Merge button using Xpath Locator
	 	driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	 	
	 	//Accept the Alert
	 	Alert alert = driver.switchTo().alert();
	 	alert.accept();
	 	
	 	//Verify the title of the page
	 	System.out.println(driver.getTitle());
	}

}
