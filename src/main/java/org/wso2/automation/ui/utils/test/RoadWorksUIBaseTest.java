package org.wso2.automation.ui.utils.test;

import org.openqa.selenium.WebDriver;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.roadwork.SignInPage;
import org.wso2.automation.ui.pages.roadwork.WSO2SSOPage;
import org.wso2.automation.ui.utils.browser.BrowserManager;
import org.wso2.automation.ui.utils.browser.PropertyMapper;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.data.LargeWorkTestData;
import org.wso2.automation.ui.utils.data.SimpleWorkTestData;

import java.util.concurrent.TimeUnit;


public class RoadWorksUIBaseTest {
    protected WebDriver driver;
    protected UIElementMapper uiElementMapper;
    protected User user;
    protected LargeWorkTestData largeWorkTestData;
    protected SimpleWorkTestData simpleWorkTestData;

    private BasePage basePage;
    private SignInPage signInPage;
    private WSO2SSOPage wso2SSOPage;
    private HomePage homePage;


    protected void init(User user){
        this.driver= BrowserManager.getWebDriver(PropertyMapper.getInstance().getElement("defaultBrowser"));
        this.uiElementMapper=UIElementMapper.getInstance();
        this.user=user;
        this.largeWorkTestData =new LargeWorkTestData();
        this.simpleWorkTestData =new SimpleWorkTestData();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected HomePage loginToRoadWorks(){
        basePage=new BasePage(driver,uiElementMapper,user);
        signInPage=basePage.loadApplication();
        wso2SSOPage=signInPage.clickSSOLogin();
        homePage=wso2SSOPage.loginWithSSOCredentials(user.getUserName(),user.getPassWord());
        return homePage;

    }

}
