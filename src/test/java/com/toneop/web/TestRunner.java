package com.toneop.web;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/feature", 
	    glue = {"com.toneop.web.stepdefinitions"}, 
	    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}, 
	    monochrome = true 

	)
public class TestRunner {

}
