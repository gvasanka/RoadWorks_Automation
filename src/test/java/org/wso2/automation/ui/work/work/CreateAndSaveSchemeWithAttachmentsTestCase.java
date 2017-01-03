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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.AttachmentsPage;
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.LargeWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.WorkTypeSchemePage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;

/**
 * The following test case checks the Create and Save functionality of Schemes With Attachements
 */
public class CreateAndSaveSchemeWithAttachmentsTestCase extends RoadWorksUIBaseTest {

    private HomePage homePage;
    private WorkHomePage WorkHomePage;
    private CreateWorkPage createWorkPage;
    private LargeWorkHomePage largeWorkHomePage;
    private WorkTypeSchemePage WorkTypeSchemePage;
    private AttachmentsPage attachmentsPage;

    @BeforeClass()
    public void init() {
        User user=new User("promoter1","promoter1","Promoter");
        super.init(user);
        homePage= loginToRoadWorks();

    }

    @Test(dataProvider = "schemeTypeDataProvider")
    public void testCreateAndSaveScheme(String schemeType){
        WorkHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = WorkHomePage.loadCreateWork();
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

        WorkTypeSchemePage.loadImpactsMitigationsForm().fillImpactsMitigationsForm(
                largeWorkTestData.IMPACTLEVEL_POSITIVE,
                largeWorkTestData.commentMessage);

        WorkTypeSchemePage.loadAttachedWorksForm().addAttachedWorksToScheme();

        createWorkPage =new CreateWorkPage(driver,uiElementMapper,user);
        attachmentsPage= createWorkPage.loadAttachementsPage();

        attachmentsPage.addNewAttachement("File1","File1 Description","Existing Layout Drawings",
                "/src/main/resources/data/test1.txt");
        attachmentsPage.addNewAttachement("File2","File2 Description","NAT Planning Response",
                "/src/main/resources/data/test2.txt");
        createWorkPage.saveCreatedWork();

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
