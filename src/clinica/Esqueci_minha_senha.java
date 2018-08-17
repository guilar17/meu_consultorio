package clinica;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

import Mapa.Mapeamento;

@RunWith(JUnit4.class)
public class Esqueci_minha_senha extends Executa_clinica_chrome {
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	  public void setUp() throws Exception {
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@Test
	public void testEsqueciMinhaSenha() throws Exception {
		
		driver.manage().window().maximize();
		driver.get(Mapeamento.urlclinica);
		Thread.sleep(4000);
		driver.findElement(By.linkText("Dificuldade de acesso?")).click();
		Thread.sleep(500);
		driver.findElement(By.name("cpf")).clear();
		driver.findElement(By.name("cpf")).sendKeys("37363425604");
		Thread.sleep(500);
		driver.findElement(By.name("cpf")).clear();
		driver.findElement(By.name("cpf")).sendKeys("373.634.256-04");
		driver.findElement(By.xpath("//input[@value='Continuar > ']")).click();
		Thread.sleep(4000);
		assertEquals("daniel_assis@nefrodata.com.br", driver.findElement(By.cssSelector("b.ng-binding")).getText());
		driver.findElement(By.xpath("//button")).click();
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
