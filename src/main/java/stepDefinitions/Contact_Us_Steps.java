package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {
    private WebDriver webDriver;

    @Before
    public void setUp(){
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe"
        );
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--incognito");
        webDriver=new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        webDriver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("Enter personal information")
    public void enter_personal_information() {
        webDriver.findElement(By.name("first_name"))
                .sendKeys("Yhors Brayan");
        webDriver.findElement(By.name("last_name"))
                .sendKeys("Prueba");
        webDriver.findElement(By.name("email"))
                .sendKeys("correo@correo.com");
    }

    @And("Enter a comment")
    public void enter_a_comment() {
        webDriver.findElement(By.name("message"))
                .sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean lobortis sed orci convallis maximus. Aenean sed sodales ligula, ac luctus risus. In erat ipsum, feugiat a malesuada a, ultricies et est. Fusce fringilla dui vel faucibus ultrices. Morbi nec pellentesque ipsum. Vivamus iaculis velit tellus, non faucibus nisi varius eget. Sed vel dictum massa. Duis tincidunt ante eu ultrices aliquam.");
    }

    @And("Click on the submit button")
    public void click_on_the_submit_button() {
        webDriver.findElement(By.cssSelector("[value=\"SUBMIT\"]"))
                .click();
    }

    @Then("Should be presented with a successful contact us submission message")
    public void should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contact_us_submission_message=webDriver.findElement(By.cssSelector("[id=\"contact_reply\"]>h1"));
        Assert.assertEquals(
                contact_us_submission_message.getText(),
                "Thank You for your Message!"
        );
    }
}
