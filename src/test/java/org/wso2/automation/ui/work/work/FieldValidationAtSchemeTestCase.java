/*
 *
 *  * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *  *
 *  * WSO2 Inc. licenses this file to you under the Apache License,
 *  * Version 2.0 (the "License"); you may not use this file except
 *  * in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *    http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing,
 *  * software distributed under the License is distributed on an
 *  * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  * KIND, either express or implied.  See the License for the
 *  * specific language governing permissions and limitations
 *  * under the License.
 *
 */

package org.wso2.automation.ui.work.work;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.LargeWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.WorkTypeSchemePage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;


/**
 * The following test case checks field validation at Save
 */

public class FieldValidationAtSchemeTestCase extends RoadWorksUIBaseTest {

    private HomePage homePage;
    private WorkHomePage workHomePage;
    private WorkTypeSchemePage WorkTypeSchemePage;
    private CreateWorkPage createWorkPage;
    private LargeWorkHomePage largeWorkHomePage;



    @BeforeClass()
    public void init() {
        User user=new User("promoter1","promoter1","Promoter");
        super.init(user);
        homePage= loginToRoadWorks();

    }


    @Test
    public void testFieldValidationAtSave(){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        largeWorkHomePage = createWorkPage.selectSchemeWork();
        WorkTypeSchemePage = largeWorkHomePage.selectSchemaType(largeWorkTestData.schemeType);

        new CreateWorkPage(driver,uiElementMapper,user).saveCreatedWorkWithoutFillingData();
        WorkTypeSchemePage.loadPromoterDetailsForm().fieldValidationAtSave();
        WorkTypeSchemePage.loadSchemeSummaryForm().fieldValidationAtSave();
        WorkTypeSchemePage.loadDetailForm().fieldValidationAtSave();


    }

    @Test
    public void testFieldValidationAtProvision(){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        largeWorkHomePage = createWorkPage.selectSchemeWork();
        WorkTypeSchemePage = largeWorkHomePage.selectSchemaType(largeWorkTestData.schemeType);

        new CreateWorkPage(driver,uiElementMapper,user).doSubmitProvisionalWithoutFillingData();

        WorkTypeSchemePage.loadPromoterDetailsForm().fieldValidationAtSubmitProvision();
        WorkTypeSchemePage.loadSchemeSummaryForm().fieldValidationAtProvision();
        WorkTypeSchemePage.loadDetailForm().fieldValidationAtSubmitProvision();


    }

    @Test
    public void testFieldValidationAtSubmitFormal(){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        largeWorkHomePage = createWorkPage.selectSchemeWork();
        WorkTypeSchemePage = largeWorkHomePage.selectSchemaType(largeWorkTestData.schemeType);

        new CreateWorkPage(driver,uiElementMapper,user).doSubmitFormalWithoutFillingData();

        WorkTypeSchemePage.loadPromoterDetailsForm().fieldValidationAtSubmitFormal();
        WorkTypeSchemePage.loadSchemeSummaryForm().fieldValidationAtSubmitFormal();
        WorkTypeSchemePage.loadDetailForm().fieldValidationAtSubmitFormal();


    }

    @AfterClass()
    public void tearDown(){
        if (driver != null) {
        driver.quit();
        }
    }



}
