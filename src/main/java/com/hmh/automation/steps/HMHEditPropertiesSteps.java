package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHEditPropertiesPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHEditPropertiesSteps extends AbstractSteps<HMHEditPropertiesPage> {

    private static final long serialVersionUID = -854601134541075184L;

    public HMHEditPropertiesSteps(Pages pages) {
        super(pages, HMHEditPropertiesPage.class);
    }

    @Step("Edit grade{0} for component")
    public void editGrade(String grade) {
        currentPage().editGrades(grade);
    }

    @Step("Edit right{0} for component")
    public void editRight(String right) {
        currentPage().editRights(right);
    }

    @Step("Edit description{0}")
    public void editDescription(String description) {
        currentPage().editDescription(description);
    }

    @Step("Edit title{0}")
    public void editTitle(String title) {
        currentPage().editTitle(title);
    }

    @Step("Confirm multiple edit propertiesc ")
    public void confirmMultipleEdit() {
        currentPage().confirmMultipleEdit();
    }

    @Step("Edit a learning style{0} in Edit Properties")
    public void editLearningStyles(String style) {
        currentPage().editLearningStyles(style);

    }

    @Step("Edit the lifecycle {0}")
    public void editLifeCycle(String lifecycle) {
        currentPage().editLifeCycle(lifecycle);
    }

    @Step("Edit sub market US {0}")
    public void editSubMarketUS(String subMarket) {
        currentPage().editSubMarketUS(subMarket);
    }

    @Step("Edit sub market International {0}")
    public void editSubMarketInternational(String subMarket) {
        currentPage().editSubMarketInternational(subMarket);
    }

    @Step("Edit the product type id{0}")
    public void editProductTypeID(String id) {
        currentPage().editProductTypeID(id);
    }
    
    @Step("Edit the resource type id{0}")
    public void editResourceType (String resourceType) {
        currentPage().editResourceType(resourceType);
    }
    
//    @Step("Select the HMH keywords - type id{0}")
//    public void editResourceType (String resourceType) {
//        currentPage().editResourceType(resourceType);
//    }
}
