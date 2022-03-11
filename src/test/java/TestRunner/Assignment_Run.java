package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src\\test\\resources\\Features\\Assignment.feature",
		    glue="StepDef",
		    tags="@test5",
		    plugin= {"pretty",
		    		
		    },
		
		dryRun=false,
				monochrome=true,
				publish=true
		)

public class Assignment_Run {
}

