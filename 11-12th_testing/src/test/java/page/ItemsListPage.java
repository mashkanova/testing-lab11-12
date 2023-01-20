package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemsListPage extends AbstractPage{
    private final By setPriceLocator = By.xpath("//*[@data-filtername='Price']");
    private final By setLowPriceLocator = By.xpath("//*[@class='epoq_filter_value'][@title='0 - 25 €']");
    private final By filtersButtonLocator = By.xpath("//*[@class='slider-icon']");
    private final By onlyGreen = By.xpath("//*[@title='Green']");
    private final By selectFirstLocator = By.xpath("//*[@class='product-grid-item-container small']");
    private final By selectedLookButtonLocator = By.xpath("    //*[@id='page-content']/section[1]/div[1]/div/article[1]/div[1]/a/span/div");
    private final By viewMoreButtonLocator = By.xpath("//*[@id='page-content']/section[1]/div[1]/div/article[1]/div[2]/div/div[2]/div[1]/form/a");


    protected ItemsListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public ItemsListPage setPriceFilter(){
        WebElement priceButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(setPriceLocator));
        priceButton.click();
        WebElement lowerPriceButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(setLowPriceLocator));
        lowerPriceButton.click();
        logger.info("Filter price");
        return this;
    }
    public ItemsListPage sortByPriceUp(){
        WebElement filtersButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(filtersButtonLocator));
        filtersButton.click();
        WebElement lowtohigh = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(onlyGreen));
        lowtohigh.click();
        logger.info("Filter running");
        return this;
    }
    public ItemPage selectFirst(){
        WebElement selected = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectFirstLocator));
        selected.click();
        logger.info("select First");
        return new ItemPage(driver);
    }
    public ItemsListPage selectlookFirst(){
        WebElement selectedlook = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectedLookButtonLocator));
        selectedlook.click();
        logger.info("select First");
        return this;
    }
    public ItemPage viewMore(){
        WebElement selected = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(viewMoreButtonLocator));
        selected.click();
        logger.info("select First");
        return new ItemPage(driver);
    }

}
