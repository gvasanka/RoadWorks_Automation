package org.wso2.automation.ui.pages.worknotifications.largework;

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

public class DetailsPage extends BasePage{


    private WebElement calStartDate;
    private WebElement calEndDate;
    private WebElement txtLocationUSRN;
    private WebElement txtLocationDetails;
    private WebElement txtSignalSiteNumber;
    private WebElement txtRoadNumbers;
    private WebElement dropDownBoroughCode;
    private WebElement chkTLRN;
    private WebElement chkSRN;
    private WebElement chkBPRN;
    private WebElement chkBRN;
    private WebElement txtSchemeDetails;
    private WebElement dropDownWorksImpact;
    private WebElement txtWorksDetails;
    private WebElement txtConsultationSummary;
    private WebElement dropDownTrafficOrder;
    private WebElement txtConsultees;
    private WebElement txtAdjacentSchemes;

    private WebElement lblUserName;
    private WebElement btnLogOut;




    public DetailsPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));

            calStartDate=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("DetailsPage.calStartDate.id"))));
            calEndDate=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("DetailsPage.calEndDate.id"))));

            txtLocationUSRN=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.txtLocationUSRN.id")));
            txtLocationDetails=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.txtLocationDetails.id")));
            txtSignalSiteNumber=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.txtSignalSiteNumber.id")));
            txtRoadNumbers=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.txtRoadNumbers.id")));
            dropDownBoroughCode=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.dropDownBoroughCode.id")));

            chkTLRN=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.chkTLRN.id")));
            chkSRN=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.chkSRN.id")));
            chkBPRN=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.chkBPRN.id")));
            chkBRN=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.chkBRN.id")));

            txtSchemeDetails=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.txtSchemeDetails.id")));
            dropDownWorksImpact=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.dropDownWorksimpact.id")));
            txtWorksDetails=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.txtWorksDetails.id")));
            txtConsultationSummary=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.txtConsultationSummary.id")));
            dropDownTrafficOrder=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.dropDownTrafficOrder.id")));
            txtConsultees=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.txtConsultees.id")));

            txtAdjacentSchemes=driver.findElement(By.id(uiElementMapper.getElement("DetailsPage.txtAdjacentSchemes.id")));



            lblUserName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.lblUserName.xpath"))));


        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void fieldValidationAtSave(){
//        No Validation will load on promoter section with Save
    }

    public void fieldValidationAtSubmitProvision(){
        Assert.assertEquals(driver.findElement(By.id("locationUSRN-label")).getText(),"USRN is required");
        Assert.assertEquals(driver.findElement(By.id("locationDetails-label")).getText(),"Location details are required");
        Assert.assertEquals(driver.findElement(By.id("roadNumbers-label")).getText(),"Road numbers are required");
        Assert.assertEquals(driver.findElement(By.id("locationBoroughCode-label")).getText(),"Borough code is required");
        Assert.assertEquals(driver.findElement(By.id("network-type-label")).getText(),"Please select network type(s)");
        Assert.assertEquals(driver.findElement(By.id("schemeDetails-label")).getText(),"Scheme details are required");
        Assert.assertEquals(driver.findElement(By.id("worksDetails-label")).getText(),"Work details are required");
        Assert.assertEquals(driver.findElement(By.id("consultationSummary-label")).getText(),"Consultation summary is required");
        Assert.assertEquals(driver.findElement(By.id("consultees-label")).getText(),"Consultees are required");

    }

    public void fieldValidationAtSubmitFormal(){
        Assert.assertEquals(driver.findElement(By.id("proposedStartDate-label")).getText(),"Start date is required");
        Assert.assertEquals(driver.findElement(By.id("proposedEndDate-label")).getText(),"End date is required");
        Assert.assertEquals(driver.findElement(By.id("locationUSRN-label")).getText(),"USRN is required");
        Assert.assertEquals(driver.findElement(By.id("locationDetails-label")).getText(),"Location details are required");
        Assert.assertEquals(driver.findElement(By.id("roadNumbers-label")).getText(),"Road numbers are required");
        Assert.assertEquals(driver.findElement(By.id("locationBoroughCode-label")).getText(),"Borough code is required");
        Assert.assertEquals(driver.findElement(By.id("network-type-label")).getText(),"Please select network type(s)");
        Assert.assertEquals(driver.findElement(By.id("schemeDetails-label")).getText(),"Scheme details are required");
        Assert.assertEquals(driver.findElement(By.id("worksDetails-label")).getText(),"Work details are required");
        Assert.assertEquals(driver.findElement(By.id("consultationSummary-label")).getText(),"Consultation summary is required");
        Assert.assertEquals(driver.findElement(By.id("consultees-label")).getText(),"Consultees are required");

    }

    public void fillDetailsForm(String startDate, String endDate, String usrn, String locationDetails, String numbers,
                                String roadNumber, String borough, boolean isTLRN, boolean isSRN, boolean isBPRN, boolean
                                        isBRN, String schemeDetails,String impact, String worksdetails,String
                                        summary, String order, String consultees, String schemes){

        calStartDate.sendKeys(startDate);

        calEndDate.sendKeys(endDate);

        txtLocationUSRN.clear();
        txtLocationUSRN.sendKeys(usrn);

        txtLocationDetails.clear();
        txtLocationDetails.sendKeys(locationDetails);

        txtSignalSiteNumber.clear();
        txtSignalSiteNumber.sendKeys(numbers);

        txtRoadNumbers.clear();
        txtRoadNumbers.sendKeys(roadNumber);

        Select select=new Select(dropDownBoroughCode);
        select.selectByVisibleText(borough);


           if(isTLRN){ chkTLRN.click();}
           if(isSRN){ chkSRN.click();}
           if(isBPRN){  chkBPRN.click();}
           if(isBRN){  chkBRN.click();}


        txtSchemeDetails.clear();
        txtSchemeDetails.sendKeys(schemeDetails);

        select=new Select(dropDownWorksImpact);
        select.selectByVisibleText(impact);

        txtWorksDetails.clear();
        txtWorksDetails.sendKeys(worksdetails);

        txtConsultationSummary.clear();
        txtConsultationSummary.sendKeys(summary);

        select=new Select(dropDownTrafficOrder);
        select.selectByVisibleText(order);

        txtConsultees.clear();
        txtConsultees.sendKeys(consultees);

        txtAdjacentSchemes.clear();
        txtAdjacentSchemes.sendKeys(schemes);


    }

    public void verifyDetailsForm(String startDate, String endDate, String usrn, String locationDetails, String numbers,
                                String roadNumber, String borough, boolean isTLRN, boolean isSRN, boolean isBPRN, boolean
                                        isBRN, String schemeDetails,String impact, String worksdetails,String
                                        summary, String order, String consultees, String schemes){

        Assert.assertEquals(txtLocationUSRN.getText(),usrn);

        Assert.assertEquals(txtLocationDetails.getText(),locationDetails);

        Assert.assertEquals(txtSignalSiteNumber.getText(),numbers);

        Assert.assertEquals(txtRoadNumbers.getText(),roadNumber);


        Select select=new Select(dropDownBoroughCode);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),borough);

        Assert.assertTrue(chkTLRN.isSelected());
        Assert.assertTrue(chkSRN.isSelected());
        Assert.assertTrue(chkBPRN.isSelected());
        Assert.assertTrue(chkBRN.isSelected());

        Assert.assertEquals(txtSchemeDetails.getText(),schemeDetails);

        select=new Select(dropDownWorksImpact);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),impact);

        Assert.assertEquals(txtWorksDetails.getText(),worksdetails);


        select=new Select(dropDownTrafficOrder);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),order);

        Assert.assertEquals(txtConsultees.getText(),consultees);

        Assert.assertEquals(txtAdjacentSchemes.getText(),schemes);



    }


    public HomePage logOutFromApp(){
        lblUserName.click();
        btnLogOut=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.btnLogOut.xpath"))));
        btnLogOut.click();
        return new HomePage(driver,uiElementMapper,user);

    }




}
