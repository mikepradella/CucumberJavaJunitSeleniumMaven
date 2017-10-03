	package stepDefinition;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TesteComCucumber {
	WebDriver driver;
	
	
	@Given("^que abro o firefox/chrome e inicio a aplicacao$")
	public void que_abro_o_firefox_chrome_e_inicio_a_aplicacao() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:/Users/Inmetrics/Downloads/ambienteEclipseSelenium/chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		// captura a tela e salva na raiz do projeto , funciona corretamente
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String caminhoEvidencia = "C:/Users/Inmetrics/workspace/com.apreendendoAutomacao.cucumber/Evidencias";
		 
		//este comando salva na raiz - new File("my.jpg")
		FileUtils.copyFile(source,new File("C:/Users/Inmetrics/workspace/com.apreendendoAutomacao.cucumber/Evidencias/my.jpg"));
	}

	@When("^eu entrar com \"([^\"]*)\" e valido \"([^\"]*)\"$")
	public void eu_entrar_com_e_valido(String arg1, String arg2) throws Throwable {
		 driver.findElement(By.id("email")).sendKeys("mike testando cucumber e selenium");
		 driver.findElement(By.id("pass")).sendKeys("mike cucumber java selenium");
		 driver.findElement(By.cssSelector("#loginbutton")).click();
		
	}

	@Then("^devera ser logado com sucesso$")
	public void devera_ser_logado_com_sucesso() throws Throwable {
		// funciona corretamente
		//Assert.assertEquals(driver.findElement(By.xpath(".//span[text()='Entrar no Facebook']")).getText(), "Entrar no Facebook");
		// estou utilizando contains , funciona corretamenta
		Assert.assertTrue(driver.findElement(By.xpath(".//span[text()='Entrar no Facebook']")).getText().contains("Entrar no Facebook"));
	}


	

}
