package org.fetch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageClass {
    public int totalWeighings = 0;
    private static WebDriver driver;

    @FindBy(xpath = "//button[@id='reset' and text()='Reset']")
    private WebElement resetButton;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "weigh")
    private WebElement weightButton;

    @FindAll({@FindBy(css = "input[data-side='left']")})
    private List<WebElement> leftGrid;

    @FindAll({@FindBy(css = "input[data-side='right']")})
    private List<WebElement> rightGrid;

    @FindAll({@FindBy(xpath = "*//div[@class='game-info']//ol/li")})
    private List<WebElement> weighResult;

    @FindBy(xpath = "*//div[@class='game-info']//ol")
    private WebElement mainWeighResultElement;

    @FindAll({@FindBy(xpath = "*//button[contains(@id, 'coin_')]")})
    private List<WebElement> coin;

    public PageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void typeIntoGrids(int[] leftGridValues, int[] rightGridValues) {
        for (int i = 0; i < leftGridValues.length; i++) {
            leftGrid.get(i).sendKeys(String.valueOf(leftGridValues[i]));
        }

        for (int i = 0; i < rightGridValues.length; i++) {
            rightGrid.get(i).sendKeys(String.valueOf(rightGridValues[i]));
        }
    }

    // methods to interact with the elements
    public WebElement getResetButton() {
        return resetButton;
    }

    public void clickWeighButton() {
        // increment the total weighings once this button is clicked to keep
        // a track of how many times it was clicked on and be able to use in
        // getLatestWeightResult()
        totalWeighings++;
        weightButton.click();
    }

    public String getLatestWeightResult() {
        int updatedElementSize = 0;

        while (updatedElementSize != totalWeighings) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            updatedElementSize = weighResult.size();
        }

        String result = weighResult.get(updatedElementSize - 1).getText();
        return result;
    }

    // just to get the number of total weighings element
    public List<WebElement> getWeighResultElement(){
        return weighResult;
    }

    public WebElement getMainWeighResultElement(){
        return mainWeighResultElement;
    }

    public void clickOnCoin(int coinLocation) {
        coin.get(coinLocation).click();
    }
}
