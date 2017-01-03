package org.wso2.automation.ui.pages.roadwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

/**
 * Created by asankav on 7/21/16.
 */
public class SignInPage extends BasePage {

    private WebElement iframe;
    private WebElement lnkWSO2SSO;
    private WebElement lblSignIn;

    public WebElement getLblSignIn() {
        return lblSignIn;
    }


    public SignInPage(WebDriver driver, UIElementMapper uiElementMapper, User user){

        super(driver,uiElementMapper,user);


            try {
                wait.until(ExpectedConditions.titleIs("Portal for ArcGIS - Sign In"));

                lblSignIn=driver.findElement(By.xpath(uiElementMapper.getElement("SignInPage.lblSignIn.xpath")));
                iframe=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(uiElementMapper.getElement("SignInPage.iframe.xpath")))));
                driver.switchTo().frame(iframe);
                lnkWSO2SSO =driver.findElement(By.xpath(uiElementMapper.getElement("SignInPage.lnkWSO2SSO.xpath")));

            }
            catch (org.openqa.selenium.TimeoutException e){
                throw new IllegalStateException("Page doesn't load within expected time frame  ::"+e.toString());
            }


    }

    public WSO2SSOPage clickSSOLogin() {
        lnkWSO2SSO.click();
        return new WSO2SSOPage(driver,uiElementMapper,user);
    }

}
