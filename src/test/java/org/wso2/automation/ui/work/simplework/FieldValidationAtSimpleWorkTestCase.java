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


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkPromoterDetailsPage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;


/**
 * The following test case checks the field validations at simplework work save
 */
public class FieldValidationAtSimpleWorkTestCase extends RoadWorksUIBaseTest {

    private HomePage homePage;
    private WorkHomePage workHomePage;
    private CreateWorkPage createWorkPage;
    private SimpleWorkHomePage simpleWorkHomePage;


    @BeforeClass()
    public void init() {
        User user=new User("promoter2","promoter2","Promoter");
        super.init(user);
        homePage= loginToRoadWorks();

    }

    @Test
    public void testFieldValidationAtSave(){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        simpleWorkHomePage = createWorkPage.selectStandaloneWork();

        new CreateWorkPage(driver,uiElementMapper,user).saveCreatedWorkWithoutFillingData();

        simpleWorkHomePage.verifyFieldValidationAtSave();
        new SimpleWorkPromoterDetailsPage(driver,uiElementMapper,user).verifyFieldValidationAtSave();

    }

    @Test
    public void testFieldValidationAtSubmitProvision(){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        simpleWorkHomePage = createWorkPage.selectStandaloneWork();

        new CreateWorkPage(driver,uiElementMapper,user).doSubmitProvisionalWithoutFillingData();
        simpleWorkHomePage.verifyFieldValidationAtProvision();
        new SimpleWorkPromoterDetailsPage(driver,uiElementMapper,user).verifyFieldValidationAtProvision();

    }

    @Test
    public void testFieldValidationAtSubmitFormal(){
        workHomePage =homePage.loadWorkFormHomePage();
        createWorkPage = workHomePage.loadCreateWork();
        simpleWorkHomePage = createWorkPage.selectStandaloneWork();

        new CreateWorkPage(driver,uiElementMapper,user).doSubmitFormalWithoutFillingData();

        simpleWorkHomePage.verifyFieldValidationAtSubmitFormal();
        new SimpleWorkPromoterDetailsPage(driver,uiElementMapper,user).verifyFieldValidationAtSubmitFormal();

    }

    @AfterClass()
    public void tearDown(){
        if (driver != null) {
             driver.quit();
        }
    }



}
