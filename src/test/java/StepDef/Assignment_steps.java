package StepDef;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assignment_steps {
	WebDriver driver;
	Scenario scn;
	String Expected ="http://automationpractice.com/index.php";
	String BaseURL = "http://automationpractice.com";
	int Actualheight =99;
	int Actualwidth=350;
	String expName = "seleniumfrmwrk";
int count = 3;
	@Before
	public void setup(Scenario scn) {
		this.scn=scn;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@After
	public void teardown() {
		driver.quit();
	}

	@Given("Open URL")
	public void open_URL() {
		driver.get(BaseURL);
		scn.log("URL open Successfully");
	}

	@When("Get Expected URL and Validate")
	public void get_expected_url_and_validate() {
		String Actual=driver.getCurrentUrl();
		assertTrue(Actual.equalsIgnoreCase(Expected));
		scn.log("URL validate Successfully");
	}

	@Then("Get Title")
	public void get_title() {
		String name=driver.getTitle();
		scn.log("Title of the page :--"+name);
	}

	@When("Check Logo Display")
	public void check_logo_display() {
		WebElement logo =  driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		int Expectedheight = logo.getSize().getHeight();
		int Expectedwidth=logo.getSize().getWidth();
		
		assertEquals(Expectedheight,Actualheight);
		
		scn.log("Height is matched");
		assertEquals(Expectedwidth,Actualwidth );
		scn.log("width is matched");

	}

	@Then("validate Height and Width of Logo")
	public void validate_height_and_width_of_logo() {

		String  name = driver.getTitle();
		scn.log("the title is" +name );
	}
	
	@When("Validate Product Category")
	public void validate_product_category() {
	
		List<WebElement> productCateg =driver.findElements(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li"));
		int sizze =productCateg.size();
		assertEquals("count is 3", sizze, count);
	}

	@Then("Display categories")
	public void display_categories() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-shirt");
		Thread.sleep(4000);
		WebElement  suggestion = driver.findElement(By.xpath("/html/body/div[2]/ul/li"));
		String ss = suggestion.getText();
		assertTrue(ss.contains("T-shirt"));
		scn.log("suggestion contains 'T-shirt'");
	}

	@When("Validate while entering the T-Shirt in textbox")
	public void validate_while_entering_the_t_shirt_in_textbox() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-shirt");
		Thread.sleep(4000);
		WebElement  suggestion = driver.findElement(By.xpath("/html/body/div[2]/ul/li"));
		String ss = suggestion.getText();
		assertTrue(ss.contains("T-shirt"));
		scn.log("suggestion contains 'T-shirt'");
		}

	@When("User click on the footer link")
	public void user_click_on_the_footer_link() {
	   driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[2]")).click();
	   
	   
	   Set<String> handle = driver.getWindowHandles();
	   Iterator <String> itr = handle.iterator();
	  String ParentWindow =  itr.next();
	  String ChildWindow =  itr.next();
	  driver.switchTo().window(ChildWindow); 
	  scn.log("user successfully click on the footer link");
	}

	@Then("Validate the URL opened in new tab contains\"seleniumfrmwork\"")
	public void validate_the_url_opened_in_new_tab_contains_seleniumfrmwork() {
		String currentURL =driver.getCurrentUrl();
		assertTrue(currentURL.contains(expName));
		scn.log("in url 'seleniumfrmwork' is displayed ");
	   
	}
	@Then("Display Twitter account name as\"Selenium Framework\"")
	public void display_twitter_account_name_as_selenium_framework() {
	   WebElement twitterhandle = driver.findElement(By.xpath("//span//span//span[text()='Selenium Framework']"));
	  String Twittertext =  twitterhandle.getText();
	  assertTrue(Twittertext.contains("Selenium Framework"));
	  scn.log("Twitter account name is same as 'Selenium Framework'");
	  
	   
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
