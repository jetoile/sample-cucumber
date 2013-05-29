package fr.jetoile.demo.breizhcamp.webapp.it;


import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@Cucumber.Options(features = "classpath:fr/jetoile/demo/breizhcamp/it", format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
@Cucumber.Options(features = "classpath:fr/jetoile/demo/breizhcamp/it/webappMultiFeature.feature", format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class BasicRunner {

//    @BeforeClass
//    public static void setup() {
//        FluentCucumberAdapter.sharedDriver = null;
//    }

}
