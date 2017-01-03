package org.wso2.automation.ui.pages.worknotifications.largework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class LargeWorkHomePage extends BasePage{


    private WebElement lblSchemaType;
    private WebElement dropDownSchemaType;


    public LargeWorkHomePage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Road Works - TMAN"));

            lblSchemaType=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("LargeWorkHomePage.lblSchemaType.xpath"))));
            dropDownSchemaType=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("LargeWorkHomePage.dropDownSchemaType.xpath"))));

        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public WorkTypeSchemePage selectSchemaType(String scheme){
        Select select=new Select(dropDownSchemaType);
        select.selectByVisibleText(scheme);

        return new WorkTypeSchemePage(driver,uiElementMapper,user);
    }


    public WorkTypeAttachedWorksPage selectAttachedWork(){
        Select select=new Select(dropDownSchemaType);
        select.selectByVisibleText("Attached Works");

        return new WorkTypeAttachedWorksPage(driver,uiElementMapper,user);
    }





}
