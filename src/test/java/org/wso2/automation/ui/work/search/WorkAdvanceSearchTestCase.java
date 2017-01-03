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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.search.AdvancedSearchPage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;

import java.util.List;


/**
 * The following test case checks the Create And Save of AttachWorks
 */

public class WorkAdvanceSearchTestCase extends RoadWorksUIBaseTest {

    private HomePage homePage;
    private WorkHomePage workHomePage;
    private AdvancedSearchPage advancedSearchPage;




    @BeforeClass()
    public void init() {
        User user=new User("promoter1","promoter1","Promoter");
        super.init(user);
        homePage= loginToRoadWorks();
        workHomePage =homePage.loadWorkFormHomePage();
    }


    @Test(dataProvider = "RefNumberDataProvider")
    public void testSearchByRefNumber(String refNumber){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.searchByRefNumber(refNumber);
        advancedSearchPage.clickClearButton();
        advancedSearchPage.searchByRefNumber(refNumber);
        workHomePage =advancedSearchPage.clickApplyButton();
        workHomePage.checkWorkSearchTableLoad();

        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(elements.size()>0);

    }

    @Test(dataProvider = "TypeDataProvider")
    public void testSearchBytype(String type){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.searchByType(type);
        advancedSearchPage.clickClearButton();
        advancedSearchPage.searchByType(type);
        workHomePage =advancedSearchPage.clickApplyButton();
        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(elements.size()>0);

    }

    @Test(dataProvider = "RoadNWDataProvider")
    public void testSearchRoadNetwork(String roadNetwork){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.searchByRoadNetwork(roadNetwork);
        advancedSearchPage.clickClearButton();
        advancedSearchPage.searchByRoadNetwork(roadNetwork);
        workHomePage =advancedSearchPage.clickApplyButton();
        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(elements.size()>0);

    }

    @Test(dataProvider = "BroughLocationDataProvider")
    public void testSearchByBroughLocation(String broughLocation){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.searchByBoroughLocation(broughLocation);
        advancedSearchPage.clickClearButton();
        advancedSearchPage.searchByBoroughLocation(broughLocation);
        workHomePage =advancedSearchPage.clickApplyButton();
        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(elements.size()>0);

    }

    @Test(dataProvider = "PromoRefDataProvider")
    public void testSearchByPromReference(String promoterRef){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.searchByPromoterRef(promoterRef);
        advancedSearchPage.clickClearButton();
        advancedSearchPage.searchByPromoterRef(promoterRef);
        workHomePage =advancedSearchPage.clickApplyButton();
        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(elements.size()>0);

    }

    @Test(dataProvider = "PromoterOrgDataProvider")
    public void testSearchByPromOrg(String promoterOrg){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.searchByPromoterOrg(promoterOrg);
        advancedSearchPage.clickClearButton();
        advancedSearchPage.searchByPromoterOrg(promoterOrg);
        workHomePage =advancedSearchPage.clickApplyButton();
        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(elements.size()>0);

    }

    @Test(dataProvider = "NotificationTitleDataProvider")
    public void testSearchByNotificationTitle(String notificationTitle){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.searchByNotificationTitle(notificationTitle);
        advancedSearchPage.clickClearButton();
        advancedSearchPage.searchByNotificationTitle(notificationTitle);
        workHomePage =advancedSearchPage.clickApplyButton();
        workHomePage.checkWorkSearchTableLoad();
//        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
//        Assert.assertTrue(elements.size()>0);

    }

    @Test(dataProvider = "StatusDataProvider")
    public void testSearchByStatus(String status){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.searchByStatus(status);
        advancedSearchPage.clickClearButton();
        advancedSearchPage.searchByStatus(status);
        workHomePage =advancedSearchPage.clickApplyButton();
        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(elements.size()>0);

    }

    @Test(dataProvider = "SubmissionTypeDataProvider")
    public void testSearchBySubmissionType(String submissionType){

        advancedSearchPage = workHomePage.loadAdavancedSearch();

        advancedSearchPage.searchBySubmissionType(submissionType);
        advancedSearchPage.clickClearButton();
        advancedSearchPage.searchBySubmissionType(submissionType);
        workHomePage =advancedSearchPage.clickApplyButton();
        workHomePage.checkWorkSearchTableLoad();
        List<WebElement> elements= workHomePage.findMatchingTableRow(simpleWorkTestData.notificationTitle);
        Assert.assertTrue(elements.size()>0);

    }


    @DataProvider(name ="TypeDataProvider")
    public Object[][] provideData1() {

        return new Object[][]{
                {"Work"},
                {"Scheme"},
                {"Standalone Work"}
        };
    }

    @DataProvider(name ="RoadNWDataProvider")
    public Object[][] provideData2() {

        return new Object[][]{
                {"SRN"},
                {"TLRN"},
                {"BPRN"},
                {"BRN"}
        };
    }

    @DataProvider(name ="BroughLocationDataProvider")
    public Object[][] provideData3() {

        return new Object[][]{
                {"Hackney"},
                {"Bromley"},
                {"Camden"},
                {"Haringey"}
        };
    }

    @DataProvider(name ="PromoterOrgDataProvider")
    public Object[][] provideData4() {

        return new Object[][]{
                {"Test1"},
                {"Test1"},
                {"Test1"},
                {"Test1"}
        };
    }

    @DataProvider(name ="RefNumberDataProvider")
    public Object[][] provideData5() {

        return new Object[][]{
                {"N1601561"},
                {"N1601546"},
                {"N1601545"},
                {"N1601542"}
        };
    }


    @DataProvider(name ="NotificationTitleDataProvider")
    public Object[][] provideData6() {

        return new Object[][]{
                {"Pitigal road traffic3"},
                {"N1601546"},
                {"N1601545"},
                {"N1601542"}
        };
    }

    @DataProvider(name ="StatusDataProvider")
    public Object[][] provideData7() {

        return new Object[][]{
                {"Withdrawn"},
                {"Notification Required"},
                {"No Notification Required"},
                {"Objection"},
                {"No Objection"}
        };
    }

    @DataProvider(name ="SubmissionTypeDataProvider")
    public Object[][] provideData8() {

        return new Object[][]{
                {"Saved"},
                {"Notification Required"},
                {"Formal"}
        };
    }

    @DataProvider(name ="PromoRefDataProvider")
    public Object[][] provideData9() {

        return new Object[][]{
                {"test1"},
                {"test1"},
                {"test1"}
        };
    }
    @AfterClass()
    public void tearDown(){
        if (driver != null) {
        driver.quit();
        }
    }



}
