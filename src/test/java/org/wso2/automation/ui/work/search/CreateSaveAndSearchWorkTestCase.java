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

package org.wso2.automation.ui.work.search;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.LargeWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.WorkTypeSchemePage;
import org.wso2.automation.ui.pages.worknotifications.search.AdvancedSearchPage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;

import static org.wso2.automation.ui.utils.data.AppConstants.SKIP;


/**
 * The following test case checks the Create and Save functionality of Schemes, Then try to find created SchemeWork
 * using Advanced search
 */
public class CreateSaveAndSearchWorkTestCase extends RoadWorksUIBaseTest {


    private HomePage homePage;
    private WorkHomePage workHomePage;
    private CreateWorkPage createWorkPage;
    private LargeWorkHomePage largeWorkHomePage;
    private WorkTypeSchemePage WorkTypeSchemePage;
    private AdvancedSearchPage advancedSearchPage;


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
        WorkTypeSchemePage = largeWorkHomePage.selectSchemaType("Better Junctions");

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

    @Test(dependsOnMethods ="testCreateAndSaveScheme" )
    public void testSearchCreatedSchemeWork(){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.enterSearchCriteria(SKIP,"Scheme","TLRN", largeWorkTestData.borough,SKIP,
                largeWorkTestData.promoter, largeWorkTestData.notificationTitle,SKIP,"Saved");
        advancedSearchPage.clickClearButton();
        advancedSearchPage.enterSearchCriteria(SKIP,"Scheme","TLRN", largeWorkTestData.borough,SKIP,
                largeWorkTestData.promoter, largeWorkTestData.notificationTitle,SKIP,"Saved");
        workHomePage =advancedSearchPage.clickApplyButton();

//        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
//        Assert.assertTrue(elements.size()>0);

    }


    @AfterClass()
    public void tearDown(){
        if (driver != null) {
        driver.quit();
        }
    }



}
