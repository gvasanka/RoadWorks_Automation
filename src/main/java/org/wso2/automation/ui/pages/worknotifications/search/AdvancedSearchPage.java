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

package org.wso2.automation.ui.pages.worknotifications.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

import static org.wso2.automation.ui.utils.data.AppConstants.SKIP;


public class AdvancedSearchPage extends BasePage{

    private WebElement txtReferenceNumber;
    private WebElement dropDownType;
    private WebElement dropDownRoadNetwork;
    private WebElement dropDownBoroughLocation;
    private WebElement txtPromoterReference;
    private WebElement dropDownPromotorOrganization;
    private WebElement txtNotificationTitle;
    private WebElement dropDownStatus;
    private WebElement dropDownSubmissionType;
    private WebElement btnApply;
    private WebElement btnClear;

    public AdvancedSearchPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);


        try {
            wait.until(ExpectedConditions.titleIs("Search TMAN"));


            txtReferenceNumber=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("AdvancedSearchPage.txtReferenceNumber.id"))));
            dropDownType=wait.until(ExpectedConditions.elementToBeClickable(By.name(uiElementMapper.getElement
                    ("AdvancedSearchPage.dropDownType.name"))));
            dropDownRoadNetwork=wait.until(ExpectedConditions.elementToBeClickable(By.name(uiElementMapper.getElement
                    ("AdvancedSearchPage.dropDownRoadNetwork.name"))));
            dropDownBoroughLocation=wait.until(ExpectedConditions.elementToBeClickable(By.name(uiElementMapper.getElement
                    ("AdvancedSearchPage.dropDownBoroughLocation.name"))));
            txtPromoterReference=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("AdvancedSearchPage.txtPromoterReference.id"))));
            
            dropDownPromotorOrganization=wait.until(ExpectedConditions.elementToBeClickable(By.name(uiElementMapper
                    .getElement("AdvancedSearchPage.dropDownPromotorOrganization.name"))));
            txtNotificationTitle=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("AdvancedSearchPage.txtNotificationTitle.id"))));


            dropDownStatus=wait.until(ExpectedConditions.elementToBeClickable(By.name(uiElementMapper
                    .getElement("AdvancedSearchPage.dropDownStatus.name"))));
            dropDownSubmissionType=wait.until(ExpectedConditions.elementToBeClickable(By.name(uiElementMapper.getElement
                    ("AdvancedSearchPage.dropDownSubmissionType.name"))));

            btnApply=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper
                    .getElement("AdvancedSearchPage.btnApply.id"))));
            btnClear=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement
                    ("AdvancedSearchPage.btnClear.xpath"))));

        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void enterSearchCriteria(String refNumber, String type, String roadNetwork, String boroughLocation, String
            promoterRef, String promoterOrg, String notoficatonTitle, String status, String submissionType){

        txtReferenceNumber.clear();

        if(!refNumber.equalsIgnoreCase(SKIP)) {
            txtReferenceNumber.sendKeys(refNumber);
        }

        if(!type.equalsIgnoreCase(SKIP)) {
            Select select = new Select(dropDownType);
            select.selectByVisibleText(type);
        }

        if(!roadNetwork.equalsIgnoreCase(SKIP)) {
            Select select = new Select(dropDownRoadNetwork);
            select.selectByVisibleText(roadNetwork);
        }

        if(!boroughLocation.equalsIgnoreCase(SKIP)) {
            Select select = new Select(dropDownBoroughLocation);
            select.selectByVisibleText(boroughLocation);
        }
        txtPromoterReference.clear();

        if(!promoterRef.equalsIgnoreCase(SKIP)) {
            txtReferenceNumber.sendKeys(promoterRef);
        }

        if(!promoterOrg.equalsIgnoreCase(SKIP)) {
            Select select = new Select(dropDownPromotorOrganization);
            select.selectByVisibleText(promoterOrg);
        }

        txtNotificationTitle.clear();

        if(!notoficatonTitle.equalsIgnoreCase(SKIP)) {
            txtNotificationTitle.sendKeys(notoficatonTitle);
        }

        if(!status.equalsIgnoreCase(SKIP)) {
            Select select = new Select(dropDownStatus);
            select.selectByVisibleText(status);
        }

        if(!submissionType.equalsIgnoreCase(SKIP)) {
            Select select = new Select(dropDownSubmissionType);
            select.selectByVisibleText(submissionType);
        }
    }

    public void searchByRefNumber(String refNumber){
        enterSearchCriteria(refNumber,SKIP,SKIP,SKIP,SKIP,SKIP,SKIP,SKIP,SKIP);
    }

    public void searchByType(String type){
        enterSearchCriteria(SKIP,type,SKIP,SKIP,SKIP,SKIP,SKIP,SKIP,SKIP);
    }

    public void searchByRoadNetwork(String roadNetwork){
        enterSearchCriteria(SKIP,SKIP,roadNetwork,SKIP,SKIP,SKIP,SKIP,SKIP,SKIP);
    }

    public void searchByBoroughLocation(String boroughLocation){
        enterSearchCriteria(SKIP,SKIP,SKIP,boroughLocation,SKIP,SKIP,SKIP,SKIP,SKIP);
    }

    public void searchByPromoterRef(String promoterRef){
        enterSearchCriteria(SKIP,SKIP,SKIP,SKIP,promoterRef,SKIP,SKIP,SKIP,SKIP);
    }

    public void searchByPromoterOrg(String promoterOrg){
        enterSearchCriteria(SKIP,SKIP,SKIP,SKIP,SKIP,promoterOrg,SKIP,SKIP,SKIP);
    }

    public void searchByNotificationTitle(String notificationTitle){
        enterSearchCriteria(SKIP,SKIP,SKIP,SKIP,SKIP,SKIP,notificationTitle,SKIP,SKIP);
    }

    public void searchByStatus(String status){
        enterSearchCriteria(SKIP,SKIP,SKIP,SKIP,SKIP,SKIP,SKIP,status,SKIP);
    }

    public void searchBySubmissionType(String submissionType){
        enterSearchCriteria(SKIP,SKIP,SKIP,SKIP,SKIP,SKIP,SKIP,SKIP,submissionType);
    }


    public WorkHomePage clickApplyButton(){
        btnApply.click();
        return  new WorkHomePage(driver,uiElementMapper,user);
    }

    public void clickClearButton(){
        btnClear.click();
    }

}
