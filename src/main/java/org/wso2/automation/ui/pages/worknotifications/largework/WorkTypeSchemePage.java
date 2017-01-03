package org.wso2.automation.ui.pages.worknotifications.largework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class WorkTypeSchemePage extends BasePage{

    private WebElement lnkSchemeSummary;
    private WebElement lnkPromoterDetails;
    private WebElement lnkDetails;
    private WebElement lnkImpactsMitigations;
    private WebElement lnkAttachedWorks;



    private WebElement lblUserName;
    private WebElement btnLogOut;


    public WorkTypeSchemePage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));

            lnkPromoterDetails=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("WorkTypeSchemePage.lnkPromoterDetails.id"))));
            lnkSchemeSummary=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("WorkTypeSchemePage.lnkSchemeSummary.id"))));
            lnkDetails=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("WorkTypeSchemePage.lnkDetails.id"))));
            lnkImpactsMitigations=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("WorkTypeSchemePage.lnkImpactsMitigations.id"))));
            lnkAttachedWorks=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("WorkTypeSchemePage.lnkAttachedWorks.id"))));


            lblUserName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.lblUserName.xpath"))));


        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public PromoterDetailsPage loadPromoterDetailsForm(){
      //  lnkPromoterDetails.click();

        return new PromoterDetailsPage(driver,uiElementMapper,user);
    }

    public SummaryPage loadSchemeSummaryForm(){
        lnkSchemeSummary.click();

        return new SummaryPage(driver,uiElementMapper,user);
    }

    public DetailsPage loadDetailForm(){
        lnkDetails.click();

        return new DetailsPage(driver,uiElementMapper,user);
    }

    public ImpactsMitigationsPage loadImpactsMitigationsForm(){
        lnkImpactsMitigations.click();

        return new ImpactsMitigationsPage(driver,uiElementMapper,user);
    }

    public AttachedWorksPage loadAttachedWorksForm(){
        lnkAttachedWorks.click();

        return new AttachedWorksPage(driver,uiElementMapper,user);
    }


    public HomePage logOutFromApp(){
        lblUserName.click();
        btnLogOut=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.btnLogOut.xpath"))));
        btnLogOut.click();
        return new HomePage(driver,uiElementMapper,user);

    }




}
