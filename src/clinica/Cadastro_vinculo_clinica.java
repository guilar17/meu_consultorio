package clinica;

import java.sql.ResultSet;
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

import banco_clinica.Apaga_cadastro_profissional;
import banco_clinica.Apaga_clinica;
import banco_clinica.Apaga_vinculo_profissional;
import Mapa.Mapeamento;

@RunWith(JUnit4.class)
public class Cadastro_vinculo_clinica extends Executa_clinica_chrome{

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCadastroVinculoClinica() throws Exception {

		driver.manage().window().maximize();
		driver.get(Mapeamento.urlclinica);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("37363425604");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("37363425604");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("1234567b");
		driver.findElement(By.xpath("//input[@value='Entrar']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/div[1]/navbar/nav/a[2]/span")).click();
		Thread.sleep(3000);


		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[4]/div/div/h4/button")).click();
		driver.findElement(By.name("identificacao")).clear();
		driver.findElement(By.name("identificacao")).sendKeys("00380867000110");
		driver.findElement(By.xpath("//input[@value='Continuar >']")).click();
		Thread.sleep(3000);
		assertEquals("(Nao usar) Lab Marcio Jardim", driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/div[2]/form/div[1]/p[1]/b[1]")).getText());
		assertEquals("Daniel Assis", driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/div[2]/form/div[1]/p[1]/b[2]")).getText());
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/div[2]/form/div[3]/div[1]/button")).click();
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/div[2]/div[2]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/div[1]/navbar/nav/a[2]/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[4]/div/div/h4/button")).click();

		Apaga_vinculo_profissional apagavinculoprofissional = new Apaga_vinculo_profissional();
		apagavinculoprofissional.testApaga_vinculo_profissional();

		driver.findElement(By.name("identificacao")).clear();
		driver.findElement(By.name("identificacao")).sendKeys("10209323000143");
		driver.findElement(By.xpath("//input[@value='Continuar >']")).click();
		driver.findElement(By.name("nomeFantasia")).clear();
		driver.findElement(By.name("nomeFantasia")).sendKeys("Clinica Automacao");
		driver.findElement(By.name("telefone")).clear();
		driver.findElement(By.name("telefone")).sendKeys("(37) 999995555");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("daniel_assis@nefrodata.com.br");
		driver.findElement(By.name("razaoSocial")).clear();
		driver.findElement(By.name("razaoSocial")).sendKeys("Clinica Automacao");
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[6]/div/div[1]/div/input[2]")).click();
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[6]/div/div[1]/div/input[2]")).sendKeys("MG");
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[6]/div/div[1]/div/input[2]")).sendKeys(Keys.ENTER);


		Thread.sleep(200);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[6]/div/div[2]/div/input[2]")).click();
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[6]/div/div[2]/div/input[2]")).sendKeys("divinó");
		Thread.sleep(200);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[6]/div/div[2]/div/input[2]")).sendKeys(Keys.ENTER);		
		driver.findElement(By.xpath("//input[@value='Continuar >']")).click();
		Thread.sleep(500);

		try {
			if(isElementPresent(By.xpath("html/body/div[1]/div/ul/li/div/span/span[contains(text(),'Servidor Offline')]")))
				fail("500 page displayed! Failing test, and quitting.");
		}

		catch (Exception e) {
		}
		apagavinculoprofissional.testApaga_vinculo_profissional();

		Apaga_clinica apagaclinica = new Apaga_clinica();
		apagaclinica.testApaga_clinica();

		//------------------------------------------------------APAGA O PROFISSIONAL-------------------------------------

		Apaga_cadastro_profissional apagaprofissional = new Apaga_cadastro_profissional();
		apagaprofissional.testApaga_cadastro_profissional();
		
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
