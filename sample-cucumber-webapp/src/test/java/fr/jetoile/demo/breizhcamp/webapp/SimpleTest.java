package fr.jetoile.demo.breizhcamp.webapp;

import fr.jetoile.demo.breizhcamp.webapp.page.HomePage;
import fr.jetoile.demo.breizhcamp.webapp.page.ResultPage;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

import java.io.File;

public class SimpleTest extends FluentTest {

    @Page
    HomePage homePage;
    @Page
    ResultPage resultPage;

    @Override
    public String getDefaultBaseUrl() {
        return "http://localhost:8080/sample-cucumber-webapp";
    }

    @Test
    public void homePage_exists() {
        goTo(homePage);
        homePage.isAt();
    }

    @Test
    public void default_add_should_return_3() {
        goTo(homePage);
        homePage.isAt();

        homePage.submit("form").await().untilPage();
        resultPage.isAt();

        assertThat(resultPage.getResult()).isEqualTo(3);
    }

    @Test
    public void add_one_and_four_should_return_5() {
        goTo(homePage);
        homePage.isAt();
        homePage.fill("#arg1").with("1");
        homePage.fill("#arg2").with("4");

        homePage.submit("form").await().untilPage();
        resultPage.isAt();

        assertThat(resultPage.getResult()).isEqualTo(5);
    }

    @Test
    public void add_one_and_four_should_return_5_with_impl2() {
        goTo(homePage);
        homePage.isAt();
        homePage.fill("#arg1").with("1");
        homePage.fill("#arg2").with("4");

        click("option", withText("calculatorImpl2"));

        homePage.submit("form").await().untilPage();
        resultPage.isAt();

        assertThat(resultPage.getResult()).isEqualTo(5);
    }

}
