Feature:Validate links

Background:
  When i click blog
  Then i should go to blog page

@Regression
@Smoke
@Scenario1
  Scenario: Verify links on how to avoid the preference payment trap page
  When i select "Risk Management" of categories dropdown
  Then i should go to risk management page and page title should be "Risk Management Archives - CreditorWatch Blog"
  When i click How to Avoid the Preference Payment Trap
  Then i should go to How to Avoid the Preference Payment Trap page and title should be "Avoid the Preference Payment Trap | Secured Creditors | CreditorWatch"
  And all the linkTexts in the article should be validated

@Regression
@Smoke
@Scenario2
  Scenario: Verify links on Company Financial Statements page
  When i select "Due Diligence" of categories dropdown
  Then i should go to Due Diligence page and page title should be
  |Due Diligence Archives - CreditorWatch Blog|
  When i click Company Financial Statements: Identifying Signs of Business Failure
  Then i should go to Company Financial Statements page and title should be "Company Financial Statements | Identifying Financial Risk | CreditorWatch"
  And all the linkTexts in the article of Company Financial Statements should be validated

