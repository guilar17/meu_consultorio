package minha_conta;

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
import org.openqa.selenium.support.ui.Sleeper;

import painel_administrativo.Extrato_cliente;
import Mapa.Mapeamento;

@RunWith(JUnit4.class)
public class Contratar_plano extends Executa_Minhaconta_chrome{

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testContratarPlano() throws Exception {

		driver.manage().window().maximize();
		driver.get(Mapeamento.urlminhaconta);
		driver.findElement(By.xpath("//input[@type='tel']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("01.057.278/0002-49");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234567a");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[3]/div/div[2]/div/div")).click();
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("scroll(0,1200)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[2]/div[4]/div[1]/div/div[7]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[3]/form/div/div/a")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		assertEquals("Contratação realizada com sucesso!", driver.findElement(By.cssSelector("h1.success.text-center")).getText());
		((JavascriptExecutor)driver).executeScript("scroll(0,800)");
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div/div[3]/a")).click();
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[2]/form/ul/li[2]/div/select")).sendKeys("Enviados");
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[2]/form/button")).click();
		Thread.sleep(2000);

		//Envio de laudos alem da franquia
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[2]/div[2]/div/div/a")).click();
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("scroll(0,1200)");
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[3]/form/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		//Assinatura digital
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[2]/div[2]/div/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[3]/form/ul/li[1]/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[3]/form/div/input")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		//Alterar plano.
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[2]/div[2]/div/div[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[2]/div/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/div[3]/div/div")).click();
		Thread.sleep(1000);
		assertEquals("Plano Ilimitado", driver.findElement(By.xpath("//li[2]/div")).getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[2]/div/div")).click();
		Thread.sleep(1000);
		assertEquals("Plano Avançado", driver.findElement(By.xpath("//li[2]/div")).getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[2]/div[2]/div/div[2]/a")).click();
		Thread.sleep(2000);
		assertEquals("Plano Ilimitado", driver.findElement(By.xpath("//li[2]/div")).getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[3]/form/div/input")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
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
