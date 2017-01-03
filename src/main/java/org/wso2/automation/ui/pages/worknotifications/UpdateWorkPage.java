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

package org.wso2.automation.ui.pages.worknotifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.data.SimpleWorkTestData;
import org.wso2.automation.ui.utils.test.User;

import static org.wso2.automation.ui.utils.data.AppConstants.SUB_TYPE_FORMAL;
import static org.wso2.automation.ui.utils.data.AppConstants.SUB_TYPE_PROVISIONAL;
import static org.wso2.automation.ui.utils.data.AppConstants.SUB_TYPE_SAVE;


public class UpdateWorkPage extends BasePage{

    private WebElement btnSave;
    private WebElement btnSubmitProvisional;
    private WebElement btnSubmitFormal;
    private WebElement btnWithdraw;

    public UpdateWorkPage(WebDriver driver, UIElementMapper uiElementMapper, User user, String workSubType) {
        super(driver,uiElementMapper,user);


        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));

            if(workSubType.equalsIgnoreCase(SUB_TYPE_SAVE)){
                btnSave=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.
                        getElement("UpdateWorkPage.btnSave.id"))));
                btnSubmitProvisional=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.
                        getElement("UpdateWorkPage.btnSubmitProvisional.id"))));
                btnSubmitFormal=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.
                        getElement("UpdateWorkPage.btnSubmitFormal.id"))));
                btnWithdraw=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.
                        getElement("UpdateWorkPage.btnWithdraw.xpath"))));
            }

            if(workSubType.equalsIgnoreCase(SUB_TYPE_PROVISIONAL)){
                btnSave=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.
                        getElement("UpdateWorkPage.btnSave.id"))));
                btnSubmitFormal=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.
                        getElement("UpdateWorkPage.btnSubmitFormal.id"))));
                btnWithdraw=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.
                        getElement("UpdateWorkPage.btnWithdraw.xpath"))));
            }

            if(workSubType.equalsIgnoreCase(SUB_TYPE_FORMAL)){
                btnSave=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.
                        getElement("UpdateWorkPage.btnSave.id"))));
                btnWithdraw=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.
                        getElement("UpdateWorkPage.btnWithdraw.xpath"))));
            }




        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public WorkHomePage doSubmitProvisional(){
        btnSubmitProvisional.click();
        handleAcceptWindow();
        return new WorkHomePage(driver,uiElementMapper,user);
    }

    public WorkHomePage doSubmitFormal(){
        btnSubmitFormal.click();
        handleAcceptWindow();
        return new WorkHomePage(driver,uiElementMapper,user);

    }

    public WorkHomePage doWithdraw(){
        btnWithdraw.click();

                WebElement txtComment=wait.until(ExpectedConditions.elementToBeClickable(By.
                        xpath(".//*[@id='notificationComment']")));
                WebElement btnProceed=wait.until(ExpectedConditions.elementToBeClickable(By.
                        xpath(".//*[@id='withdrawNotificationModalButton']")));
                WebElement btnDiscard=wait.until(ExpectedConditions.elementToBeClickable(By.
                        xpath(".//*[@id='withdrawNotificationModal']/div/div/div[3]/button[1]")));

                txtComment.sendKeys(SimpleWorkTestData.withdrawAppText);
                btnProceed.click();

        handleAcceptWindow();

        return new WorkHomePage(driver,uiElementMapper,user);

    }

    public WorkHomePage doSave(){
        btnSave.click();
        handleAcceptWindow();
        return new WorkHomePage(driver,uiElementMapper,user);

    }






}
