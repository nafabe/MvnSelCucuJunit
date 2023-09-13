package StepDefinitions;

import Pages.ActionsPage;
import Pages.HomePage;
import Utilities.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ActionsSteps {
    WebDriver driver = DriverFactory.getDriver();
    ActionsPage actionsPage = new ActionsPage(driver);
    HomePage homePage = new HomePage(driver);

    @Then("user should be able to navigate to System Users page by doing hover over action")
    public void user_should_be_able_to_navigate_to_System_Users_page_by_doing_hover_over_action() {
        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.allMainTabs.get(0)).perform();
    }

    @Given("user navigates to Context Menu Page")
    public void user_navigates_to_Context_Menu_Page() throws InterruptedException {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        Thread.sleep(3000);
    }

    @Then("user should be able to handle context click on Context Menu Page")
    public void user_should_be_able_to_handle_context_click_on_Context_Menu_Page() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.contextClick(actionsPage.rightClickMeButton).perform();
        Thread.sleep(3000);
        //TODO Hint for HW: inspect and save all options as a List of WebElements
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Thread.sleep(3000);

        /* switch and handle the alert */
        Alert alert = driver.switchTo().alert();
        //TODO Hint for HW: retrieve expected values from Examples section of Scenario Outline
        String expectedAlertText = "clicked: edit";
        String actualAlertText = alert.getText();
        Assert.assertEquals("Alert Text verification failed!", expectedAlertText, actualAlertText);
        alert.accept();

    }

    @Given("user navigates Drag and Drop Page")
    public void user_navigates_Drag_and_Drop_Page() throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Thread.sleep(3000);
    }

    @Then("user should be able to perform drag and drop action on Drag and Drop Page")
    public void user_should_be_able_to_perform_drag_and_drop_action_on_Drag_and_Drop_Page() throws InterruptedException {
        Actions actions = new Actions(driver);
        //TODO Hint for HW: inspect and save all options as a List of WebElements
        WebElement source = driver.findElement(By.id("box3"));
        WebElement target = driver.findElement(By.id("box103"));
        actions.dragAndDrop(source, target).perform();
        Thread.sleep(3000);
        //TODO Hint for HW: retrieve expected values from Examples section of Scenario Outline
        String backgroundColorCode = source.getCssValue("background-color");
        System.out.println("Code color for Washington is: " + backgroundColorCode);
        Assert.assertTrue("Background color verification failed!", backgroundColorCode.contains("0, 255, 0"));
    }

    @Given("user navigates to Practice Page")
    public void user_navigates_to_Practice_Page() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");
        Thread.sleep(3000);
    }

    @Then("user should be able to perform double click action on Practice Page")
    public void user_should_be_able_to_perform_double_click_action_on_Practice_Page() throws InterruptedException {
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        WebElement copyTextButton = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        WebElement fieldTwo = driver.findElement(By.id("field2"));
        actions.doubleClick(copyTextButton).perform();
        Thread.sleep(2000);
        /* verify if the value from field 1 is copied to field 2 */
        String expectedData = "Hello World!";
//        String actualData = fieldTwo.getText();
        String actualData = (String) jse.executeScript("return arguments[0].value;", fieldTwo);

        Assert.assertEquals("Data verification failed!", expectedData, actualData);

    }

    @Given("user navigates to Key Presses Page")
    public void user_navigates_to_Key_Presses_Page() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/key_presses");
        Thread.sleep(3000);
    }

    @Then("user should be able to perform keyboard action on Key Presses Page")
    public void user_should_be_able_to_perform_keyboard_action_on_Key_Presses_Page() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        Thread.sleep(2000);
        /* verify if entered key is displayed */
        WebElement keyValue = driver.findElement(By.xpath("//p[contains(text(),'You entered:')]"));
        String expectedKeyValue = "You entered: BACK_SPACE";
        String actualKeyValue = keyValue.getText();
        Assert.assertEquals("Key value verification failed!", expectedKeyValue, actualKeyValue);
    }

}








