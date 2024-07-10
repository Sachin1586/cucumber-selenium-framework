package org.example.pages;


import org.openqa.selenium.WebDriver;

public class SolutionsPage extends BasePage{
	
	public SolutionsPage(WebDriver driver) {
		super(driver);
	}

    public int getNumberOfComments() throws Exception{
       String comments_xpath = "//div[contains(@class,'slick-slide') and not (contains(@class,'slick-cloned')) and (@data-slick-index)]";
       return findElements(comments_xpath).size();
    }
    
    public int getNumberOfCommentDots() throws Exception{
        String commentDots_xpath = "//ul[@class='slick-dots']/li";
        return findElements(commentDots_xpath).size();
    }
}
