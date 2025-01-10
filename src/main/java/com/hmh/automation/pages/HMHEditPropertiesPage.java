package com.hmh.automation.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ixxus.ipm.automation.pages.alfresco.EditPropertiesDocumentPage;

public class HMHEditPropertiesPage extends EditPropertiesDocumentPage {

    public HMHEditPropertiesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "select[id*='publicationRights'] option")
    private List<WebElement> rightsList;

    @FindBy(css = "select[id*='hmh-cms_grade-entry'] option")
    private List<WebElement> gradesList;

    @FindBy(css = "textarea[id*='prop_cm_description']")
    private WebElement descriptionTextAreaInput;

    @FindBy(css = "textarea[id*='prop_cm_title']")
    private WebElement titleTextAreaInput;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    private WebElement confirmEditButton;

    @FindBy(css = "select[id$='learningStyles-entry'] option")
    private List<WebElement> learningStylesList;

    @FindBy(css = "select[id*='prop_hmh-cms_lifecycle'] option")
    private List<WebElement> lifecycleList;

    @FindBy(css = "select[id*='subMarketsStates-entry'] option")
    private List<WebElement> subMarkestUsList;

    @FindBy(css = "select[id*='subMarketsInternational-entry'] option")
    private List<WebElement> subMarketsInternationalList;

    @FindBy(css = "select[id$='productTypeID-entry'] option")
    private List<WebElement> productTypeIDList;
    
    //added by cts QA
    @FindBy(css = "select[id$='resourceType'] option")
    private List<WebElement> resourceTypeList;

    public void editRights(String right) {
        boolean rightsFound = false;
        for (WebElement rightsElement : rightsList) {
            if (rightsElement.getText().toLowerCase().contentEquals(right.toLowerCase())) {
                rightsFound = true;
                rightsElement.click();
                break;
            }
        }
        Assert.assertTrue("The right was not found", rightsFound);
    }

    public void editGrades(String grade) {
        boolean gradeFound = false;
        for (WebElement gradeElement : gradesList) {
            if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
                gradeFound = true;
                gradeElement.click();
                break;
            }
        }
        Assert.assertTrue("The grade was not found", gradeFound);
    }

    @Override
    public void editDescription(String descritpion) {
        element(descriptionTextAreaInput).waitUntilVisible();
        descriptionTextAreaInput.clear();
        descriptionTextAreaInput.sendKeys(descritpion);
    }

    @Override
    public void editTitle(String title) {
        element(titleTextAreaInput).waitUntilVisible();
        titleTextAreaInput.clear();
        titleTextAreaInput.sendKeys(title);
    }

    public void confirmMultipleEdit() {
        element(confirmEditButton).waitUntilVisible();
        confirmEditButton.click();
    }

    public void editLearningStyles(String learningStyle) {
        boolean found = false;
        for (WebElement style : learningStylesList) {
            if (style.getText().toLowerCase().contains(learningStyle.toLowerCase())) {
                found = true;
                style.click();
                break;
            }
        }
        Assert.assertTrue("The learning style was not found", found);
    }

    public void editLifeCycle(String lifeCycle) {
        boolean found = false;
        for (WebElement cycle : lifecycleList) {
            if (cycle.getText().toLowerCase().contains(lifeCycle.toLowerCase())) {
                found = true;
                cycle.click();
                break;
            }
        }
        Assert.assertTrue("The lifecycle was not found ", found);
    }

    public void editSubMarketUS(String subMarket) {
        boolean found = false;
        for (WebElement market : subMarkestUsList) {
            if (market.getText().toLowerCase().contains(subMarket.toLowerCase())) {
                found = true;
                market.click();
                break;
            }
        }
        Assert.assertTrue("The sub market US was not found ", found);
    }

    public void editSubMarketInternational(String subMarket) {
        boolean found = false;
        for (WebElement market : subMarketsInternationalList) {
            if (market.getText().toLowerCase().contains(subMarket.toLowerCase())) {
                found = true;
                market.click();
                break;
            }
        }
        Assert.assertTrue("The sub market International was not found ", found);
    }

    public void editProductTypeID(String id) {
        boolean found = false;
        for (WebElement productTypeID : productTypeIDList) {
            if (productTypeID.getText().toLowerCase().contains(id.toLowerCase())) {
                found = true;
                productTypeID.click();
                break;
            }
        }
        Assert.assertTrue("The product type id was not found ", found);
    }
    
    public void editResourceType (final String resourceType) {
    	boolean resourceTypeFound = false;
        for (final WebElement resource : resourceTypeList) {
            if (resource.getText().toLowerCase().contains(resourceType.toLowerCase())) {
                resourceTypeFound = true;
                resource.click();
                break;
            }
        }
        Assert.assertTrue("The resource type was not found", resourceTypeFound);
    }
}
