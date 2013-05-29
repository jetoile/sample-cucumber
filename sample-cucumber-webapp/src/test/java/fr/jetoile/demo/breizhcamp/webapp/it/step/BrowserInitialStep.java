/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package fr.jetoile.demo.breizhcamp.webapp.it.step;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import org.fluentlenium.cucumber.adapter.FluentCucumberAdapter;
import org.fluentlenium.cucumber.adapter.driver.SupportedWebDriver;
import org.fluentlenium.cucumber.adapter.driver.WebDriverFactory;
import org.fluentlenium.cucumber.adapter.exception.UnsupportedDriverException;
import org.fluentlenium.cucumber.adapter.util.SharedDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserInitialStep extends FluentCucumberAdapter {

    @Given(value = "I use browser ([^ ]*) with ([^ ]*)")
    public void init(String browser, String parametersCmd) throws UnsupportedDriverException {
        SupportedWebDriver driverType = SupportedWebDriver.getBrowser(browser);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String[] parameters = parametersCmd.split(";");
        for (String parameter : parameters) {
            if (!parameter.isEmpty()) {
                String[] key_value = parameter.split("@");
                capabilities.setCapability(key_value[0], key_value[1]);
            }
        }
        capabilities.setBrowserName(driverType.getName());

        WebDriver webDriver = WebDriverFactory.newWebdriverInstance(this, driverType, capabilities);
        initFluentWithWebDriver(this, webDriver);
    }

    @Given(value = "I use browser ([^ ]*)")
    public void init(String browser) throws UnsupportedDriverException {
        SupportedWebDriver driverType = SupportedWebDriver.getBrowser(browser);

        // populate DesiredCapabilities with mandatory parameters
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(driverType.getName());

        //TODO : generifying this action or using an annotation? (actually SharedDriver.PER_FEATURE)
        WebDriver webDriver = WebDriverFactory.newWebdriverInstance(this, driverType, capabilities);
        initFluentWithWebDriver(this, webDriver).withDefaultUrl("http://localhost:8080/sample-cucumber-webapp");
    }

    @After
    public void after() {
        this.quit();
    }
}
