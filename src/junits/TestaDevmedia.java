package junits;
// Importa as bibliotecas do JUnit, Selenium WebDriver, List etc.
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

// Classe JUnit que cont�m os m�todos de teste.
public class TestaDevmedia { 

	// Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver. 
	private static WebDriver driver;

	// M�todo que inicia tudo que for necess�rio para o teste 
	// Cria uma inst�ncia do navegador e abre a p�gina inicial da DevMedia. 
	@BeforeClass 
	public static void setUpTest(){
		driver = new FirefoxDriver();
		driver.get("http://www.devmedia.com.br");
	}

	// M�todo que finaliza o teste, fechando a inst�ncia do WebDriver. 
	@AfterClass 
	public static void tearDownTest(){ 
		driver.quit(); 
	} 

	// Testa t�tulo "DevMedia - Cursos, Tutoriais e V�deos para Desenvolvedores". 
	@Test 
	public void testaTituloDaPagina(){ 
		assertEquals("DevMedia - Cursos, Tutoriais e V�deos para Desenvolvedores", driver.getTitle()); 
	} 

	// M�todo que testa o login no site DevMedia. 
	@Test 
	public void testaLoginDevMedia() { 

		// Instancia um novo objeto do tipo "WebElement", e passa como par�metro 
		// um elemento da tela cujo valor do atributo "name" seja igual a "usuario".
		WebElement element = driver.findElement(By.name("usuario")); 

		// Insere dados no elemento "usuario". 
		element.sendKeys("user@devmedia.com.br"); 

		// Atribui ao objeto �element� o elemento de atributo "name" igual a "senha". 
		element = driver.findElement(By.name("senha")); 

		// Insere dados no elemento "senha". 
		element.sendKeys("123456"); 

		// Clica no bot�o "OK" e submete os dados para concluir o login. 
		driver.findElement(By.id("imglogar")).click(); 
	} 

}
/*
Leia mais em: Introdu��o aos Testes Funcionais Automatizados com JUnit e Selenium WebDriver 
http://www.devmedia.com.br/introducao-aos-testes-funcionais-automatizados-com-junit-e-selenium-webdriver/28037#ixzz3U71xrEfD*/