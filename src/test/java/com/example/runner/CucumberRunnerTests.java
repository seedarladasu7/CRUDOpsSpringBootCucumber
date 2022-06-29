package com.example.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber/cucumber.json"}, features = {"src/test/resources/Features"}, glue = { "com.example.definitions"})
 
public class CucumberRunnerTests {
}
