package com.hmh.automation.pages;

import java.util.List;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ixxus.ipm.automation.pages.alfresco.AdvancedSearchPage;

public class HMHAdvancedSearchPage extends AdvancedSearchPage {

    public HMHAdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[id*='default-forms'] div[class='share-form'] select[id$='prop_hmh-cms_grade-entry'] option")
    private List<WebElement> advanceSearchGradesList;

    @FindBy(css = "input[id*='copyrightYear']")
    private WebElement copyrightYear;

    @FindBy(css = "select[id*='lifecycle'] option")
    private List<WebElement> lifecycleList;

    @FindBy(css = "select[id*='productType'] option")
    private List<WebElement> productTypes;

    @FindBy(css = "div[id*='cm_taggable-cntrl-itemGroupActions'] button")
    private WebElement tagsSelectButton;

    @FindBy(css = "div[id*='prop_cm_taggable-cntrl-picker-results'] tbody[class$='data'] tr[class^='yui-dt-rec yui-dt']")
    private List<WebElement> HMHkewords;

    @FindBy(css = "button[id*='prop_cm_taggable-cntrl-ok-button']")
    private WebElement hmhKewordsOKButton;

    @FindBy(css = "div[id$='default-results'] tr td[class*='col-select'] input")
    private List<WebElement> selectCheckboxes;

    @FindBy(css = "button[id*='fileSelect-button-button']")
    private WebElement SelectButton;

    @FindBy(css = "span[class='selectAll']")
    private WebElement selectAllButton;

    @FindBy(css = "div[id*='default-fileSelect-menu'] li a span")
    private List<WebElement> selectionOptions;

    @FindBy(css = "button[id*='_default-selectedItems-button-button']")
    private WebElement selectedItemsButton;

    @FindBy(css = "div[id*='default-selectedItems-menu'] li span")
    private List<WebElement> selectedItemsOptions;

    String addButton = " span[class='addIcon']";
    String text = " h3";
    String hmhkeys = "div[id*='prop_cm_taggable-cntrl-picker-results'] tbody[class$='data'] tr[class^='yui-dt-rec yui-dt']";
    String actionsCssSelector = "div[id*='default-selectedItems-menu'] li span";

    public void selectAllItemsInSearchResults() {
        SelectButton.click();
        waitABit(1000);
        selectAllButton.click();
    }

    public void switchToWindow(int number){
    	String window = getDriver().getWindowHandles().toArray()[number].toString();
    	getDriver().switchTo().window(window);    	
    }
    public void performActionOnSelectedResults(String action) {
        boolean found = false;
        selectedItemsButton.click();
        waitABit(1000);

        List<WebElement> actions = getDriver().findElements(By.cssSelector(actionsCssSelector));
        waitABit(1000);
        for (WebElement item : actions) {
            if (item.getText().toLowerCase().contains(action.toLowerCase())) {
                found = true;
                item.click();
                break;
            }
        }
        Assert.assertTrue("The action was not found", found);
    }

    public void selectProductTypeInAdvancedSearch(String productType) {
        boolean productTypeFound = false;
        for (WebElement type : productTypes) {
            if (type.getText().toLowerCase().contains(productType.toLowerCase())) {
                productTypeFound = true;
                type.click();
                break;
            }
        }
        Assert.assertTrue("The product Type was not found", productTypeFound);
    }

    public void selectYearInAdvacnedSearch(String year) {
        element(copyrightYear).waitUntilVisible();
        copyrightYear.sendKeys(year);
    }

    public void selectLifeCycleInAdvancedSearch(String liefcycle) {
        boolean productTypeFound = false;
        for (WebElement cycle : lifecycleList) {
            if (cycle.getText().toLowerCase().contains(liefcycle.toLowerCase())) {
                productTypeFound = true;
                cycle.click();
                break;
            }
        }
        Assert.assertTrue("The lifecycle was not found", productTypeFound);
    }

    public void selectGradeInAdvancedSearch(String grade) {
        boolean gradeFound = false;
        for (WebElement gradeElement : advanceSearchGradesList) {
            if (gradeElement.getText().toLowerCase().contains(grade.toLowerCase())) {
                gradeFound = true;
                gradeElement.click();
                break;
            }
        }
        Assert.assertTrue("The grade was not found", gradeFound);
    }

    public void selectKeyword(String hmhKey) {
        element(tagsSelectButton).waitUntilVisible();
        boolean found = false;
        tagsSelectButton.click();
        System.out.println("INAINTE DE FOR");
        List<WebElement> hmh = getDriver().findElements(By.cssSelector(hmhkeys));
        for (WebElement element : hmh) {
            System.out.println("INTRA IN FOR");
            System.out.println("Element :" + element.getText());
            WebElement textKey = element.findElement(By.cssSelector(text));
            if (textKey.getText().toLowerCase().contains(hmhKey.toLowerCase())) {
                System.out.println("AJUNGE AICI");
                found = true;
                WebElement add = element.findElement(By.cssSelector(addButton));
                add.click();
                break;
            }
        }
        Assert.assertTrue("The hmh keword was not found", found);
        hmhKewordsOKButton.click();
    }
}
