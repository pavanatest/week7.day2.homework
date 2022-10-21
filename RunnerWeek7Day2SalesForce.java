package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/features/Week7Day2SalesForce.feature",
				glue={"steps","hooks"},
				monochrome=true,
				publish=true,
				tags="@Smoke and @Sanity")

public class RunnerWeek7Day2SalesForce extends AbstractTestNGCucumberTests{
	

}
