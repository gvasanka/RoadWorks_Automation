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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkPhasesPage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class AddNewPhasePage extends BasePage{
    private WebElement lblAddNewPhase;
    private WebElement lblTMStart;
    private WebElement lblTMEnd;
    private WebElement txtTMStart;
    private WebElement txtTMEnd;
    private WebElement chkBoxContinuous;
    private WebElement dropDownTraffficMgt;
    private WebElement dropDownRestrictions;
    private WebElement txtAttachment;
    private WebElement txtComments;
    private WebElement btnSubmit;
    private WebElement btnDismiss;


    public AddNewPhasePage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);


        try {

//            lblAddNewPhase=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
//                    ("AddNewPhasePage.lblAddNewPhase.id"))));
//            lblTMStart=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement
//                    ("AddNewPhasePage.lblTMStart.xpath"))));
//            lblTMEnd=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement
//                    ("AddNewPhasePage.lblTMEnd.xpath"))));

            txtTMStart=driver.findElement(By.id(uiElementMapper.getElement("AddNewPhasePage.txtTMStart.id")));
            txtTMEnd=driver.findElement(By.id(uiElementMapper.getElement("AddNewPhasePage.txtTMEnd.id")));
            chkBoxContinuous=driver.findElement(By.id(uiElementMapper.
                    getElement("AddNewPhasePage.chkBoxContinuous.id")));
            dropDownTraffficMgt=driver.findElement(By.id(uiElementMapper.getElement("AddNewPhasePage.dropDownTraffficMgt.id")));
            dropDownRestrictions=driver.findElement(By.id(uiElementMapper.getElement("AddNewPhasePage.dropDownRestrictions.id")));
            txtAttachment= driver.findElement(By.id(uiElementMapper.getElement("AddNewPhasePage.txtAttachment.id")));
            txtComments=driver.findElement(By.id(uiElementMapper.getElement("AddNewPhasePage.txtComments.id")));
            btnSubmit=driver.findElement(By.id(uiElementMapper.getElement("AddNewPhasePage.btnSubmit.id")));
            btnDismiss=driver.findElement(By.xpath(uiElementMapper.getElement("AddNewPhasePage.btnDismiss.xpath")));

        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void fillAddNewPhaseForm(String startDate, String endDate, String trafficMgt, String restrictions,String comments){

        txtTMStart.sendKeys(startDate);
        txtTMEnd.sendKeys(endDate);

        Select select=new Select(dropDownTraffficMgt);
        select.selectByVisibleText(trafficMgt);

        select=new Select(dropDownRestrictions);
        select.selectByVisibleText(restrictions);

//        txtAttachment.sendKeys(attachment);
        txtComments.sendKeys(comments);
    }

    public void verifyAddNewPhaseForm(String startDate, String endDate, String trafficMgt, String restrictions,String
            comments){

        Select select=new Select(dropDownTraffficMgt);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),trafficMgt);

        select=new Select(dropDownRestrictions);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),restrictions);

        Assert.assertEquals(txtComments.getText(),comments);

    }


    public SimpleWorkPhasesPage submitAddNewPhase(){
        btnSubmit.click();
        return new SimpleWorkPhasesPage(driver,uiElementMapper,user);
    }

    public SimpleWorkPhasesPage dismissAddNewPhase(){
        btnDismiss.click();
        return new SimpleWorkPhasesPage(driver,uiElementMapper,user);
    }




}
