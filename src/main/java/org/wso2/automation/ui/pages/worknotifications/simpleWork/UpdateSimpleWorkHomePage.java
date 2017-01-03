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

package org.wso2.automation.ui.pages.worknotifications.simpleWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

/**
 * Created by asankav on 10/21/16.
 */
public class UpdateSimpleWorkHomePage extends BasePage{

    private WebElement lblMorethanPhase;
    private WebElement dropDownMorethanPhase;
    private WebElement lblTrafficMgt;
    private WebElement dropDownTrafficMgt;
    private WebElement lblOvernightWork;
    private WebElement dropDownOvernightWork;

    public WebElement getLblMorethanPhase() {
        return lblMorethanPhase;
    }

    public WebElement getLblTrafficMgt() {
        return lblTrafficMgt;
    }

    public WebElement getLblOvernightWork() {
        return lblOvernightWork;
    }


    public UpdateSimpleWorkHomePage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - Work"));


            lblMorethanPhase=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uiElementMapper.getElement("UpdateSimpleWorkHomePage.lblMorethanPhase.xpath"))));
            dropDownMorethanPhase=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("UpdateSimpleWorkHomePage.dropDownMorethanPhase.xpath"))));
            lblTrafficMgt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uiElementMapper.getElement("UpdateSimpleWorkHomePage.lblTrafficMgt.xpath"))));
            dropDownTrafficMgt=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("UpdateSimpleWorkHomePage.dropDownTrafficMgt.xpath"))));
            lblOvernightWork=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uiElementMapper.getElement("UpdateSimpleWorkHomePage.lblOvernightWork.xpath"))));
            dropDownOvernightWork=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("UpdateSimpleWorkHomePage.dropDownOvernightWork.xpath"))));


        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void selectOnePhase(){
        Select select=new Select(dropDownMorethanPhase);
        select.selectByVisibleText("No");

    }

    public void selectMorePhases(){
        Select select=new Select(dropDownMorethanPhase);
        select.selectByVisibleText("Yes");

    }

    public SimpleWorkPhasesPage expandPhases(){
        driver.findElement(By.id(uiElementMapper.getElement("UpdateSimpleWorkHomePage.lnkPhases.id"))).click();

        return new SimpleWorkPhasesPage(driver,uiElementMapper,user);
    }

    public SimpleWorkPromoterDetailsPage selectTrafficMgtType(String trafficMgtType){
        Select select=new Select(dropDownTrafficMgt);
        select.selectByVisibleText(trafficMgtType);

        return new SimpleWorkPromoterDetailsPage(driver,uiElementMapper,user);
    }

    public void selectOvernightWorks(String OvernightWorks){
        Select select=new Select(dropDownOvernightWork);
        select.selectByVisibleText(OvernightWorks);


    }

}
