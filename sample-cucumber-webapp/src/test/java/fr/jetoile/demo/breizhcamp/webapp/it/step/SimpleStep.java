package fr.jetoile.demo.breizhcamp.webapp.it.step;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.jetoile.demo.breizhcamp.Calculator;
import fr.jetoile.demo.breizhcamp.CalculatorImpl1;
import fr.jetoile.demo.breizhcamp.CalculatorImpl2;
import fr.jetoile.demo.breizhcamp.webapp.page.HomePage;
import fr.jetoile.demo.breizhcamp.webapp.page.ResultPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.cucumber.adapter.FluentCucumberTest;
import org.fluentlenium.cucumber.adapter.util.SharedDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withText;


@SharedDriver(type = SharedDriver.SharedType.PER_SCENARIO)
public class SimpleStep extends FluentCucumberTest {

    @Page
    private HomePage homePage;

    @Page
    private ResultPage resultPage;

    private Calculator calculator;

    @Override
    public String getDefaultBaseUrl() {
        return "http://localhost:8080/sample-cucumber-webapp";
    }

//    @Override
//    public WebDriver getDefaultDriver() {
//        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
//        return new ChromeDriver();
//    }

    @Given("^an instance of (CalculatorImpl2|CalculatorImpl1) is used$")
    public void an_instance_of_CaculatorController_is_used(String calculatorInstance) throws Throwable {
        this.initFluent();
        this.initTest();

        goTo(homePage);
        homePage.isAt();

        switch (calculatorInstance) {
            case "CalculatorImpl1" :
                click("option", withText("calculatorImpl2"));
                break;
            case "CalculatorImpl2" :
                click("option", withText("calculatorImpl2"));
                break;
        }
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void I_add_and(int arg1, int arg2) throws Throwable {
        this.initFluent();
        this.initTest();

        fill("#arg1").with(Integer.toString(arg1));
        fill("#arg2").with(Integer.toString(arg2));
    }


    @Then("^I should obtain (\\d+)$")
    public void I_should_obtain(int arg1) throws Throwable {
        this.initFluent();
        this.initTest();

        submit("form").await().untilPage();
        resultPage.isAt();

        assertThat(resultPage.getResult()).isEqualTo(arg1);
    }

    @After
    public void tearDown() {
        this.quit();
    }
}
