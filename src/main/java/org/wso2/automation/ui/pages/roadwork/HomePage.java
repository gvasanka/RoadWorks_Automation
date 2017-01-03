package org.wso2.automation.ui.pages.roadwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.crapplication.CRHomePage;
import org.wso2.automation.ui.pages.filtermgt.FilterMgtHomePage;
import org.wso2.automation.ui.pages.fpform.FPHomePage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.utils.browser.PropertyMapper;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

/**
 * Created by asankav on 10/21/16.
 */
public class HomePage extends BasePage{

    WebElement lnkCRApplication;
    WebElement lnkFilterMgt;
    WebElement lnkFPForm;
    WebElement lnkWorkForm;
    private WebElement lblRoadWorks;
    private WebElement lblUserName;
    private WebElement btnLogOut;

    public HomePage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

            try {
                wait.until(ExpectedConditions.titleIs("Road Works"));
                lblUserName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("HomePage.lblUserName.xpath"))));

//                lnkCRApplication = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("HomePage.lnkCRApplication.xpath"))));
//                //lnkCRApplication =driver.findElement(By.xpath(uiElementMapper.getElement("HomePage.lnkCRApplication.xpath")));
//                lnkFilterMgt =wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("HomePage.lnkFilterMgt.xpath"))));
//
//                lnkFPForm =wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("HomePage.lnkFPForm.xpath"))));
//
//                lnkWorkForm=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("HomePage.lnkWorkForm.xpath"))));

                lblRoadWorks =wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("HomePage.lblRoadWorks.xpath"))));
            }
            catch (org.openqa.selenium.TimeoutException e){
                throw new IllegalStateException("Page doesn't load within expected time frame:: "+e.toString());
            }

    }

   public CRHomePage loadCRAppHomePage(){
       driver.get(PropertyMapper.getInstance().getElement("crBaseURL"));
//       lnkCRApplication.click();

       return new CRHomePage(driver,uiElementMapper,user);
   }

    public FilterMgtHomePage loadFilterMgtHomePage(){
        driver.get(PropertyMapper.getInstance().getElement("filterMgtBaseURL"));
//        lnkFilterMgt.click();

        return new FilterMgtHomePage(driver,uiElementMapper,user);
    }

    public FPHomePage loadFPFormHomePage(){
        driver.get(PropertyMapper.getInstance().getElement("FpFormBaseURL"));
//        lnkFPForm.click();

        return new FPHomePage(driver,uiElementMapper,user);
    }

    public WorkHomePage loadWorkFormHomePage(){
        driver.get(PropertyMapper.getInstance().getElement("tWorkBaseURL"));
//        lnkWorkForm.click();

        return new WorkHomePage(driver,uiElementMapper,user);
    }

    public SignInPage logOutFromApp(){
        lblUserName.click();
        btnLogOut=wait.until(ExpectedConditions.
                elementToBeClickable(By.id(uiElementMapper.getElement("HomePage.btnLogOut.id"))));
        btnLogOut.click();

        return new SignInPage(driver,uiElementMapper,user);

    }

}
