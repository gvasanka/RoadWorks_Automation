package org.wso2.automation.ui.pages.worknotifications.largework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class SummaryPage extends BasePage{



    private WebElement txtNotificationTitle;
    private WebElement txtProposalClient;
    private WebElement txtPromoterRef;
    private WebElement txtLipBspRef;
    private WebElement txtWbsCode;
    private WebElement txtSiteNumber;

    private WebElement lblUserName;
    private WebElement btnLogOut;


    public SummaryPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));


            txtNotificationTitle=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("SummaryPage.txtNotificationTitle.id"))));
            txtProposalClient=driver.findElement(By.id(uiElementMapper.getElement("SummaryPage.txtProposalClient.id")));
            txtPromoterRef=driver.findElement(By.id(uiElementMapper.getElement("SummaryPage.txtPromoterRef.id")));
            txtLipBspRef=driver.findElement(By.id(uiElementMapper.getElement("SummaryPage.txtLipBspRef.id")));
            txtWbsCode=driver.findElement(By.id(uiElementMapper.getElement("SummaryPage.txtWbsCode.id")));
            txtSiteNumber=driver.findElement(By.id(uiElementMapper.getElement("SummaryPage.txtSiteNumber.id")));



            lblUserName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.lblUserName.xpath"))));


        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void fieldValidationAtSave(){
        Assert.assertEquals(driver.findElement(By.id("notificationTitle-label")).getText(),"Notification title is required");

    }

    public void fieldValidationAtProvision(){
        Assert.assertEquals(driver.findElement(By.id("notificationTitle-label")).getText(),"Notification title is required");

    }

    public void fieldValidationAtSubmitFormal(){
        Assert.assertEquals(driver.findElement(By.id("notificationTitle-label")).getText(),"Notification title is required");

    }

    public void fillSchemeSummaryForm(String notificationTitle,String proposalClient,String promoterRef, String bspRef,
                                      String wbsCode, String siteNumber){

            txtNotificationTitle.clear();
            txtNotificationTitle.sendKeys(notificationTitle);

            txtProposalClient.clear();
            txtProposalClient.sendKeys(proposalClient);

            txtPromoterRef.clear();
            txtPromoterRef.sendKeys(promoterRef);

            txtLipBspRef.clear();
            txtLipBspRef.sendKeys(bspRef);

            txtWbsCode.clear();
            txtWbsCode.sendKeys(wbsCode);

            txtSiteNumber.clear();
            txtSiteNumber.sendKeys(siteNumber);

    }

    public void verifySchemeSummaryForm(String notificationTitle,String proposalClient,String promoterRef, String
            bspRef, String wbsCode, String siteNumber){

        Assert.assertEquals(txtNotificationTitle.getText(),notificationTitle);
        Assert.assertEquals(txtProposalClient.getText(),proposalClient);
        Assert.assertEquals(txtPromoterRef.getText(),promoterRef);
        Assert.assertEquals(txtLipBspRef.getText(),bspRef);
        Assert.assertEquals(txtWbsCode.getText(),wbsCode);
        Assert.assertEquals(txtSiteNumber.getText(),siteNumber);

    }


    public HomePage logOutFromApp(){
        lblUserName.click();
        btnLogOut=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.btnLogOut.xpath"))));
        btnLogOut.click();
        return new HomePage(driver,uiElementMapper,user);

    }




}
