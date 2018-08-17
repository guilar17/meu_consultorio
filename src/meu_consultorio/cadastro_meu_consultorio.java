package meu_consultorio;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;

import Mapa.Mapeamento;

@RunWith(JUnit4.class)
public class cadastro_meu_consultorio extends executa_meu_consultorio {

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setup() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testCadastroMeuConsultorio() throws Exception{
		
		driver.manage().window().maximize();
		driver.get(Mapeamento.meu_consultorio);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Crie uma conta")).click();
		
		
		
	}

}
