package com.hmh.automation.pages;

import java.util.List;
import java.util.UUID;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ixxus.ipm.automation.pages.AbstractPage;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

public class HMHShareHeaderPage extends AbstractPage {

    public HMHShareHeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span[id *= 'HEADER_SITES']")
    private WebElement sitesButton;

    @FindBy(id = "HEADER_SITES_MENU_CREATE_SITE_text")
    private WebElement createSiteHeaderMenuButton;

    @FindBy(css = "input[id*='createSite-instance-title']")
    private WebElement siteName;

    @FindBy(css = "button[id*='createSite-instance-ok']")
    private WebElement createSiteOKButton;

    @FindBy(css = "div[class*='simple-dialog']")
    private WebElement siteNotCreatedPopup;

    @FindBy(css = "span[class*='button-group'] button")
    private WebElement siteNotCreatedPopupOkButton;

    @FindBy(css = "select[id$='instance-sitePreset']")
    private WebElement siteTypeDrop;

    @FindBy(css = "select[id$='instance-sitePreset'] option")
    private List<WebElement> siteTypeOptions;

    private final String siteTitleCssSelector = "#HEADER_TITLE > a";

    public String createNewSite(String siteType) {
        String newSiteName = generateSiteName();
        while (!createNewSite(newSiteName, siteType)) {
            newSiteName = generateSiteName();
        }
        return newSiteName;
    }

    private String generateSiteName() {
        return Constants.PREFIX_SITE + UUID.randomUUID();
    }

    public boolean createNewSite(final String newSiteName, String siteType) {
        boolean siteTypeFound = false;
        element(sitesButton).waitUntilVisible();
        element(By.cssSelector(siteTitleCssSelector)).waitUntilVisible();
        //final String siteTitleBefore = getDriver().findElement(By.cssSelector(siteTitleCssSelector)).getText();
        sitesButton.click();
        element(createSiteHeaderMenuButton).waitUntilVisible();
        createSiteHeaderMenuButton.click();
        element(siteName).waitUntilVisible();
        siteName.click();
        siteName.sendKeys(newSiteName);
        siteTypeDrop.click();
        waitABit(1000);
        for (WebElement type : siteTypeOptions) {
            if (type.getText().toLowerCase().contains(siteType.toLowerCase())) {
                siteTypeFound = true;
                type.click();
                break;

            }
        }
        Assert.assertTrue("The type was not found", siteTypeFound);
        createSiteOKButton.click();
        final WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        final boolean element = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(siteTitleCssSelector), newSiteName));
        //                waitForCreateResult(newSiteName);
        //                if (!onSiteDashboard(getDriver(), newSiteName) && errorPopup()) {
        //                    siteNotCreatedPopupOkButton.click();
        //                    return false;
        //                }
        //                return true;

        //int counter = 0;
        //        waitForPageToLoadCompletely(30);
        //        while (getDriver().findElement(By.cssSelector(siteTitleCssSelector))
        //                .getText().contains(siteTitleBefore) && (counter < 120)) {
        //            waitABit(2000);
        //            counter++;
        //        }
        if (element) {
            return true;
        }
        else {
            element(siteNotCreatedPopupOkButton).waitUntilVisible();
            siteNotCreatedPopupOkButton.click();
            return false;
        }
    }

}
