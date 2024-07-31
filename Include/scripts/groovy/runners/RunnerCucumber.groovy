//package runners
//import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
//import cucumber.api.CucumberOptions
//import org.junit.runner.RunWith
//import cucumber.api.junit.Cucumber
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//features = 'Include/Login.feature',
//glue = 'LoginSteps',
//plugin=["pretty", "html:ReportsFolder", "json:ReportsFolder/cucumber.json"],
//tags = '@tag'
//)
//public class CucumberRunner {
//}

package runners

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import cucumber.api.CucumberOptions
import org.junit.runner.RunWith
import cucumber.api.junit.Cucumber

@RunWith(Cucumber.class)
@CucumberOptions(
	features = 'Include/features/Login.feature',
//	glue = ['LoginSteps'],  // Ensure this matches your step definition package
	glue = ['newstepsefinition'],
	plugin = ["pretty", "html:ReportsFolder", "json:ReportsFolder/cucumber.json"],
	tags = '@tag'
)
public class CucumberRunner {
}
