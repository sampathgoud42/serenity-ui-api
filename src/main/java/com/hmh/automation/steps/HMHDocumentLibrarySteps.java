package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHDocumentLibraryPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHDocumentLibrarySteps extends AbstractSteps<HMHDocumentLibraryPage> {

    private static final long serialVersionUID = -854602134541078184L;

    public HMHDocumentLibrarySteps(final Pages pages) {
        super(pages, HMHDocumentLibraryPage.class);
    }

    @Step("Chose option from selected items")
    public void choseOptionFromSelectedItems(final String optionToSelect) {
        currentPage().choseOptionFromSelectedItems(optionToSelect);
    }

    @Step("Select item in document library")
    public void selectItem(final String itemName) {
        currentPage().selectItem(itemName);
    }

//    @Step("Create a Program named {0} with grade{1}")
//    public void createProgram(final String name, final String title, final String grade, String market) {
//        currentPage().createProgram(name, title, grade, market);
//    }

    @Step("Create a Program named {0} with grade{1}")
    public void createProgram(final String name, final String title, String market) {
        currentPage().createProgram(name, title, market);
    }
    
    @Step("Select hnh EditProperties")
    public void hmhEditPropertiesClick(final String asset) {
        currentPage().hmhEditPropertiesClick(asset);
    }

    @Step("Click create button when mandatory fields are not filled")
    public void createObjectWhenNotAllMandatoryMetadataFieldsAreFilled() {
        currentPage().createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
    }

    @Step("Check if message for duplicate file name is displayed")
    public void duplicataNameMessageShow() {
        currentPage().duplicataNameMessageShow();
    }

    @Step("Create product set {0}")
    public void createProductSet(final String name, final String year, final String grade, final String levle1, final String level1Restart,
            final String market, final String title) {
        currentPage().createProductSet(name, year, grade, levle1, level1Restart, market, title);
    }

    @Step("Create Sequence bundle {0}")
    public void createSequenceBundle(final String name, final String market, final String title) {
        currentPage().createSequenceBundle(name, market, title);
    }

    @Step("Create Learinig bundle {0} in Consumer Site")
//    public void createLearningBundleConsumerSite(final String name, final String grade, final String market, final String lifecycle,
//            final String learningStyle, final String interactivityLevel, final String socialInteraction, final String title) {
    public void createLearningBundleConsumerSite(final String name, final String grade, 
    		  final String market, final String title) {
        
    	currentPage().createLearningBundleConsumerSite(name, grade, market, title);
    }

    @Step("Create Learning Bundle {0} in K-12 Site")
    public void createLearningBundleK12Site(final String name, final String title, final String lifecycle, final String market, final String grade) {
        currentPage().createLearningBundleK12Site(name, title, lifecycle, market, grade);
    }

    @Step("Create Learning object {0} in Consumer Site")
    public void createLearningObjectConsumerSite(
    		final String name, final String grade,
            final String rights, final String market, 
            final String title) {
        currentPage().createLearningObjectConsumerSite(name, grade,
                rights, market, title);
    }

    @Step("Create Component {0} in Consumer Site")
    public void createComponentConsumerSite(final String name, final String title, final String rights,
            final String grade, final String lifecycle, final String resourceType) {
        currentPage().createComponentConsumerSite(name, title, rights, grade, lifecycle,resourceType);
    }

    @Step("Create Component {0} in K-12 Site")
//    public void createComponentK12Site(final String name, final String title, final String rights, final String grade, final String language,
//            final String lifeCycle, final String activityType) {
    public void createComponentK12Site(final String name, final String title, final String rights, final String grade, final String lifeCycle) {
        currentPage().createComponentK12Site(name, title, rights, grade, lifeCycle);
    }

    @Step("Wait for extract to complete")
    public void waitForZipToFinishExtract(String assetExtracted) {
        currentPage().waitForZipToFinishExtract(assetExtracted);
    }

    @Step("Navigate to a standard in correlatons dialog box")
    public void clickItemInCorrelationsPane(String standardName) {
        currentPage().clickItemInCorrelationsPane(standardName);
    }

    @Step("Select a standard to correlate")
    public void selectStandardToCorrelate(String standard) {
        currentPage().selectStandardToCorrelate(standard);
    }

    @Step("Check if standard was added")
    public void checkIfStandardWasAdded(String standard) {
        currentPage().checkIfStandardWasAdded(standard);
    }

    @Step("Remove an added correlation")
    public void removeACorrelation(String standard) {
        currentPage().removeACorrelation(standard);
    }

    @Step("Check if there are no correlations")
    public void checkIfThereAreNoCorrelations() {
        currentPage().checkIfThereAreNoCorrelations();
    }

    @Step("Delete HMH keword")
    public void deleteTagFromDocLibViewHMH(final String assetName, final String tagName) {
        currentPage().deleteTagFromDocLibView(assetName, tagName);
    }

    @Step("Check message for no spreadSheet in zip file")
    public void checkExtractErrorMessage(String message) {
        currentPage().checkExtractErrorMessage(message);
    }

    @Step("Click on refresh button")
    public void refresh() {
        currentPage().refresh();
    }

    @Step("Create Learning Object{0} in K-12 Site")
    public void createLearningObjectK12Site(final String name, final String grade, final String language,
            final String rights, final String market, final String title, final String lifecycle) {
        currentPage().createLearningObjectK12Site(name, grade, language, rights, market, title, lifecycle);
    }

    @Step("Check if message for publishing action is displayed")
    public void checkPublishMessage() {
        currentPage().checkPublishMessage();
    }

    @Step("Select {0}")
    public void selectAnItemFromSelectedItemsDropDown(String actionName) {
        currentPage().selectAnItemFromSelectedItemsDropDown(actionName);
    }
    
    //Added by Sampath - CognizantQA
    @Step("Refresh page to exit from - item moved popup")
    public void refreshToExitPopup() {
    	currentPage().refreshToExitPopup();
    }
    
    @Step("Click on folder to view the content")
    public void clickOnFolder() {
    currentPage().clickOnFolder();	
    
    }
    
    @Step("Click on View Detials for folder {0}")
	public void viewDetailsClick(final String assetName) {
		currentPage().viewDetailsClick(assetName);
	}

    @Step("Click on different actions from MoreActions Menu")
	public void moreActionMenuClick(final String menuOption,
			final String itemName) {
		currentPage().moreActionMenuClick(menuOption, itemName);
	}
    
    @Step("Click on asset name (exact title)")
	public void assetFromListClickSub(final String assetName) {
		currentPage().assetFromListClickSub(assetName);
	}
    @Step("Click on Delete Object Button")
	public void clickDeleteObject() {
		currentPage().clickDeleteObject();
	}
    @Step("Click on Delete Object Button")
	public void clickDeleteFolder() {
		currentPage().clickDeleteFolder();
	}
    @Step("Confirm delete")
	public void confirmDelete() {
		currentPage().confirmDelete();
	}
    
    @Step("Filter by category {0}")
	public void filterByCategory(final String categoryName) {
		currentPage().filterByCategory(categoryName);
	}
    
    @Step("Click on Move to.. button")
    public void clickMoveto() {
    	currentPage().clickMoveto();
    }
    
    @Step("Click on Extract button")
    public void clickExtract() {
    	currentPage().clickExtract();
    }
    
    @Step("Click on Navigation bar to view the details")
    public void navBarClick() {
    	currentPage().navBarClick();
    }
    
    @Step("Select all items on document library")
	public void selectAllItems() {
		currentPage().selectAllItems();
	}
    
    @Step("Click on Coorrelations in view details page")
  	public void clickCorrelations() {
  		currentPage().clickCorrelations();
  	}
    
    @Step("Select an aspect for a folder")
	public void selectAspectForAFolder(String aspectName) {
		currentPage().selectAspectForAFolder(aspectName);
	}
}
