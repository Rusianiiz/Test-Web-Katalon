//import com.kms.katalon.core.listener.AbstractTestListener
//import com.kms.katalon.core.context.TestCaseContext
//import com.kms.katalon.core.cucumber.keyword.internal.CucumberGlueGenerator
//
//class NewTestListener extends AbstractTestListener {
//
//    @Override
//    void beforeTestCase(TestCaseContext context) {
//        // Add default Cucumber glue packages
//        CucumberGlueGenerator.addDefaultPackages()
//    }
//}

package code
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.cucumber.keyword.internal.CucumberGlueGenerator

class NewTestListener {

    @BeforeTestCase
    def beforeTestCase(TestCaseContext testCaseContext) {
        // Add default Cucumber glue packages
        CucumberGlueGenerator.addDefaultPackages()
    }
}

