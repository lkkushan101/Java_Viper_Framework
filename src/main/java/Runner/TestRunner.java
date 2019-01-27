package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.runtime.model.CucumberFeature;



import org.testng.annotations.*;

@CucumberOptions(
	
		glue = {"stepdefs"},//Your step definitions package.
		features = {"src/main/java/Features"})

public class TestRunner extends AbstractTestNGCucumberTests {

}
