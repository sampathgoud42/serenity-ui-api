package com.hmh.automation.pages;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ixxus.ipm.automation.pages.AbstractPage;

public class HMHSequenceViewPage extends AbstractPage {

    public HMHSequenceViewPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[id*='collapse-all-button-button']")
    private WebElement colapseAllButton;

    @FindBy(css = "button[id*='go-back-button-button']")
    private WebElement goBackButton;

    @FindBy(css = "div[id='assembly-view-tree-container'] ul li[id^='workspace'] span[class*='dynatree-exp'] a")
    private List<WebElement> sequenceItems;

    @FindBy(css = "div[id*='detailed-list-view-previewer'] tbody[class$='data'] tr td[class*='fileName '] span[class='detailed-list-element']")
    private List<WebElement> galleryViewItems;

    @FindBy(css = "button[id*='default-folderview-button']")
    private WebElement folderView;

    @FindBy(css = "button[id*='view-details-panel-metadata-button-button']")
    private WebElement metadataSequenceViewButton;
    
    @FindBy (css= "button[id*='expand-all-button-button']")
    private WebElement expandAllButton;

    public void folderViewButtonClick() {
        element(folderView).waitUntilVisible();
        folderView.click();
    }

    public void metadataSequenceViewButtonClick() {
        element(metadataSequenceViewButton).waitUntilVisible();
        metadataSequenceViewButton.click();
    }

    public void checkIfOnSequenceViewPage() {
        boolean found = false;
        element(colapseAllButton).waitUntilVisible();

        if (colapseAllButton.isDisplayed()) {
            found = true;
        }
        Assert.assertTrue("You are not on Sequence View Page", found);
    }

    public void goBackClick() {
        goBackButton.click();
    }

    public void checkSequenceTreeStructure(String firstElement, String secondElement, String thirdElement) {
        waitABit(1000);
        boolean orderCorrect = false;
        getDriver().navigate().refresh();
        List<String> myList = new ArrayList<String>();
        for (WebElement item : sequenceItems) {

            myList.add(item.getText());
        }
        if (myList.get(0).contains(firstElement)) {
            if (myList.get(1).contains(secondElement)) {
                if (myList.get(2).contains(thirdElement)) {
                    orderCorrect = true;
                }
            }
        }
        Assert.assertTrue("The order is not correct", orderCorrect);
    }

    public void changeSequenceTreeStructure(String elementToMove, String destination) {
        boolean elementFound = false;
        boolean destinationFound = false;
        Actions newAction = new Actions(getDriver());

        for (WebElement item : sequenceItems) {
            for (WebElement dest : sequenceItems) {
                if (item.getText().toLowerCase().contains(elementToMove.toLowerCase())
                        && dest.getText().toLowerCase().contains(destination.toLowerCase())) {
                    elementFound = true;
                    destinationFound = true;
                    newAction.dragAndDrop(item, dest).perform();
                    System.out.println("MOVE DONE");
                    break;
                }
            }
        }
        Assert.assertTrue("The element to move was not found", elementFound);
        Assert.assertTrue("The destination element was not found", destinationFound);
        System.out.println("MOVE DONE 2");
    }

    public void clickOnAnElementInTheSequenceView(String element) {
        boolean elementFound = false;
        
        for (WebElement item : sequenceItems) {
            if (item.getText().toLowerCase().contains(element.toLowerCase())) {
                elementFound = true;
                item.click();
                break;
            }
        }
        Assert.assertTrue("The item on which you want to click was not found", elementFound);
    }

    public void checkIfElementIsDisplayedInSequenceViewGallery(String elementName) {
        boolean elementFound = false;

        for (WebElement item : galleryViewItems) {
            if (item.getText().toLowerCase().contains(elementName.toLowerCase())) {
                elementFound = true;
                break;
            }
        }

        Assert.assertTrue("The item on which you want to click was not found", elementFound);
    }

    public void expandTreeInSequenceView() {

        element(expandAllButton).waitUntilVisible();
        expandAllButton.click();
        waitABit(1000);

    }

}
