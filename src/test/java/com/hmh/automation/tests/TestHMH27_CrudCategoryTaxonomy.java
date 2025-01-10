package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.CategoryManagerSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Categories.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH27_CRUDCategoryTaxonomy.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH27_CrudCategoryTaxonomy extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private DashboardSteps dashboardSteps;
    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private SiteFinderSteps siteFinderSteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private CategoryManagerSteps categoryManagerSteps;
    @Steps
    private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;

    String categoryName1 = RandomStringUtils.randomNumeric(5), newCategoryName2 = RandomStringUtils.randomNumeric(5), siteTypeTest;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH27 - CrudCategoryTaxonomy")
    public void testHMH27_CrudCategoryTaxonomy() {
        shareHeaderSteps.adminToolsButtonClick();
        categoryManagerSteps.categoryManagerMenuClick();
        categoryManagerSteps.addCategory(categoryName1);
        hmhDocumentLibrarySteps.refresh();
        categoryManagerSteps.checkIfCategoryIsPresent(categoryName1);
        categoryManagerSteps.editCategoryFromCategoryManager(categoryName1, newCategoryName2);
        categoryManagerSteps.checkIfCategoryIsPresent(newCategoryName2);
//        shareHeaderSteps.customWait(3);
//        categoryManagerSteps.deleteCategoryFromCategoryManager(newCategoryName2); //mouse hover build perform
//        shareHeaderSteps.customWait(3);
//        categoryManagerSteps.checkIfCategoryIsNotPresent(newCategoryName2);
        shareHeaderSteps.customWait(3);
        
    }

}
