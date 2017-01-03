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


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.search.AdvancedSearchPage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkPromoterDetailsPage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;

import static org.wso2.automation.ui.utils.data.AppConstants.SKIP;
import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_NO;


/**
 * The following test case checks the Application accessibility via the URL
 */
public class CreateSaveAndSearchSimpleWorkTestCase extends RoadWorksUIBaseTest {

    private HomePage homePage;
    private WorkHomePage workHomePage;
    private CreateWorkPage createWorkPage;
    private SimpleWorkHomePage simpleWorkHomePage;
    private SimpleWorkPromoterDetailsPage simpleWorkPromoterDetailsPage;
    private AdvancedSearchPage advancedSearchPage;



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
        simpleWorkHomePage.selectOvernightWorks(TEXT_NO);
        simpleWorkHomePage.selectTrafficMgtType(simpleWorkTestData.trafficMgtType);
        simpleWorkHomePage.selectWorksType(simpleWorkTestData.worksType);


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

        new CreateWorkPage(driver,uiElementMapper,user).saveCreatedWork();

    }

    @Test(dependsOnMethods ="testCreateStandaloneWorkWith1Phase" )
    public void testSearchCreatedStansaloneWork(){
        workHomePage =homePage.loadWorkFormHomePage();
        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.enterSearchCriteria(SKIP,"Scheme","TLRN", simpleWorkTestData.borough,SKIP,
                simpleWorkTestData.promoter, simpleWorkTestData.notificationTitle,SKIP,"Saved");

        advancedSearchPage.clickClearButton();

        advancedSearchPage.enterSearchCriteria(SKIP,"Scheme","TLRN", simpleWorkTestData.borough,SKIP,
                simpleWorkTestData.promoter, simpleWorkTestData.notificationTitle,SKIP,"Saved");

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
