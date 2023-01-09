package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/html-reports/cucumber.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-reports/cucumber.xml",
                "rerun:target/failedRerun.txt",
        },
        features = "./src/test/resources/features/grid_features",
        glue = {"stepdefinitions"},
        tags = "@grid_chrome and @grid_firefox",
        dryRun = false
)
public class GRIDRunner {
}
