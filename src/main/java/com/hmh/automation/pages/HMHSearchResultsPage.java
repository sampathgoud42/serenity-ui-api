package com.hmh.automation.pages;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ixxus.ipm.automation.pages.AbstractPage;

public class HMHSearchResultsPage extends AbstractPage {

    public HMHSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img[src*='generic-learning-bundle']")
    private WebElement learningBundleThumbnail;

    @FindBy(css = "img[src*='generic-program']")
    private WebElement programThumbnail;

    @FindBy(css = "img[src*='generic-product-set']")
    private WebElement productSetThumbnail;

    @FindBy(css = "img[src*='content']")
    private WebElement contentThumbnail;

    @FindBy(css = "img[src*='generic-sequence-bundle']")
    private WebElement sequenceBundleTumbnail;

    public void checkIfThumbnailIsDisplayed(String object) {
        switch (object) {
        case "Learning Bundle":
            Assert.assertTrue("The thumbnail for learning bundle is not displayed", learningBundleThumbnail.isDisplayed());
            break;

        case "Program":
            Assert.assertTrue("The thumbnail for program is not displayed", programThumbnail.isDisplayed());
            break;

        case "Product Set":
            Assert.assertTrue("The thumbnail for product set is not displayed", productSetThumbnail.isDisplayed());
            break;

        case "Sequence Bundle":
            Assert.assertTrue("The thumbnail for sequence bundle is not displayed", sequenceBundleTumbnail.isDisplayed());
            break;

        case "Learning Object":
            Assert.assertTrue("The thumbnail for contnet is not displayed", contentThumbnail.isDisplayed());
            break;

        case "Component":
            Assert.assertTrue("The thumbnail for contnet is not displayed", contentThumbnail.isDisplayed());
            break;
        }
    }
}
