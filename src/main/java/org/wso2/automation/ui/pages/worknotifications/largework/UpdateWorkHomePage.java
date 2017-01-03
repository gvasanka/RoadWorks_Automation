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
import org.openqa.selenium.support.ui.Select;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class UpdateWorkHomePage extends BasePage{

    private WebElement lblSchemaType;
    private WebElement dropDownSchemaType;


    public UpdateWorkHomePage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));

            lblSchemaType=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SchemeHomePage.lblSchemaType.xpath"))));
            dropDownSchemaType=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SchemeHomePage.dropDownSchemaType.xpath"))));




        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public WorkTypeSchemePage selectSchemaType(String scheme){
        Select select=new Select(dropDownSchemaType);
        select.selectByVisibleText(scheme);

        return new WorkTypeSchemePage(driver,uiElementMapper,user);
    }


    public WorkTypeAttachedWorksPage selectAttachedWork(){
        Select select=new Select(dropDownSchemaType);
        select.selectByVisibleText("Attached Works");

        return new WorkTypeAttachedWorksPage(driver,uiElementMapper,user);
    }


}
