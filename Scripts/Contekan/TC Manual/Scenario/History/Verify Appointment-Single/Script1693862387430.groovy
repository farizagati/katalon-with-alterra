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

WebUI.callTestCase(findTestCase('Contekan/TC Manual/Block/Block-Appointment'), [('facility') : 'Tokyo CURA Healthcare Center', ('hospital_readmission') : true
        , ('healthcare_program') : 'None', ('visit_date') : '31/01/2050', ('comment') : 'This is my comment.'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ObjSpy/Homepage/btn_menu-toggle'))

WebUI.waitForElementVisible(findTestObject('ObjSpy/Homepage/btn_History'), 0)

WebUI.click(findTestObject('ObjSpy/Homepage/btn_History'))

WebUI.waitForElementVisible(findTestObject('ObjSpy/History Page/h2_History'), 0)

WebUI.verifyElementText(findTestObject('ObjSpy/History Page/txt_facility'), facility)

if (hospital_readmission == true) {
    WebUI.verifyElementText(findTestObject('ObjSpy/History Page/txt_hospital_readmission'), 'Yes')
} else {
    WebUI.verifyElementText(findTestObject('ObjSpy/History Page/txt_Hospital Readmission'), 'No')
}

switch (healthcare_program) {
    case 'Medicare':
        //Verify element text Medicare
        WebUI.verifyElementText(findTestObject('ObjSpy/History Page/txt_Program'), 'Medicare')

        break
    case 'Medicaid':
        //Verify element text Medicaid
        WebUI.verifyElementText(findTestObject('ObjSpy/History Page/txt_Program'), 'Medicaid')

        break
    default:
        WebUI.verifyElementText(findTestObject('ObjSpy/History Page/txt_Program'), 'None')

        break
}

WebUI.verifyElementText(findTestObject('ObjSpy/History Page/txt_panel heading'), visit_date)

WebUI.verifyElementText(findTestObject('ObjSpy/History Page/txt_comment'), comment)

WebUI.closeBrowser()

