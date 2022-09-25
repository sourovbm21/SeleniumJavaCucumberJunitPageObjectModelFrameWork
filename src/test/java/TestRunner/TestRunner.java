package TestRunner;


/**
 * 
 * This is a runner class for Junit 
 * @author Tohidur Rahman
 */
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
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
		tags="@Sanity"
		
		
		
		)


public class TestRunner {
	
	
	
	
	
	

}
