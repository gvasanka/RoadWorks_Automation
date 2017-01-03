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
import org.wso2.automation.ui.pages.worknotifications.UpdateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.largework.LargeWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.WorkTypeSchemePage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;

import static org.wso2.automation.ui.utils.data.AppConstants.SUB_TYPE_SAVE;


/**
 * The following test case checks the Edit and Save functionality of Schemes
 */
public class EditAndSaveSchemeTestCase extends RoadWorksUIBaseTest {

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
    public void testCreateAndSaveScheme(){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        largeWorkHomePage = createWorkPage.selectSchemeWork();

        WorkTypeSchemePage = largeWorkHomePage.selectSchemaType(largeWorkTestData.schemeType);

        WorkTypeSchemePage.loadPromoterDetailsForm().fillSchemePromoterDetailsForm(
                        largeWorkTestData.promoter,
                        largeWorkTestData.contactName,
                        largeWorkTestData.contactAddress,
                        largeWorkTestData.contactPositions,
                        largeWorkTestData.contactEmail,
                        largeWorkTestData.contactNumber,
                        largeWorkTestData.mobileNumber);

        WorkTypeSchemePage.loadSchemeSummaryForm().fillSchemeSummaryForm(
                        largeWorkTestData.notificationTitle,
                        largeWorkTestData.proposalClient,
                        largeWorkTestData.promoterRef,
                        largeWorkTestData.bspRef,
                        largeWorkTestData.wbsCode,
                        largeWorkTestData.siteNumber);

        WorkTypeSchemePage.loadDetailForm().fillDetailsForm(
                largeWorkTestData.startDate,
                largeWorkTestData.endDate,
                largeWorkTestData.locationUSRN,
                largeWorkTestData.locationDetails,
                largeWorkTestData.signalSiteNumbers,
                largeWorkTestData.roadNumbers,
                largeWorkTestData.borough,
                largeWorkTestData.isTLRN,
                largeWorkTestData.isSRN,
                largeWorkTestData.isBPRN,
                largeWorkTestData.isBRN,
                largeWorkTestData.schemeDetails,
                largeWorkTestData.worksImpact,
                largeWorkTestData.worksDetails,
                largeWorkTestData.consultationSummary,
                largeWorkTestData.trafficOrder,
                largeWorkTestData.consultees,
                largeWorkTestData.adjacentSchemes);

        WorkTypeSchemePage.loadImpactsMitigationsForm().fillImpactsMitigationsForm(
                largeWorkTestData.IMPACTLEVEL_POSITIVE,
                largeWorkTestData.commentMessage);

        workHomePage =new CreateWorkPage(driver,uiElementMapper,user).saveCreatedWork();
    }

    @Test(dependsOnMethods = "testCreateAndSaveScheme")
    public void testEditAndSaveScheme(){

        workHomePage.checkWorkSearchTableLoad();
        workHomePage.viewMatchingWork(largeWorkTestData.notificationTitle,SUB_TYPE_SAVE);
        WorkTypeSchemePage =new WorkTypeSchemePage(driver,uiElementMapper,user);

        WorkTypeSchemePage.loadPromoterDetailsForm().fillSchemePromoterDetailsForm(
                        largeWorkTestData.promoter,
                        largeWorkTestData.contactName,
                        largeWorkTestData.contactAddress,
                        largeWorkTestData.contactPositions,
                        largeWorkTestData.contactEmail,
                        largeWorkTestData.contactNumber,
                        largeWorkTestData.mobileNumber);

        WorkTypeSchemePage.loadSchemeSummaryForm().fillSchemeSummaryForm(
                        largeWorkTestData.notificationTitle,
                        largeWorkTestData.proposalClient,
                        largeWorkTestData.promoterRef,
                        largeWorkTestData.bspRef,
                        largeWorkTestData.wbsCode,
                        largeWorkTestData.siteNumber);

        WorkTypeSchemePage.loadDetailForm().fillDetailsForm(
                largeWorkTestData.startDate,
                largeWorkTestData.endDate,
                largeWorkTestData.locationUSRN,
                largeWorkTestData.locationDetails,
                largeWorkTestData.signalSiteNumbers,
                largeWorkTestData.roadNumbers,
                largeWorkTestData.borough,
                largeWorkTestData.isTLRN,
                largeWorkTestData.isSRN,
                largeWorkTestData.isBPRN,
                largeWorkTestData.isBRN,
                largeWorkTestData.schemeDetails,
                largeWorkTestData.worksImpact,
                largeWorkTestData.worksDetails,
                largeWorkTestData.consultationSummary,
                largeWorkTestData.trafficOrder,
                largeWorkTestData.consultees,
                largeWorkTestData.adjacentSchemes);

        WorkTypeSchemePage.loadImpactsMitigationsForm().fillImpactsMitigationsForm(
                largeWorkTestData.IMPACTLEVEL_POSITIVE,
                largeWorkTestData.commentMessage);

        workHomePage =new UpdateWorkPage(driver,uiElementMapper,user,SUB_TYPE_SAVE).doSave();
    }

    @Test(dependsOnMethods = "testEditAndSaveScheme")
    public void verifyUpdateScheme() {
        workHomePage.checkWorkSearchTableLoad();
        workHomePage.viewMatchingWork(largeWorkTestData.notificationTitle,SUB_TYPE_SAVE);
        WorkTypeSchemePage =new WorkTypeSchemePage(driver,uiElementMapper,user);

        WorkTypeSchemePage.loadPromoterDetailsForm().verifySchemePromoterDetailsForm(
                largeWorkTestData.promoter,
                largeWorkTestData.contactName,
                largeWorkTestData.contactAddress,
                largeWorkTestData.contactPositions,
                largeWorkTestData.contactEmail,
                largeWorkTestData.contactNumber,
                largeWorkTestData.mobileNumber);

    }

    @AfterClass()
    public void tearDown(){
        if (driver != null) {
           driver.quit();
        }
    }



}
