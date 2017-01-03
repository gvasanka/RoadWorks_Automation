package org.wso2.automation.ui.pages.worknotifications.largework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

import java.util.List;

public class ImpactsMitigationsPage extends BasePage{


    private WebElement chkQualityBusNetwork;
    private WebElement chkReliableRoads;
    private WebElement chkImprovingEnvironment;
    private WebElement chkMoreSaferCycling;
    private WebElement chkBetterPlacestoWalk;
    private WebElement chkReducedCasualties;
    private WebElement chkSustainableFreight;
    private WebElement chkQualityDTDTransport;
    private WebElement chkReducedCrime;
    private WebElement chkRealisingRiversPotential;

    private WebElement lblUserName;
    private WebElement btnLogOut;





    public ImpactsMitigationsPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));

            chkQualityBusNetwork=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("ImpactsMitigationsPage.chkQualityBusNetwork.id"))));

            chkReliableRoads=driver.findElement(By.id(uiElementMapper.getElement("ImpactsMitigationsPage.chkReliableRoads.id")));
            chkImprovingEnvironment=driver.findElement(By.id(uiElementMapper.getElement("ImpactsMitigationsPage.chkImprovingEnvironment.id")));
            chkMoreSaferCycling=driver.findElement(By.id(uiElementMapper.getElement("ImpactsMitigationsPage.chkMoreSaferCycling.id")));
            chkBetterPlacestoWalk=driver.findElement(By.id(uiElementMapper.getElement("ImpactsMitigationsPage.chkBetterPlacestoWalk.id")));

            chkReducedCasualties=driver.findElement(By.id(uiElementMapper.getElement("ImpactsMitigationsPage.chkReducedCasualties.id")));
            chkSustainableFreight=driver.findElement(By.id(uiElementMapper.getElement("ImpactsMitigationsPage.chkSustainableFreight.id")));
            chkQualityDTDTransport=driver.findElement(By.id(uiElementMapper.getElement("ImpactsMitigationsPage.chkQualityDTDTransport.id")));
            chkReducedCrime=driver.findElement(By.id(uiElementMapper.getElement("ImpactsMitigationsPage.chkReducedCrime.id")));

            chkRealisingRiversPotential=driver.findElement(By.id(uiElementMapper.getElement("ImpactsMitigationsPage.chkRealisingRiversPotential.id")));


            lblUserName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.lblUserName.xpath"))));


        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    private void selectImpactsMitigationsOptions(WebElement element,String impactLevel, String impactId, String
            commentId, String commentMessage){

        element.click();
        if ( element.isSelected() )
        {
            List<WebElement> radios = driver.findElements(By.id(impactId));

            if(impactLevel.equalsIgnoreCase("Positive")){
                radios.get(0).click();
            } else if(impactLevel.equalsIgnoreCase("Neutral")){
                radios.get(1).click();
            } else{
                radios.get(2).click();
            }

            driver.findElement(By.id(commentId)).clear();
            driver.findElement(By.id(commentId)).sendKeys(commentMessage);
        }
    }

    public void fillImpactsMitigationsForm(String impactLevel, String message){

        selectImpactsMitigationsOptions(chkQualityBusNetwork,impactLevel,"quality-bus-network-promoter",
                "quality-bus-network-promoter-msg-box",message);

        selectImpactsMitigationsOptions(chkReliableRoads,impactLevel,"reliable-roads-promoter",
                "reliable-roads-promoter-msg-box",message);

        selectImpactsMitigationsOptions(chkImprovingEnvironment,impactLevel,"improving-environment-promoter",
                "improving-environment-promoter-msg-box",message);

        selectImpactsMitigationsOptions(chkMoreSaferCycling,impactLevel,"safer-cycline-promoter",
                "safer-cycline-promoter-msg-box",message);

        selectImpactsMitigationsOptions(chkBetterPlacestoWalk,impactLevel,"better-walk-promoter",
                "better-walk-promoter-msg-box",message);

        selectImpactsMitigationsOptions(chkReducedCasualties,impactLevel,"reduced-casualties-promoter",
                "reduced-casualties-promoter-msg-box",message);

        selectImpactsMitigationsOptions(chkSustainableFreight,impactLevel,"sustainable-freight-promoter",
                "sustainable-freight-promoter-msg-box",message);

        selectImpactsMitigationsOptions(chkQualityDTDTransport,impactLevel,"quality-dtd-transport-promoter",
                "quality-dtd-transport-promoter-msg-box",message);

        selectImpactsMitigationsOptions(chkReducedCrime,impactLevel,"reduced-crime-promoter",
                "reduced-crime-promoter-msg-box",message);

        selectImpactsMitigationsOptions(chkRealisingRiversPotential,impactLevel,"rivers-potential-promoter",
                "rivers-potential-promoter-msg-box",message);


    }

    public HomePage logOutFromApp(){
        lblUserName.click();
        btnLogOut=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.btnLogO+ut.xpath"))));
        btnLogOut.click();
        return new HomePage(driver,uiElementMapper,user);

    }




}
