package org.example.stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps extends BaseSteps{
	
	public HomePageSteps(Hooks setUp) {
		super(setUp);
	}

	@Given("user navigates to home page")
	public void user_navigates_to_home_page() throws Exception {
		if(!homePage.isAtHomePage()) {
			homePage.clickHomePage();
		}
		homePage.clickRejectAllCookies();
	}

	@When("user clicks on Learn More button for section EdAssist Solutions for Employers")
	public void user_clicks_on_learn_more_button_for_section_ed_assist_solutions_for_employers() throws Exception {
		homePage.clickEdAssistLink();
		homePage.clickEdAssistLearnMore();
	}
	
	@When("user clicks on Search icon")
	public void user_clicks_on_search_icon() throws Exception {
		homePage.clickSearchIcon();
	}
	
	@Then("search field should be visible")
	public void search_field_is_viisble() throws Exception {
		Assert.assertTrue(homePage.isSearchFieldVisible(), "Serach field is not visible");	}
	
	@When("user types {string} in serach field and clicks search button")
	public void user_types_in_search_field_and_clicks_search_button(String text) throws Exception {
		homePage.enterSearchText(text);
		homePage.clickSearchButton();
	}
	
	@When("search results should have result which is exact match of searched text {string}")
	public void verify_search_result(String text) throws Exception {
		Assert.assertTrue(homePage.isSearchTextPresentInSearchResults(text), "Search text is not present in search results");
	}
	
}