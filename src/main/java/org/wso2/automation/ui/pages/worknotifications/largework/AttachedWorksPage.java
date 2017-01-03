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
import org.wso2.automation.ui.pages.worknotifications.CreateWorkPage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class AttachedWorksPage extends BasePage{


    private WebElement lnkAddattachedWorks;

    public AttachedWorksPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            lnkAddattachedWorks=wait.until(ExpectedConditions.elementToBeClickable(By.linkText(uiElementMapper.getElement
                    ("AttachedWorksPage.lnkAddattachedWorks.link"))));

        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public CreateWorkPage addAttachedWorksToScheme(){
        lnkAddattachedWorks.click();
        return new CreateWorkPage(driver,uiElementMapper,user);
    }




}
