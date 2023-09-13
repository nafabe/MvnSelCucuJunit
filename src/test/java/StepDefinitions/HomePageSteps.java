package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class HomePageSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Then("user should be able to verify account name on HRM Homepage")
    public void user_should_be_able_to_verify_account_name_on_HRM_Homepage() {
        String expectedUsername = "Welcome Yoll";
        String actualUsername = homePage.usernameHeader.getText();
        Assert.assertEquals("Username header verification failed!",
                expectedUsername, actualUsername);
    }

    @And("user verifies main tabs on HRM Homepage")
    public void userVerifiesMainTabsOnHRMHomepage(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);
        int i = 0;

        for(Map<String, String> map : maps){
            String expectedTabname = map.get("tabname");
            String actualTabname = homePage.allMainTabs.get(i).getText();
            Assert.assertEquals("Tabname verification failed!",
                    expectedTabname, actualTabname);
            i++;
            
        }

    }
    
}