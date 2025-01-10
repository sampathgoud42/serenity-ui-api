package com.hmh.automation.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//import com.ixxus.ipm.automation.alfresco.Test22_SearchAllTaggedItemsByClickedTagLink;

import com.hmh.automation.tests.TestHMH01_Login;
import com.hmh.automation.tests.TestHMH03_SavedSearchDashlet;
import com.hmh.automation.tests.TestHMH15_EditAssociationsForAStructuralObject;
import com.hmh.automation.tests.TestHMH17_CreateSequenceBundle;
import com.hmh.automation.tests.TestHMH18_CreateProgram;
import com.hmh.automation.tests.TestHMH19_CreateProductSet;
import com.hmh.automation.tests.TestHMH20_CreateComponent;
import com.hmh.automation.tests.TestHMH21_CreateLearningBundle;
import com.hmh.automation.tests.TestHMH22_CreateLearningObject;
import com.hmh.automation.tests.TestHMH52_CreateProgramK12Site;
import com.hmh.automation.tests.TestHMH53_CreateLearningObjectK12Site;
import com.hmh.automation.tests.TestHMH59_CreateCompositeLearningObject;

@RunWith(Suite.class)
@SuiteClasses({

 //BVT-Smoke Test Suite
	
	    TestHMH01_Login.class,
	    TestHMH17_CreateSequenceBundle.class,
	    TestHMH18_CreateProgram.class,
	    TestHMH19_CreateProductSet.class,
	    TestHMH20_CreateComponent.class,
	    TestHMH21_CreateLearningBundle.class,
	    TestHMH22_CreateLearningObject.class,
	    TestHMH59_CreateCompositeLearningObject.class,
	    TestHMH52_CreateProgramK12Site.class,
	    TestHMH53_CreateLearningObjectK12Site.class,
	    TestHMH03_SavedSearchDashlet.class,                  //Upload Functionality
        TestHMH15_EditAssociationsForAStructuralObject.class, // Reference Functionality covered
 
        

  /*	       //Vanilla Alfresco Tests
        Test07_DocumentDetailsUploadNewVersion.class,
        Test15_VersionHistorySection.class,
        Test26_ExpandSearch.class,
        // Test22: NOT FOUND -- therefore commented out
        //Test22_SearchAllTaggedItemsByClickedTagLink.class,
        Test27_FavouriteSite.class,
        Test30_CrudMetadata.class,
        Test31_FavoriteObjects.class,
        Test33_AdvancedSearch_Mime.class,      */                  

  //HMH Regression Test Suite
        
        /*TestHMH01_Login.class,
        TestHMH02_InviteUsersToMySiteAsDiffrentRoles.class,
        TestHMH03_SavedSearchDashlet.class,
        TestHMH04_SearchAllTaggedItemsByClickedTagLink.class,
        TestHMH05_AdvancedSearch_Mime.class,
        TestHMH06_ExitSequenceView.class,
        TestHMH07_SequenceViewForProgram.class,
        TestHMH08_SequenceViewForProductSet.class,
        TestHMH09_SequenceViewForSequenceBundle.class,
        TestHMH10_SequenceViewForLearningBundle.class,
        TestHMH11_SequenceViewForLearningObject.class,
        TestHMH12_SequenceViewForComponent.class,
        TestHMH13_DeleteStructuralObject.class,
        TestHMH14_EditSequenceForAStructuralObject.class,
        TestHMH15_EditAssociationsForAStructuralObject.class,
        TestHMH16_DeleteAssociationsForAStructuralObject.class, //pass (need to ad a step to verify
        TestHMH17_CreateSequenceBundle.class,
        TestHMH18_CreateProgram.class,
        TestHMH19_CreateProductSet.class,
        TestHMH20_CreateComponent.class,
        TestHMH21_CreateLearningBundle.class,
        TestHMH22_CreateLearningObject.class,
        TestHMH23_FilterByCategory.class,
        TestHMH24_RemoveCategory.class,
        TestHMH25_AddUserToGroup.class,
        TestHMH26_CreateGroup.class,
        TestHMH27_CrudCategoryTaxonomy.class,
        TestHMH28_UploadNewVersion.class,
        TestHMH29_ViewMetadataInEditSequence.class,
        TestHMH30_AdvancedSearchForStructuralObject.class,
        TestHMH31_MoveObject.class,
        TestHMH32_EditPropertiesForMoreThanOneObject.class,  //**pass but not consistent
        TestHMH33_SortResultsInSearchResultsList.class,
        TestHMH34_PerformActionsOnItemsInSearchResultsList.class,
        TestHMH35_FilterSearchResults.class,
        TestHMH36_FilterByHMHKeywords.class,
        TestHMH37_ChangeTheTypeOfAnObject.class,
        TestHMH38_BulkUploadZip.class,                   //**Adobe action script problem
        TestHMH39_DeleteReferenceObject.class,
        TestHMH40_NavigateToSourceReference.class,
        TestHMH41_QuickSearch.class,
        TestHMH42_Annotations.class,           		 //**Looks like Annotations not yet implemented as of 08/31/2015 "connect to server failed unable to get annotations"
        TestHMH43_CreateCorrelations.class,
        TestHMH44_DataLists.class,
        TestHMH45_DeleteObjectAndCheckThatCorrelationWasRemoved.class,
        TestHMH46_CreateCorelationsFromDataLists.class,
        TestHMH47_ExtractZipFromStructuralObject.class,
        TestHMH48_UploadAZipWithoutManifest.class,
        TestHMH49_AdvancedSearchForContentObject.class,
        TestHMH50_CreateStructuralObjectFromEditSequenceView.class,
        TestHMH51_CreateContentObjectFromEditSequenceView.class,
        TestHMH52_CreateProgramK12Site.class,
        TestHMH53_CreateLearningObjectK12Site.class,
        TestHMH54_CreateComponentK12Site.class,
        TestHMH55_CreateLearningBundleK12Site.class,
        TestHMH56_ReleaseProductSet.class,
        TestHMH57_VersionAProductSet.class, 
        TestHMH59_CreateCompositeLearningObject.class,  
        TestHMH60_CreateCompositeLearningObjectK12Site.class,*/
        
})
public class TestSuite {

}