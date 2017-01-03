package org.wso2.automation.ui.pages.worknotifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wso2.automation.ui.pages.BasePage;
import org.wso2.automation.ui.pages.roadwork.HomePage;
import org.wso2.automation.ui.pages.worknotifications.search.AdvancedSearchPage;
import org.wso2.automation.ui.utils.browser.UIElementMapper;
import org.wso2.automation.ui.utils.test.User;

import java.util.ArrayList;
import java.util.List;


public class WorkHomePage extends BasePage{


    private WebElement lblSearchWork;
    private WebElement btnAdvancedSearch;
    private WebElement btnCreateWork;
    private WebElement lblUserName;
    private WebElement btnLogOut;
    private WebElement tableWork;


    public WorkHomePage(WebDriver driver, UIElementMapper uiElementMapper, User user) {
        super(driver,uiElementMapper,user);

        try {
            wait.until(ExpectedConditions.titleIs("Search TMAN"));

            lblSearchWork =wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("WorkHomePage.lblSearchTman.id"))));
            btnAdvancedSearch=wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("WorkHomePage.btnAdvancedSearch.id"))));
            btnCreateWork =wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("WorkHomePage.btnCreateTMAN.id"))));
            lblUserName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.lblUserName.xpath"))));


        }
        catch (org.openqa.selenium.TimeoutException e){
            throw new IllegalStateException("Page doesn't load within expected time frame :: "+e.toString());
        }


    }

    public void checkWorkSearchTableLoad(){
        WebDriverWait longwait=new WebDriverWait(driver, 100);
        longwait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                ("WorkHomePage.tableTMAN.id"))));
        longwait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement
                ("WorkHomePage.tableNoOfEntries.id"))));

    }

    public boolean isMatchingTextAvailableInCell(WebElement list, String searchTerm ){
            for (WebElement cell : list.findElements(By.tagName("td"))) {

                if (cell.getText().equalsIgnoreCase(searchTerm)){
                    return true;
                }
            }

        return false;
    }


    public List<WebElement> findMatchingTableRow(String searchTerm){

        tableWork =wait.until(ExpectedConditions.elementToBeClickable(By.id(uiElementMapper.getElement("WorkHomePage.tableTMAN.id"))));

        List<WebElement>  matchingRows=new ArrayList<>();
//        List<WebElement> cells=new ArrayList<>();

        // Now get all the TR elements from the table
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("tr")));
        List<WebElement> allRows = tableWork.findElements(By.tagName("tr"));

        // And iterate over them, getting the cells
        for (WebElement row : allRows) {
            wait.until(ExpectedConditions.elementToBeClickable(By.tagName("td")));
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {

                if (cell.getText().equalsIgnoreCase(searchTerm)){
                    matchingRows.add(row);
                    break;
                }
            }

        }
        return matchingRows;

    }

    public UpdateWorkPage viewMatchingWork(String searchTerm, String workSubType){
        List<WebElement>  matchingRows;

        matchingRows=findMatchingTableRow(searchTerm);
        matchingRows.get(0).findElement(By.className("view")).click();

        moveToNextTab();
        handleAlert();
        return new UpdateWorkPage(driver,uiElementMapper,user,workSubType);

    }


    public HomePage logOutFromApp(){
        lblUserName.click();
        btnLogOut=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uiElementMapper.getElement("WorkHomePage.btnLogOut.xpath"))));
        btnLogOut.click();
        return new HomePage(driver,uiElementMapper,user);

    }

    public CreateWorkPage loadCreateWork(){
        btnCreateWork.click();
        return new CreateWorkPage(driver,uiElementMapper,user);

    }

    public AdvancedSearchPage loadAdavancedSearch(){
        btnAdvancedSearch.click();
        return new AdvancedSearchPage(driver,uiElementMapper,user);

    }


}
