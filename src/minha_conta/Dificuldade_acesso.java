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

import Mapa.Mapeamento;

@RunWith(JUnit4.class)
public class Dificuldade_acesso extends Executa_Minhaconta_chrome {

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testDificuldadeAcesso() throws Exception {

		driver.manage().window().maximize();
		driver.get(Mapeamento.urlminhaconta);
		driver.findElement(By.linkText("Dificuldade de acesso?")).click();
		driver.findElement(By.id("codigoAtivacao")).click();
		driver.findElement(By.xpath("//label[2]")).click();
		driver.findElement(By.xpath("//input[@type='tel']")).clear();
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("01.057.278/0002-49");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		assertEquals("daniel_assis@lifesys.com.br", driver.findElement(By.cssSelector("strong.ng-binding")).getText());
		driver.findElement(By.linkText("Ok, entendi")).click();
		driver.findElement(By.linkText("Dificuldade de acesso?")).click();
		driver.findElement(By.id("esqueciSenha")).click();
		driver.findElement(By.cssSelector("label")).click();
		driver.findElement(By.xpath("//input[@type='tel']")).clear();
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("01.057.278/0002-49");
		driver.findElement(By.xpath("html/body/ng-view/div/div/div[2]/div/div/div/ng-include/div/form/div[3]/button")).click();
		
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
