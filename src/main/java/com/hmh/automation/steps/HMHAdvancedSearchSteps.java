package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHAdvancedSearchPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHAdvancedSearchSteps extends AbstractSteps<HMHAdvancedSearchPage> {

    private static final long serialVersionUID = 2288209712204716852L;

    public HMHAdvancedSearchSteps(final Pages pages) {
        super(pages, HMHAdvancedSearchPage.class);
    }

    @Step("Select a hmh keyword in Advanced search")
    public void selectHMHKewordsInAdvancedSearch(String hmhKey) {
        currentPage().selectKeyword(hmhKey);
    }

    @Step("Select a grade in Advanced Search ")
    public void selectGradeInAdvancedSearch(String grade) {
        currentPage().selectGradeInAdvancedSearch(grade);
    }

    @Step("Select lifecycle in Advanced Search")
    public void selectLifeCycleInAdvancedSearch(String life) {
        currentPage().selectLifeCycleInAdvancedSearch(life);
    }

    @Step("Select Product type in Advanced search")
    public void selectProductTypeInAdvancedSearch(String type) {
        currentPage().selectProductTypeInAdvancedSearch(type);
    }

    @Step("Select year in Advanced Search")
    public void selectYearInAdvancedSearch(String year) {
        currentPage().selectYearInAdvacnedSearch(year);
    }

    @Step("Select all items in search results")
    public void selectAllItemsInSearchResults() {
        currentPage().selectAllItemsInSearchResults();
    }

    @Step("Select {0} action to perform it on selected results")
    public void performActionOnSelectedResults(String action) {
        currentPage().performActionOnSelectedResults(action);
    }
}
