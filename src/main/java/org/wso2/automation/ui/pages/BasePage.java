package org.wso2.automation.ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wso2.automation.ui.pages.roadwork.SignInPage;
import org.wso2.automation.ui.utils.browser.PropertyMapper;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

import java.util.ArrayList;
import java.util.Set;


public class BasePage {

    protected  WebDriver driver;
    protected UIElementMapper uiElementMapper;
    protected User user;
    protected WebDriverWait wait;

    public BasePage(){

    }

    public BasePage(WebDriver driver,UIElementMapper uiElementMapper,User user) {
        this.driver = driver;
        this.uiElementMapper=uiElementMapper;
        this.user=user;
        this.wait=new WebDriverWait(driver, 60);
    }

    protected boolean handleAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return true;
        } catch (Exception e) {
            return true;
        }
    }
    protected void moveToNextTab(){
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
    }

    protected void handleAcceptWindow(){
        WebElement btnClose = wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("//*[starts-with(@id,'ja_btn_')]")));
        btnClose.click();

    }

    protected void handleAcceptWindowPopUp(String parentWindow){

        Set<String> windowHandles=driver.getWindowHandles();
        for(String winHandle : windowHandles){
            if(!winHandle.equals(parentWindow)) {
                driver.switchTo().window(winHandle);
                WebElement btnClose = wait.until(ExpectedConditions.elementToBeClickable(By.
                        xpath("//*[starts-with(@id,'ja_btn_')]")));
                btnClose.click();

            }
        }
        driver.switchTo().window(parentWindow);
    }



    public SignInPage loadApplication()  {

        driver.manage().window().maximize();
        driver.get(PropertyMapper.getInstance().getElement("baseAppURL"));

        return new SignInPage(this.driver,this.uiElementMapper,user);

    }

}
