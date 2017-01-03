package org.wso2.automation.ui.filtermgt;

/**
 * Created by asankav on 7/21/16.
 */


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.filtermgt.FilterMgtHomePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.roadwork.SignInPage;
import org.wso2.automation.ui.pages.roadwork.WSO2SSOPage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;


/**
 * The following test case checks the Application accessibility via the URL
 */
public class FilterMgtLoginTestCase extends RoadWorksUIBaseTest {

    private BasePage basePage;
    private SignInPage signInPage;
    private WSO2SSOPage wso2SSOPage;
    private HomePage homePage;
    private FilterMgtHomePage filterMgtHomePage;

    @BeforeClass()
    public void init() {
        User user=new User("promoter1","promoter1","Promoter");
        super.init(user);

    }

    @Test()
    public void testLogin(){
        basePage=new BasePage(driver,uiElementMapper,user);
        signInPage=basePage.loadApplication();
        wso2SSOPage=signInPage.clickSSOLogin();
        homePage=wso2SSOPage.loginWithSSOCredentials(user.getUserName(),user.getPassWord());
        filterMgtHomePage=homePage.loadFilterMgtHomePage();

    }

    @Test(dependsOnMethods="testLogin")
    public void testLogOut(){
        filterMgtHomePage.logOutFromApp();

    }

    @AfterClass()
    public void tearDown(){
        if (driver != null) {
        driver.quit();
        }
    }



}
