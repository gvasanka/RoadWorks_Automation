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


public class PromoterDetailsPage extends BasePage{



    private WebElement dropDownPromoter;
    private WebElement txtContactName;
    private WebElement txtContactAddress;
    private WebElement txtContactPosition;
    private WebElement txtContactEmail;
    private WebElement txtContactNumber;
    private WebElement txtMobileNumber;


    private WebElement lblUserName;
    private WebElement btnLogOut;


    public PromoterDetailsPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));


            dropDownPromoter=wait.until(ExpectedConditions.elementToBeClickable(By.name(uiElementMapper.getElement
                    ("PromoterDetailsPage.dropDownPromoter.name"))));

            txtContactName=driver.findElement(By.id(uiElementMapper.getElement("PromoterDetailsPage.txtContactName.id")));
            txtContactAddress=driver.findElement(By.id(uiElementMapper.getElement("PromoterDetailsPage.txtContactAddress.id")));
            txtContactPosition=driver.findElement(By.id(uiElementMapper.getElement("PromoterDetailsPage.txtContactPosition.id")));
            txtContactEmail=driver.findElement(By.id(uiElementMapper.getElement("PromoterDetailsPage.txtContactEmail.id")));
            txtContactNumber=driver.findElement(By.id(uiElementMapper.getElement("PromoterDetailsPage.txtContactNumber.id")));
            txtMobileNumber=driver.findElement(By.id(uiElementMapper.getElement("PromoterDetailsPage.txtMobileNumber.id")));


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
        Assert.assertEquals(driver.findElement(By.id("workPromoter-label")).getText(),"Promoter is required");
        Assert.assertEquals(driver.findElement(By.id("contactName-label")).getText(),"Contact name is required");
        Assert.assertEquals(driver.findElement(By.id("contactEmail-label")).getText(),"Contact email is required");
        Assert.assertEquals(driver.findElement(By.id("contactFax-label")).getText(),"Contact fax number is required");
    }

    public void fieldValidationAtSubmitFormal(){
        Assert.assertEquals(driver.findElement(By.id("workPromoter-label")).getText(),"Promoter is required");
        Assert.assertEquals(driver.findElement(By.id("contactName-label")).getText(),"Contact name is required");
        Assert.assertEquals(driver.findElement(By.id("contactEmail-label")).getText(),"Contact email is required");
        Assert.assertEquals(driver.findElement(By.id("contactFax-label")).getText(),"Contact fax number is required");
    }

    public void fillSchemePromoterDetailsForm(String promoter,String contactName, String contactAdd, String
            contactPositions, String contactEmail, String contactNumber, String mobileNumber){

        Select select=new Select(dropDownPromoter);
        select.selectByVisibleText(promoter);

        txtContactName.clear();
        txtContactName.sendKeys(contactName);

        txtContactAddress.clear();
        txtContactAddress.sendKeys(contactAdd);

        txtContactPosition.clear();
        txtContactPosition.sendKeys(contactPositions);

        txtContactEmail.clear();
        txtContactEmail.sendKeys(contactEmail);

        txtContactNumber.clear();
        txtContactNumber.sendKeys(contactNumber);

        txtMobileNumber.clear();
        txtMobileNumber.sendKeys(mobileNumber);

    }

    public void verifySchemePromoterDetailsForm(String promoter,String contactName, String contactAdd, String
            contactPositions, String contactEmail, String contactNumber, String mobileNumber){

        Select select=new Select(dropDownPromoter);

        Assert.assertEquals(select.getFirstSelectedOption().getText(),promoter);

        Assert.assertEquals(txtContactName.getText(),contactName);
        Assert.assertEquals(txtContactAddress.getText(),contactAdd);
        Assert.assertEquals(txtContactPosition.getText(),contactPositions);

        Assert.assertEquals(txtContactEmail.getText(),contactEmail);
        Assert.assertEquals(txtContactNumber.getText(),contactNumber);
        Assert.assertEquals(txtMobileNumber.getText(),mobileNumber);


    }

    public HomePage logOutFromApp(){
        lblUserName.click();
        btnLogOut=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.btnLogOut.xpath"))));
        btnLogOut.click();
        return new HomePage(driver,uiElementMapper,user);

    }




}
