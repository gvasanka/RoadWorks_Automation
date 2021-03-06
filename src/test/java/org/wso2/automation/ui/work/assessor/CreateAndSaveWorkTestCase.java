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

package org.wso2.automation.ui.work.assessor;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.UpdateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.largework.LargeWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.WorkTypeSchemePage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;

import java.util.List;

import static org.wso2.automation.ui.utils.data.AppConstants.SCHEME;
import static org.wso2.automation.ui.utils.data.AppConstants.STATUS_WITHDRAW;
import static org.wso2.automation.ui.utils.data.AppConstants.SUB_TYPE_SAVE;


/**
 * The following test case checks the Create and Save functionality of Schemes
 */
public class CreateAndSaveWorkTestCase extends RoadWorksUIBaseTest {

    private HomePage homePage;
    private WorkHomePage workHomePage;
    private CreateWorkPage createWorkPage;
    private LargeWorkHomePage largeWorkHomePage;
    private WorkTypeSchemePage WorkTypeSchemePage;
    private UpdateWorkPage updateWorkPage;


    @BeforeClass()
    public void init() {
        User user=new User("assessor1","assessor1","Assessor");
        super.init(user);
        homePage= loginToRoadWorks();
    }

    @Test(dataProvider = "schemeTypeDataProvider")
    public void testCreateAndSaveScheme(String schemeType){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        largeWorkHomePage = createWorkPage.selectSchemeWork();
        WorkTypeSchemePage = largeWorkHomePage.selectSchemaType(schemeType);

        WorkTypeSchemePage.loadPromoterDetailsForm().
                fillSchemePromoterDetailsForm(largeWorkTestData.promoter, largeWorkTestData.contactName,
                        largeWorkTestData.contactAddress, largeWorkTestData.contactPositions, largeWorkTestData.contactEmail, largeWorkTestData.contactNumber, largeWorkTestData.mobileNumber);

        WorkTypeSchemePage.loadSchemeSummaryForm().
                fillSchemeSummaryForm(largeWorkTestData.notificationTitle, largeWorkTestData.proposalClient, largeWorkTestData
                        .promoterRef, largeWorkTestData.bspRef, largeWorkTestData.wbsCode, largeWorkTestData.siteNumber);

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


        WorkTypeSchemePage.loadImpactsMitigationsForm().fillImpactsMitigationsForm(largeWorkTestData.IMPACTLEVEL_POSITIVE,
                largeWorkTestData.commentMessage);
        WorkTypeSchemePage.loadAttachedWorksForm().addAttachedWorksToScheme();
        new CreateWorkPage(driver,uiElementMapper,user).saveCreatedWork();
    }

    @Test(dependsOnMethods ="testCreateAndSaveScheme")
    public void testWithdrawSavedScheme(){
        workHomePage.checkWorkSearchTableLoad();
        updateWorkPage = workHomePage.viewMatchingWork(SCHEME,SUB_TYPE_SAVE);
        updateWorkPage.doWithdraw();

        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> matchingWorks= workHomePage.findMatchingTableRow(largeWorkTestData.notificationTitle);
        Assert.assertTrue(workHomePage.isMatchingTextAvailableInCell(matchingWorks.get(0),SUB_TYPE_SAVE));
        Assert.assertTrue(workHomePage.isMatchingTextAvailableInCell(matchingWorks.get(0),STATUS_WITHDRAW));
    }

    @DataProvider(name ="schemeTypeDataProvider")
    public Object[][] provideData() {

        return new Object[][]{
                        {"CSH"},
                        {"STIP"},
                        {"Better Junctions"},
                        {"Mini Holland"},
                        {"Improvement"},
                        {"Development"},
                        {"Major Works"},
                };
    }


    @AfterClass()
    public void tearDown(){
        if (driver != null) {
        driver.quit();
        }
    }



}
