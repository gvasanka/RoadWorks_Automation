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

package org.wso2.automation.ui.pages.worknotifications.largework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.worknotifications.AddNewPhasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class PhasesPage extends BasePage{

    private WebElement lblStart;
    private WebElement lblEnd;
    private WebElement lblTraffiMgt;
    private WebElement lblRestrictions;
    private WebElement btnAddWorksPhase;

    private AddNewPhasePage addNewPhasePage;


    public PhasesPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));

            lblStart=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("StandalonePhasesPage.lblStart.xpath"))));
            lblEnd=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("StandalonePhasesPage.lblEnd.xpath"))));
            lblTraffiMgt=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("StandalonePhasesPage.lblTraffiMgt.xpath"))));
            lblRestrictions=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("StandalonePhasesPage.lblRestrictions.xpath"))));

            btnAddWorksPhase=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("StandalonePhasesPage.btnAddWorksPhase.xpath"))));


        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void addNewPhase(String tmStart, String tmEnd, String tfcMgt, String restrictions, String comment){

        String parentWindow=driver.getWindowHandle();
        btnAddWorksPhase.click();

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            if(!winHandle.equals(parentWindow))
                driver.switchTo().window(winHandle);

            addNewPhasePage=new AddNewPhasePage(driver,uiElementMapper,user);
            addNewPhasePage.fillAddNewPhaseForm(tmStart,tmEnd,tfcMgt,restrictions,comment);
            addNewPhasePage.submitAddNewPhase();
        }

        driver.switchTo().window(parentWindow);

    }

    public void verifyAddNewPhase(String tmStart, String tmEnd, String tfcMgt, String restrictions, String comment){

        String parentWindow=driver.getWindowHandle();
        btnAddWorksPhase.click();

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            if(!winHandle.equals(parentWindow))
                driver.switchTo().window(winHandle);

            addNewPhasePage=new AddNewPhasePage(driver,uiElementMapper,user);
            addNewPhasePage.verifyAddNewPhaseForm(tmStart,tmEnd,tfcMgt,restrictions,comment);
            addNewPhasePage.submitAddNewPhase();
        }

        driver.switchTo().window(parentWindow);

    }


}
