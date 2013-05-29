package fr.jetoile.demo.breizhcamp.it;


import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:fr/jetoile/demo/breizhcamp/it",
        format = {
                "pretty", "html:target/cucumber",
                "json:target/cucumber.json"
        }
        ,
        tags = "@wip"
)
public class BasicRunner {

}
