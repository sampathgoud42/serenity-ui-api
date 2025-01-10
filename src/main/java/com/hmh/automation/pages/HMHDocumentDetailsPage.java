package com.hmh.automation.pages;

import java.util.List;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.tools.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.pages.alfresco.DocumentDetailsPage;

public class HMHDocumentDetailsPage extends DocumentDetailsPage {
    public HMHDocumentDetailsPage(final WebDriver driver) {
        super(driver);
    }
    private static final Logger LOG = LoggerFactory
			.getLogger(AbstractBaseSiteTest.class);
    
    @FindBy(css = "div.create-reference-from a span")
    private WebElement manageReferencesActionLink;

    @FindBy(css = "button[id *='references-cntrl-ok-button']")
    private WebElement applyReferenceButton;

    @FindBy(css = "div[id*='cntrl-picker-right'] tbody[class$='message'] div")
    private WebElement emptyReferences;

    @FindBy(css = "div[id $= 'references-cntrl-picker-right'] tr[class *= 'dt-rec']")
    private List<WebElement> selectedReferencesList;

    @FindBy(xpath = "//div[contains(text(),'Derived From ')]")
    private WebElement derivedFromLabel;

    @FindBy(css = "div[id*='formContainer_assoc_cm_original'] span a")
    private WebElement originalObject;

    @FindBy(css = "a[title *='Delete Object'] span")
    private WebElement deleteObjectLink;

    @FindBy(css = "div[id='message'] > div.bd > span[class='message']")
    private WebElement deleteObjectNotPossibleMessage;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    private WebElement deleteObjectConfirm;

    @FindBy(css = "div[id *='references-cntrl-picker-selectedItems'] table")
    private WebElement targetReferencesEmpty;

    @FindBy(css = "div.create-reference-to a")
    private WebElement outgoingReferences;

    @FindBy(css = "h2[id*='relationships']")
    private WebElement relationsDropButton;

    @FindBy(xpath = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'References')]/div[@class='divCell']//a")
    private List<WebElement> referenceList;

    //	@FindBy(xpath = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'References')]/div[@class='divCell']//a")
    //	private List<WebElement> referencesList;

    //	@FindBy(css = "div[id $= 'references-cntrl-picker-left'] tr[class *= 'dt-rec']")
    //	private List<WebElement> referenceAvailableList;

    @FindBy(css = "//h3[@id='relationships_element_title_2']/following-sibling::div[contains(.,'Correlation')]/div[@class='divCell']//a")
    private List<WebElement> correlations;

    private String referencesListXpathSelector = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'References')]/div[@class='divCell']//a";
    private String referencesNamesCssSelector = " h3 a";
    private String referenceAvailableListCssSelector = "div[id $= 'references-cntrl-picker-left'] tr[class *= 'dt-rec']";
    private String folderReferenceAvailableListCssSelector = "div[id $= 'references-cntrl-picker-left'] tr[class *= 'dt-rec'] h3>a";

    private String correlationListXpathSelector = "//h3[@id='relationships_element_title_2']/following-sibling::div[contains(.,'Correlation')]/div[@class='divCell']//a";
    private String corrleatedItemsListXpathSelector = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'Correlation')]/div[@class='divCell']//a";
    private String relationTwisterCssSelector = "div[class='document-details-panel'] h2[class*='thin dark alfresco-twister alfresco-twiste']";

    @FindBy(xpath = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'Correlation')]/div[@class='divCell']//a")
    private WebElement correlationsList;

    @FindBy(css = "div[id$='default-formContainer'] span.viewmode-label")
    private List<WebElement> propertiesLabelList;

    @FindBy(css = "div[id$='default-formContainer'] span.viewmode-value")
    private List<WebElement> propertiesValuesList;

    @FindBy(css = "div[id*='folder-details'] div[id$='latestVersion'] span.document-version")
    private WebElement latestVesrion;
    
	@FindBy(css = "div[id$='default-formContainer'] span.viewmode-value")
	private List<WebElement> propertiesValueList;
	
	@FindBy(css = "button[id*='createContent-button-button']")
	private WebElement createButton;
	
	@FindBy(css = "div.create-content div.bd ul li a span.hmh-learning-object-file")
	private WebElement createLearningObject;
	
	@FindBy (css = "div[class$='version'] a span")
	private WebElement versionButton;
	
	//Habitat Elements
	
	@FindBy (css = "div.publish-to-habitat a")  //div.publish-to-habitat a span || div[id*='habitat'] a[title *='Push to Habitat'] span  || div[class$='Push To Habitat'] a span
	private WebElement pushToHabitat;
	
	@FindBy(css = "div.set-bordered-panel-body span.viewmode-label") // div.set-bordered-panel-body span ||
	private List<WebElement> habitatMetaDataProperty;
	
	@FindBy(css = "div.set-bordered-panel-body span.viewmode-value") // div.set-bordered-panel-body span ||
	private List<WebElement> habitatMetaDataValue;
	
	@FindBy (xpath = ".//*[@id='template_x002e_folder-metadata_x002e_folder-details_x0023_default-formContainer-form-fields']/div[10]/div/div[1]")
	private WebElement habitatMetaDataText;
	
	@FindBy (css = "div.pull-habitat a")  //div.pull-habitat a span
	private WebElement habitatPull;
	
	@FindBy (css = "div.bd div.set legend")  //div.set legend  div.bd div.set legend
	private WebElement habitatPullLoginLegend;
	
	@FindBy (css= "div.form-fields label")   //
	private WebElement habitatLoginTitles;
	
	@FindBy (css= "div.form-fields input[name*='userName']")   //
	private WebElement habitatUSERInput;
	
	@FindBy (css= "div.form-fields input[name*='password']")   //
	private WebElement habitatPWDInput;
	
	@FindBy (css= "//button[contains(text(),'OK')]")
	private WebElement habitatPullOK;
	
	@FindBy(css = "div[id*='folder-details'] div[id$='latestVersion'] span.document-version")
	private WebElement isPublishedtoHabitat;


    public void outgoingReferencesClick() {
        element(outgoingReferences).waitUntilVisible();
        outgoingReferences.click();
    }

    public void checkCorrelationIsVisible(final String correlationName) {
        Boolean found = false;
        if (correlationsList.getText().contains(correlationName)) {
            found = true;
            correlationsList.click();
        }
        Assert.assertTrue("The correlation was not found", found);
    }

    public void clickOnReference(final String referenceName) {
        boolean found = false;

        String status = "";
        WebElement relationTwister = getDriver().findElement(
                By.cssSelector(relationTwisterCssSelector));
        status = relationTwister.getAttribute("class");
        if (status.contains("closed")) {
            relationsDropButton.click();
        }

        waitForRenderedElementsToBePresent(By.xpath(referencesListXpathSelector));
        Serenity.takeScreenshot();
        waitABit(2000);
        for (WebElement reference : referenceList) {
            //        for (WebElement reference : getDriver().findElements(By.xpath(referencesListXpathSelector))) {
            System.out.println("Referinta este: " + reference.getText());
            if (reference.getText().toLowerCase().contains(referenceName.toLowerCase())) {
                reference.click();
                found = true;
                break;
            }
        }
        Assert.assertTrue("The reference was not found", found);
    }

    public void checkIfStandardWasCorrelatedToItemAndClickOnIt(String itemName) {
        boolean found = false;
        relationsDropButton.click();
        //        relationsDropButton.click();
        relationsDropButton.click();
        waitForRenderedElementsToBePresent(By.xpath(corrleatedItemsListXpathSelector));
        Serenity.takeScreenshot();
        waitABit(2000);
        for (WebElement item : getDriver().findElements(By.xpath(corrleatedItemsListXpathSelector))) {
            //        for (WebElement reference : getDriver().findElements(By.xpath(referencesListXpathSelector))) {
            System.out.println("Referinta este: " + item.getText());
            if (item.getText().toLowerCase().contains(itemName.toLowerCase())) {
                item.click();
                found = true;
                break;
            }
        }
        Assert.assertTrue("The reference was not found", found);
    }

    //    correlationListXpathSelector
    public void clickOnCorrelation(final String correlationName) {
        boolean found = false;
        String status = "";

        WebElement relationTwister = getDriver().findElement(
                By.cssSelector(relationTwisterCssSelector));

        status = relationTwister.getAttribute("class");

        System.out.println("Status este: " + status);

        if (status.contains("closed")) {
            relationsDropButton.click();
        }

        //        relationsDropButton.click();
        waitForRenderedElementsToBePresent(By.xpath(correlationListXpathSelector));

        Serenity.takeScreenshot();

        waitABit(4000);

        for (WebElement correlation : getDriver().findElements(By.xpath(correlationListXpathSelector))) {
            //        for (WebElement reference : getDriver().findElements(By.xpath(referencesListXpathSelector))) {
            System.out.println("Referinta este: " + correlation.getText());
            if (correlation.getText().toLowerCase().contains(correlationName.toLowerCase())) {
                System.out.println(" 2 Referinta este: " + correlation.getText());
                found = true;
                correlation.click();
                break;
            }
        }
        Assert.assertTrue("The correlation was not found", found);

    }

    public void checkObjectCanNotBeDeleted(final String message) {
        element(deleteObjectNotPossibleMessage).waitUntilVisible();
        boolean found = false;
        if (deleteObjectNotPossibleMessage.getText().toLowerCase().contains(message.toLowerCase())) {
            found = true;
        }
        Assert.assertTrue("The object with the reference was deleted!!", found);
    }

    public void deleteObject() {
        element(deleteObjectLink).waitUntilVisible();
        deleteObjectLink.click();
        element(deleteObjectConfirm).waitUntilVisible();
        deleteObjectConfirm.click();
        System.out.println("Am dat click pe buton");
    }
    public void selectReferenceFolder(final String folderName ) {
        boolean found = false;
        waitABit(1000);
        waitForRenderedElementsToBePresent(By.cssSelector(folderReferenceAvailableListCssSelector));
        Serenity.takeScreenshot();

        for (WebElement folderaspect : getDriver().findElements(By.cssSelector(folderReferenceAvailableListCssSelector))) {
            System.out.println(folderaspect.getText());
            element(folderaspect).waitUntilVisible();
            
            if (folderaspect.getText().toLowerCase().contains(folderName.toLowerCase())) {
                WebElement clickFolder = folderaspect.findElement(By.cssSelector("div[id $= 'references-cntrl-picker-left'] tr[class *= 'dt-rec'] h3>a"));
                found = true;
                clickFolder.click();
                Serenity.takeScreenshot();
                break;
            }
        }
        Assert.assertTrue("The reference folder was not found", found);
      //  applyReferenceButton.click();
    }
    public void clickItemInReferencesPane(final String itemName) {
        boolean found = true;
        waitABit(1000);
        waitForRenderedElementsToBePresent(By.cssSelector(referenceAvailableListCssSelector));
        Serenity.takeScreenshot();
        for (WebElement aspect : getDriver().findElements(By.cssSelector(referenceAvailableListCssSelector))) {
            System.out.println(aspect.getText());
            element(aspect).waitUntilVisible();
            if (aspect.getText().toLowerCase().contains(itemName.toLowerCase())) {
                WebElement navigate = aspect.findElement(By.cssSelector(referencesNamesCssSelector));
                found = true;
                navigate.click();
                Serenity.takeScreenshot();
                break;
            }
        }
        Assert.assertTrue("The reference was not found", found);

    }

    public void selectReference(final String referenceName) {
        boolean found = false;
        waitABit(1000);
        waitForRenderedElementsToBePresent(By.cssSelector(referenceAvailableListCssSelector));
        Serenity.takeScreenshot();

        for (WebElement aspect : getDriver().findElements(By.cssSelector(referenceAvailableListCssSelector))) {
            System.out.println(aspect.getText());
            element(aspect).waitUntilVisible();
            if (aspect.getText().toLowerCase().contains(referenceName.toLowerCase())) {
                WebElement addB = aspect.findElement(By.cssSelector("td > div > a > span.addIcon"));
                found = true;
                addB.click();
                Serenity.takeScreenshot();
                break;
            }
        }
        Assert.assertTrue("The reference was not found", found);
        applyReferenceButton.click();
    }
    
    
    public void clickOnManageReferenceLink() {
        element(manageReferencesActionLink).waitUntilVisible();
        manageReferencesActionLink.click();
    }

    public void checkIfReferenceWasAdded(final String itemName) {
        boolean found = false;
        waitABit(3000);

        List<WebElement> listOfReferences = getDriver().findElements(By.cssSelector("div[id $= 'references-cntrl-picker-right'] tr[class *= 'dt-rec']"));

        for (WebElement ref : listOfReferences) {
            element(ref).waitUntilVisible();
            if (ref.getText().toLowerCase().contains(itemName.toLowerCase())) {
                found = true;
                LOG.info(itemName+"Reference found");
                break;
               
            }
        }
        Assert.assertTrue("The asset was not found", found);
    }

    public void deleteReference(final String itemName) {
        boolean found = false;
        waitABit(3000);
        for (WebElement aspect : selectedReferencesList) {
            element(aspect).waitUntilVisible();
            WebElement remove = aspect.findElement(By.cssSelector("td > div > a > span.removeIcon"));
            if (aspect.getText().toLowerCase().contains(itemName.toLowerCase())) {
                found = true;
                remove.click();
                break;
            }
        }
        Assert.assertTrue("The asset was not found", found);
        applyReferenceButton.click();
    }

    public void checkIfTheReferencesAreRemoved() {
        boolean empty = false;
        element(emptyReferences).waitUntilVisible();
        if (emptyReferences.getText().contains("No items selected")) {
            empty = true;
        }
        Assert.assertTrue("the refenreces list is not empty", empty);
    }

    public void checkDerivedFrom(final String object) {
        boolean found = true;
        element(derivedFromLabel).waitUntilVisible();
        if (originalObject.getText().toLowerCase().contains(object.toLowerCase())) {
            found = true;
        }
        Assert.assertTrue("The derived from object is not displayed", found);
    }

    public void checkIfIncomingReferenceWasAdded(String referencedItem) {
        boolean found = false;
        String status = "";
        WebElement relationTwister = getDriver().findElement(
                By.cssSelector(relationTwisterCssSelector));
        status = relationTwister.getAttribute("class");
        if (status.contains("closed")) {
            relationsDropButton.click();
        }
        waitForRenderedElementsToBePresent(By.xpath(referencesListXpathSelector));
        Serenity.takeScreenshot();
        waitABit(2000);
        for (WebElement reference : referenceList) {
            System.out.println("Referinta este: " + reference.getText());
            if (reference.getText().toLowerCase().contains(referencedItem.toLowerCase())) {
                found = true;
                break;
            }
        }
        Assert.assertTrue("The reference was not found", found);
    }

    public void verifyHMHPropertyValue(final String propertyName,
            final String propertyValue) {
        boolean match = false;
        for (int i = 0; i < propertiesLabelList.size(); i++) {
            if (propertiesLabelList.get(i).getText().contains(propertyName)) {
                if (propertiesValuesList.get(i).getText().contains(propertyValue)) {
                    match = true;
                    break;
                }
            }
        }

        Assert.assertTrue(String.format(
                "The value of document '%s' property is '%s'!", propertyName,
                propertyValue), match);
    }

    public void checkLatestVersion(String version) {
        boolean latestVersionCorrect = false;
        element(latestVesrion).waitUntilVisible();
        if (latestVesrion.getText().contains(version)) { //if (latestVesrion.getText().equalsIgnoreCase(version)) {
            latestVersionCorrect = true;
        }
        Assert.assertTrue("The latest version is not correct", latestVersionCorrect);
    }
    
    public void verifyPropertyValue(final String propertyName,
			final String propertyValue) {
		boolean match = false;
		for (int i = 0; i < propertiesLabelList.size(); i++) {
			if (propertiesLabelList.get(i).getText().contains(propertyName)) {
				if (propertiesValueList.get(i).getText().toLowerCase()
						.contentEquals(propertyValue.toLowerCase())) {
					match = true;
					break;
				}
			}
		}
		Assert.assertTrue(String.format(
				"The value of document '%s' property is '%s'!", propertyName,
				propertyValue), match);
	}
    
    public void createLOfork12() {
        element(createButton).waitUntilVisible();
        createButton.click();
        createLearningObject.click();
        System.out.println("clicked on Learning Object Button");
    }
    
    public void clickonVersion() {
        element(versionButton).waitUntilVisible();
        versionButton.click();
        System.out.println("Version");
    }

    
    //pushToHabitat
    
    public void pushToHabitat() {
        
    	element(pushToHabitat).waitUntilVisible();
    	pushToHabitat.click();
        System.out.println("clicked on PUSH to habitat button");
    	
    }
 
  //  waitForPush Habitat status
    
 public void waitUntilPushToHabitatDone() {
     String habitatMetaData ="Habitat Specific Metadata";
     element(latestVesrion).waitUntilVisible();
	 boolean done = false;
        
        while( !done){
        	getDriver().navigate().refresh();
            if(habitatMetaDataText.isDisplayed()){
            habitatMetaDataText.getText().contains(habitatMetaData);
            System.out.println("habitatMetaData Found");
            done=true;
            }else
            	waitABit(5000);
        }
    	
        Assert.assertTrue("The Habitat metadata not found in 5 minutes", done);
    }
    
//    public void waitForZipToFinishExtract(final String zipAsset) {
//        int nr = getNumberOfItemsOnPage();
//        boolean gone = false;
//        int counter = 0;
//        waitABit(1000);
//        while ((gone == false) && (counter < 35) && (nr > 0)) {
//            for (final WebElement element : assetList) {
//                if (!element.getText().contains(zipAsset.toLowerCase())) {
//                    gone = true;
//                    break;
//                }
//            }
//            waitABit(6000);
//            refreshPage();
//            counter++;
//            nr = getNumberOfItemsOnPage();
//        }
//        Assert.assertTrue("The zip file hasn't dissapeard in more than 3 minutes", counter < 30);
//    }

    
    
    
    //verifyPushTohabitatStatus
    
    public void verifyPushTohabitatStatus(final String propertyName,
    		final String propertyValue) {
			boolean match = false;
			for (int i = 0; i < habitatMetaDataProperty.size(); i++) {
				if (habitatMetaDataProperty.get(i).getText().contains(propertyName)) {
					if (habitatMetaDataValue.get(i).getText().toLowerCase()
						.contentEquals(propertyValue.toLowerCase())) {
						match = true;
						break;
				}
			}
		}
		Assert.assertTrue(String.format("Result:", propertyName, propertyValue), match);
	}
   

    
    //habitatPull
    //habitatPullLoginLegend
    //habitatPullOK
    
    public void clickHabitatPull() {
        
    	element(habitatPull).waitUntilVisible();
    	habitatPull.click();
    	
    }
    
    public void checkHabitatLoginPopup() {
        boolean legend = false;
        element(habitatPullLoginLegend).waitUntilVisible();
        if (habitatPullLoginLegend.getText().contains("Habitat Login")) {
            legend = true;
        }
        Assert.assertTrue("Habitat Login popup for Pull", legend);
    }
    public void habitatLoginForPull(final String habitatUserName, final String habitatPassword ) {
      
    	element(habitatLoginTitles).waitUntilVisible();
    	boolean usernameFound = false;
    	boolean passwordFound = false;
    	
    	habitatUSERInput.clear();
    	habitatUSERInput.sendKeys(habitatUserName);
    	habitatPWDInput.clear();
    	habitatPWDInput.sendKeys(habitatUserName);
    	
    	habitatPullOK.click();
    	 System.out.println("Successfully Pulled From Habitat");
    }
}   
    
    
    
    
    
//     <span>Download as Zip</span>
//    <span>Habitat Pull & Version</span>
//    <span>Generate ePub</span>
//    <span>Copy to...</span>
//    <span>Move to...</span>
//    <span>Delete Folder</span>
//    <span>Manage Aspects</span>
//    <span>Change Type</span>
//    <span>Sync to Cloud</span>
//    <span>Generate Annotation Summary</span>
//    <span>Edit Sequence</span>
//    <span>Outgoing References</span>
//    <span>Incoming References</span>
//    <span>Correlations</span>
//    <span>Version</span>
//    <span>Generate Snapshot</span>
//    <span>Generate Report</span>
//    <span>View in Node Browser</span> 



