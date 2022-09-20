package Stepdefinations;

import java.io.IOException;

import org.testng.Assert;

//import org.junit.Assert;

import com.qa.TestBase.TestBase;
import com.qa.pages.SearchPage;
import com.qa.utils.ConstantMessage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class SearchPageSteps extends TestBase  {
	
	/**
	 *  User Opens The Browser 
	 *  @param : null 
	 *  @author : Tohidur Rahman
	 */
	
	@Given("User invokes the browser")
	public void user_invokes_the_browser() throws IOException {	
			driver_int();	
	}

	@Given("User navigates to the search page")
	public void user_navigates_to_the_search_page() {
	  SearchPage searchpage = new SearchPage();
	  String str_Search_Page_Url = searchpage.get_Url();
	  //Assert.assertTrue(str_Search_Page_Url.contains("search"));
	  System.out.println("Url From Selemium : --> "+str_Search_Page_Url);
	  Assert.assertEquals(str_Search_Page_Url, pro.getProperty("url"));
	  System.out.println("Url From Configfile : --> "+pro.getProperty("url"));
	  
	}
	

	@When("User Inputs Valid Year {string} To {string} In The Textbox")
	public void user_inputs_valid_year_to_in_the_textbox(String string, String string2) {
		SearchPage searchpage = new SearchPage();
		searchpage.enteringDesireDate(string, string2);
		
	}

	@When("User Clicks On Go Button")
	public void user_clicks_on_go_button() {
		SearchPage searchpage = new SearchPage();
		searchpage.clickButtonGo();
	}

	@When("User Navigates To Search Page")
	public void user_navigates_to_search_page() {
		SearchPage searchpage = new SearchPage();
		Assert.assertTrue(searchpage.search_Page_validation());
	}

	@Then("User Validates Search Data")
	public void user_validates_search_data() {
		SearchPage searchpage = new SearchPage();
		Assert.assertTrue(searchpage.searchFilterValidation());
		
	}

	@Then("User Close The Browser")
	public void user_close_the_browser() {
	   driver.quit();
	}
	

	@When("Use inputs invalid year {string} to {string} in the textbox")
	public void use_inputs_invalid_year_to_in_the_textbox(String string, String string2) {
		SearchPage searchpage = new SearchPage();
		searchpage.enteringDesireDate(string, string2);
	}



	@Then("User Should see {string} Message")
	public void user_should_see_message(String string) {
		SearchPage searchpage = new SearchPage();
		Assert.assertEquals(searchpage.strErrorMessage(), ConstantMessage.invalid_Date_Error_Message);
		
	}

	
	
	
	
 
//	@When("Use input search publication from {string} to {string}")
//	public void use_input_search_publication_from_to(String startYear, String endingYear) {
//		SearchPage searchpage = new SearchPage();
//		searchpage.entering_DesireDate(startYear, endingYear);
//		//Assert.assertTrue(searchpage.search_Page_validation());
//		searchpage.click_Go_Button();
//		Assert.assertTrue(searchpage.filter_Validation(Integer.valueOf(startYear), Integer.valueOf(endingYear)));
//		
//	
//	}


	
	

}
