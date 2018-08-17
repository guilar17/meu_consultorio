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
public class Login_dados_conta extends Executa_Minhaconta_chrome { 
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testLoginDadosConta() throws Exception {
		driver.manage().window().maximize();
		driver.get(Mapeamento.urlminhaconta);
		driver.findElement(By.xpath("//input[@type='tel']")).clear();
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("01.057.278/0002-49");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.linkText("Dados da conta")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("CLIOMEL - CLINICA ODONTOMEDICA LTDA 1");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("CLIOMEL LABORATORIO 1");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Automação 1");
		driver.findElement(By.xpath("//input[@type='email']")).clear();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("daniel_assis1@lifesys.com.br");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("(37) 888888888");
		driver.findElement(By.cssSelector("button.btn.btn-primaria")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("i.fa.fa-pencil")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("CLIOMEL - CLINICA ODONTOMEDICA LTDA");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("CLIOMEL LABORATORIO");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Automação");
		driver.findElement(By.xpath("//input[@type='email']")).clear();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("daniel_assis@lifesys.com.br");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("(37) 999999999");
		driver.findElement(By.cssSelector("button.btn.btn-primaria")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Alterar senha")).click();
		driver.findElement(By.name("senhaAtual")).clear();
		driver.findElement(By.name("senhaAtual")).sendKeys("1234567a");
		driver.findElement(By.name("senha")).clear();
		driver.findElement(By.name("senha")).sendKeys("1234567b");
		driver.findElement(By.id("confirmacao")).clear();
		driver.findElement(By.id("confirmacao")).sendKeys("1234567b");
		driver.findElement(By.cssSelector("button.btn.btn-primaria")).click();
		Thread.sleep(1500);
		driver.findElement(By.linkText("Alterar senha")).click();
		driver.findElement(By.name("senhaAtual")).clear();
		driver.findElement(By.name("senhaAtual")).sendKeys("1234567b");
		driver.findElement(By.name("senha")).clear();
		driver.findElement(By.name("senha")).sendKeys("1234567a");
		driver.findElement(By.id("confirmacao")).clear();
		driver.findElement(By.id("confirmacao")).sendKeys("1234567a");
		driver.findElement(By.cssSelector("button.btn.btn-primaria")).click();
		Thread.sleep(1500);
		driver.findElement(By.linkText("Produtos e serviços")).click();
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
