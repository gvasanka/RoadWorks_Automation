package org.wso2.automation.ui.pages.fpform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

/**
 * Created by asankav on 10/21/16.
 */
public class FPHomePage extends BasePage{

    private WebElement lnkCRApplication;
    private WebElement lnkFilterMgt;
    private WebElement lnkFPForm;
    private WebElement lnkWOrkForm;
    private WebElement lblUserName;
    private WebElement btnLogOut;

    public FPHomePage(WebDriver driver, UIElementMapper uiElementMapper,User user) {
        super(driver,uiElementMapper,user);

//        oldTab = driver.getWindowHandle();
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(oldTab);
//        driver.switchTo().window(newTab.get(0));


            try {
                 wait.until(ExpectedConditions.titleIs("Search Forward Plan"));
                lblUserName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.lblUserName.xpath"))));

            }
            catch (org.openqa.selenium.TimeoutException e){
                throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
            }


    }

    public HomePage logOutFromApp(){
        lblUserName.click();
        btnLogOut=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.btnLogOut.xpath"))));
        btnLogOut.click();
        return new HomePage(driver,uiElementMapper,user);

    }



}
