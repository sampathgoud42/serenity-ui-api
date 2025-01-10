package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHDocumentDetailsPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHDocumentDetailsSteps extends AbstractSteps<HMHDocumentDetailsPage> {

    private static final long serialVersionUID = -854602134541078184L;

    public HMHDocumentDetailsSteps(final Pages pages) {
        super(pages, HMHDocumentDetailsPage.class);
    }

    @Step("Create reference")
    public void selectReference(final String referenceName) {
        currentPage().selectReference(referenceName);
    }

    @Step("Check correlation is present in document details page")
    public void checkCorrelationIsVisible(final String correlationName) {
        currentPage().checkCorrelationIsVisible(correlationName);
    }

    @Step("Click on manage references link")
    public void clickOnManageReferenceLink() {
        currentPage().clickOnManageReferenceLink();
    }

    @Step("Click on outgoing references")
    public void outgoingReferencesClick() {
        currentPage().outgoingReferencesClick();
    }

    @Step("Check if refernece was added")
    public void checkIfReferenceWasAdded(final String itemName) {
        currentPage().checkIfReferenceWasAdded(itemName);
    }

    @Step("Check if reference is present in Document Details Page")
    public void clickOnReference(final String referenceName) {
        currentPage().clickOnReference(referenceName);
    }

    @Step("Check if correlation is present in Document details page and click on it")
    public void clickOnCorrelation(final String correlationName) {
        currentPage().clickOnCorrelation(correlationName);
    }

    @Step("Check if standard was correlated to Item and click on it")
    public void checkIfStandardWasCorrelatedToItemAndClickOnIt(String itemName) {
        currentPage().checkIfStandardWasCorrelatedToItemAndClickOnIt(itemName);
    }

    @Step("Delete Object")
    public void deleteObject() {
        currentPage().deleteObject();
    }

    @Step("Check message for not being able to delete an object")
    public void checkObjectCanNotBeDeleted(final String message) {
        currentPage().checkObjectCanNotBeDeleted(message);
    }

    @Step("Navigate in references dialgo box")
    public void clickItemInReferencesPane(String itemName) {
        currentPage().clickItemInReferencesPane(itemName);
    }

    @Step("Delete a reference")
    public void deleteReference(final String itemName) {
        currentPage().deleteReference(itemName);
    }

    @Step("Check if references list is empty")
    public void checkIfReferencesListIsEmpty() {
        currentPage().checkIfTheReferencesAreRemoved();
    }

    @Step("Check derived from object")
    public void checkDerivedFrom(final String object) {
        currentPage().checkDerivedFrom(object);
    }

    @Step("Check if reference to object {0} is present")
    public void checkIfIncomingReferenceWasAdded(final String referencedItem) {
        currentPage().checkIfIncomingReferenceWasAdded(referencedItem);
    }

    @Step("Check if property{0} has the value{1}")
    public void verifyHMHPropertyValue(final String propertyName,
            final String propertyValue) {
        currentPage().verifyHMHPropertyValue(propertyName, propertyValue);
    }

    @Step("Check the latest version is {0}")
    public void checkLatestVersion(String version) {
        currentPage().checkLatestVersion(version);
    }
    
    @Step("Verify that property {0} has value {1}")
	public void verifyPropertyValue(final String propertyName,
			final String propertyValue) {
		currentPage().verifyPropertyValue(propertyName, propertyValue);
	}
    
    @Step("Create Learning Object")
	public void createLOfork12() {
		currentPage().createLOfork12();
	}
    
    @Step("Create Learning Object")
	public void createLOforConsumer() {
		currentPage().createLOfork12();
	}

    @Step("Click on reference folder ")
    public void selectReferenceFolder (final String folderName) {
        currentPage().selectReferenceFolder(folderName);
    }
    
    @Step("Click on reference folder ")
    public void clickonVersion() {
        currentPage().clickonVersion();
    }
    
    @Step("Click on Push to Habitat button ")
    public void pushToHabitat() {
        currentPage().pushToHabitat();
    }
    
    @Step("Wait for Habitat metadata displayed on page ")
    public void waitUntilPushToHabitatDone() {
        currentPage().waitUntilPushToHabitatDone();
    }
    
    @Step("Verify that property {0} has value {1} ")
    public void verifyPushTohabitatStatus(final String propertyName,
    		final String propertyValue) {
        currentPage().verifyPushTohabitatStatus(propertyName, propertyValue);
    }
    
  //pull from Habitat
    @Step("Click on Habitat pull button ")
    public void clickHabitatPull() {
        currentPage().clickHabitatPull();
    }
    
    @Step("Click on popup Habitat pull OK button ")
    public void checkHabitatLoginPopup() {
        currentPage().checkHabitatLoginPopup();
    }
    
    
    @Step("Click on popup Habitat pull OK button ")
    public void habitatLoginForPull(final String habitatUserName, final String habitatPassword) {
        currentPage().habitatLoginForPull(habitatUserName, habitatPassword);
    }
    
    
}
