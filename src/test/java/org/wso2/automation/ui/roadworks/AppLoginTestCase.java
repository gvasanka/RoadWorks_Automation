package org.wso2.automation.ui.roadworks;

/**
 * Created by asankav on 7/21/16.
 */


import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.roadwork.SignInPage;
import org.wso2.automation.ui.pages.roadwork.WSO2SSOPage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.wso2.automation.ui.utils.test.User;


/**
 * The following test case checks the Application accessibility via the URL
 */
public class AppLoginTestCase extends RoadWorksUIBaseTest {

    private BasePage basePage;
    private SignInPage signInPage;
    private WSO2SSOPage wso2SSOPage;
    private HomePage homePage;

    @BeforeClass()
    public void init() {
        User user=new User("promoter1","promoter1","Promoter");
        super.init(user);
    }

    @Test()
    public void testApplicationLoad(){
        basePage=new BasePage(driver,uiElementMapper,user);
        signInPage=basePage.loadApplication();
        String expected="Portal for ArcGIS - Sign In";
        Assert.assertEquals(expected,driver.getTitle());
    }

    @Test(dependsOnMethods="testApplicationLoad")
    public void testLogin(){
        wso2SSOPage=signInPage.clickSSOLogin();
        homePage=wso2SSOPage.loginWithSSOCredentials(user.getUserName(),user.getPassWord());

    }

    @Test(dependsOnMethods="testLogin")
    public void testLogOut(){
        homePage.logOutFromApp();

    }

    @AfterClass()
    public void tearDown(){
        if (driver != null) {
        driver.quit();
        }
    }



}
