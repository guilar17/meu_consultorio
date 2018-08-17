package painel_administrativo;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import painel_administrativo.administrarcliente;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	//administrarcliente.class,
	Extrato_cliente.class
})

public class Executa_painel_chrome {

	public static ChromeDriverService service;
	public static WebDriver driver;


	@BeforeClass
	public static void createAndStartService(){

		service = new ChromeDriverService.Builder()
		.usingDriverExecutable(new File("D:/Automação WEB/chromedriver.exe"))
		.usingAnyFreePort()
		.build();

		try {
			service.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void createDriver() {	
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
	}

	@AfterClass
	public static void createAndStopService() {
		try {
			Thread.sleep(8000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		service.stop();
	}

	@After
	public void quitDriver() {
		try {
			Thread.sleep(8000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		driver.quit();
	}

}