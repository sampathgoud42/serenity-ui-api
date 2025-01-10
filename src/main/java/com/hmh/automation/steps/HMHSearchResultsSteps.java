package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHSearchResultsPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHSearchResultsSteps extends AbstractSteps<HMHSearchResultsPage> {

    private static final long serialVersionUID = -854611134541075184L;

    public HMHSearchResultsSteps(Pages pages) {
        super(pages, HMHSearchResultsPage.class);
    }

    @Step("Check HMH thumbnails in searc results list")
    public void checkIfThumbnailIsDisplayed(String object) {
        currentPage().checkIfThumbnailIsDisplayed(object);
    }

}
