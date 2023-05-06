package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/GITHUB_API",
glue= "stepDefenition",
plugin = {"html:test-output/Abhay.html","json:test-output/Abhay.json"}
		)


public class TestRunner {
      
}

 