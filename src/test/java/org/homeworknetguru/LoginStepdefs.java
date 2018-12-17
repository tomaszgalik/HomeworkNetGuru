package org.homeworknetguru;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertNotNull;

public class LoginStepdefs {

    WebDriver driver;

    @Given("^I am on the main page https://trello.com/$")
    public void I_am_on_the_main_page_https_trello_com() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://trello.com");
    }

    @And("^I go to Login Page$")
    public void I_go_to_Login_Page() throws Throwable {
        driver.findElement(By.xpath("//a[@href ='/login?returnUrl=%2F']")).click();
    }


    @And("^I input correct email address$")
    public void I_input_correct_email_address() throws Throwable {

        driver.findElement(By.cssSelector(".hide-when-two-factor #user")).sendKeys("testytomka@gmail.com");

    }

    @And("^I input password$")
    public void I_input_password() throws Throwable {
        driver.findElement(By.cssSelector(".hide-when-two-factor #password")).sendKeys("homeworkng");
    }

    @When("^I click “Log in”$")
    public void I_click_Log_in() throws Throwable {
        driver.findElement(By.id("login")).click();
    }

    @Then("^I am logged in$")
    public void I_am_logged_in() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header-user")));
        assertNotNull(element);
    }

    @And("^I am on dashboard page$")
    public void I_am_on_dashboard_page() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-left-sidebar-container")));
        assertNotNull(element);
        driver.close();
    }

    @And("^I click “Sign up” button$")
    public void I_click_Sign_up_button() throws Throwable {
        driver.findElement(By.xpath("//a[@href ='/signup?returnUrl=%2F']")).click();           }

    @And("^I click “Sign in to your account”$")
    public void I_click_Sign_in_to_your_account() throws Throwable {
       driver.findElement(By.cssSelector(".sign-in-account a")).click();
    }


    @And("^I input incorrect password$")
    public void I_input_incorrect_password() throws Throwable {
        driver.findElement(By.cssSelector(".hide-when-two-factor #password")).sendKeys("1homeworkng");

    }

    @Then("^I get prompt message “Invalid password”$")
    public void I_get_prompt_message_Invalid_password() throws Throwable {
        WebElement error = driver.findElement(By.xpath("//p[contains(@class, 'error-message')]"));
        assertNotNull(error);
        driver.close();
    }

    @And("^I input incorrect email address$")
    public void I_input_incorrect_email_address() throws Throwable {
        driver.findElement(By.cssSelector(".hide-when-two-factor #user")).sendKeys("1testytomka@gmail.com");

    }

    @Then("^I get prompt message “There isn't an account for this email”$")
    public void I_get_prompt_message_There_isn_t_an_account_for_this_email() throws Throwable {
        WebElement error = driver.findElement(By.xpath("//p[contains(@class, 'error-message')]"));
        assertNotNull(error);
        driver.close();
    }
}
