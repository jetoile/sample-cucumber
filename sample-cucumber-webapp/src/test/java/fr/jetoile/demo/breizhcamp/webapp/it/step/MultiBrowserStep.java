package fr.jetoile.demo.breizhcamp.webapp.it.step;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.jetoile.demo.breizhcamp.Calculator;
import fr.jetoile.demo.breizhcamp.webapp.page.HomePage;
import fr.jetoile.demo.breizhcamp.webapp.page.ResultPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.cucumber.adapter.FluentCucumberAdapter;
import org.fluentlenium.cucumber.adapter.util.SharedDriver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withText;


public class MultiBrowserStep extends FluentCucumberAdapter {
    private BrowserInitialStep initialStep;

    @Page
    private HomePage homePage;

    @Page
    private ResultPage resultPage;

    private Calculator calculator;

    public MultiBrowserStep(BrowserInitialStep initialStep) {
        this.initialStep = initialStep;
    }

    @When("^I add (\\d+) and (\\d+) for multi$")
    public void I_add_and(int arg1, int arg2) throws Throwable {
        this.initFluentWithWebDriver(initialStep).withDefaultUrl("http://localhost:8080/sample-cucumber-webapp");
        this.initTest();

        homePage.fill("#arg1").with(Integer.toString(arg1));
        homePage.fill("#arg2").with(Integer.toString(arg2));
    }

    @Given("^an instance of (CalculatorImpl2|CalculatorImpl1) is used for multi$")
    public void an_instance_of_CaculatorController_is_used(String calculatorInstance) throws Throwable {
        this.initFluentWithWebDriver(initialStep).withDefaultUrl("http://localhost:8080/sample-cucumber-webapp");
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

    @Then("^I should obtain (\\d+) for multi$")
    public void I_should_obtain(int arg1) throws Throwable {
        this.initFluentWithWebDriver(initialStep).withDefaultUrl("http://localhost:8080/sample-cucumber-webapp");
        this.initTest();

        homePage.submit("form").await().untilPage(resultPage);
        resultPage.isAt();

        assertThat(resultPage.getResult()).isEqualTo(arg1);
    }

    @After
    public void tearDown() {
        this.quit();
    }
}
