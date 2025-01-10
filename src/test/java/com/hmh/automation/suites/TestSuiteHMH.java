package com.hmh.automation.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//import com.ixxus.ipm.automation.alfresco.Test22_SearchAllTaggedItemsByClickedTagLink;

import com.hmh.automation.tests.TestHMH01_Login;
import com.hmh.automation.tests.TestHMH02_InviteUsersToMySiteAsDiffrentRoles;
import com.hmh.automation.tests.TestHMH03_SavedSearchDashlet;
import com.hmh.automation.tests.TestHMH04_SearchAllTaggedItemsByClickedTagLink;
import com.hmh.automation.tests.TestHMH05_AdvancedSearch_Mime;
import com.hmh.automation.tests.TestHMH06_ExitSequenceView;
import com.hmh.automation.tests.TestHMH07_SequenceViewForProgram;
import com.hmh.automation.tests.TestHMH08_SequenceViewForProductSet;
import com.hmh.automation.tests.TestHMH09_SequenceViewForSequenceBundle;
import com.hmh.automation.tests.TestHMH10_SequenceViewForLearningBundle;
import com.hmh.automation.tests.TestHMH11_SequenceViewForLearningObject;
import com.hmh.automation.tests.TestHMH12_SequenceViewForComponent;
import com.hmh.automation.tests.TestHMH13_DeleteStructuralObject;
import com.hmh.automation.tests.TestHMH14_EditSequenceForAStructuralObject;
import com.hmh.automation.tests.TestHMH15_EditAssociationsForAStructuralObject;
import com.hmh.automation.tests.TestHMH16_DeleteAssociationsForAStructuralObject;
import com.hmh.automation.tests.TestHMH17_CreateSequenceBundle;
import com.hmh.automation.tests.TestHMH18_CreateProgram;
import com.hmh.automation.tests.TestHMH19_CreateProductSet;
import com.hmh.automation.tests.TestHMH20_CreateComponent;
import com.hmh.automation.tests.TestHMH21_CreateLearningBundle;
import com.hmh.automation.tests.TestHMH22_CreateLearningObject;
import com.hmh.automation.tests.TestHMH23_FilterByCategory;
import com.hmh.automation.tests.TestHMH24_RemoveCategory;
import com.hmh.automation.tests.TestHMH25_AddUserToGroup;
import com.hmh.automation.tests.TestHMH26_CreateGroup;
import com.hmh.automation.tests.TestHMH27_CrudCategoryTaxonomy;
import com.hmh.automation.tests.TestHMH28_UploadNewVersion;
import com.hmh.automation.tests.TestHMH29_ViewMetadataInEditSequence;
import com.hmh.automation.tests.TestHMH30_AdvancedSearchForStructuralObject;
import com.hmh.automation.tests.TestHMH31_MoveObject;
import com.hmh.automation.tests.TestHMH32_EditPropertiesForMoreThanOneObject;
import com.hmh.automation.tests.TestHMH33_SortResultsInSearchResultsList;
import com.hmh.automation.tests.TestHMH34_PerformActionsOnItemsInSearchResultsList;
import com.hmh.automation.tests.TestHMH35_FilterSearchResults;
import com.hmh.automation.tests.TestHMH36_FilterByHMHKeywords;
import com.hmh.automation.tests.TestHMH37_ChangeTheTypeOfAnObject;
import com.hmh.automation.tests.TestHMH38_BulkUploadZip;
import com.hmh.automation.tests.TestHMH39_DeleteReferenceObject;
import com.hmh.automation.tests.TestHMH40_NavigateToSourceReference;
import com.hmh.automation.tests.TestHMH41_QuickSearch;
import com.hmh.automation.tests.TestHMH42_Annotations;
import com.hmh.automation.tests.TestHMH43_CreateCorrelations;
import com.hmh.automation.tests.TestHMH44_DataLists;
import com.hmh.automation.tests.TestHMH45_DeleteObjectAndCheckThatCorrelationWasRemoved;
import com.hmh.automation.tests.TestHMH46_CreateCorelationsFromDataLists;
import com.hmh.automation.tests.TestHMH47_ExtractZipFromStructuralObject;
import com.hmh.automation.tests.TestHMH48_UploadAZipWithoutManifest;
import com.hmh.automation.tests.TestHMH49_AdvancedSearchForContentObject;
import com.hmh.automation.tests.TestHMH50_CreateStructuralObjectFromEditSequenceView;
import com.hmh.automation.tests.TestHMH51_CreateContentObjectFromEditSequenceView;
import com.hmh.automation.tests.TestHMH52_CreateProgramK12Site;
import com.hmh.automation.tests.TestHMH53_CreateLearningObjectK12Site;
import com.hmh.automation.tests.TestHMH54_CreateComponentK12Site;
import com.hmh.automation.tests.TestHMH55_CreateLearningBundleK12Site;
import com.hmh.automation.tests.TestHMH56_ReleaseProductSet;
import com.hmh.automation.tests.TestHMH57_VersionAProductSet;
import com.hmh.automation.tests.TestHMH59_CreateCompositeLearningObject;
import com.hmh.automation.tests.TestHMH60_CreateCompositeLearningObjectK12Site;

@RunWith(Suite.class)
@SuiteClasses({

 
  //HMH Regression Test Suite
 
        TestHMH01_Login.class,
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
     //   TestHMH42_Annotations.class,           		 //**Looks like Annotations not yet implemented as of 08/31/2015 "connect to server failed unable to get annotations"
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
        TestHMH60_CreateCompositeLearningObjectK12Site.class,  
   
        
        
   /*
               
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
        	    TestHMH54_CreateComponentK12Site.class,
        	    TestHMH55_CreateLearningBundleK12Site.class,
        	    TestHMH60_CreateCompositeLearningObjectK12Site.class,
        	    TestHMH03_SavedSearchDashlet.class,
        	    TestHMH28_UploadNewVersion.class,	  
        	    TestHMH08_SequenceViewForProductSet.class,	
        	    TestHMH10_SequenceViewForLearningBundle.class,
        	    TestHMH11_SequenceViewForLearningObject.class,
        	    TestHMH15_EditAssociationsForAStructuralObject.class, // Reference Functionality covered  
        	    
        	// 	TestHMH04_SearchAllTaggedItemsByClickedTagLink.class, // pass
        	//    TestHMH05_AdvancedSearch_Mime.class, //pass
        	//    TestHMH06_ExitSequenceView.class, //pass
            //    TestHMH07_SequenceViewForProgram.class, //pass
             //   TestHMH09_SequenceViewForSequenceBundle.class,  //pass
             //   TestHMH25_AddUserToGroup.class, // pass
             //   TestHMH26_CreateGroup.class,  //pass 
           //     TestHMH12_SequenceViewForComponent.class, //pass
        	    
        	//    TestHMH13_DeleteStructuralObject.class, // pass
           //     TestHMH14_EditSequenceForAStructuralObject.class, //pass
                TestHMH16_DeleteAssociationsForAStructuralObject.class,  //selecteREfreence
          //      TestHMH23_FilterByCategory.class, //pass
           //     TestHMH24_RemoveCategory.class, //pass
           //     TestHMH27_CrudCategoryTaxonomy.class, //pass
                
            //  TestHMH29_ViewMetadataInEditSequence.class, //pass
                
                TestHMH30_AdvancedSearchForStructuralObject.class,
                TestHMH31_MoveObject.class,
                TestHMH32_EditPropertiesForMoreThanOneObject.class,
                TestHMH33_SortResultsInSearchResultsList.class,
                TestHMH34_PerformActionsOnItemsInSearchResultsList.class,
                TestHMH35_FilterSearchResults.class,
                
         /*      TestHMH36_FilterByHMHKeywords.class,
                TestHMH37_ChangeTheTypeOfAnObject.class,
                TestHMH38_BulkUploadZip.class,
                TestHMH39_DeleteReferenceObject.class,
                TestHMH40_NavigateToSourceReference.class,
                TestHMH41_QuickSearch.class,
                TestHMH42_Annotations.class, 
                
        /*
                //Vanilla Alfresco Tests
                Test07_DocumentDetailsUploadNewVersion.class,
                Test15_VersionHistorySection.class,
                Test26_ExpandSearch.class,
                // Test22: NOT FOUND -- therefore commented out
                //Test22_SearchAllTaggedItemsByClickedTagLink.class,
                Test27_FavouriteSite.class,
                Test30_CrudMetadata.class,
                Test31_FavoriteObjects.class,
                Test33_AdvancedSearch_Mime.class,      */                  

        
})
public class TestSuiteHMH {

}
