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

import Banco_minha_conta.Apaga_conta;
import Mapa.Mapeamento;

@RunWith(JUnit4.class)
public class Cadastro_conta extends Executa_Minhaconta_chrome {

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCadastroConta() throws Exception {

		driver.manage().window().maximize();
		driver.get(Mapeamento.urlminhaconta);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Criar minha conta")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div[2]/ng-include/div/div/div/div/a[1]")).click();
		driver.findElement(By.xpath("html/body/ng-view/div/div/div[2]/ng-include/div/div/div/div/form/div[1]/input")).clear();
		driver.findElement(By.xpath("html/body/ng-view/div/div/div[2]/ng-include/div/div/div/div/form/div[1]/input")).sendKeys("01.057.278/0002-49");
		driver.findElement(By.xpath("html/body/ng-view/div/div/div[2]/ng-include/div/div/div/div/form/div[2]/input")).clear();
		driver.findElement(By.xpath("html/body/ng-view/div/div/div[2]/ng-include/div/div/div/div/form/div[2]/input")).sendKeys("455.722.164-53");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		assertEquals("CLIOMEL - CLINICA ODONTOMEDICA LTDA", driver.findElement(By.name("razaoSocial")).getAttribute("value"));
		assertEquals("CLIOMEL LABORATORIO", driver.findElement(By.name("nomeFantasia")).getAttribute("value"));
		driver.findElement(By.name("responsavel")).clear();
		driver.findElement(By.name("responsavel")).sendKeys("Automação");
		driver.findElement(By.name("telefone")).clear();
		driver.findElement(By.name("telefone")).sendKeys("(37) 999999999");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("daniel_assis@lifesys.com.br");
		driver.findElement(By.id("confirmacaoEmail")).clear();
		driver.findElement(By.id("confirmacaoEmail")).sendKeys("daniel_assis@lifesys.com.br");
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		Thread.sleep(1500);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div[2]/ng-include/div/div/div/div/form/div[11]/button")).click();
		Thread.sleep(1500);
		driver.findElement(By.name("senha")).clear();
		driver.findElement(By.name("senha")).sendKeys("1234567a");
		driver.findElement(By.id("confirmacao")).clear();
		driver.findElement(By.id("confirmacao")).sendKeys("1234567a");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		assertEquals("daniel_assis@lifesys.com.br", driver.findElement(By.cssSelector("strong.ng-binding")).getText());
		driver.findElement(By.linkText("Ok, entendi")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div[2]/div/div/div/ng-include/div/form/div[4]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div[2]/ng-include/div/div/div/div/a[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("razaoSocial")).clear();
		driver.findElement(By.name("razaoSocial")).sendKeys("Laboratorio Automação");
		driver.findElement(By.name("responsavel")).clear();
		driver.findElement(By.name("responsavel")).sendKeys("Daniel");
		driver.findElement(By.name("telefone")).clear();
		driver.findElement(By.name("telefone")).sendKeys("(37) 989899898");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("daniel_assis@lifesys.com.br");
		driver.findElement(By.id("confirmacaoEmail")).clear();
		driver.findElement(By.id("confirmacaoEmail")).sendKeys("daniel_assis@lifesys.com.br");
		driver.findElement(By.name("laudosDia")).clear();
		driver.findElement(By.name("laudosDia")).sendKeys("1500");
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1500);
		assertEquals("Seu pedido foi enviado com sucesso!", driver.findElement(By.cssSelector("h5")).getText());
		driver.findElement(By.linkText("Conhecer o site")).click();
		driver.findElement(By.cssSelector("i.fa.fa-chevron-left")).click();
		Thread.sleep(2000);

		//Apaga_conta apagaconta = new Apaga_conta();
		//apagaconta.testApaga_conta();

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
