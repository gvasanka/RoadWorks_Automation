package org.wso2.automation.ui.work;

/**
 * Created by asankav on 7/21/16.
 */


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.roadwork.SignInPage;
import org.wso2.automation.ui.pages.roadwork.WSO2SSOPage;
import org.wso2.automation.ui.pages.worknotifications.WorkHomePage;
import org.wso2.automation.ui.utils.test.RoadWorksUIBaseTest;
import org.wso2.automation.ui.utils.test.User;


/**
 * The following test case checks the ability to login to Work
 */
public class WorkLoginTestCase extends RoadWorksUIBaseTest {

    private BasePage basePage;
    private SignInPage signInPage;
    private WSO2SSOPage wso2SSOPage;
    private HomePage homePage;
    private WorkHomePage WorkHomePage;


    @BeforeClass()
    public void init() {
        User user=new User("promoter1","promoter1","Promoter");
        super.init(user);

    }


    @Test(dataProvider = "userDataProvider")
    public void testLoginAndLogOut(User user){
        basePage=new BasePage(driver,uiElementMapper,user);
        signInPage=basePage.loadApplication();
        wso2SSOPage=signInPage.clickSSOLogin();
        this.user=user;
        homePage=wso2SSOPage.loginWithSSOCredentials(user.getUserName(),user.getPassWord());
        WorkHomePage =homePage.loadWorkFormHomePage();
        WorkHomePage.logOutFromApp();
    }

// TODO When LogOut issue fixed, Need to enable again

//    @DataProvider(name ="userDataProvider")
//    public Object[][] provideData() {
//
//        return new Object[][]{
//                {new User("promoter1","promoter1","Promoter")},
//                {new User("assessor1","assessor1","Assessor")},
//                {new User("qa_lw_admin1 ","qa_lw_admin1 ","SysAdmin")}
//
//        };
//    }

    @AfterClass()
    public void tearDown(){
        if (driver != null) {
        driver.quit();
        }
    }



}
