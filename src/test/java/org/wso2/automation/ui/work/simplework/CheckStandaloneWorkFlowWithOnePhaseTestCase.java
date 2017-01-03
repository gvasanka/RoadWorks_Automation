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

package org.wso2.automation.ui.work.simplework;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.UpdateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkPromoterDetailsPage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;

import java.util.List;

import static org.wso2.automation.ui.utils.data.AppConstants.STATUS_WITHDRAW;
import static org.wso2.automation.ui.utils.data.AppConstants.SUB_TYPE_FORMAL;
import static org.wso2.automation.ui.utils.data.AppConstants.SUB_TYPE_PROVISIONAL;
import static org.wso2.automation.ui.utils.data.AppConstants.SUB_TYPE_SAVE;
import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_NO;
import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_YES;


/**
 * The following test case checks the lifecycle of the Standalone Work With Only One Phase
 */
public class CheckStandaloneWorkFlowWithOnePhaseTestCase extends RoadWorksUIBaseTest {

    private HomePage homePage;
    private CreateWorkPage createWorkPage;
    private SimpleWorkHomePage simpleWorkHomePage;
    private SimpleWorkPromoterDetailsPage simpleWorkPromoterDetailsPage;
    private WorkHomePage workHomePage;
    private UpdateWorkPage updateWorkPage;


    @BeforeClass()
    public void init() {
        User user=new User("promoter2","promoter2","Promoter");
        super.init(user);
        homePage= loginToRoadWorks();

    }

    @Test
    public void testCreateStandaloneWorkWith1Phase(){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        simpleWorkHomePage = createWorkPage.selectStandaloneWork();
        Assert.assertEquals(simpleWorkHomePage.getLblMorethanPhase().getText(),"More than 1 Phase?");
        simpleWorkHomePage.selectMoreThan1Phase(TEXT_NO);
        simpleWorkHomePage.selectOvernightWorks(TEXT_YES);
        simpleWorkHomePage.selectTrafficMgtType(simpleWorkTestData.trafficMgtType);
        simpleWorkHomePage.selectWorksType(simpleWorkTestData.worksType);
        simpleWorkPromoterDetailsPage = simpleWorkHomePage.loadPromoterDetailsForm();

        simpleWorkPromoterDetailsPage.fillStandalonePromoterDetailsForm(
                simpleWorkTestData.promoter,
                simpleWorkTestData.companyName,
                simpleWorkTestData.contactName,
                simpleWorkTestData.contactAdd,
                simpleWorkTestData.contactEmail,
                simpleWorkTestData.contactNumber,
                simpleWorkTestData.mobileNumber,
                simpleWorkTestData.notificationTitle,
                simpleWorkTestData.propsedStart,
                simpleWorkTestData.proposedEnd,
                simpleWorkTestData.duration,
                simpleWorkTestData.locationUSRN,
                simpleWorkTestData.locationDetails,
                simpleWorkTestData.borough,
                simpleWorkTestData.isTLRN,
                simpleWorkTestData.isSRN,
                simpleWorkTestData.isBPRN,
                simpleWorkTestData.isBRN,
                simpleWorkTestData.workDetails,
                simpleWorkTestData.stakeholderConsultated,
                simpleWorkTestData.consultees );

        workHomePage =new CreateWorkPage(driver,uiElementMapper,user).saveCreatedWork();
        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> matchingWorks= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(workHomePage.isMatchingTextAvailableInCell(matchingWorks.get(0),"Saved"));
    }

    @Test(dependsOnMethods ="testCreateStandaloneWorkWith1Phase")
    public void testSubmitProvisionalStandalone(){
        workHomePage.checkWorkSearchTableLoad();
        updateWorkPage = workHomePage.viewMatchingWork(simpleWorkTestData.notificationTitle,SUB_TYPE_SAVE);
        updateWorkPage.doSubmitProvisional();

        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> matchingWorks= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(workHomePage.isMatchingTextAvailableInCell(matchingWorks.get(0),SUB_TYPE_PROVISIONAL));


    }

    @Test(dependsOnMethods ="testSubmitProvisionalStandalone")
    public void testSubmitFormalStandalone(){
        workHomePage.checkWorkSearchTableLoad();
        updateWorkPage = workHomePage.viewMatchingWork(simpleWorkTestData.notificationTitle,SUB_TYPE_PROVISIONAL);
        updateWorkPage.doSubmitFormal();

        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> matchingWorks= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(workHomePage.isMatchingTextAvailableInCell(matchingWorks.get(0),SUB_TYPE_FORMAL));


    }

    @Test(dependsOnMethods ="testSubmitFormalStandalone")
    public void testWithdrawFormalStandalone(){
        workHomePage.checkWorkSearchTableLoad();
        updateWorkPage = workHomePage.viewMatchingWork(simpleWorkTestData.notificationTitle,SUB_TYPE_FORMAL);
        updateWorkPage.doWithdraw();

        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> matchingWorks= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(workHomePage.isMatchingTextAvailableInCell(matchingWorks.get(0),SUB_TYPE_FORMAL));
        Assert.assertTrue(workHomePage.isMatchingTextAvailableInCell(matchingWorks.get(0),STATUS_WITHDRAW));


    }


    @AfterClass()
    public void tearDown(){
        if (driver != null) {
             driver.quit();
        }
    }



}
