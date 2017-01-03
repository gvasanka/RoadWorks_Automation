package org.wso2.automation.ui.pages.worknotifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;


public class AttachmentsPage extends BasePage{

    private WebElement txtFileName;
    private WebElement txtDescription;
    private WebElement dropDownattachmentType;
    private WebElement btnAddAttachment;



    public AttachmentsPage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {

            txtFileName=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("AttachmentsPage.txtFileName.id"))));
            txtDescription=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("AttachmentsPage.txtDescription.id"))));
            dropDownattachmentType=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                    ("AttachmentsPage.dropDownattachmentType.id"))));
            btnAddAttachment=driver.findElement(By.xpath(uiElementMapper.
                    getElement("AttachmentsPage.btnAddAttachment.xpath")));



        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }
    public void addNewAttachement(String fileName, String des, String attachementType, String filePath){
        txtFileName.sendKeys(fileName);
        txtDescription.sendKeys(des);

        Select select=new Select(dropDownattachmentType);
        select.selectByVisibleText(attachementType);
        String projectRoot=System.getProperty("user.dir");

        System.out.println(projectRoot +filePath);
        btnAddAttachment.sendKeys(projectRoot +filePath);

    }


}
