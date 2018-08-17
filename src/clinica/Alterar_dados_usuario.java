package clinica;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import banco_clinica.connectionFactory_contas;
import Mapa.Mapeamento;



@RunWith(JUnit4.class)
public class Alterar_dados_usuario extends Executa_clinica_chrome {

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	connectionFactory_contas connection = new connectionFactory_contas();

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAlterarDadosUsuario() throws Exception {

		driver.manage().window().maximize();
		driver.get(Mapeamento.urlclinica);
		Thread.sleep(5000);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("37363425604");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("37363425604");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("1234567a");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Entrar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/button")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div[2]/div/div/div/div/ui-view/div[2]/form/div[3]/div/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[2]/div/div[1]/div/input[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Quarta-feira")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("horario")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("horario")).sendKeys("07:00");
		Thread.sleep(3000);
		driver.findElement(By.name("telefoneContato")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("telefoneContato")).sendKeys("(37) 989999999");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Me ligue']")).click();
		Thread.sleep(4000);
		assertEquals("Quarta-feira", driver.findElement(By.cssSelector("span.ng-binding")).getText());
		assertEquals("07:00", driver.findElement(By.xpath("//span[2]")).getText());
		assertEquals("(37) 98999-9999", driver.findElement(By.xpath("//span[3]")).getText());
		Thread.sleep(3000);

		driver.findElement(By.xpath("html/body/ui-view/div[1]/navbar/nav/a[2]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Alterar meus dados")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("nome")).click();
		driver.findElement(By.name("nome")).clear();
		driver.findElement(By.name("nome")).sendKeys("Daniel 1");
		driver.findElement(By.name("dataNascimento")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("dataNascimento")).sendKeys("02/02/1992");
		Thread.sleep(500);
		new Select(driver.findElement(By.name("sexo"))).selectByVisibleText("Sexo");
		Thread.sleep(3000);
		new Select(driver.findElement(By.name("sexo"))).selectByVisibleText("Feminino");
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[2]/div[1]/div/div/form/div[4]/div/div[1]/div/input[2]")).clear();
		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[2]/div[1]/div/div/form/div[4]/div/div[1]/div/input[2]")).sendKeys("MG");
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[2]/div[1]/div/div/form/div[4]/div/div[1]/div/input[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[2]/div[1]/div/div/form/div[4]/div/div[2]/div/input[2]")).clear();
		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[2]/div[1]/div/div/form/div[4]/div/div[2]/div/input[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[2]/div[1]/div/div/form/div[4]/div/div[2]/div/input[2]")).sendKeys("divinó");
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[2]/div[1]/div/div/form/div[4]/div/div[2]/div/input[2]")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[2]/div[1]/div/div/form/div[6]/div/input[2]")).clear(); 
		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[2]/div[1]/div/div/form/div[6]/div/input[2]")).sendKeys("Médico cirurgião da mão");
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/ui-view/div/div/div[2]/div[1]/div/div/form/div[6]/div/input[2]")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		driver.findElement(By.name("telefone")).clear();
		driver.findElement(By.name("telefone")).sendKeys("(37) 879846464");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("guilar.17@gmail.com");
		driver.findElement(By.name("telefone")).clear();
		driver.findElement(By.name("telefone")).sendKeys("(37) 111111111");
		driver.findElement(By.name("telefone")).clear();
		driver.findElement(By.name("telefone")).sendKeys("(37) 111111111");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Alterar']")).click();


		Thread.sleep(3000);
		//---------------------------------------------------------ALTERAR SENHA-----------------------------------------
		driver.findElement(By.linkText("Alterar minha senha")).click();
		driver.findElement(By.name("senhaAtual")).clear();
		driver.findElement(By.name("senhaAtual")).sendKeys("1234567a");
		driver.findElement(By.name("novaSenha")).clear();
		driver.findElement(By.name("novaSenha")).sendKeys("1234567b");
		driver.findElement(By.name("confirmacaoSenha")).clear();
		driver.findElement(By.name("confirmacaoSenha")).sendKeys("1234567b");
		driver.findElement(By.xpath("//input[@value='Alterar']")).click();
		Thread.sleep(3000);

		try {
			if(isElementPresent(By.xpath("html/body/div[1]/div/ul/li/div/span/span[contains(text(),'Servidor Offline')]")))
				fail("500 page displayed! Failing test, and quitting.");
		}

		catch (Exception e) {
		}

		//-----------------------------------------------------VOLTA A SENHA ORIGINAL---------------------------------------


		String query2 = "UPDATE `lifesys_contas_homologacao_sprint8`.`conta_profissional` SET `Senha`='FE008700F25CB28940CA8ED91B23B354' WHERE `CPF`='37363425604';";
		connection.executaQuery(query2);

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
