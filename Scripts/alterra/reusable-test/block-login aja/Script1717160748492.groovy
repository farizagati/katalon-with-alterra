import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.WaitForElementPresentKeyword as WaitForElementPresentKeyword
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

/*Open browser and login*/
WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('ObjSpy/Homepage/btn_menu-toggle'))

WebUI.click(findTestObject('ObjSpy/Homepage/btn_Login'))

WebUI.waitForElementPresent(findTestObject('ObjSpy/Login Page/btn_Login'), 0)

WebUI.setText(findTestObject('ObjSpy/Login Page/txtField_username'), 'John Doe')

WebUI.setText(findTestObject('ObjSpy/Login Page/txtField_password'), 'ThisIsNotAPassword')

WebUI.click(findTestObject('ObjSpy/Login Page/btn_Login'))

WebUI.waitForElementPresent(findTestObject('ObjSpy/Appointment/btn_Book Appointment'), 0)

