package com.hmh.automation.pages;

import java.util.List;
import java.util.UUID;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

public class HMHDocumentLibraryPage extends AbstractPage {
    public HMHDocumentLibraryPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[id $= 'documents'] > table > tbody[class $= 'data'] > tr")
    private List<WebElement> documentsList;

    @FindBy(css = "input[id*='createObject_prop_cm_name']")
    private WebElement nameInput;

    @FindBy(css = "input[id$='copyrightYear']")
    private WebElement copyrightYearInput;

    @FindBy(css = "select[id*='createObject_prop_hmh-cms_grade-entry'] option")
    private List<WebElement> gradesList;

    @FindBy(css = "input[id$='level1Label']")
    private WebElement level1LabelInput;

    @FindBy(css = "select[id$='level1Restart'] option")
    private List<WebElement> level1RestartList;

    @FindBy(css = "button[id*='createObject-form-submit-button']")
    private WebElement saveBtn;

    @FindBy(css = "select[id$='activityType'] option")
    private List<WebElement> activitTypelist;

    @FindBy(css = "select[id$='language'] option")
    private List<WebElement> laguagesList;

    @FindBy(css = "select[id$='publicationRights-entry'] option")
    private List<WebElement> rightsList;

    @FindBy(css = "input[class='invalid']")
    private WebElement invalidInput;

    @FindBy(css = "div[id*='message'] span[class='message']")
    private WebElement duplicateNameMessage;

    @FindBy(css = "button[id*='form-cancel-button']")
    private WebElement cancelButton;

    @FindBy(css = "div[id*='default-selectedItems-menu'] div.bd ul")
    private WebElement selectedItemsOptionsPanel;

    @FindBy(css = "input[id*='prop_hmh-cms_scmUrl']")
    private WebElement codeRepositoryURl;

    @FindBy(css = "div[id*='correlation-cntrl-picker-results'] tbody[class$='data'] tr")
    private List<WebElement> standards;

    @FindBy(css = "div[id*='hmh-cms_correlation-cntrl-picker-selectedItems'] tbody[class$='data'] tr")
    private List<WebElement> selectedStandards;

    @FindBy(css = "div[id*='prop_hmh-cms_correlation-cntrl-picker-selectedItems'] tbody[class$='message'] div")
    private WebElement emptyStandardList;

    @FindBy(css = "button[id*='correlation-cntrl-ok-button']")
    private WebElement confirmCorrelateButton;

    @FindBy(css = "div[id*='correlation-cntrl-picker-results'] tbody[class*='message']")
    private WebElement loadingMessage;

    @FindBy(css = "div[id*='default-documents'] tbody[class*='data'] tr h3 a")
    private List<WebElement> assetList;

    @FindBy(xpath = "//ul[contains(@id, 'tags')]//li//span")
    private List<WebElement> tagsList;

    @FindBy(css = "input[id ^='form-field']")
    private WebElement enterNewTagDocLibView;

    @FindBy(xpath = "//form[contains(@class, 'insitu-edit')]//a[contains(text(),'Save')]")
    private WebElement saveButtonEditTagsDocViewSection;

    @FindBy(css = "div[class ='inlineTagEdit']")
    private WebElement editTagsContainer;

    @FindBy(css = "div[id*='dnd-upload'] div[id$='default-filelist-table'] tbody[class$='data'] td[class*='name'] span[class*='fileupload-filesize-span']")
    private WebElement noSpreadSheetInZipMessage;

    @FindBy(css = "span[class*='current']")
    private WebElement numberOfElementsOnPage;

    @FindBy(css = "select[id$='cms_markets-entry'] option")
    private List<WebElement> marketsList;

    @FindBy(css = "select[id$='lifecycle'] option")
    private List<WebElement> lifecycleList;

    @FindBy(css = "select[id$='learningStyles-entry'] option")
    private List<WebElement> learningStylesList;

    @FindBy(css = "select[id$='interactivityLevel'] option")
    private List<WebElement> interactivityLevelList;

    @FindBy(css = "select[id$='socialInteraction'] option")
    private List<WebElement> socialInteractionList;

    @FindBy(css = "textarea[id$='prop_cm_title']")
    private WebElement displayTitle;

    @FindBy(css = "select[id$='productCategory'] option")
    private List<WebElement> productCategoryList;

    @FindBy(css = "select[id$='productType-entry'] option")
    private List<WebElement> productTypeList;

    @FindBy(css = "select[id$='resourceType'] option")
    private List<WebElement> resourceTypeList;

    @FindBy(css = "select[id$='cms_activityType'] option")
    private List<WebElement> activityTypeList;

    @FindBy(css = "div.bd span[class='message']")
    private WebElement publishMessage;

    @FindBy(css = "[id $= 'selectedItems-button-button']")
    private WebElement selectedItemsButton;

    @FindBy(css = "div[id $= 'selectedItems-menu'] > div > ul > li > a > span")
    private List<WebElement> selectedItemsItemsList;
    
    @FindBy(css = "#yui-gen147-button")
    private WebElement clickOkPopup;
    
    @FindBy(css = "#yui-gen97")
    private WebElement clickOnFolderName;
    
	
	@FindBy(css = "tbody[class $= 'data'] > tr h3 > span a")
	private List<WebElement> documentLibraryAssetName;
	
	@FindBy(css= "a[title='Delete Object'] > span" )
	private WebElement deleteObjectButton;
	
	@FindBy (css= "a[title='Delete Folder'] > span")
	private WebElement deleteFolderButton;
	
	@FindBy(xpath = "//Button[contains(text(),'Delete')]")
	private WebElement confirmDelete;
	
	@FindBy(css="a[title='Move to...'] span")
	private WebElement moveToselect;
	
	@FindBy(css="a[title='Extract'] span")
	private WebElement extractButton;
	
	@FindBy(css="div[id*='default-navBar'] span.label a")  // div[id*='default-navBar'] span a || div[id*='default-navBar'] span[class*='label'] a
	private WebElement navBarViewDetails;
	
	@FindBy(css = "[id $= 'fileSelect-button-button']")
	private WebElement selectButton;
	@FindBy(className = "selectAll")
	private WebElement allLink;
	@FindBy(css = "[id $= 'selectedItems-button-button']")
	private WebElement selectedItemsButtontwo;
	
	@FindBy(css = "div.header-bar > div.left > div.hideable.DocListTree button")
	private WebElement docListTree;
	
	@FindBy(css="a[title='Correlations'] span")
	private WebElement correlations;
	
	@FindBy(css = "div[id $= 'aspects-left'] tr[class *= 'dt-rec'] td > div > a > span.addIcon")
	private List<WebElement> addAspectButtonList;
	@FindBy(css = "div[id $= 'aspects-left'] tr[class *= 'dt-rec'] > td > div > h3")
	private List<WebElement> aspectsAvailableForFoldersList;
	
    String stadardNames = "h3 a";
    String addStandardButton = " a span[class='addIcon']";
    String removeStandardButton = "a span[class='removeIcon']";
    String documentsName = "h3.filename span a";
    String editPropertiesButtonString = "a[title='Edit Properties'] > span";
    String titleListSelector = " h3 span a";
    String standardList = "div[id$='correlation-cntrl-picker-results'] tbody[class$='data'] tr a";
    String noHMHKeywordsXpathSelector = "//span[contains(text(), 'No HMH Keywords')]";
    String editTagsButtonDocLib = "div[class='detail'] span[title ='Tag']";
    String assetTagsSpan = "span.item>span.tag";
    String assetTagContainer = "span.inlineTagEditTag";
    String deleteTagButton = "span.inlineTagEditTag img:nth-child(2)";
    
    
    
    // Added by Sampath-cognizantQA
    String hiddenContainerIdentifier = "div[class $= 'dt-liner'] > div";
    private final String viewDetails = "a[title='View Details'] > span";
  //  private final String moreButtonIdentifier = "//div[4]/a/span";
    final String moreButtonIdentifier = "div#onActionShowMore a.show-more > span";
  //  private final String moreButtonIdentifier = "More...";
	private final String moreActionsCSSSelector = "div.more-actions > div a span";
	
	@FindBy(css = "div[class='categoryview filter'] > h2")
    private WebElement categoriesMainButton;
//	@FindBy(css = "div[class='categoryview filter'] span")
	@FindBy(xpath = "//span[contains(text(), 'Category Root')]")
    private WebElement categoryRootButton;
	@FindBy(css = "div[class='categoryview filter'] div[id*='categories'] > div > div > div > div tr td span")
	private List<WebElement> categoryFilters;
	
	
    
    public void selectItem(final String itemName) {
        final List<WebElement> itemsList = getDriver().findElements(By.cssSelector("div[id $= 'default-documents'] > table > tbody.yui-dt-data > tr"));
        for (final WebElement elem : itemsList) {
            if (elem.getText().contains(itemName)) {
                elem.findElement(By.cssSelector("div.yui-dt-liner > input")).click();
                waitABit(2000);
                break;
            }
        }
    }

    public void choseOptionFromSelectedItems(final String optionToSelect) {
        boolean found = false;
        waitABit(20000);
        final List<WebElement> selectedItemsOptions = selectedItemsOptionsPanel.findElements(By.cssSelector("li a span"));
        for (int i = 0; i < selectedItemsOptions.size(); i++) {
            System.out.println("i=" + i + selectedItemsOptions.get(i).getText());
            if (selectedItemsOptions.get(i).getText().toLowerCase().contains(optionToSelect.toLowerCase())) {
                found = true;
                selectedItemsOptions.get(i).click();
                break;
            }
        }
        Assert.assertTrue("The Selected Items option was not found!", found);
    }

    public void createObjectWhenNotAllMandatoryMetadataFieldsAreFilled() {
        boolean worksWell = false;
        element(saveBtn).waitUntilVisible();
        saveBtn.click();
        waitABit(200);
        if (invalidInput.isDisplayed()) {
            worksWell = true;
        }
        Assert.assertTrue("The Invalid input message was not displayed", worksWell);

    }

    public void duplicataNameMessageShow() {
        boolean dispalayed = false;
        element(duplicateNameMessage).waitUntilVisible();
        if (duplicateNameMessage.isDisplayed()) {
            dispalayed = true;
        }
        Assert.assertTrue("The message was not displayed", dispalayed);
        cancelButton.click();
    }

//    public void createProgram(final String name, final String title, final String grade, String market) {
//        boolean gradeFound = false;
//        boolean marketsFound = false;
//        nameInput.sendKeys(name);
//        displayTitle.sendKeys(title);
//
//        for (final WebElement gradeElement : gradesList) {
//            if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
//                gradeFound = true;
//                gradeElement.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The grade was not found", gradeFound);
//        for (final WebElement marketItem : marketsList) {
//            if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
//                marketsFound = true;
//                marketItem.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The market was not found", marketsFound);
//        saveBtn.click();
//    }
    
    public void createProgram(final String name, final String title, String market) {
        boolean marketsFound = false;
        nameInput.sendKeys(name);
        displayTitle.sendKeys(title);

        for (final WebElement marketItem : marketsList) {
            if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
                marketsFound = true;
                marketItem.click();
                break;
            }
        }
        Assert.assertTrue("The market was not found", marketsFound);
        saveBtn.click();
    }

    public void createProductSet(final String name, final String year, final String grade,
            final String levle1, final String level1Restart, final String market, final String title) {
        //        element(nameInput).waitUntilVisible();
        nameInput.sendKeys(name);
        copyrightYearInput.sendKeys(year);
        displayTitle.sendKeys(title);
        boolean gradeFound = false;
        boolean level1RestartFound = false;
        boolean marketsFound = false;

        for (final WebElement gradeElement : gradesList) {
            if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
                gradeFound = true;
                gradeElement.click();
                break;
            }
        }
        Assert.assertTrue("The grade was not found", gradeFound);

        level1LabelInput.sendKeys(levle1);

        for (final WebElement lvl : level1RestartList) {
            if (lvl.getText().toLowerCase().contentEquals(level1Restart.toLowerCase())) {
                level1RestartFound = true;
                lvl.click();
                break;
            }
        }
        Assert.assertTrue("The level 1 Restart was not found", level1RestartFound);

        for (final WebElement marketItem : marketsList) {
            if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
                marketsFound = true;
                marketItem.click();
                break;
            }
        }
        Assert.assertTrue("The market was not found", marketsFound);

        saveBtn.click();
    }

    public void createSequenceBundle(final String name, final String market, final String title) {
        boolean marketsFound = false;
        element(nameInput).waitUntilVisible();
        nameInput.sendKeys(name);
        displayTitle.sendKeys(title);
        for (final WebElement marketItem : marketsList) {
            if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
                marketsFound = true;
                marketItem.click();
                break;
            }
        }
        Assert.assertTrue("The market was not found", marketsFound);

        saveBtn.click();
    }

//    public void createLearningBundleConsumerSite(final String name, final String grade, final String market, final String lifecycle,
//            final String learningStyle, final String interactivityLevel, final String socialInteraction, final String title) {
    public void createLearningBundleConsumerSite(final String name, final String grade, 
    		                       final String market, final String title) {
        boolean gradeFound = false;
        boolean lifecycleFound = false;
        boolean marketsFound = false;
        boolean learningStylesFound = false;
        boolean interactivityLevelFound = false;
        boolean socialInteractionFound = false;
        element(nameInput).waitUntilVisible();
        nameInput.sendKeys(name);
        displayTitle.sendKeys(title);
        for (final WebElement gradeElement : gradesList) {
            if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
                gradeFound = true;
                gradeElement.click();
                break;
            }
        }
        Assert.assertTrue("The grade was not found", gradeFound);
//        for (final WebElement lifeCycle : lifecycleList) {
//            if (lifeCycle.getText().toLowerCase().contentEquals(lifecycle.toLowerCase())) {
//                lifecycleFound = true;
//                lifeCycle.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The lifecycle was not found", lifecycleFound);
        for (final WebElement marketItem : marketsList) {
            if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
                marketsFound = true;
                marketItem.click();
                break;
            }
        }
        Assert.assertTrue("The market was not found", marketsFound);
//        for (final WebElement learnStyle : learningStylesList) {
//            if (learnStyle.getText().toLowerCase().contains(learningStyle.toLowerCase())) {
//                learningStylesFound = true;
//                learnStyle.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The learning Style was not found", learningStylesFound);
//        for (final WebElement interLevel : interactivityLevelList) {
//            if (interLevel.getText().toLowerCase().contains(interactivityLevel.toLowerCase())) {
//                interactivityLevelFound = true;
//                interLevel.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The interactivity level was not found", interactivityLevelFound);
//        for (final WebElement interaction : socialInteractionList) {
//            if (interaction.getText().toLowerCase().contains(socialInteraction.toLowerCase())) {
//                socialInteractionFound = true;
//                interaction.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The social interaction was not found", socialInteractionFound);
         saveBtn.click();
    }

    public void createLearningBundleK12Site(final String name, final String title, final String lifecycle, final String market, final String grade) {
        boolean gradeFound = false;
        boolean lifecycleFound = false;
        boolean marketsFound = false;
        nameInput.sendKeys(name);
        displayTitle.sendKeys(title);
        for (final WebElement gradeElement : gradesList) {
            if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
                gradeFound = true;
                gradeElement.click();
                break;
            }
        }
        Assert.assertTrue("The grade was not found", gradeFound);

        for (final WebElement lifeCycle : lifecycleList) {
            if (lifeCycle.getText().toLowerCase().contentEquals(lifecycle.toLowerCase())) {
                lifecycleFound = true;
                lifeCycle.click();
                break;
            }
        }
        Assert.assertTrue("The lifecycle was not found", lifecycleFound);

        for (final WebElement marketItem : marketsList) {
            if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
                marketsFound = true;
                marketItem.click();
                break;
            }
        }
        Assert.assertTrue("The market was not found", marketsFound);
        saveBtn.click();
    }

    public void createLearningObjectConsumerSite(final String name, final String grade,
            final String rights, final String market, final String title) {

        boolean gradeFound = false;

        boolean languageFound = false;
        boolean rightsFound = false;
        boolean marketsFound = false;
        boolean learningStylesFound = false;
        boolean interactivityLevelFound = false;
        boolean socialInteractionFound = false;
        boolean resourceTypeFound = false;

        element(nameInput).waitUntilVisible();

        nameInput.sendKeys(name);
        displayTitle.sendKeys(title);

        for (final WebElement rightsElement : rightsList) {
            if (rightsElement.getText().toLowerCase().contentEquals(rights.toLowerCase())) {
                rightsFound = true;
                rightsElement.click();
                break;
            }
        }
        Assert.assertTrue("The right was not found", rightsFound);

        for (final WebElement gradeElement : gradesList) {
            if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
                gradeFound = true;
                gradeElement.click();
                break;
            }
        }
        Assert.assertTrue("The grade was not found", gradeFound);

//        for (final WebElement languageElement : laguagesList) {
//            if (languageElement.getText().toLowerCase().contentEquals(language.toLowerCase())) {
//                languageFound = true;
//                languageElement.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The language was not found", languageFound);

        for (final WebElement marketItem : marketsList) {
            if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
                marketsFound = true;
                marketItem.click();
                break;
            }
        }
        Assert.assertTrue("The market was not found", marketsFound);

//        for (final WebElement learnStyle : learningStylesList) {
//            if (learnStyle.getText().toLowerCase().contains(learningStyle.toLowerCase())) {
//                learningStylesFound = true;
//                learnStyle.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The learning Style was not found", learningStylesFound);

        //interactivity Level
//        for (final WebElement interLevel : interactivityLevelList) {
//            if (interLevel.getText().toLowerCase().contains(interactivityLevel.toLowerCase())) {
//                interactivityLevelFound = true;
//                interLevel.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The interactivity level was not found", interactivityLevelFound);
//
//        //social interaction
//        for (final WebElement interaction : socialInteractionList) {
//            if (interaction.getText().toLowerCase().contains(socialInteraction.toLowerCase())) {
//                socialInteractionFound = true;
//                interaction.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The social interaction was not found", socialInteractionFound);
//
//        //resource Type
//        for (final WebElement resource : resourceTypeList) {
//            if (resource.getText().toLowerCase().contains(resourceType.toLowerCase())) {
//                resourceTypeFound = true;
//                resource.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The resource type was not found", resourceTypeFound);

        saveBtn.click();
    }

    // create Learning object in k-12 site
    
    /*public void createLearningObjectK12Site(final String name, final String activityType, final String grade, final String language,
            final String rights, final String market, final String title, final String productCategory, final String productType, final String lifecycle) {

        boolean gradeFound = false;
        boolean languageFound = false;
        boolean rightsFound = false;
        boolean marketsFound = false;
        boolean activityTypeFound = false;
        boolean productCategoryFound = false;
        boolean productTypeFound = false;
        boolean lifeCycleFound = false;
        element(nameInput).waitUntilVisible();
        nameInput.sendKeys(name);
        displayTitle.sendKeys(title);

        for (final WebElement rightsElement : rightsList) {
            if (rightsElement.getText().toLowerCase().contentEquals(rights.toLowerCase())) {
                rightsFound = true;
                rightsElement.click();
                break;
            }
        }
        Assert.assertTrue("The right was not found", rightsFound);

        for (final WebElement activity : activitTypelist) {
            if (activity.getText().toLowerCase().contentEquals(activityType.toLowerCase())) {
                activityTypeFound = true;
                activity.click();
                break;
            }
        }
        Assert.assertTrue("The acitivty was not found", activityTypeFound);

        for (final WebElement gradeElement : gradesList) {
            if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
                gradeFound = true;
                gradeElement.click();
                break;
            }
        }
        Assert.assertTrue("The grade was not found", gradeFound);

        for (final WebElement languageElement : laguagesList) {
            if (languageElement.getText().toLowerCase().contentEquals(language.toLowerCase())) {
                languageFound = true;
                languageElement.click();
                break;
            }
        }
        Assert.assertTrue("The language was not found", languageFound);

        for (final WebElement marketItem : marketsList) {
            if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
                marketsFound = true;
                marketItem.click();
                break;
            }
        }
        Assert.assertTrue("The market was not found", marketsFound);

        for (final WebElement category : productCategoryList) {
            if (category.getText().toLowerCase().contains(productCategory.toLowerCase())) {
                productCategoryFound = true;
                category.click();
                break;
            }
        }
        Assert.assertTrue("The product category was not found", productCategoryFound);

        for (final WebElement type : productTypeList) {
            if (type.getText().toLowerCase().contains(productType.toLowerCase())) {
                productTypeFound = true;
                type.click();
                break;
            }
        }
        Assert.assertTrue("The product type was not found", productTypeFound);

        for (final WebElement cycle : lifecycleList) {
            if (cycle.getText().toLowerCase().contains(lifecycle.toLowerCase())) {
                lifeCycleFound = true;
                cycle.click();
                break;
            }
        }
        Assert.assertTrue("The lifeCycle was not found", lifeCycleFound);*/
    
    public void createLearningObjectK12Site(final String name, final String grade, final String language,
            final String rights, final String market, final String title, final String lifecycle) {

    	 boolean gradeFound = false;
         boolean languageFound = false;
         boolean rightsFound = false;
         boolean marketsFound = false;
         boolean activityTypeFound = false;
         boolean productCategoryFound = false;
         boolean productTypeFound = false;
         boolean lifeCycleFound = false;
         element(nameInput).waitUntilVisible();
         nameInput.sendKeys(name);
         displayTitle.sendKeys(title);

         for (final WebElement rightsElement : rightsList) {
             if (rightsElement.getText().toLowerCase().contentEquals(rights.toLowerCase())) {
                 rightsFound = true;
                 rightsElement.click();
                 break;
             }
         }
         Assert.assertTrue("The right was not found", rightsFound);

         for (final WebElement gradeElement : gradesList) {
             if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
                 gradeFound = true;
                 gradeElement.click();
                 break;
             }
         }
         Assert.assertTrue("The grade was not found", gradeFound);

         for (final WebElement languageElement : laguagesList) {
             if (languageElement.getText().toLowerCase().contentEquals(language.toLowerCase())) {
                 languageFound = true;
                 languageElement.click();
                 break;
             }
         }
         Assert.assertTrue("The language was not found", languageFound);

         for (final WebElement marketItem : marketsList) {
             if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
                 marketsFound = true;
                 marketItem.click();
                 break;
             }
         }
         Assert.assertTrue("The market was not found", marketsFound);

//         for (final WebElement category : productCategoryList) {
//             if (category.getText().toLowerCase().contains(productCategory.toLowerCase())) {
//                 productCategoryFound = true;
//                 category.click();
//                 break;
//             }
//         }
//         Assert.assertTrue("The product category was not found", productCategoryFound);

         for (final WebElement cycle : lifecycleList) {
             if (cycle.getText().toLowerCase().contains(lifecycle.toLowerCase())) {
                 lifeCycleFound = true;
                 cycle.click();
                 break;
             }
         }
         Assert.assertTrue("The lifeCycle was not found", lifeCycleFound);
        
        saveBtn.click();
    }

//    public void createComponentConsumerSite(final String name, final String title, final String rights,
//            final String grade, final String language, final String lifecycle,
//            final String learningSyles, final String interactivityLevel,
//            final String socialInteraction, final String resourceType) {
    public void createComponentConsumerSite(final String name, final String title, final String rights,
            final String grade, final String lifecycle, final String resourceType) {

        boolean rightsFound = false;
        boolean languageFound = false;
        boolean gradeFound = false;
        boolean lifecycleFound = false;
        boolean learningStylesFound = false;
        boolean interactivityLevelFound = false;
        boolean socialInteractionFound = false;
        boolean resourceTypeFound = false;

        element(nameInput).waitUntilVisible();
        nameInput.sendKeys(name);
        displayTitle.sendKeys(title);

        for (final WebElement rightsElement : rightsList) {
            if (rightsElement.getText().toLowerCase().contentEquals(rights.toLowerCase())) {
                rightsFound = true;
                rightsElement.click();
                break;
            }
        }
        Assert.assertTrue("The right was not found", rightsFound);
        for (final WebElement gradeElement : gradesList) {
            if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
                gradeFound = true;
                gradeElement.click();
                break;
            }
        }
        Assert.assertTrue("The grade was not found", gradeFound);
//        for (final WebElement languageElement : laguagesList) {
//            if (languageElement.getText().toLowerCase().contentEquals(language.toLowerCase())) {
//                languageFound = true;
//                languageElement.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The language was not found", languageFound);
        for (final WebElement lifeCycle : lifecycleList) {
            if (lifeCycle.getText().toLowerCase().contentEquals(lifecycle.toLowerCase())) {
                lifecycleFound = true;
                lifeCycle.click();
                break;
            }
        }
        Assert.assertTrue("The lifecycle was not found", lifecycleFound);
//        for (final WebElement learnStyle : learningStylesList) {
//            if (learnStyle.getText().toLowerCase().contains(learningSyles.toLowerCase())) {
//                learningStylesFound = true;
//                learnStyle.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The learning Style was not found", learningStylesFound);
//
//        for (final WebElement interaction : socialInteractionList) {
//            if (interaction.getText().toLowerCase().contains(socialInteraction.toLowerCase())) {
//                socialInteractionFound = true;
//                interaction.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The social interaction was not found", socialInteractionFound);
//        for (final WebElement interLevel : interactivityLevelList) {
//            if (interLevel.getText().toLowerCase().contains(interactivityLevel.toLowerCase())) {
//                interactivityLevelFound = true;
//                interLevel.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The interactivity level was not found", interactivityLevelFound);
        for (final WebElement resource : resourceTypeList) {
            if (resource.getText().toLowerCase().contains(resourceType.toLowerCase())) {
                resourceTypeFound = true;
                resource.click();
                break;
            }
        }
        Assert.assertTrue("The resource type was not found", resourceTypeFound);
        saveBtn.click();
    }

    /////////////////////////////////////////////////////////////////
    public void createComponentK12Site(final String name, final String title, final String rights, final String grade,
            final String lifeCycle) {
        boolean gradeFound = false;
        boolean languageFound = false;
        boolean rightsFound = false;
        boolean activityTypeFound = false;
        boolean lifeCycleFound = false;

        element(nameInput).waitUntilVisible();
        nameInput.sendKeys(name);
        displayTitle.sendKeys(title);

        for (final WebElement rightsElement : rightsList) {
            if (rightsElement.getText().toLowerCase().contentEquals(rights.toLowerCase())) {
                rightsFound = true;
                rightsElement.click();
                break;
            }
        }
        Assert.assertTrue("The right was not found", rightsFound);

        for (final WebElement gradeElement : gradesList) {
            if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
                gradeFound = true;
                gradeElement.click();
                break;
            }
        }
        Assert.assertTrue("The grade was not found", gradeFound);

//        for (final WebElement languageElement : laguagesList) {
//            if (languageElement.getText().toLowerCase().contentEquals(language.toLowerCase())) {
//                languageFound = true;
//                languageElement.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The grade was not found", languageFound);

        for (final WebElement cycle : lifecycleList) {
            if (cycle.getText().toLowerCase().contentEquals(lifeCycle.toLowerCase())) {
                lifeCycleFound = true;
                cycle.click();
                break;
            }
        }
        Assert.assertTrue("The lifecycle was not found", lifeCycleFound);

//        for (final WebElement activity : activitTypelist) {
//            if (activity.getText().toLowerCase().contentEquals(activityType.toLowerCase())) {
//                activityTypeFound = true;
//                activity.click();
//                break;
//            }
//        }
//        Assert.assertTrue("The acitivty was not found", activityTypeFound);
        saveBtn.click();
    }

    public void hmhEditPropertiesClick(final String asset) {
        boolean found = false;
        final Actions action = new Actions(getDriver());
        for (final WebElement elem : documentsList) {
            if (elem.getText().toLowerCase().contains(asset.toLowerCase())) {
                final WebElement hiddenContainer = elem.findElement(By.cssSelector(documentsName));
                mouseOver(hiddenContainer);
                action.moveToElement(hiddenContainer).build().perform();
                final WebElement editPropertiesButton = elem.findElement(By.cssSelector(editPropertiesButtonString));
                editPropertiesButton.click();
                found = true;
            }
        }
        Assert.assertTrue("The item " + asset + " was not found", found);
        System.out.println("Iese din metoda");
    }

    public int getNumberOfItemsOnPage() {
        String itemNumbersFoter = numberOfElementsOnPage.getText();
        String[] parts = itemNumbersFoter.split(" -");
        String part1 = parts[0];
        int nrOfItems = Integer.parseInt(part1);
        return nrOfItems;
    }

    public void waitForZipToFinishExtract(final String zipAsset) {
        int nr = getNumberOfItemsOnPage();
        boolean gone = false;
        int counter = 0;
        waitABit(1000);
        while ((gone == false) && (counter < 35) && (nr > 0)) {
            for (final WebElement element : assetList) {
                if (!element.getText().contains(zipAsset.toLowerCase())) {
                    gone = true;
                    break;
                }
            }
            waitABit(6000);
            refreshPage();
            counter++;
            nr = getNumberOfItemsOnPage();
        }
        Assert.assertTrue("The zip file hasn't dissapeard in more than 3 minutes", counter < 30);
    }

    public void clickItemInCorrelationsPane(final String standardName) {
        boolean found = true;
        waitABit(1000);
        waitForRenderedElementsToBePresent(By.cssSelector(standardList));
        Serenity.takeScreenshot();
        for (final WebElement standard : getDriver().findElements(By.cssSelector(standardList))) {
            System.out.println(standard.getText());
            element(standard).waitUntilVisible();
            if (standard.getText().toLowerCase().contains(standardName.toLowerCase())) {
                //                WebElement navigate = aspect.findElement(By.cssSelector(referencesNamesCssSelector));
                found = true;
                standard.click();
                Serenity.takeScreenshot();
                break;
            }
        }
        Assert.assertTrue("The standard set was not found", found);

    }

    public void selectStandardToCorrelate(final String standard) {
        boolean standardFound = false;
        waitABit(4000);
        for (final WebElement item : standards) {
            System.out.println("Standard is " + item.getText());
            if (item.getText().toLowerCase().contains(standard.toLowerCase())) {
                System.out.println("2 Standard is " + item.getText());
                standardFound = true;
                final WebElement add = item.findElement(By.cssSelector(addStandardButton));
                add.click();
                break;
            }
        }
        Assert.assertTrue("The searched standard was not found", standardFound);
        confirmCorrelateButton.click();
    }

    public void checkIfStandardWasAdded(final String standard) {
        boolean found = false;
        for (final WebElement item : selectedStandards) {
            if (item.getText().toLowerCase().contains(standard.toLowerCase())) {
                found = true;
                break;
            }
        }
        Assert.assertTrue("The standard was not found in selected standards list", found);
    }

    public void removeACorrelation(final String standard) {
        boolean found = false;
        element(confirmCorrelateButton).waitUntilVisible();
        for (final WebElement item : selectedStandards) {
            if (item.getText().toLowerCase().contains(standard.toLowerCase())) {
                found = true;
                final WebElement removeBtn = item.findElement(By.cssSelector(removeStandardButton));
                removeBtn.click();
                break;
            }
        }
        Assert.assertTrue("The standard was not found in selected standards list", found);
        confirmCorrelateButton.click();
    }

    public void checkIfThereAreNoCorrelations() {
        boolean noCorrelations = false;
        element(emptyStandardList).waitUntilVisible();
    //    if (emptyStandardList.isDisplayed()) {
         if (emptyStandardList.getText().contains("No items selected")) {
            noCorrelations = true;
        }
        Assert.assertTrue("The correlations list is not empty", noCorrelations);
    }

    public void deleteTagFromDocLibView(final String assetName, final String tagName) {
        final int counterBefore = getTagNumericValue(tagName);
        editTagButtonClickHMH(assetName);
        element(enterNewTagDocLibView).waitUntilVisible();
        for (final WebElement asset : documentsList) {
            if (asset.getText().toLowerCase().contains(assetName.toLowerCase())) {
                final List<WebElement> tagList = asset.findElements(By.cssSelector(assetTagContainer));
                for (final WebElement tagN : tagList) {
                    if (tagN.getText().contains(tagName)) {
                        final WebElement delTagButton = tagN.findElement(By.cssSelector(deleteTagButton));
                        delTagButton.click();
                    }
                }
            }
        }
        element(saveButtonEditTagsDocViewSection).waitUntilVisible();
        saveButtonEditTagsDocViewSection.click();
        element(editTagsContainer).waitUntilNotVisible();
        getDriver().navigate().refresh();

        final int counterAfter = getTagNumericValue(tagName);
        Assert.assertTrue("Counter for tag is incorrect!", counterBefore == (counterAfter + 1));
    }

    public void editTagButtonClickHMH(final String assetName) {
        final Actions actions = new Actions(getDriver());
        boolean found = false;
        //        waitForListToLoad(documentsList, 5);
        System.out.println("Inainte de FOR");
        for (final WebElement container : documentsList) {
            final WebElement name = container.findElement(By.cssSelector(titleListSelector));
            if (name.getText().equalsIgnoreCase(assetName)) {
                System.out.println("In primul IF");
                if (verifyElementPresent(By.cssSelector(noHMHKeywordsXpathSelector), 5)) {
                    System.out.println("In al doilea IF");

                    final WebElement findTags = container.findElement(By
                            .cssSelector(noHMHKeywordsXpathSelector));

                    actions.moveToElement(findTags);
                    actions.click().build().perform();
                    waitABit(2000);
                    final WebElement editTagsButton = container.findElement(By
                            .cssSelector(editTagsButtonDocLib));
                    element(editTagsButton).waitUntilVisible();
                    actions.moveToElement(editTagsButton);
                    actions.click().build().perform();

                    System.out.println("Se termina al doilea IF");
                    found = true;
                    break;
                } else {
                    final WebElement findTags = container.findElement(By
                            .cssSelector(assetTagsSpan));
                    actions.moveToElement(findTags);
                    actions.build().perform();
                    waitABit(2000);
                    final WebElement editTagsButton = container.findElement(By
                            .cssSelector(editTagsButtonDocLib));
                    element(editTagsButton).waitUntilVisible();
                    actions.moveToElement(editTagsButton);
                    actions.click().build().perform();
                    found = true;
                    break;
                }
            }
        }
        Assert.assertTrue("The asset is not in the list!", found);
    }

    public int getTagNumericValue(final String tagName) {
        String tagText = null;
        int tagNumber = 0;
        waitABit(2000);
        for (final WebElement tag : tagsList) {
            if (tag.getText().contains(tagName.toLowerCase())) {
                tagText = tag.getText();
                tagNumber = Integer.parseInt(tagText.split("[\\(\\)]")[1]);
            }
        }
        return tagNumber;
    }

    public void checkExtractErrorMessage(final String message) {
        boolean found = false;
        if (noSpreadSheetInZipMessage.getText().contains(message)) {
            found = true;
        }
        Assert.assertTrue("The message is not correct or not found", found);
    }

    public void refresh() {
        refreshPage();
    }

    public void checkPublishMessage() {
        String message = "Successfully queued for publishing";
        boolean found = false;
        element(publishMessage).waitUntilVisible();
        if (publishMessage.getText().contains(message)) {
            found = true;
        }
        Assert.assertTrue("The message for publishing was not displayed", found);
    }

    public void selectAnItemFromSelectedItemsDropDown(final String actionName) {
        boolean isFound = false;
        element(selectedItemsButton).waitUntilVisible();
        selectedItemsButton.click();
        waitABit(1200);
        List<WebElement> itemsList = getDriver().findElements(By.cssSelector("div[id $= 'selectedItems-menu'] > div > ul > li > a > span"));
        waitABit(1000);
        waitForListToLoad(itemsList, 1, true);
        for (final WebElement action : itemsList) {
            if (action.getText().toLowerCase()
                    .contains(actionName.toLowerCase())) {
                action.click();
                isFound = true;
                break;
            }
        }
        Assert.assertTrue(" " + actionName + " was not found", isFound);
    }
    
  /*Edited by Sampath-CognizantQA */  
    
    public void refreshToExitPopup() {
        waitABit(2000);
        getDriver().navigate().refresh();
        waitABit(2000);
		
	}

	public void clickOnFolder() {
		element(clickOnFolderName).waitUntilVisible();
		clickOnFolderName.click();
		waitABit(2000);
	}
	
	public void viewDetailsClick(final String assetName) {
		boolean found = false;
		final Actions action = new Actions(getDriver());
		for (final WebElement elem : documentsList) {
			if (elem.getText().toLowerCase().contains(assetName.toLowerCase())) {
				final WebElement hiddenContainer = elem.findElement(By
						.cssSelector(hiddenContainerIdentifier));
				action.moveToElement(hiddenContainer).build().perform();
				final WebElement viewD = elem.findElement(By
						.cssSelector(viewDetails));
				viewD.click();
				found = true;
				waitABit(800);
				break;
			}
		}
		Assert.assertTrue("The View Details dialog popup was not found", found);
	}
	
	public void moreActionMenuClick(final String menuAction,
			final String itemName) {
		waitForPageToLoadCompletely(30);
		boolean found = false;
		final Actions action = new Actions(getDriver());
		waitForListToLoad(documentsList, 10, false);
		for (final WebElement elem : documentsList) {
			final WebElement name = elem.findElement(By
					.cssSelector(titleListSelector));
			
			if (name.getText().toLowerCase().contains(itemName.toLowerCase())) {
				action.moveToElement(elem).build().perform();
				element (moreButtonIdentifier).waitUntilVisible();
				final WebElement moreButton = elem.findElement(By
						.cssSelector(moreButtonIdentifier));
			//	action.moveToElement(moreButton).build().perform();
				moreButton.click();
				action.moveToElement(moreButton).build().perform();
				final List<WebElement> moreActionsList = elem.findElements(By
						.cssSelector(moreActionsCSSSelector));
				waitForListToLoad(moreActionsList, 10, false);
			//	element (moreActionsCSSSelector).waitUntilVisible();
				for (final WebElement act : moreActionsList) {
					if (act.getText().toLowerCase()
							.contains(menuAction.toLowerCase())) {
						
					//	action.moveToElement(act).build().perform();
						act.click();
						found = true;
						break;
			
//			if (name.getText().toLowerCase().contains(itemName.toLowerCase())) {
//					final WebElement hiddenContainer = elem.findElement(By
//							.cssSelector(hiddenContainerIdentifier));
//				action.moveToElement(hiddenContainer).build().perform();
//				final WebElement moreButton = elem.findElement(By
//						.linkText(moreButtonIdentifier));
//				moreButton.click();
//				final List<WebElement> moreActionsList = elem.findElements(By
//						.cssSelector(moreActionsCSSSelector));
//				waitForListToLoad(moreActionsList, 10, false);
//				for (final WebElement act : moreActionsList) {
//					if (act.getText().toLowerCase()
//							.contains(menuAction.toLowerCase())) {
//						act.click();
//						found = true;
//						break;
					}
				}
			}
			if (found) {
				break;
			}
		}
		Assert.assertTrue("The item " + itemName + " was not extracted", found);
	}
	
	public void assetFromListClickSub(final String assetName) {
		boolean isAssetInList = false;
		waitForListToLoad(documentLibraryAssetName, 30, true);
		for (final WebElement asset : documentLibraryAssetName) {
			if (asset.getText().toLowerCase().trim().contains(assetName.toLowerCase().trim())) {   
				isAssetInList = true;
				asset.click();
				break;
			}
		}
		Assert.assertTrue("Asset is not in the list!", isAssetInList);
	}
	
	public void clickDeleteObject() {
		element(deleteObjectButton).waitUntilVisible();
		deleteObjectButton.click();
	}
	public void clickDeleteFolder() {
		element(deleteFolderButton).waitUntilVisible();
		deleteFolderButton.click();
	}
	
	public void confirmDelete() {
		element(confirmDelete).waitUntilVisible();
		confirmDelete.click();
	}
	
	public void filterByCategory(String categoryName) {
        boolean found = false;
        categoriesMainButton.click();
        waitABit(1000);
        categoryRootButton.click();
        waitABit(2000);
        for (WebElement filter : categoryFilters) {
            if (filter.getText().toLowerCase()
                    .contentEquals(categoryName.toLowerCase())) {
                found = true;
                filter.click();
                break;
            }
        }
        Assert.assertTrue("The filter was not found in Category list", found);
    }

	public void clickMoveto() {
		element(moveToselect).waitUntilVisible();
		moveToselect.click();
	}
	public void clickExtract() {
		element(extractButton).waitUntilVisible();
		extractButton.click();
	}
	
	public void navBarClick() {
		element(navBarViewDetails).waitUntilVisible();
		waitABit(2000);
		navBarViewDetails.click();
	}
	
	public void selectAllItems() {
		element(selectButton).waitUntilVisible();
		selectButton.click();
		element(allLink).waitUntilVisible();
		allLink.click();
	}
	
	public void clickCorrelations() {
		element(correlations).waitUntilVisible();
		correlations.click();
	}
	public void selectAspectForAFolder(final String aspectName) {
		boolean found = false;
		waitABit(1000);
		for (int i = 0; i < addAspectButtonList.size(); i++) {
			for (int j = 0; j < aspectsAvailableForFoldersList.size(); j++) {
				if (aspectsAvailableForFoldersList.get(j).getText()
						.toLowerCase().contentEquals(aspectName.toLowerCase())) {
					found = true;
					waitABit(2000);
					element(addAspectButtonList.get(i)).waitUntilVisible();
					addAspectButtonList.get(i).click();
					break;
				}
				i++;
			}
			if (found = true) {
				break;
			}
		}
		Assert.assertTrue("The aspect was not found", found);
	}
	
	private String generateProdSetname() {
		return ConstantsHMH.PREFIX_PRODUCTSET_NAME + RandomStringUtils.randomNumeric(7);
	}
}
	
