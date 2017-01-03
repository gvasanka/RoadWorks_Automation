package org.wso2.automation.ui.pages.worknotifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.largework.LargeWorkHomePage;
import org.wso2.automation.ui.pages.worknotifications.simpleWork.SimpleWorkHomePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

import java.util.Set;

import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_NO;
import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_YES;


public class CreateWorkPage extends BasePage{


    private WebElement btnSave;
    private WebElement btnSubmitProvisional;
    private WebElement btnSubmitFormal;
    private WebElement btnAttachement;

    private WebElement lblInitialEntry;
    private WebElement lblInformationRequested;
    private WebElement lblInformationReceived;
    private WebElement lblDecisionGranted;

    private WebElement btnPromoter;
    private WebElement btnAssessor;
    private WebElement btnHistory;
    private WebElement btnConversation;

    private WebElement lblPermanantChange;
    private WebElement dropdownPermanantChange;

    private WebElement lblUserName;
    private WebElement btnLogOut;




    public CreateWorkPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));

            btnSave=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("CreateWorkPage.btnSave.id"))));
            btnSubmitProvisional=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("CreateWorkPage.btnSubmitProvisional.id"))));
            btnSubmitFormal=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("CreateWorkPage.btnSubmitFormal.id"))));

            btnAttachement=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("CreateWorkPage.btnAttachement.id"))));
            lblUserName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.lblUserName.xpath"))));

            lblInitialEntry= driver.findElement(By.id(uiElementMapper.getElement("CreateWorkPage.lblInitialEntry.id")));
            lblInformationRequested= driver.findElement(By.id(uiElementMapper.getElement("CreateWorkPage.lblInformationRequested.id")));
            lblInformationReceived= driver.findElement(By.id(uiElementMapper.getElement("CreateWorkPage.lblInformationReceived.id")));
            lblDecisionGranted= driver.findElement(By.id(uiElementMapper.getElement("CreateWorkPage.lblDecisionGranted.id")));


            btnPromoter=driver.findElement(By.id(uiElementMapper.getElement("CreateWorkPage.btnPromoter.id")));
            if (!user.getRole().equalsIgnoreCase("Promoter")) {
                btnAssessor =driver.findElement(By.id(uiElementMapper.getElement("CreateWorkPage.btnAssessor.id")));
            }
            btnHistory=driver.findElement(By.id(uiElementMapper.getElement("CreateWorkPage.btnHistory.id")));
            btnConversation=driver.findElement(By.id(uiElementMapper.getElement("CreateWorkPage.btnConversation.id")));


            lblPermanantChange=driver.findElement(By.xpath(uiElementMapper.getElement("CreateWorkPage.lblPermanantChange.xpath")));
            dropdownPermanantChange=driver.findElement(By.xpath(uiElementMapper.getElement("CreateWorkPage.dropdownPermanantChange.xpath")));


        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public AttachmentsPage loadAttachementsPage(){
        btnAttachement.click();
        return new AttachmentsPage(driver,uiElementMapper,user);
    }


    public WorkHomePage saveCreatedWork(){
        btnSave.click();
        handleAcceptWindow();
        return new WorkHomePage(driver,uiElementMapper,user);
    }

    public void saveCreatedWorkWithoutFillingData(){
        btnSave.click();
    }

    public void saveCreatedWorkWithInvalidSchemeNumber(){

        String parentWindow=driver.getWindowHandle();
        btnSave.click();
        Set<String> windowHandles=driver.getWindowHandles();
        for(String winHandle : windowHandles){
            if(!winHandle.equals(parentWindow)) {
                driver.switchTo().window(winHandle);
                WebElement errorMessage=wait.until(ExpectedConditions.elementToBeClickable(By.
                        xpath(".//*[[starts-with(@id,'ja_btn_')]/div/div[3]")));
                Assert.assertTrue(errorMessage.getText().contains("Couldn't assign to Parent Scheme Number"));
                WebElement btnClose = wait.until(ExpectedConditions.elementToBeClickable(By.
                        xpath("//*[starts-with(@id,'ja_btn_')]")));
                btnClose.click();

            }
        }
        driver.switchTo().window(parentWindow);

    }

    public WorkHomePage doSubmitProvisional(){
        btnSubmitProvisional.click();
        handleAcceptWindow();
        return new WorkHomePage(driver,uiElementMapper,user);
    }

    public void doSubmitProvisionalWithoutFillingData(){
        btnSubmitProvisional.click();

    }

    public WorkHomePage doSubmitFormal(){
        btnSubmitFormal.click();
        handleAcceptWindow();
        return new WorkHomePage(driver,uiElementMapper,user);

    }

    public void doSubmitFormalWithoutFillingData(){
        btnSubmitFormal.click();

    }


    public SimpleWorkHomePage selectStandaloneWork(){
        dropdownPermanantChange=driver.findElement(By.xpath(uiElementMapper.getElement("CreateWorkPage.dropdownPermanantChange.xpath")));
        Select select=new Select(dropdownPermanantChange);
        select.selectByVisibleText(TEXT_NO);
        handleAlert();

        return new SimpleWorkHomePage(driver,uiElementMapper,user);

    }

    public LargeWorkHomePage selectSchemeWork(){
        Select select=new Select(dropdownPermanantChange);
        select.selectByVisibleText(TEXT_YES);
        handleAlert();

        return new LargeWorkHomePage(driver,uiElementMapper,user);
    }

    public BasePage selectmajorDevelopment(String selection){
        Select select=new Select(dropdownPermanantChange);

        if(TEXT_YES.equalsIgnoreCase(selection)) {
            select.selectByVisibleText(TEXT_YES);
            handleAlert();
            return new LargeWorkHomePage(driver, uiElementMapper, user);
        }
        return new SimpleWorkHomePage(driver,uiElementMapper,user);
    }

    public HomePage logOutFromApp(){
        lblUserName.click();
        btnLogOut=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.btnLogOut.xpath"))));
        btnLogOut.click();
        return new HomePage(driver,uiElementMapper,user);

    }




}
