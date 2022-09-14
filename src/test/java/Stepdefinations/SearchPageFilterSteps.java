package Stepdefinations;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.qa.TestBase.TestBase;
import com.qa.pages.SearchPage;
import com.qa.utils.CommonUtility;
import com.qa.utils.ConstantMessage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageFilterSteps extends TestBase {
	

	@And("User Inputs Following Valid Year Data In Search Field And Validates")
	public void use_input_following_valid_year_in_search_field_and_validates(DataTable dataTable) {
		List<Map<String,String>> yearData = dataTable.asMaps(String.class,String.class);
		for (Map<String,String>data : yearData) {
			SearchPage searchpage =  new SearchPage();
			searchpage.enteringDesireDate(data.get("From"),data.get("To"));
			searchpage.clickButtonGo();
			SoftAssert sf = new SoftAssert();
			sf.assertTrue(searchpage.searchFilterValidation(),"No publication list for "+"Given Year From :  "+data.get("From")+
			"  Given Year To  "+data.get("To"));
			driver.navigate().back();
			sf.assertAll();			
		}		
	}
	
	@When("User Input Following invalid Data In Search Field And Validates")
	public void use_input_following_in_valid_year_in_search_field_and_validates(DataTable dataTable) {
	List<Map<String,String>>	invalidYears = dataTable.asMaps(String.class,String.class);
	SearchPage searchpage =  new SearchPage();
	SoftAssert sf = new SoftAssert();
	for (Map<String,String>invalidYear :invalidYears) {	
		searchpage.enteringDesireDate(invalidYear.get("From"), invalidYear.get("To"));
		searchpage.clickButtonGo();
		sf.assertEquals(searchpage.strErrorMessage(),ConstantMessage.invalid_Date_Error_Message);
		driver.navigate().back();
		sf.assertAll();
	  }
	}

	@When("User Clicks On Dropdown And Selects {string} Option")
	public void user_clicks_on_dropdown_and_selects_option( String string2) {
		SearchPage searchpage =  new SearchPage();
		searchpage.clickDropdownSortByRelevance();
		searchpage.clickDropdownOptionOldestToNewest();	
		  
	}
	
	@Then("User Should See Oldest Publication {string} On Top Of Publication List")
	public void user_should_see_oldest_publication_on_top_of_publication_list(String string) {
		SearchPage searchpage =  new SearchPage();
		String str_Oldest_Publication_Date = searchpage.strOldestPublicationDate();
		Assert.assertTrue(str_Oldest_Publication_Date.equals(string));
	}
		//
	@When("User Inputs Valid Year Data In Search Field And Validates  With Given Data")
	public void user_inputs_valid_year_data_in_search_field_and_validates_with_given_data(DataTable dataTable) {
	List<Map<String,String>>	yearDates = dataTable.asMaps(String.class,String.class);
	SearchPage searchpage =  new SearchPage();
	searchpage.expandPerPagePublicationList();
	for (Map<String,String>date:yearDates) {		
		searchpage.enteringDesireDate(date.get("From"),date.get("To"));
		searchpage.clickButtonGo();
		searchpage.totalListVarification(Integer.parseInt( date.get("From")),Integer.parseInt(date.get("To")));		
		driver.navigate().back();		
	   }	
	}
	@Given("User Clicks On Links In Year Sections And Validates")
	public void user_clicks_on_links_in_year_sections_and_validates() throws InterruptedException {
		SearchPage searchpage =  new SearchPage();
		SoftAssert sf = new SoftAssert();
		System.out.println("Total Links In Year Section: --> "+searchpage.varificationTotalLinkOfYear().size());
		searchpage.varificationTotalLinkOfYear().parallelStream().forEach(e->{
			try {
				CommonUtility.checkBrokenLinks(e);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
			
		}
	
	@When("User clicks on Only content I have access to Link")
	public void user_clicks_on_only_content_i_have_access_to_link() {
		SearchPage searchpage =  new SearchPage();
		searchpage.contentAccessLink();
	}



	@Then("User Should Verify access Content available On Publication List")
	public void user_should_varify_access_content_available_on_publication_list() {
		SearchPage searchpage =  new SearchPage();
		Assert.assertTrue(searchpage.contentAccessVarification());
		driver.navigate().back();

	}
	@And("User Clicks On Only Open Access Link")
	public void user_clicks_on_only_open_access_link() {
		
		SearchPage searchpage =  new SearchPage();
		searchpage.openAccessLink();
	  
	}
	@Then("User Should See Open Access On Publication List")
	public void user_should_see_open_access_on_publication_list() {
		SearchPage searchpage =  new SearchPage();
		Assert.assertTrue(searchpage.openAccessVarification());
	
	}
	
	@When("User Clicks On Citations Checkbox")
	public void user_clicks_on_citations_checkbox() {
		SearchPage searchpage =  new SearchPage();
		searchpage.selectCheckboxCitation();		
	}
	
	

	@Then("User Should Able To Download RIS")
	public void user_should_able_to_download_ris() {
		SearchPage searchpage =  new SearchPage();
		Assert.assertTrue(searchpage.varificationButtonDownloadRis());
	}
	
	
	

	}

	


