package junits;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testpaineldmin {
	 	private static FirefoxDriver driver;
	 	WebElement element;
	 	
	 	@BeforeClass
	     public static void openBrowser(){
	         driver = new FirefoxDriver();
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
	 		 
	 @Test
     public void inValid_UserCredential()
     {
		 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	     driver.get("http://192.168.1.69/appsLifesys/minhaConta/painelAdministrativo/#/login");
	     //driver.findElement(By.xpath("//*[@id='menu57']")).click();
	     driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[1]/input")).sendKeys("user");
	     driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[2]/input")).sendKeys("123456");
	     driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[3]/button")).click();
	     try{
			element = driver.findElement (By.xpath(".//*[@id='divisoriaLogo']/a"));
	     }catch (Exception e){
			}
	     Assert.assertNotNull(element);
	     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
     }

	 @AfterClass
	 public static void closeBrowser(){
		 driver.quit();
	 }
}