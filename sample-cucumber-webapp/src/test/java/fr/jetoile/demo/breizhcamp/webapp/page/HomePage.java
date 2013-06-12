package fr.jetoile.demo.breizhcamp.webapp.page;

import org.fluentlenium.core.FluentPage;

import static org.fest.assertions.Assertions.assertThat;

public class HomePage extends FluentPage {
    @Override
    public String getUrl() {
        return "/home";
    }

    @Override
    public void isAt() {
        assertThat(title()).containsIgnoringCase("home");
    }
}
