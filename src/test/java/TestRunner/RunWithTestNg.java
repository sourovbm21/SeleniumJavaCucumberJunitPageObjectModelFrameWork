package TestRunner;


/**
 * 
 * This is a runner class for TestNG
 * @author Tohidur Rahman
 */
import org.testng.annotations.DataProvider;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/AppFeatures"},				
		glue = {"Stepdefinations"},		
		plugin = {"pretty",
				"html:html_reports/cucumber-reports.html",
				"json:cucumber_reports/Cucumber.json",
				"junit:junit_reports/Report.xml"},
		publish =false,//To publish cucumber report on cloud.
		dryRun = false,// To check the mapping is proper between feature  and StepDefination files.
		monochrome = true,//To display the console output in a proper readable format.		
		tags = "@Sanity"
		)
public class RunWithTestNg extends AbstractTestNGCucumberTests {	
	@Override
	@DataProvider()
	public Object [][]scenarios() {
		return super.scenarios();
	}	
}
