package com.qa.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.TestBase.TestBase;
import com.qa.utils.TimeUtility;

public class SearchPage extends TestBase {

	/**
	 * Object Repository (OR)
	 * This Page Is Only For Declaring Locators
	 * @author Tohidur Rahman
	 */
	
	@FindBy(css = "#yearFrom")
	private WebElement inputStartYear;
	@FindBy(css = "#yearTo")
	private WebElement inputEndYear;
	@FindBy(xpath = "//a[@class='btn-sm btn-primary']")
	private WebElement buttonGo;

	@FindBy(xpath = "//h2[text()='Year']")
	private WebElement yearScroll;

	@FindBy(xpath = "(//section[@class='w-100 d-block pb-2']//parent::div//following-sibling::section)[1]")
	private WebElement searchPagevalidation;

	@FindBy(linkText = "50")
	private WebElement expandPerPageList;

	@FindBy(css = "span[class='font-weight-light']:nth-child(1)")
	private WebElement displayPublicationDate;
	
	@FindBy(xpath = "//span[contains(text(),'Publication date: ')]")
	private List<WebElement> listOfPublicationDates;

	@FindBy(xpath = "//strong[text()='No Search results']")
	private WebElement messageInvalidError;

	@FindBy(id = "sortByButton")
	private WebElement dropDownSortByRelevance;
	@FindBy(xpath = "//a[text()='Oldest to newest']")
	private WebElement optionDropDownOldestToNewest;
	
	@FindBy(xpath = "//span[contains(text(),'1 April 1898')]")
	private WebElement oldestPublicationDate;

	// For List
	@FindBy(xpath = "//div[@class='row intent-filter-by-div']//following-sibling::ul//li//a")
	private List<WebElement> listOfYearLinks;

	@FindBy(xpath = "//a[(text()='Only content I have access to')]")
	private WebElement clickContentAccess;
	@FindBy(xpath = "//span[contains(text(),'Content available')]")
	private WebElement messageContentAccess;

	@FindBy(xpath = "//a[text()='Only Open Access']")
	private WebElement clickOpenAccess;
	@FindBy(xpath = "//span[@title='Open Access.']//parent::span")
	private WebElement messageOpenAccess;

	@FindBy(xpath = "//input[@filled='true']")
	private WebElement checkboxCitration;

	@FindBy(css = "[class='btn p-0 ml-1 btn-link']")
	private WebElement buttonRisDownload;

	JavascriptExecutor js = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, TimeUtility.explicit_TimeOut);

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	public void enteringDesireDate(String year_Start, String year_End) {
		js.executeScript("arguments[0].scrollIntoView();", yearScroll);
		inputStartYear.clear();
		inputStartYear.sendKeys(year_Start);
		inputEndYear.clear();
		inputEndYear.sendKeys(year_End);
	}

	public void clickButtonGo() {
		buttonGo.click();
	}

	public String get_Url() {
		return driver.getCurrentUrl();
	}

	public boolean search_Page_validation() {
		wait.until(ExpectedConditions.visibilityOf(searchPagevalidation));
		return searchPagevalidation.isDisplayed();
	}

	public void expandPerPagePublicationList() {
		wait.until(ExpectedConditions.elementToBeClickable(expandPerPageList));
		expandPerPageList.click();
	}

	public boolean searchFilterValidation() {
		wait.until(ExpectedConditions.visibilityOf(displayPublicationDate));
		return displayPublicationDate.isDisplayed();
	}

	public String strErrorMessage() {
		wait.until(ExpectedConditions.visibilityOf(messageInvalidError));
		return messageInvalidError.getText();
	}

	public void clickDropdownSortByRelevance() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownSortByRelevance));
		dropDownSortByRelevance.click();
	}

	public void clickDropdownOptionOldestToNewest() {
		Actions action = new Actions(driver);
		action.moveToElement(optionDropDownOldestToNewest).click().perform();
	}

	public String strOldestPublicationDate() {
		wait.until(ExpectedConditions.visibilityOf(oldestPublicationDate));
		return oldestPublicationDate.getText();
	}

	public void totalListVarification(int x, int y) {
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfPublicationDates));
		for (WebElement list_P : listOfPublicationDates) {
			String list_Item_Name = list_P.getText();//Publication date: 29 May 2018
			System.out.println("****************************************");
			System.out.println(list_Item_Name);
			String all_Year = list_Item_Name.substring(list_Item_Name.length() - 4);//2018
			if ((Integer.parseInt(all_Year) >= x) && (Integer.parseInt(all_Year) <= y)) {
				System.out.println("Test passed :--> " + all_Year);
			} else {
				System.out.println("Test fail :---> " + all_Year);
			}
		}
		System.out.println("****************************************");
	}

	public List<String> varificationTotalLinkOfYear() {
		js.executeScript("arguments[0].scrollIntoView();", yearScroll);
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfYearLinks));
		List<String> url_List = new ArrayList();
		for (WebElement link : listOfYearLinks) {
			String url = link.getAttribute("href");
			url_List.add(url);
			// System.out.println("@@@@#######@@@@#######"+url);
		}
		return url_List;
	}

	public void contentAccessLink() {
		wait.until(ExpectedConditions.elementToBeClickable(clickContentAccess));
		clickContentAccess.click();
	}

	public boolean contentAccessVarification() {
		return messageContentAccess.isDisplayed();
	}

	public void openAccessLink() {
		wait.until(ExpectedConditions.elementToBeClickable(clickOpenAccess));
		clickOpenAccess.click();
	}

	public boolean openAccessVarification() {
		return messageOpenAccess.isDisplayed();
	}

	public void selectCheckboxCitation() {
		js.executeScript("arguments[0].click();", checkboxCitration);
	}

	public boolean varificationButtonDownloadRis() {

		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return buttonRisDownload.isDisplayed();
	}

}
