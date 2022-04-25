package naggaroTest;


//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		plugin = {"pretty",
				"html:target/cucumber-reports/cucumber.html"
				
		},
		features= {"src/test/resources/naggaroTest"},
		glue= {"naggaroTest"}
		//tags="@naggaroTest"
		
		)
public class TestRunnerTest extends AbstractTestNGCucumberTests {
	
}


