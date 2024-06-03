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

//define the path to data file
def path_to_file = 'Data Files/LoginData/LoginData-InternalData'

WebUI.callTestCase(findTestCase('Contekan/TC Manual/Block/Block-Initial Open Browser'), [('username') : 'John Doe', ('password') : 'ThisIsNotAPassword'], 
    FailureHandling.STOP_ON_FAILURE)

/*
 * Start loop here. Here's the logic:
 * At first, rowNumber is defined as a hardcoded value "1",
 * Then we define the limit of row number, by getting the rownumber using function: .getRowNumbers()
 * But .getRowNumbers() cannot stand alone, so it must be defined with the data, here I use the findTestData(path_to_file),
 * which the path_to_file is already defined in the top of this script.
 * Then, declare that the rowNumber will be increased after each iteration using rowNumber++
 * */
for (def rowNumber = 1; rowNumber <= findTestData(path_to_file).getRowNumbers(); rowNumber++) {
	WebUI.comment("========== START LOOP ==========")
	//replace each variable from the current data
	def username = findTestData(path_to_file).getValue(1, rowNumber)
	def password = findTestData(path_to_file).getValue(2, rowNumber)

	WebUI.click(findTestObject('ObjSpy/Homepage/btn_menu-toggle'))
	
	WebUI.click(findTestObject('ObjSpy/Homepage/btn_Login'))
	
	WebUI.waitForElementPresent(findTestObject('ObjSpy/Login Page/btn_Login'), 0)
	
	WebUI.setText(findTestObject('ObjSpy/Login Page/txtField_username'), username)
	
	WebUI.setText(findTestObject('ObjSpy/Login Page/txtField_password'), password)
	
	WebUI.click(findTestObject('ObjSpy/Login Page/btn_Login'))
	
	WebUI.waitForElementPresent(findTestObject('ObjSpy/Appointment/btn_Book Appointment'), 0)
	
	WebUI.click(findTestObject('ObjSpy/Homepage/btn_menu-toggle'))
	
	WebUI.waitForElementVisible(findTestObject('ObjSpy/Homepage/btn_Logout'), 0)
	
	WebUI.verifyElementPresent(findTestObject('ObjSpy/Homepage/btn_Logout'), 0)
	
	WebUI.verifyElementNotPresent(findTestObject('ObjSpy/Homepage/btn_Login'), 0)
	
	WebUI.click(findTestObject('ObjSpy/Homepage/btn_Logout'))
	
	WebUI.waitForElementVisible(findTestObject('ObjSpy/Homepage/h1_CURA Healthcare Service'), 0)
	WebUI.comment("========== END OF FOR LOOP ==========")
}
//end loop here

WebUI.closeBrowser()

