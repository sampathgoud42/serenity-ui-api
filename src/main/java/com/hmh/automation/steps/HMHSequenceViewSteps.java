package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHSequenceViewPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHSequenceViewSteps extends AbstractSteps<HMHSequenceViewPage> {

    private static final long serialVersionUID = -854602132341076184L;

    public HMHSequenceViewSteps(Pages pages) {
        super(pages, HMHSequenceViewPage.class);
    }

    @Step("Select folder view in Edit Sqeuence View")
    public void folderViewButtonClick() {
        currentPage().folderViewButtonClick();
    }

    @Step("Click Metadata button in Edit Sequence view")
    public void metadataButtonClickInEditSqeuence() {
        currentPage().metadataSequenceViewButtonClick();
    }

    @Step("Check if current page is Sequence View")
    public void checkIfOnSequenceViewPage() {
        currentPage().checkIfOnSequenceViewPage();
    }

    @Step("Go Back button click")
    public void goBackClick() {
        currentPage().goBackClick();
    }

    @Step("Move element {0} in element {1}")
    public void changeSequenceTreeStructure(String item, String dest) {
        currentPage().changeSequenceTreeStructure(item, dest);
    }

    @Step("Check if order is correct in Sequence View")
    public void checkSequenceTreeStructure(String firstItem, String secondItem, String thirdItem) {
        currentPage().checkSequenceTreeStructure(firstItem, secondItem, thirdItem);
    }

    @Step("Click on an element in the tree view")
    public void clickOnAnElementInTheSequenceView(String element) {
        currentPage().clickOnAnElementInTheSequenceView(element);
    }

    @Step("Check if an element is present in the galleri view for a sequence")
    public void checkIfElementIsDisplayedInSequenceViewGallery(String elementName) {
        currentPage().checkIfElementIsDisplayedInSequenceViewGallery(elementName);
    }
    
    @Step("Expand Tree in Sequence View")
    public void expandTreeInSequenceView() {
        currentPage().expandTreeInSequenceView();
    }
    
}
