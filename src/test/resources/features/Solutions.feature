Feature: EdAssist Solutions for Employees functionality

  Scenario: VerifyComments: Verify number of comments is same as dots visible below comments
  Given user navigates to home page
  When user clicks on Learn More button for section EdAssist Solutions for Employers
  Then page opened should have "edassist-solutions" as part of URL
  And comments and dot visible below comments for Industry Expertise Section should be same.
