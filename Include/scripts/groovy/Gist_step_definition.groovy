import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Gist_step_definition {

	@Given("I want to access github home page")
	def i_want_to_access_github_home_page() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.github)
		WebUI.maximizeWindow()
	}

	@And("I want to login using my github account")
	def i_want_to_login_using_my_github_account() {
		WebUI.click(findTestObject("Object Repository/login"))
		WebUI.setText(findTestObject("Object Repository/input_Username"), 'mapudnopal14')
		WebUI.setEncryptedText(findTestObject("Object Repository/input_password"), 'oFamvv8/RI99hz2PTY8yxw==')
		WebUI.click(findTestObject("Object Repository/btn_login"))
	}

	@And("I want to create a public GIST on my github")
	def i_want_to_create_a_public_gist_on_my_github() {
		WebUI.click(findTestObject("Object Repository/span_Sign out_dropdown-caret"))
		WebUI.click(findTestObject("Object Repository/a_New gist"))
	}

	@When("I write the description on my GIST")
	def i_write_the_description_on_my_gist() {
		WebUI.setText(findTestObject("Object Repository/input_gistdescription"), findTestData('Data Files/gist').getValue('title', 1))
		WebUI.setText(findTestObject("Object Repository/desc"), findTestData('Data Files/gist').getValue('desc', 1))
	}

	@And("I post it to my github page")
	def i_post_it_to_my_github_page() {
		WebUI.click(findTestObject("Object Repository/dropdown_public_gist"))
		WebUI.click(findTestObject("Object Repository/create_public_gist"))
		WebUI.delay(1)
		WebUI.click(findTestObject("Object Repository/button_public_gist"))
	}

	@Then("I can see my gist on my github account page")
	def i_can_see_my_gist_on_my_github_account_page() {
		WebUI.verifyElementPresent(findTestObject("Object Repository/body_gist"), 0)
		WebUI.closeBrowser()
	}

	@And("I want to edit a public GIST on my github")
	def i_want_to_edit_a_public_gist_on_my_github() {
		WebUI.click(findTestObject("Object Repository/span_New project_dropdown-caret"))
		WebUI.click(findTestObject("Object Repository/a_Your gists"))
		WebUI.click(findTestObject("Object Repository/gist_detail_page"))
		WebUI.delay(2)
		WebUI.click(findTestObject("Object Repository/a_Edit"))
	}

	@When("I write the new description on my GIST")
	def i_write_the_new_description_on_my_gist() {
		WebUI.setText(findTestObject("Object Repository/edit_title"), findTestData('Data Files/gist').getValue('title_edit', 1))
		WebUI.setText(findTestObject("Object Repository/edit_desc"), findTestData('Data Files/gist').getValue('desc_edit', 1))
	}

	@And("I update my GIST")
	def i_update_my_gist() {
		WebUI.click(findTestObject("Object Repository/btn_update"))
	}

	@And("I want to see my list gist")
	def i_want_to_see_my_list_gist() {
		WebUI.click(findTestObject("Object Repository/span_New project_dropdown-caret"))
		WebUI.click(findTestObject("Object Repository/a_Your gists"))
	}
	
	@Then("I can see my gist list")
	def i_can_see_my_gist_list() {
		WebUI.waitForPageLoad(3)
		WebUI.closeBrowser()
	}
	
	@Then("I delete one of my gist")
	def i_delete_one_of_my_gist() {
		WebUI.click(findTestObject("Object Repository/gist_detail_page"))
		WebUI.click(findTestObject("Object Repository/Page_edited by automation testing/button_Delete"))
		WebUI.acceptAlert()
		WebUI.closeBrowser()
	}
}