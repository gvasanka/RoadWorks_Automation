package org.wso2.automation.ui.pages.worknotifications.largework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class WorkTypeAttachedWorksPage extends BasePage{


    private WebElement lnkSchemeSummary;
    private WebElement lnkPromoterDetails;
    private WebElement lnkDetails;
    private WebElement lnkPhases;
    private WebElement txtSchemeNumber;


    public WorkTypeAttachedWorksPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));



            lnkPromoterDetails=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("WorkTypeAttachedWorksPage.lnkPromoterDetails.id"))));
            lnkSchemeSummary=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("WorkTypeAttachedWorksPage.lnkSchemeSummary.id"))));
            lnkDetails=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("WorkTypeAttachedWorksPage.lnkDetails.id"))));
            lnkPhases=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("WorkTypeAttachedWorksPage.lnkPhases.id"))));





        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void fillParentSchemeNumber(String schemaNumber){
        txtSchemeNumber=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                ("WorkTypeAttachedWorksPage.txtSchemeNumber.id"))));
        txtSchemeNumber.sendKeys(schemaNumber);
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

    public PhasesPage loadPhasesForm(){
        lnkPhases.click();

        return new PhasesPage(driver,uiElementMapper,user);
    }


}
