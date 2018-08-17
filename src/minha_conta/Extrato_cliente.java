package minha_conta;

import org.apache.bcel.classfile.Utility;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Mapa.Mapeamento;

@RunWith(JUnit4.class)
public class Extrato_cliente extends Executa_Minhaconta_chrome {

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	ExtentReports report;
	ExtentTest logger;

	@Before
	public void setUp() throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void testExtratoCliente() throws Exception {
				
		driver.manage().window().maximize();
		driver.get(Mapeamento.urlminhaconta);
		driver.findElement(By.xpath("//input[@type='tel']")).clear();
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("01.057.278/0002-49");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.produto-dados")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("01/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("02/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("03/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("04/2016");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("05/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("06/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("07/2016");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("08/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("09/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("10/2016");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("11/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Informações do plano")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("01/2016");
		driver.findElement(By.cssSelector("a.datePickerLink")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("02/2016");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("03/2016");
		driver.findElement(By.cssSelector("i.fa.fa-calendar-o")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("04/2016");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("05/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("06/2016");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("07/2016");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("08/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("09/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("10/2016");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("11/2016");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("12/2016");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("12/2015");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("11/2015");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("10/2015");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("09/2015");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("08/2015");
		driver.findElement(By.cssSelector("i.fa.fa-refresh")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='datePicker']")).clear();
		driver.findElement(By.xpath(".//*[@id='datePicker']")).sendKeys("07/2015");
		driver.findElement(By.cssSelector("a.btn.btn-primaria")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[3]/div/div/ng-include/div[3]/div/div/div/ul/li[2]/a/strong/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/ng-view/div/div/div/div/div/ng-include/div/div/ng-include/div[3]/div/div/ng-include/div[3]/div/div/div/ul/li[2]/span/strong/a/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/ng-view/div/app-header/div[2]/div/nav-bar/nav/ul[1]/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/ng-view/div/app-header/div[2]/div/nav-bar/nav/ul[1]/li[1]/a")).click();
		Thread.sleep(2000);

	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			String screenshot_path = minha_conta.Utility.captureScreenshot(driver, result.getName());
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
