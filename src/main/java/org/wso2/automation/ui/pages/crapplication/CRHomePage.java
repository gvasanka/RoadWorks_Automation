package org.wso2.automation.ui.pages.crapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class CRHomePage extends BasePage{


    private WebElement lblCentralRegister;




    public CRHomePage(WebDriver driver, UIElementMapper uiElementMapper,User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Central Register"));
            lblCentralRegister = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("CRHomePage.lblCentralRegister.xpath"))));




        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }


}
