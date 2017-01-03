package org.wso2.automation.ui.pages.worknotifications.simpleWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_NO;
import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_YES;


public class SimpleWorkPromoterDetailsPage extends BasePage{

    private WebElement lblUserName;
    private WebElement btnLogOut;

    private WebElement dropDownWorksType;
    private WebElement dropDownPromoter;
    private WebElement txtCompanyName;
    private WebElement txtContactName;
    private WebElement txtContactAddress;
    private WebElement txtContactEmail;
    private WebElement txtContactNumber;
    private WebElement txtMobileNumber;
    private WebElement txtNotificationTitle;
    private WebElement calProposedStart;
    private WebElement calProposedEnd;
    private WebElement txtDuration;
    private WebElement txtLocationUSRN;
    private WebElement txtLocationDetails;
    private WebElement dropDownBorough;
    private WebElement chkBoxTLRN;
    private WebElement chkBoxSRN;
    private WebElement chkBoxBPRN;
    private WebElement chkBoxBRN;
    private WebElement txtWorkDetails;
    private WebElement radioStakeholderYes;
    private WebElement radioStakeholderNo;
    private WebElement txtConsultees;


    public SimpleWorkPromoterDetailsPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);


        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));


            dropDownPromoter=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("StandalonePromoterDetailsPage.dropDownPromoter.xpath"))));

            txtCompanyName=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtCompanyName.id")));
            txtContactName=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtContactName.id")));
            txtContactAddress=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtContactAddress.id")));
            txtContactEmail=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtContactEmail.id")));

            txtContactNumber=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtContactNumber.id")));
            txtMobileNumber=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtMobileNumber.id")));
            txtNotificationTitle=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtNotificationTitle.id")));
            calProposedStart=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.calProposedStart.id")));

            calProposedEnd=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.calProposedEnd.id")));
            txtDuration=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtDuration.id")));
            txtLocationUSRN=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtLocationUSRN.id")));
            txtLocationDetails=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtLocationDetails.id")));

            dropDownBorough=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.dropDownBorough.id")));
            chkBoxTLRN=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.chkBoxTLRN.id")));
            chkBoxSRN=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.chkBoxSRN.id")));
            chkBoxBPRN=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.chkBoxBPRN.id")));

            chkBoxBRN=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.chkBoxBRN.id")));
            txtWorkDetails=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtWorkDetails.id")));
            radioStakeholderYes=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.radioStakeholderYes.id")));
            radioStakeholderNo=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.radioStakeholderNo.id")));
            txtConsultees=driver.findElement(By.id(uiElementMapper.getElement("StandalonePromoterDetailsPage.txtConsultees.id")));

            lblUserName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.lblUserName.xpath"))));


        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void verifyFieldValidationAtSave(){
        Assert.assertEquals(driver.findElement(By.id("notificationTitle-stdalone-works-label")).getText(),"Notification title is required");

    }


    public void verifyFieldValidationAtProvision(){
        Assert.assertEquals(driver.findElement(By.id("workPromoter-stdalone-works-label")).getText(),"Promoter is required");

        Assert.assertEquals(driver.findElement(By.id("contactName-stdalone-works-label")).getText(),"Contact name is required");

        Assert.assertEquals(driver.findElement(By.id("contactEmail-stdalone-works-label")).getText(),"Contact email is required");

        Assert.assertEquals(driver.findElement(By.id("contactFax-stdalone-works-label")).getText(),"Contact fax number is required");

        Assert.assertEquals(driver.findElement(By.id("notificationTitle-stdalone-works-label")).getText(),"Notification title is required");

        Assert.assertEquals(driver.findElement(By.id("locationUSRN-stdalone-works-label")).getText(),"USRN is required");

        Assert.assertEquals(driver.findElement(By.id("locationDetails-stdalone-works-label")).getText(),"Location details are required");

        Assert.assertEquals(driver.findElement(By.id("locationBoroughCode-stdalone-works-label")).getText(),"Borough code is required");

        Assert.assertEquals(driver.findElement(By.id("network-type-stdalone-works-label")).getText(),"Please select network type(s)");

        Assert.assertEquals(driver.findElement(By.id("schemeDetails-stdalone-works-label")).getText(),"Scheme details are required");

        Assert.assertEquals(driver.findElement(By.id("consultees-stdalone-works-label")).getText(),"Consultees are required");
    }

    public void verifyFieldValidationAtSubmitFormal(){
        Assert.assertEquals(driver.findElement(By.id("workPromoter-stdalone-works-label")).getText(),"Promoter is required");

        Assert.assertEquals(driver.findElement(By.id("contactName-stdalone-works-label")).getText(),"Contact name is required");

        Assert.assertEquals(driver.findElement(By.id("contactEmail-stdalone-works-label")).getText(),"Contact email is required");

        Assert.assertEquals(driver.findElement(By.id("contactFax-stdalone-works-label")).getText(),"Contact fax number is required");

        Assert.assertEquals(driver.findElement(By.id("notificationTitle-stdalone-works-label")).getText(),"Notification title is required");

        Assert.assertEquals(driver.findElement(By.id("proposedStartDate-stdalone-works-label")).getText(),"Start date is required");
        Assert.assertEquals(driver.findElement(By.id("proposedEndDate-stdalone-works-label")).getText(),"End date is required");

        Assert.assertEquals(driver.findElement(By.id("locationUSRN-stdalone-works-label")).getText(),"USRN is required");

        Assert.assertEquals(driver.findElement(By.id("locationDetails-stdalone-works-label")).getText(),"Location details are required");

        Assert.assertEquals(driver.findElement(By.id("locationBoroughCode-stdalone-works-label")).getText(),"Borough code is required");

        Assert.assertEquals(driver.findElement(By.id("network-type-stdalone-works-label")).getText(),"Please select network type(s)");

        Assert.assertEquals(driver.findElement(By.id("schemeDetails-stdalone-works-label")).getText(),"Scheme details are required");

        Assert.assertEquals(driver.findElement(By.id("consultees-stdalone-works-label")).getText(),"Consultees are required");
    }


    private void selectPromoter(String promoter){
        Select select=new Select(dropDownPromoter);
        select.selectByVisibleText(promoter);

    }

    private void selectBorough(String borough){
        Select select=new Select(dropDownBorough);
        select.selectByVisibleText(borough);
    }


    public void fillStandalonePromoterDetailsForm(String promoter,String companyName,String contactName, String
                                         contactAdd,String contactEmail, String contactNumber,
                                              String mobileNumber,String notificatonTitle, String propsedStart, String proposedEnd,
                                              String duration, String locationUSRN, String locationDetails,String borough,
                                              boolean isTLRN, boolean isSRN, boolean isBPRN, boolean isBRN, String
                                                          workDetails, String stakeholderConsultated, String consultees ){

        selectPromoter(promoter);

        txtCompanyName.clear();
        txtCompanyName.sendKeys(companyName);

        txtContactName.clear();
        txtContactName.sendKeys(contactName);

        txtContactAddress.clear();
        txtContactAddress.sendKeys(contactAdd);

        txtContactEmail.clear();
        txtContactEmail.sendKeys(contactEmail);

        txtContactNumber.clear();
        txtContactNumber.sendKeys(contactNumber);

        txtMobileNumber.clear();
        txtMobileNumber.sendKeys(mobileNumber);

        txtNotificationTitle.clear();
        txtNotificationTitle.sendKeys(notificatonTitle);

        selectProposedDates("2016/11/22","2016/11/26");

        txtLocationUSRN.clear();
        txtLocationUSRN.sendKeys(locationUSRN);

        txtLocationDetails.clear();
        txtLocationDetails.sendKeys(locationDetails);

        selectBorough(borough);

        if(isTLRN){ chkBoxTLRN.click();}
        if(isSRN){ chkBoxSRN.click();}
        if(isBPRN){  chkBoxBPRN.click();}
        if(isBRN){  chkBoxBRN.click();}

        txtWorkDetails.clear();
        txtWorkDetails.sendKeys(workDetails);

        if(TEXT_YES.equalsIgnoreCase(stakeholderConsultated)) {
            radioStakeholderYes.click();
        }else if(TEXT_NO.equalsIgnoreCase(stakeholderConsultated)){
            radioStakeholderNo.click();
        }
        txtConsultees.clear();
        txtConsultees.sendKeys(consultees);

    }

    private void selectProposedDates(String startDate,String endDate){
        calProposedStart.clear();
        calProposedStart.sendKeys(startDate);
        calProposedEnd.clear();
        calProposedEnd.sendKeys(endDate);

        Assert.assertNotNull(txtDuration.getText());

    }

    public HomePage logOutFromApp(){
        lblUserName.click();
        btnLogOut=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.btnLogOut.xpath"))));
        btnLogOut.click();
        return new HomePage(driver,uiElementMapper,user);

    }




}
