package clinica;

import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

import Mapa.Mapeamento;

@RunWith(JUnit4.class)
public class cadastro_clinica extends Executa_clinica_chrome {

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCadastroClinica() throws Exception {

		driver.manage().window().maximize();
		driver.get(Mapeamento.urlclinica);
		Thread.sleep(4000);
		driver.findElement(By.linkText("cadastre-se")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[1]/div/div[1]/div/input[2]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[contains(@id,'-option-5')]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[1]/div/div[2]/div/input[2]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[contains(@id,'-option-10')]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.name("numeroConselho")).clear();
		Thread.sleep(500);
		driver.findElement(By.name("numeroConselho")).sendKeys("645431");
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[3]/div/input[2]")).sendKeys("cir");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[contains(@id,'-option-5')]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@value='Continuar >']")).click();
		Thread.sleep(500);
		driver.findElement(By.name("cpf")).clear();
		driver.findElement(By.name("cpf")).sendKeys("373.634.256-04");
		driver.findElement(By.name("nome")).clear();
		driver.findElement(By.name("nome")).sendKeys("Daniel");
		driver.findElement(By.name("email")).clear();
		Thread.sleep(500);
		driver.findElement(By.name("email")).sendKeys("daniel_assis@nefrodata.com.br");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@value='Continuar >']")).click();
		Thread.sleep(500);
		driver.findElement(By.name("senha")).clear();
		driver.findElement(By.name("senha")).sendKeys("1234567a");
		driver.findElement(By.name("confirmacaoSenha")).clear();
		driver.findElement(By.name("confirmacaoSenha")).sendKeys("1234567a");
		driver.findElement(By.xpath("//input[@value='Finalizar cadastro']")).click();
		Thread.sleep(2000);
		assertEquals("daniel_assis@nefrodata.com.br", driver.findElement(By.cssSelector("b.ng-binding")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button")).click();

		try {
			if(isElementPresent(By.xpath("html/body/div[1]/div/ul/li/div/span/span[contains(text(),'Servidor Offline')]")))
				fail("500 page displayed! Failing test, and quitting.");
		}

		catch (Exception e) {
		}

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
