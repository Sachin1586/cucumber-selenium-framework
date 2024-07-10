package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
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
	}

	@When("user clicks on Learn More button for section EdAssist Solutions for Employers")
	public void user_clicks_on_learn_more_button_for_section_ed_assist_solutions_for_employers() throws Exception {
		homePage.clickRejectAllCookies();
		homePage.clickEdAssistLink();
		homePage.clickEdAssistLearnMore();
	}
}