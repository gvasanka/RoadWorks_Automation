package org.wso2.automation.ui.pages.worknotifications.simpleWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_NO;
import static org.wso2.automation.ui.utils.data.AppConstants.TEXT_YES;


public class SimpleWorkHomePage extends BasePage{

    private WebElement lblMorethanPhase;
    private WebElement dropDownMorethanPhase;
    private WebElement lblTrafficMgt;
    private WebElement dropDownTrafficMgt;
    private WebElement lblOvernightWork;
    private WebElement dropDownOvernightWork;
    private WebElement dropDownWorksType;

    public WebElement getLblMorethanPhase() {
        return lblMorethanPhase;
    }

    public WebElement getLblTrafficMgt() {
        return lblTrafficMgt;
    }

    public WebElement getLblOvernightWork() {
        return lblOvernightWork;
    }


    public SimpleWorkHomePage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));


            lblMorethanPhase=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uiElementMapper.getElement("SimpleWorkHomePage.lblMorethanPhase.xpath"))));
            dropDownMorethanPhase=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SimpleWorkHomePage.dropDownMorethanPhase.xpath"))));
            lblTrafficMgt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uiElementMapper.getElement("SimpleWorkHomePage.lblTrafficMgt.xpath"))));
            dropDownTrafficMgt=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SimpleWorkHomePage.dropDownTrafficMgt.xpath"))));
            lblOvernightWork=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uiElementMapper.getElement("SimpleWorkHomePage.lblOvernightWork.xpath"))));
            dropDownOvernightWork=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SimpleWorkHomePage.dropDownOvernightWork.xpath"))));
            dropDownWorksType=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SimpleWorkHomePage.dropDownWorksType.xpath"))));

        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void verifyFieldValidationAtSave(){
        Assert.assertEquals(driver.findElement(By.id("tmphases-label")).getText(),"Please select an option");

        Assert.assertEquals(driver.findElement(By.id("tmtype-label")).getText(),"Please select a type");

        Assert.assertEquals(driver.findElement(By.id("overnightworks-label")).getText(),"Please select an option");

    }

    public void verifyFieldValidationAtProvision(){
        Assert.assertEquals(driver.findElement(By.id("tmphases-label")).getText(),"Please select an option");

        Assert.assertEquals(driver.findElement(By.id("tmtype-label")).getText(),"Please select a type");

        Assert.assertEquals(driver.findElement(By.id("overnightworks-label")).getText(),"Please select an option");

    }

    public void verifyFieldValidationAtSubmitFormal(){
        Assert.assertEquals(driver.findElement(By.id("tmphases-label")).getText(),"Please select an option");

        Assert.assertEquals(driver.findElement(By.id("tmtype-label")).getText(),"Please select a type");

        Assert.assertEquals(driver.findElement(By.id("overnightworks-label")).getText(),"Please select an option");

    }

    public void verifyStandaloneHomeDetails(String morephase,String trafficMgtType,String overnight,String
            workType){

        Select select=new Select(dropDownMorethanPhase);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),morephase);

        select=new Select(dropDownTrafficMgt);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),trafficMgtType);

        select=new Select(dropDownOvernightWork);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),overnight);

    }

    public void selectMoreThan1Phase(String text){
        Select select=new Select(dropDownMorethanPhase);
        if(TEXT_YES.equalsIgnoreCase(text)) {
            select.selectByVisibleText(TEXT_YES);
        }else{
            select.selectByVisibleText(TEXT_NO);
        }
    }

    public void selectTrafficMgtType(String trafficMgtType){
        Select select=new Select(dropDownTrafficMgt);
        select.selectByVisibleText(trafficMgtType);
    }

    public void selectOvernightWorks(String OvernightWorks){
        Select select=new Select(dropDownOvernightWork);
        select.selectByVisibleText(OvernightWorks);
    }

    public void selectWorksType(String worksType){
        Select select=new Select(dropDownWorksType);
        select.selectByVisibleText(worksType);
    }

    public SimpleWorkPromoterDetailsPage loadPromoterDetailsForm(){
        //  lnkPromoterDetails.click();

        return new SimpleWorkPromoterDetailsPage(driver,uiElementMapper,user);
    }

    public SimpleWorkPhasesPage loadPhases(){
        driver.findElement(By.id(uiElementMapper.getElement("SimpleWorkHomePage.lnkPhases.id"))).click();

        return new SimpleWorkPhasesPage(driver,uiElementMapper,user);
    }



}
