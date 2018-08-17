package painel_administrativo;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import painel_administrativo.Executa_painel_chrome;
import Mapa.Mapeamento;

@RunWith(JUnit4.class)
public class administrarcliente extends Executa_painel_chrome{
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAdministrarcliente() throws InterruptedException {

		/*driver.manage().window().maximize();
		driver.get(Mapeamento.urlpaineladmin);
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("user");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[@id='1470401304992-11-uiGrid-0005-cell']/div")).click();
		driver.findElement(By.linkText("Administrar cliente")).click();*/
		
		driver.manage().window().maximize();
		driver.get(Mapeamento.urlpaineladmin);
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[1]/input")).clear();
		driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[1]/input")).sendKeys("user");
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[2]/input")).sendKeys("123456789");
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[3]/button")).click();

		Thread.sleep(6000);


		//repetição para clicar no primeiro item da grid e ir descendo um a um
		/*
		 * driver.findElement(By.xpath("//*[contains(@id,'-0-uiGrid-0005')]/div")).click();
		 * 
		 * Actions action = new Actions(driver);

		for (int i=0; i<=26; i++)
		{
			Thread.sleep(500);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();

		}*/  

		//driver.findElement(By.xpath("//*[contains(@id,'div[1]/div/div[2]/div/div/input')]/div")).click();

		List<WebElement> Listgridclientes = driver.findElements(By.xpath("//*[starts-with(@class, 'ui-grid-filter-input ui-grid-filter-input-0')]"));
		//System.out.println(Listgridclientes.size());
		Listgridclientes.get(0).sendKeys("00380867000110");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@id,'-0-uiGrid-0005')]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/ng-view/div[2]/div/div/ng-include/div/div/div[2]/div/div/div[3]/a")).click();
		Thread.sleep(5000);
		
	    
		List<WebElement> Listdata = driver.findElements(By.xpath("//*[contains(@id,'datePicker')]"));
		//System.out.println(Listdata.size());
		Listdata.get(0).clear();
		Listdata.get(0).sendKeys("01/2016");
		Listdata.get(1).clear();
		Listdata.get(1).sendKeys("06/2016");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[2]/div[1]/form/div[3]/a")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		assertEquals("00.380.867/0001-10", driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[1]/form/div[1]/div")).getText());
		assertEquals("(NAO USAR) LAB MARCIO JARDIM", driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[1]/form/div[2]/div")).getText());
		assertEquals("(NAO USAR) LAB MARCIO JARDIM", driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[1]/form/div[3]/div")).getText());
		assertEquals("Daniel", driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[1]/form/div[4]/div")).getText());
		assertEquals("daniel_assis@nefrodata.com.br", driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[1]/form/div[5]/div")).getText());
		assertEquals("(12) 313456465", driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[1]/form/div[6]/div")).getText());
		assertEquals("MG", driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[1]/form/div[7]/div")).getText());
		assertEquals("BOM DESPACHO", driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[1]/form/div[8]/div")).getText());
		assertEquals("Renata", driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[2]/div/table/tbody/tr/td[2]/span")).getText());
		
		driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[2]/div[2]/div[6]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("31/10/2016");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='justificativa']")).sendKeys("qq7w9e87q89we798as4da4s6d4aqq7w9e87q89we798as4da4s6d4aqq7w9e87q89we798as4da4s6d4aqq7w9e87q89we798as4da4s6d4aqq7w9e87q89we798as4da4s6d4aqq7w9e87q89we798as4da4s6d4aqq7w9e87q89we798as4da4s6d4aqq7w9e87q89");
		driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/button")).click();
		Thread.sleep(5000);
	/*    driver.findElement(By.xpath("/html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[2]/div[1]/form/div[1]/a/i")).click();
	    List<WebElement> teste = driver.findElements(By.xpath("//table[@class='uib-monthpicker']/tbody/tr/td/button/span"));
	    
	    System.out.println(teste.size());
	    
	    int total_node=teste.size();
	    
	    for(int i=0; i<total_node; i++)
	    {
	    	String date=teste.get(i).getText();
	    	System.out.println(date);
	    	if(date.equalsIgnoreCase("janeiro"))
	    	{
	    		teste.get(i).click();
	    		break;
	    	}
	    }*/
	    
	    
	    // .//table[@class='uib-monthpicker']/tbody/tr/td/button/span
	   
		
		//List<WebElement> Listfiltrofatura = driver.findElements(By.cssSelector("//*[@ng-model='ctrl.filtro.inicio']"));
		
		//Listfiltrofatura.get(0).sendKeys("01/2016");
		
		//List<WebElement> Listfiltrofatura = driver.findElements(By.xpath("//*[starts-with(@class, 'form-group col-xs-10')]/input"));
		//Listfiltrofatura.get(0).clear();
		//System.out.println(Listfiltrofatura.size());
		//Listfiltrofatura.get(0).sendKeys("01/2016");
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
