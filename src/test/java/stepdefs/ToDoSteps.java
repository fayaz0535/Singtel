package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobjects.HomePage;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

public class ToDoSteps {
    String driverPath = null;
    WebDriver driver;
    HomePage objHomePage;

    @Before
    public void setup() throws InterruptedException {
        driverPath = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", driverPath + "\\src\\test\\resources\\driverexe\\geckodriver.exe");
        FirefoxOptions browserOptions = new FirefoxOptions();
        driver = new FirefoxDriver(browserOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("I launch ToDo App")
    public void i_launch_to_do_app() {
        driver.get("http://todomvc.com/examples/vue/");
    }

    @When("^I Add TODO Item \"([^\"]*)\"$")
    public void i_add_todo_item(String todoItem) {
        objHomePage = new HomePage(driver);
        objHomePage.addToDo(todoItem);
    }

    @Then("^TODO Item \"(.*)\" should be displayed in the active TODO List")
    public void todo_item_should_be_displayed_in_the_todo_list(String todoItem) {
        Assert.assertTrue(objHomePage.isActiveToDo(todoItem));
    }

    @Then("^TODO Item \"(.*)\" should not be displayed in the TODO List")
    public void todo_item_should_not_be_displayed_in_the_todo_list(String todoItem) {
        Assert.assertFalse(objHomePage.isLabelExists(todoItem));
    }
    @When("^I Complete a TODO Item \"([^\"]*)\"$")
    public void i_complete_a_todo_item(String todoItem) {
        driver.findElement(By.xpath("//label[contains(text(),'" + todoItem +"')]//preceding-sibling::input")).click();
    }
    @Then("^TODO Item \"(.*)\" should be marked as completed in the TODO List")
    public void todo_item_should_be_marked_as_completed_in_the_todo_list(String todoItem) {
        Assert.assertTrue(objHomePage.isCompletedToDo(todoItem));
    }

    @Then("^TODO Item \"(.*)\" should be cleared from the TODO List")
    public void todo_item_should_be_cleared_from_the_todo_list(String todoItem) {
        Assert.assertFalse(objHomePage.isLabelExists(todoItem));
    }
    @Then("^the count of ToDo Items left should be displayed \"([^\"]*)\"$")
    public void the_count_of_to_do_items_left_should_be_displayed(String todoLeftCount) {
        Assert.assertTrue(objHomePage.todoCount(todoLeftCount));
    }

    @When("^I Click on ToDo Filter \"([^\"]*)\"$")
    public void i_click_on_todo_filter(String todoFilter) {

        switch(todoFilter)
        {
            case "All":
                        objHomePage.clickLinkAll();
                        break;
            case "Active":
                        objHomePage.clickLinkActive();
                        break;
            case "Completed":
                        objHomePage.clickLinkCompleted();
                        break;
            case "Clear Completed":
                        objHomePage.clickButtonClearCompleted();
                        break;
        }
    }

    @After
    public void teardown(Scenario scenario) {

        if(scenario.isFailed())
        {
            Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        // Close the browser
        driver.close();
    }

}