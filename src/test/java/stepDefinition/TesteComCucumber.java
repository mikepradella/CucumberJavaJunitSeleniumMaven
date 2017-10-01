package stepDefinition;

import org.openqa.selenium.By;
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
		
	}

	@When("^eu entrar com \"([^\"]*)\" e valido \"([^\"]*)\"$")
	public void eu_entrar_com_e_valido(String arg1, String arg2) throws Throwable {
		 driver.findElement(By.id("email")).sendKeys("mike testando cucumber e selenium");
		 driver.findElement(By.id("pass")).sendKeys("mike cucumber java selenium");
		
	}

	@Then("^devera ser logado com sucesso$")
	public void devera_ser_logado_com_sucesso() throws Throwable {
	}


	

}
