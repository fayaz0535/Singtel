package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/ToDo.feature"},
        glue = {"stepdefs"},
        plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},monochrome = true)
       /* plugin = { "pretty", "json:target/cucumber/report.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber/report.html" }, monochrome = true)*/
public class RunCucumberTest {

}
