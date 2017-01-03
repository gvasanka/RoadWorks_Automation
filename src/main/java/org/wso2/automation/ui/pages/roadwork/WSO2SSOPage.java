package org.wso2.automation.ui.pages.roadwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

import java.util.ArrayList;

/**
 * Created by asankav on 7/21/16.
 */
public class WSO2SSOPage extends BasePage {

    WebElement txtUserName;
    WebElement txtPassWord;
    WebElement btnSignIn;
    WebElement lblSignIn;

    String oldTab;


    public WSO2SSOPage(WebDriver driver, UIElementMapper uiElementMapper, User user){
        super(driver,uiElementMapper,user);

        oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));

            try {
                wait.until(ExpectedConditions.titleIs("WSO2 Identity Server"));

                txtUserName=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(uiElementMapper.getElement("WSO2SSOPage.txtUserName.id")))));
                txtPassWord =driver.findElement(By.id(uiElementMapper.getElement("WSO2SSOPage.txtPassWord.id")));
                btnSignIn =driver.findElement(By.xpath(uiElementMapper.getElement("WSO2SSOPage.btnSignIn.xpath")));

            }
            catch (org.openqa.selenium.TimeoutException e){
                throw new IllegalStateException("Page doesn't load within expected time frame ::"+e.toString());
            }

    }

    public HomePage loginWithSSOCredentials(String userName,String Password) {

        txtUserName.sendKeys(userName);
        txtPassWord.sendKeys(Password);
        btnSignIn.click();

        //driver.close();
        driver.switchTo().window(oldTab);
        return new HomePage(driver,uiElementMapper,user);
    }


}
