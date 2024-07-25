Feature: EdAssist Solutions for Employees functionality

  Scenario: VerifyComments: Verify number of comments is same as dots visible below comments
  Given user navigates to home page
  When user clicks on Learn More button for section EdAssist Solutions for Employers
  Then page opened should have "edassist-solutions" as part of URL
  And comments and dot visible below comments for Industry Expertise Section should be same.
  
  Scenario: VerifySearchResults: Verify search results is same as what is typed in search
  Given user navigates to home page
  When user clicks on Search icon
  Then search field should be visible
  When user types "Employee Education in 2018: Strategies to Watch" in serach field and clicks search button
  Then search results should have result which is exact match of searched text "Employee Education in 2018: Strategies to Watch"
