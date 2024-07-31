import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.logging.KeywordLogger

KeywordLogger logger = new KeywordLogger()

"Memanggil Test Data"
TestData data = findTestData('Data Files/DDTDatabase')
logger.logInfo("Test Data Loaded")

"Mendapatkan jumlah baris dalam Test Data"
int rowCount = data.getRowNumbers()
logger.logInfo("Number of Rows: " + rowCount)

for (int i = 1; i <= rowCount; i++) {
	"Membuka browser"
	WebUI.openBrowser('')
	logger.logInfo("Browser Opened")
	

	"Navigasi ke URL menggunakan global variable"
	WebUI.navigateToUrl(GlobalVariable.URL)
	logger.logInfo("Navigated to URL: " + GlobalVariable.URL)
	WebUI.maximizeWindow()
	logger.logInfo("Window Maximized")
	WebUI.takeScreenshot()

	"Klik menu login"
	WebUI.click(findTestObject('Object Repository/Login/SpyWeb/Login Toggle Menu/Page_CURA Healthcare Service/a_CURA Healthcare_menu-toggle'))
	logger.logInfo("Clicked Login Menu Toggle")
	WebUI.focus(findTestObject('Object Repository/Login/SpyWeb/Login Toggle Menu/Page_CURA Healthcare Service/a_Login'))
	logger.logInfo("Focused on Login")
	WebUI.takeScreenshot()
	logger.logInfo("Screenshot Taken")

	"Proses login dengan data dari baris ke-i"
	WebUI.setText(findTestObject('Object Repository/Login/SpyWeb/Login Toggle Menu/Page_CURA Healthcare Service/input_Username_username'),
		data.getValue('username', i))
	logger.logInfo("Username Set: " + data.getValue('username', i))
	WebUI.setText(findTestObject('Object Repository/Login/SpyWeb/Login Toggle Menu/Page_CURA Healthcare Service/input_Password_password'),
		data.getValue('password', i))
	logger.logInfo("Password Set")

	WebUI.click(findTestObject('Object Repository/Login/SpyWeb/Login Toggle Menu/Page_CURA Healthcare Service/button_Login'))
	logger.logInfo("Clicked Login Button")
	WebUI.delay(5)
	WebUI.takeScreenshot()
	logger.logInfo("Screenshot Taken After Login")

	"Menutup browser"
	WebUI.closeBrowser()
	logger.logInfo("Browser Closed")
}

