package fr.jetoile.demo.breizhcamp.webapp.page;

import org.fluentlenium.core.FluentPage;

import static org.fest.assertions.Assertions.assertThat;

public class ResultPage extends FluentPage {
    @Override
    public String getUrl() {
        return "/result";
    }

    @Override
    public void isAt() {
        assertThat(title()).containsIgnoringCase("result");
    }

    public int getResult() {
        return Integer.valueOf(findFirst("#result").getText());
    }
}
