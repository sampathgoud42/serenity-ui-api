package com.hmh.automation.tools;

public class ConstantsHMH {

    public static final String CSV_FILES_BASE_PATH_HMH = "csv/";
    public static final String TESTDATA_FILES_BASE_PATH_HMH = "target/test-classes/filesToUpload/";
   // public static final String ALFRESCO_URL = "http://alf-qa.hmh.ixxus.co.uk/share";
    public static final String ALFRESCO_URL = "http://10.34.36.46:8080/share/page";
    public static final char CSV_SEPARATOR = ',';

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "Ohd7raev";

    public static final String TEST_USER_LOGIN = "automation_user_01";
    public static final String TEST_PASS_LOGIN = "welcome";
    public static final String TEST_USER_EMAIL = "TestUser@norealemail23143213.com";
    public static final String TEST_USER_GROUP = "alfresco_administrators";
    
    public static final String HABITAT_TEST_USER_LOGIN = "cms.engineering@hmhco.com";
    public static final String HABITAT_TEST_PASS_LOGIN = "habitatToken";

    public static final int SEARCH_RESULTS_MANUAL_SCROLL = 20;

    /*
     * how to run from command line: mvn clean dependency:unpack verify -U -P ft -Dwebdriver.driver=firefox
     * -Dwebdriver.base.url=http://alf-qa.hmh.ixxus.co.uk/share thucydides:aggregate -Dmaven.test.failure.ignore=true
     * 
     * Created in HMH Alfresco Share, the following user from vanilla alfresco constants public static final String ALFRESCO_TEST_USER_LOGIN = "TestUser";
     * public static final String ALFRESCO_TEST_PASS_LOGIN = "Auto.m@tion";
     */

    //roles for permissions
    public static final String USER_ROLE_MANAGER = "Manager";
    public static final String USER_ROLE_COLLABORATOR = "Collaborator";
    public static final String USER_ROLE_CONTRIBUTOR = "Contributor";
    public static final String USER_ROLE_CONSUMER = "Consumer";
    public static final String PREFIX_PRODUCTSET_NAME = "ProdcutSet";

}
