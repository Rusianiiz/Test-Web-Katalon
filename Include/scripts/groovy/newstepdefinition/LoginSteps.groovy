package newstepdefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.cucumber.keyword.internal.CucumberGlueGenerator
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable

public class LoginSteps {

	@Given("I open the browser and navigate to the URL")
	def openBrowser() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.URL)
		WebUI.maximizeWindow()
	}

	@When("I login with username (.*) and password (.*)")
	def login(String username, String password) {
		WebUI.click(findTestObject('Object Repository/Login/SpyWeb/Login Toggle Menu/Page_CURA Healthcare Service/a_CURA Healthcare_menu-toggle'))
		WebUI.focus(findTestObject('Object Repository/Login/SpyWeb/Login Toggle Menu/Page_CURA Healthcare Service/a_Login'))
		WebUI.setText(findTestObject('Object Repository/Login/SpyWeb/Login Toggle Menu/Page_CURA Healthcare Service/input_Username_username'), username)
		WebUI.setEncryptedText(findTestObject('Object Repository/Login/SpyWeb/Login Toggle Menu/Page_CURA Healthcare Service/input_Password_password'), password)
		WebUI.click(findTestObject('Object Repository/Login/SpyWeb/Login Toggle Menu/Page_CURA Healthcare Service/button_Login'))
	}
	@Then("I should be redirected to the dashboard")
	def verifyDashboard() {
		WebUI.verifyElementPresent(findTestObject('Page_CURA Healthcare Service/h2_Make Appointment'), 10)
	}

	@And("I close the browser")
	def closeBrowser() {
		WebUI.delay(5)
		WebUI.closeBrowser()
	}
}
