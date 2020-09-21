Feature:Validate links

Background:
  When i click blog
  Then i should go to blog page

@Regression
@Smoke
@Scenario1
  Scenario: Verify links on how to avoid the preference payment trap page
  When i go through categories dropdown one at a time and then all the links should be validated



