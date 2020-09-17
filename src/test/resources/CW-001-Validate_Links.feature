Feature: Generate quotes

Background:
  When i click blog
  Then i should go to blog page

@Scenario1
  Scenario: Verify links on how to avoid the preference payment trap page
  When i select "Risk Management" of categories dropdown
  Then i should go to risk management page
  When i click How to Avoid the Preference Payment Trap
  Then i should go to How to Avoid the Preference Payment Trap page
  And all the linkTexts in the article should be validated



#@Scenario2
  #Scenario: Verify links
  #Given that  I'm on creditorwatch home page
  #When i select "Due Diligence" of categories dropdown
  #Then i should go to Due Diligence page
