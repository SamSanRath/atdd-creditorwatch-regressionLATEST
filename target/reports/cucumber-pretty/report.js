$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/CW-001-Validate_Links.feature");
formatter.feature({
  "name": "Generate quotes",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "i click blog",
  "keyword": "When "
});
formatter.match({
  "location": "com.creditorwatch.stepdefinition.test.ValidateLinksTest.i_click_blog() in file:/C:/Automation/Selenium/workspace/atdd-creditorwatch-regression/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i should go to blog page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.creditorwatch.stepdefinition.test.ValidateLinksTest.i_should_go_to_blog_page() in file:/C:/Automation/Selenium/workspace/atdd-creditorwatch-regression/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify links on how to avoid the preference payment trap page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Scenario1"
    }
  ]
});
formatter.step({
  "name": "i select \"Risk Management\" of categories dropdown",
  "keyword": "When "
});
formatter.match({
  "location": "com.creditorwatch.stepdefinition.test.ValidateLinksTest.i_select_Risk_Management_of_categories_dropdown(String) in file:/C:/Automation/Selenium/workspace/atdd-creditorwatch-regression/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i should go to risk management page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.creditorwatch.stepdefinition.test.ValidateLinksTest.i_should_go_to_risk_management_page() in file:/C:/Automation/Selenium/workspace/atdd-creditorwatch-regression/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i click How to Avoid the Preference Payment Trap",
  "keyword": "When "
});
formatter.match({
  "location": "com.creditorwatch.stepdefinition.test.ValidateLinksTest.i_click_How_to_Avoid_the_Preference_Payment_Trap() in file:/C:/Automation/Selenium/workspace/atdd-creditorwatch-regression/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i should go to How to Avoid the Preference Payment Trap page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.creditorwatch.stepdefinition.test.ValidateLinksTest.i_should_go_to_How_to_Avoid_the_Preference_Payment_Trap_page() in file:/C:/Automation/Selenium/workspace/atdd-creditorwatch-regression/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "all the linkTexts in the article should be validated",
  "keyword": "And "
});
formatter.match({
  "location": "com.creditorwatch.stepdefinition.test.ValidateLinksTest.all_the_linkTexts_in_the_article_should_be_validated() in file:/C:/Automation/Selenium/workspace/atdd-creditorwatch-regression/target/test-classes/"
});
formatter.result({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\t\"https://asic.gov.au/regulatory-resources/insolvency/insolvency-for-creditors/\" is broken! expected [true] but found [false]\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:47)\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:31)\r\n\tat com.creditorwatch.stepdefinition.testbase.TestBase.validateHyperLinks(TestBase.java:116)\r\n\tat com.creditorwatch.stepdefinition.test.ValidateLinksTest.all_the_linkTexts_in_the_article_should_be_validated(ValidateLinksTest.java:51)\r\n\tat ✽.all the linkTexts in the article should be validated(///C:/Automation/Selenium/workspace/atdd-creditorwatch-regression/src/test/resources/CW-001-Validate_Links.feature:14)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});