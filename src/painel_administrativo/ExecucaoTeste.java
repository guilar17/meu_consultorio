package painel_administrativo;
import java.util.List;

import junits.foxTest;

import org.apache.xpath.operations.And;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

@RunWith(JUnit4.class)
public class ExecucaoTeste extends foxTest  {


	@Test
	public void TestePrincipal() throws InterruptedException{

		driver.manage().window().maximize();

		driver.get("http://192.168.1.69/appsLifesys/minhaConta/painelAdministrativo/#/login");
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

		
		
		
		//driver.findElement(By.id("//*[@id='datePicker']"));
		
	    
		driver.findElement(By.xpath("//*[contains(@name,'dataInicio')]")).click();
		
		
	    driver.findElement(By.xpath("/html/body/ng-view/div[2]/div/div/ng-include/div/div/div/div[3]/div/div/div/div/ng-include/div/div/div/div/div[2]/div[1]/form/div[1]/a/i")).click();
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
	    }
	    
	    
	    // .//table[@class='uib-monthpicker']/tbody/tr/td/button/span
	   
		
		//List<WebElement> Listfiltrofatura = driver.findElements(By.cssSelector("//*[@ng-model='ctrl.filtro.inicio']"));
		
		//Listfiltrofatura.get(0).sendKeys("01/2016");
		
		//List<WebElement> Listfiltrofatura = driver.findElements(By.xpath("//*[starts-with(@class, 'form-group col-xs-10')]/input"));
		//Listfiltrofatura.get(0).clear();
		//System.out.println(Listfiltrofatura.size());
		//Listfiltrofatura.get(0).sendKeys("01/2016");
		
		
		driver.findElement(By.xpath("//*[contains(@ng-class, 'inicio')]")).clear();
		driver.findElement(By.xpath("(//input[@id='datePicker'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@id='datePicker'])[2]")).sendKeys("06/2016");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		driver.findElement(By.xpath("//div[@id='1471007240486-2-uiGrid-00CG-cell']/div")).click();
		driver.findElement(By.xpath("//div[@id='1471007240486-3-uiGrid-00CE-cell']/div")).click();
		driver.findElement(By.xpath("//div[@id='1471007240486-4-uiGrid-00CE-cell']/div")).click();

		
	   

	}
	
}