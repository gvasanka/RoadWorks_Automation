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


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.UpdateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkPhasesPage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkPromoterDetailsPage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;

import static org.wso2.automation.ui.utils.data.AppConstants.SUB_TYPE_SAVE;
import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_NO;
import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_YES;


/**
 * The following test case checks the Create Save Verify And StandaloneWorkTestCase
 */

public class CreateAndSaveSimpleWorkTestCase extends RoadWorksUIBaseTest {

    private HomePage homePage;
    private WorkHomePage workHomePage;
    private CreateWorkPage createWorkPage;
    private SimpleWorkHomePage simpleWorkHomePage;
    private SimpleWorkPromoterDetailsPage simpleWorkPromoterDetailsPage;
    private SimpleWorkPhasesPage simpleWorkPhasesPage;
    private UpdateWorkPage updateWorkPage;

    private User user;

    @Factory(dataProvider = "userDataProvider")
    public CreateAndSaveSimpleWorkTestCase(User user) {
        this.user = user;
    }


    @BeforeClass()
    public void init() {
//        User user=new User("promoter2","promoter2","Promoter");
        super.init(user);

        homePage= loginToRoadWorks();

    }

    @Test(dataProvider = "trafficMgtTypeDataProvider")
    public void testCreateStandaloneWorkWith1Phase(String trafficMgtTypeDataProvider){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        simpleWorkHomePage = createWorkPage.selectStandaloneWork();
        Assert.assertEquals(simpleWorkHomePage.getLblMorethanPhase().getText(),"More than 1 Phase?");
        simpleWorkHomePage.selectMoreThan1Phase(TEXT_NO);
        simpleWorkHomePage.selectOvernightWorks(TEXT_YES);
        simpleWorkHomePage.selectTrafficMgtType(trafficMgtTypeDataProvider);
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


//       Verify the created Work content
            workHomePage.checkWorkSearchTableLoad();
            workHomePage.viewMatchingWork(simpleWorkTestData.notificationTitle,SUB_TYPE_SAVE);

            simpleWorkHomePage =new SimpleWorkHomePage(driver,uiElementMapper,user);




    }

    @Test(dataProvider = "trafficMgtTypeDataProvider")
    public void testCreateStandaloneWorkWithMorePhase(String trafficMgtTypeDataProvider){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        simpleWorkHomePage = createWorkPage.selectStandaloneWork();
        Assert.assertEquals(simpleWorkHomePage.getLblMorethanPhase().getText(),"More than 1 Phase?");
        simpleWorkHomePage.selectMoreThan1Phase(TEXT_YES);
        simpleWorkHomePage.selectOvernightWorks(TEXT_YES);

        simpleWorkHomePage.selectTrafficMgtType(trafficMgtTypeDataProvider);
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

        simpleWorkPhasesPage = simpleWorkHomePage.loadPhases();

        simpleWorkPhasesPage.addNewPhase(
                largeWorkTestData.tmStart,
                largeWorkTestData.tmEnd,
                largeWorkTestData.tfcMgt,
                largeWorkTestData.restrictions,
                largeWorkTestData.comments);

        new CreateWorkPage(driver,uiElementMapper,user).saveCreatedWork();

    }

    @DataProvider(name ="trafficMgtTypeDataProvider")
    public Object[][] provideData() {

        return new Object[][]{
                {"Road Closure"},
                {"Multi-way Signals"},
                {"2-way Signals"},
                {"Contra-flow"},
                {"Stop & Go"},
                {"Priority Working"},
                {"2+ Lanes Remains Running"},
                {"1 Lane Remains Running"},
                {"No Impact on Running Lanes"},
        };
    }

    @DataProvider(name ="userDataProvider")
    public static Object[][] provideData2() {
        return new Object[][] {
                { new User("promoter1","promoter1","Promoter")},
                { new User("assessor1","assessor1","Assessor") },
                { new User("qa_lw_admin","qa_lw_admin","Admin") }
        };
    }

    @AfterClass()
    public void tearDown(){
        if (driver != null) {
             driver.quit();
        }
    }



}
