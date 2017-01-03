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


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.LargeWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.WorkTypeAttachedWorksPage;
import org.wso2.automation.ui.pages.worknotifications.search.AdvancedSearchPage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;

import java.util.List;

import static org.wso2.automation.ui.utils.data.AppConstants.SKIP;


/**
 * The following test case checks the Create And Save of AttachWorks
 */

public class CreateSaveAndSearchAttachWorksTestCase extends RoadWorksUIBaseTest {

    private HomePage homePage;
    private WorkHomePage workHomePage;
    private CreateWorkPage createWorkPage;
    private LargeWorkHomePage largeWorkHomePage;
    private WorkTypeAttachedWorksPage workTypeAttachedWorksPage;
    private AdvancedSearchPage advancedSearchPage;


    @BeforeClass()
    public void init() {
        User user=new User("promoter1","promoter1","Promoter");
        super.init(user);
        homePage= loginToRoadWorks();
    }

    @Test
    public void testCreateAndSaveAttacheWorks(){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        largeWorkHomePage = createWorkPage.selectSchemeWork();
        workTypeAttachedWorksPage = largeWorkHomePage.selectAttachedWork();
        workTypeAttachedWorksPage.fillParentSchemeNumber("N1600850");

        workTypeAttachedWorksPage.loadPromoterDetailsForm().fillSchemePromoterDetailsForm(
                largeWorkTestData.promoter,
                largeWorkTestData.contactName,
                largeWorkTestData.contactAddress,
                largeWorkTestData.contactPositions,
                largeWorkTestData.contactEmail,
                largeWorkTestData.contactNumber,
                largeWorkTestData.mobileNumber);

        workTypeAttachedWorksPage.loadSchemeSummaryForm().fillSchemeSummaryForm(
                largeWorkTestData.notificationTitle,
                largeWorkTestData.proposalClient,
                largeWorkTestData.promoterRef,
                largeWorkTestData.bspRef,
                largeWorkTestData.wbsCode,
                largeWorkTestData.siteNumber);

        workTypeAttachedWorksPage.loadDetailForm().fillDetailsForm(
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

        workTypeAttachedWorksPage.loadPhasesForm().addNewPhase(
                largeWorkTestData.tmStart,
                largeWorkTestData.tmEnd,
                largeWorkTestData.tfcMgt,
                largeWorkTestData.restrictions,
                largeWorkTestData.comments);


        workHomePage =new CreateWorkPage(driver,uiElementMapper,user).saveCreatedWork();
    }

    @Test(dependsOnMethods ="testCreateAndSaveAttacheWorks" )
    public void testSearchCreatedAttacheWorks(){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.enterSearchCriteria(SKIP,"Work","TLRN", largeWorkTestData.borough,SKIP,
                largeWorkTestData.promoter, largeWorkTestData.notificationTitle,SKIP,"Saved");
        advancedSearchPage.clickClearButton();
        advancedSearchPage.enterSearchCriteria(SKIP,"Scheme","TLRN", largeWorkTestData.borough,SKIP,
                largeWorkTestData.promoter, largeWorkTestData.notificationTitle,SKIP,"Saved");
        workHomePage =advancedSearchPage.clickApplyButton();

        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(elements.size()>0);

    }




    @AfterClass()
    public void tearDown(){
        if (driver != null) {
        driver.quit();
        }
    }



}
