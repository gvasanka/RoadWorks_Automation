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
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.AttachmentsPage;
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkPhasesPage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkPromoterDetailsPage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;

import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_NO;
import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_YES;


/**
 * The following test case checks the creation of Simple work  with Attachements
 *
 */

public class CreateAndSaveSimpleWorkWithAttachmentTestCase extends RoadWorksUIBaseTest {


    private HomePage homePage;
    private WorkHomePage workHomePage;
    private CreateWorkPage createWorkPage;
    private SimpleWorkHomePage simpleWorkHomePage;
    private SimpleWorkPromoterDetailsPage simpleWorkPromoterDetailsPage;
    private SimpleWorkPhasesPage simpleWorkPhasesPage;
    private AttachmentsPage attachmentsPage;


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

        createWorkPage =new CreateWorkPage(driver,uiElementMapper,user);
        attachmentsPage= createWorkPage.loadAttachementsPage();
        attachmentsPage.addNewAttachement("File1","File1 Description","Existing Layout Drawings",
                "/src/main/resources/data/test1.txt");
        attachmentsPage.addNewAttachement("File2","File2 Description","NAT Planning Response",
                "/src/main/resources/data/test2.txt");
        workHomePage = createWorkPage.saveCreatedWork();

        workHomePage.checkWorkSearchTableLoad();


    }

    @Test()
    public void testCreateStandaloneWorkWithMorePhase(){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        simpleWorkHomePage = createWorkPage.selectStandaloneWork();

        Assert.assertEquals(simpleWorkHomePage.getLblMorethanPhase().getText(),"More than 1 Phase?");

        simpleWorkHomePage.selectMoreThan1Phase(TEXT_YES);
        simpleWorkHomePage.selectOvernightWorks(TEXT_NO);
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

        simpleWorkPhasesPage = simpleWorkHomePage.loadPhases();

        simpleWorkPhasesPage.addNewPhase(
                largeWorkTestData.tmStart,
                largeWorkTestData.tmEnd,
                largeWorkTestData.tfcMgt,
                largeWorkTestData.restrictions,
                largeWorkTestData.comments);

        createWorkPage = new CreateWorkPage(driver,uiElementMapper,user);
        attachmentsPage= createWorkPage.loadAttachementsPage();
        attachmentsPage.addNewAttachement("File1","File1 Description","Existing Layout Drawings",
                "/src/main/resources/data/test1.txt");
        attachmentsPage.addNewAttachement("File2","File2 Description","NAT Planning Response",
                "/src/main/resources/data/test2.txt");
        createWorkPage.saveCreatedWork();

    }


    @AfterClass()
    public void tearDown(){
        if (driver != null) {
             driver.quit();
        }
    }



}
