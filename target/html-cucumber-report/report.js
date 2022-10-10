$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/calculator.feature");
formatter.feature({
  "name": "Calculator",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Sum two numbers",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have two numbers: 1 and 2",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "The calculator sums them",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I receive 3 as a result",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});