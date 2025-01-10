package com.hmh.automation.tests;

	import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

	@Story(HMHApplication.ProductSet.class)
	@RunWith(SerenityParameterizedRunner.class)
	@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH62_PullFromHabitatLevelOne.csv", separator = ConstantsHMH.CSV_SEPARATOR)
	public class TestHMH62_PullFromHabitatLevelOne extends com.hmh.automation.tools.AbstractBaseSiteTest {
		
		 @Steps
		    private SiteHeaderSteps siteHeaderSteps;
		    @Steps
		    private DocumentLibrarySteps documentLibrarySteps;
		    @Steps
		    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
		    @Steps
		    private HMHSequenceViewSteps hmhSequenceViewSteps;
		    @Steps
		    private DocumentDetailsSteps documentDetailsSteps;
		    @Steps
		    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
		    @Steps
		    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
		    @Steps
		    private ShareHeaderSteps shareHeaderSteps;

		    String siteTypeTest, folderType, folderName, programAspect, productSetBucket, SequenceBundleBucket, LearningBundleBucket, programType, programName1, title,
		            grade, markets, editSequence, programName2, productSetType, year, levle1, level1Restart, sequenceBundleType, SequenceBundleName,
		            learningBundleType, learningBundleName, lifecycle, learningStyle, interactivityLevel, socialInteraction, outgoing, learningObjectAspect, componentBucketAspect,
		            componentType, compoName, activityType, language, rights,
		            compoLearningObjectType, cloName, productCategory, productType;
		    
		    String habitatProperty ="Is Pushed To Habitat?"; 
		    String habitatStatus = "Yes";
		    String ProductSetName = ConstantsHMH.PREFIX_PRODUCTSET_NAME + RandomStringUtils.randomNumeric(5);
		    								// HABITAT_TEST_USER_LOGIN = "cms.engineering@hmhco.com"; HABITAT_TEST_PASS_LOGIN = "habitatToken";
		    @Override
		    public void setSiteType() {
		        siteType = siteTypeTest;
		    }

		    @Test
		    @Title("TestHMH62_Pull From Habitat functionality level one")
		    public void testHMH62_PullFromHabitatLevelOne() {

		        siteHeaderSteps.clickOnDocumentLibraryButton();
		        documentLibrarySteps.createNewContent(folderType);
		        documentLibrarySteps.createFolder(folderName, "");
		        siteHeaderSteps.clickOnDocumentLibraryButton();
		        documentLibrarySteps.assetFromListClick(folderName);
		        hmhDocumentLibrarySteps.navBarClick();
				shareHeaderSteps.customWait(5);
		        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
		     //   documentLibraryLeftPanelSteps.selectAspectForElement(programAspect);
		        hmhDocumentLibrarySteps.selectAspectForAFolder(productSetBucket);
		        hmhDocumentLibrarySteps.selectAspectForAFolder(SequenceBundleBucket);
		        hmhDocumentLibrarySteps.selectAspectForAFolder(learningObjectAspect);
		        hmhDocumentLibrarySteps.selectAspectForAFolder(componentBucketAspect);
		        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
		        siteHeaderSteps.clickOnDocumentLibraryButton();
		        documentLibrarySteps.assetFromListClick(folderName);
		        documentLibrarySteps.createNewContent(productSetType);
		        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		        hmhDocumentLibrarySteps.createProductSet(ProductSetName, year, grade, levle1, level1Restart, markets, title);
		        hmhDocumentLibrarySteps.refresh();

		        siteHeaderSteps.clickOnDocumentLibraryButton();
		        documentLibrarySteps.assetFromListClick(folderName);
		        shareHeaderSteps.customWait(5);
		        documentLibrarySteps.assetFromListClick(ProductSetName);
		        shareHeaderSteps.customWait(5);
		        hmhDocumentLibrarySteps.navBarClick();
		        shareHeaderSteps.customWait(5);
		        documentDetailsSteps.editSequenceButtonDocumentActionClick(); // documentLibrarySteps.moreActionMenuClick(editSequence, programName1);
		   //////////////       

		     //***Click on ProductSet and create sequence Bundle in edit sequence
		        shareHeaderSteps.customWait(5);
		        hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		   		hmhSequenceViewSteps.clickOnAnElementInTheSequenceView(ProductSetName);
		        shareHeaderSteps.customWait(5);
		        documentLibrarySteps.createNewContent(sequenceBundleType);
		        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		        hmhDocumentLibrarySteps.createSequenceBundle(SequenceBundleName, markets, title);
		   //***Click on Sequence Bundle and create Learning Bundle in edit sequence
		        hmhDocumentLibrarySteps.refresh();
		        hmhSequenceViewSteps.expandTreeInSequenceView();
		        hmhSequenceViewSteps.clickOnAnElementInTheSequenceView(SequenceBundleName);
		        shareHeaderSteps.customWait(5);
		        documentLibrarySteps.createNewContent(compoLearningObjectType);
		        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		        hmhDocumentLibrarySteps.createLearningObjectK12Site(cloName, grade, language, rights, markets, title, lifecycle);
		        
		        hmhDocumentLibrarySteps.refresh();
		        siteHeaderSteps.clickOnDocumentLibraryButton();
		        documentLibrarySteps.assetFromListClick(folderName);
		 
		  //Check references
		        shareHeaderSteps.customWait(5);
		        documentLibrarySteps.assetFromListClick(ProductSetName);
		        shareHeaderSteps.customWait(5);
		        hmhDocumentLibrarySteps.navBarClick();
		        shareHeaderSteps.customWait(5);
		        hmhDocumentDetailsSteps.outgoingReferencesClick();//   documentLibrarySteps.moreActionMenuClick(outgoing, programName1);
		        hmhDocumentDetailsSteps.checkIfReferenceWasAdded(SequenceBundleName);
		        hmhDocumentLibrarySteps.refresh();
		        shareHeaderSteps.customWait(5);
		        
		 //Perform Push to Habitat functionality and verify
		       
		        hmhDocumentDetailsSteps.pushToHabitat();		        
		        siteHeaderSteps.clickOnDocumentLibraryButton();
		        documentLibrarySteps.assetFromListClick(folderName);
		        shareHeaderSteps.customWait(5);
		        documentLibrarySteps.assetFromListClick(ProductSetName);
		        hmhDocumentLibrarySteps.navBarClick();
		        shareHeaderSteps.customWait(5);
		        hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();  // wait until Habitat meta data displayed on page
		        
		   //verify the Habitat value
		       hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		       
		   //Habitat Pull    
		       hmhDocumentLibrarySteps.refresh();
		       hmhDocumentDetailsSteps.clickHabitatPull();
		       hmhDocumentDetailsSteps.checkHabitatLoginPopup();
		       
		       hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		       hmhDocumentLibrarySteps.createLearningObjectK12Site(cloName, grade, language, rights, markets, title, lifecycle);
		       hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		       shareHeaderSteps.customWait(5);
		       hmhDocumentLibrarySteps.refresh();
		       
		    }

}
