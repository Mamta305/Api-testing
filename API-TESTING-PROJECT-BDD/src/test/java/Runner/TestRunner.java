package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/GITHUB_API",
glue= "stepDefenition")
public class TestRunner {
      
}

 //C:\Users\Abhay Pathak\eclipse-workspace\APITesting-Project-Cucumber\src\test\java\Runner