package org.wso2.automation.ui.pages.worknotifications.simpleWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.worknotifications.AddNewPhasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class SimpleWorkPhasesPage extends BasePage{

    private WebElement lblStart;
    private WebElement lblEnd;
    private WebElement lblTraffiMgt;
    private WebElement lblRestrictions;
    private WebElement btnAddWorksPhase;

    private AddNewPhasePage addNewPhasePage;


    public SimpleWorkPhasesPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);


        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));

            lblStart=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SimpleWorkPhasesPage.lblStart.xpath"))));
            lblEnd=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SimpleWorkPhasesPage.lblEnd.xpath"))));
            lblTraffiMgt=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SimpleWorkPhasesPage.lblTraffiMgt.xpath"))));
            lblRestrictions=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SimpleWorkPhasesPage.lblRestrictions.xpath"))));

            btnAddWorksPhase=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("SimpleWorkPhasesPage.btnAddWorksPhase.xpath"))));

        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void addNewPhase(String tmStart, String tmEnd, String tfcMgt, String restrictions, String comment){

        String parentWindow=driver.getWindowHandle();
        btnAddWorksPhase.click();

//        // Switch to new window opened
//        for(String winHandle : driver.getWindowHandles()){
//            if(!winHandle.equals(parentWindow))
//                driver.switchTo().window(winHandle);

            addNewPhasePage=new AddNewPhasePage(driver,uiElementMapper,user);
            addNewPhasePage.fillAddNewPhaseForm(tmStart,tmEnd,tfcMgt,restrictions,comment);
            addNewPhasePage.submitAddNewPhase();
//        }
//
//        driver.switchTo().window(parentWindow);

    }





}
