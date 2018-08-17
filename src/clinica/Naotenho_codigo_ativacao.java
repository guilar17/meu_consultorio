package clinica;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.omg.CORBA.INITIALIZE;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

import banco_clinica.connectionFactory_contas;
import Mapa.Mapeamento;

@RunWith(JUnit4.class)
public class Naotenho_codigo_ativacao extends Executa_clinica_chrome {

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	connectionFactory_contas connection = new connectionFactory_contas();
	int id;
	
	@Before
	  public void setUp() throws Exception {
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@Test
	public void testNaotenhoCodigoAtivacao() throws Exception{
		
		driver.manage().window().maximize();
		driver.get(Mapeamento.urlclinica);
		Thread.sleep(4000);
		driver.findElement(By.linkText("Dificuldade de acesso?")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[1]/div[2]/label")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[2]/input")).sendKeys("37363425604");
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/form/div[4]/div[1]/input")).click();
		Thread.sleep(3000);
		assertEquals("daniel_assis@nefrodata.com.br", driver.findElement(By.cssSelector(".ng-binding")).getText());
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/ui-view/ui-view/div[2]/div/div/div/div/ui-view/div[2]/div[2]/button"));
		Thread.sleep(1000);
	
		//------------------------------REALIZA A ATIVAÇÃO DO PROFISSIONAL DIRETO NO BANCO----------------

				String query = "SELECT Id FROM lifesys_contas_homologacao_sprint8.conta_profissional WHERE conta_profissional.CPF='37363425604'";
				ResultSet rs = connection.busca(query);

				try {
					rs.next();
					if (rs.getRow() != 0) {		
						id = Integer.parseInt(rs.getString("Id"));

						String query1 = "UPDATE lifesys_contas_homologacao_sprint8.conta_profissional SET Situacao = 1 where id = "+ id;
						connection.executaQuery(query1);

					}
				}catch (Exception ex) {
					System.out.println("Sem conteudo");
				}
				//-----------------------------------------------------------------------------

				
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
