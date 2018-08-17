package junits;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
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
	     driver.get("http://www.lifesys.com.br/relacionamento");	
	     //driver.findElement(By.xpath("//*[@id='menu57']")).click();
	     driver.findElement(By.id("cnpj")).sendKeys("aaaaa");
	     driver.findElement(By.id("senha")).sendKeys("111233");
	     driver.findElement(By.id("submit")).click();
	     try{
			element = driver.findElement (By.xpath(".//*[@id='divisoriaLogo']/a"));
	     }catch (Exception e){
			}
	     Assert.assertNotNull(element);
	     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
     }
	 
	 @Test
     public void valid_UserCredential(){

		 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	     driver.get("http://www.lifesys.com.br/relacionamento");	
	     //driver.findElement(By.xpath("//*[@id='menu57']")).click();
	     driver.findElement(By.id("cnpj")).sendKeys("1111");
	     driver.findElement(By.id("senha")).sendKeys("nefrod@t@");
	     driver.findElement(By.id("submit")).click();
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