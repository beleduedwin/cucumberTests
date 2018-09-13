package gradle.cucumber;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.bs.A;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class StepDefinitions {
    
	WebDriver driver;

	@Before
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.wikipedia.org");
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }

    // You can implement missing steps with the snippets below:

    @Given("I open wikipedia")
    public void i_open_wikipedia() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
    }

    @When("I search {string}")
    public void i_search(String string) {
        WebElement barreRecherche = driver.findElement(By.id("searchInput"));
        barreRecherche.sendKeys(string);
        barreRecherche.sendKeys(Keys.ENTER);
    }

    @Then("I should see {string} in the title")
    public void i_should_see_in_the_title(String string) {

	    //j'appel la methode WebElement, acces à driver puis findElement
	    WebElement title = driver.findElement(By.id("firstHeading"));

	    //
	    String result = title.getText();

	    //compare les resultat(result) et la variable(string) definie
        Assert.assertEquals(result, string);
    }


}
