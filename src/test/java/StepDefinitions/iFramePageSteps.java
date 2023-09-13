package StepDefinitions;

import Pages.iFramePage;
import Utilities.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class iFramePageSteps {
    WebDriver driver = DriverFactory.getDriver();
    iFramePage iFramePage = new iFramePage(driver);

    @Given("user navigates to iFrames Page")
    public void user_navigates_to_iFrames_Page() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("user enters a keyword into the text box on iFrames Page")
    public void user_enters_a_keyword_into_the_text_box_on_iFrames_Page() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(iFramePage.iFrameMenu);
        iFramePage.editorTextBox.clear();
        Thread.sleep(2000);
        iFramePage.editorTextBox.sendKeys("My Name is Nastia");
    }

    @Then("user should be able to verify entered text on iFrames Page")
    public void user_should_be_able_to_verify_entered_text_on_iFrames_Page() {

    }
}