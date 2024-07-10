package org.example.stepdefinitions;

import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.en.Then;

public class SolutionsPageSteps extends BaseSteps{
	
	public SolutionsPageSteps(Hooks setUp) {
		super(setUp);
	}

	@Then("page opened should have {string} as part of URL")
	public void page_opened_should_have_as_part_of_url(String urlPartName) {
		Reporter.log("Solutions Page Url :: " + solutionsPage.getCurrentUrl(), true);
		Assert.assertTrue(solutionsPage.getCurrentUrl().contains(urlPartName), "Url does not have " + urlPartName);
	}

	@Then("comments and dot visible below comments for Industry Expertise Section should be same.")
	public void comments_and_dot_visible_below_comments_for_industry_expertise_section_should_be_same() throws Exception {
		int numOfComments = solutionsPage.getNumberOfComments();
		int numOfCommentDots = solutionsPage.getNumberOfCommentDots();
		Reporter.log("Number of Comments :: " + numOfComments, true);
		Reporter.log("Number of Comment Dots :: " + numOfCommentDots, true);
		Assert.assertEquals(numOfComments, numOfCommentDots, "Comments and its dots are not equal");
		
	}
	
}