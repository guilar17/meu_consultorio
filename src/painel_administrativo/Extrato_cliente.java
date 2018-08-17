package painel_administrativo;

import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import banco_clinica.connectionFactory_contas;
import Banco_minha_conta.Apaga_preferencia_contrato;
import Mapa.Mapeamento;
import painel_administrativo.Executa_painel_chrome;

@RunWith(JUnit4.class)
public class Extrato_cliente extends Executa_painel_chrome  {

	@Test
	public void TestePrincipal() throws Exception{

		driver.manage().window().maximize();

		driver.get(Mapeamento.urlpaineladmin);
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[1]/input")).clear();
		driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[1]/input")).sendKeys("user");
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[2]/input")).sendKeys("123456789");
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/ng-view/div[1]/div/div[2]/div/div/div/ng-include/div/form/div[3]/button")).click();
		Thread.sleep(6000);

		List<WebElement> Listgridclientes = driver.findElements(By.xpath("//*[starts-with(@class, 'ui-grid-filter-input ui-grid-filter-input-0')]"));
		Listgridclientes.get(0).sendKeys("01057278000249");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@id,'-0-uiGrid-0005')]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/div[2]/div/div/div[3]/table[1]/tbody/tr/td[1]/a/div[2]/span")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("html/body/ng-view/div[2]/div/div/ng-include/div/div/ng-include/div/div/div/div[2]/div[2]/div[1]/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='justificativa']")).sendKeys("Cancelamento de contrato teste");
		driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/button")).click();
		Thread.sleep(3000);
		
		Apaga_preferencia_contrato apagapreferencia = new Apaga_preferencia_contrato();
		apagapreferencia.testApaga_preferencia();


	}

}