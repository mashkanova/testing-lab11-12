package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.carhartt-wip.com/en";
    private final By searchButtonLocator = By.xpath("//button[@title='Search']");
    private final By searchInputLocator = By.xpath("//input[@class='search-form__input epoq_search_box ui-autocomplete-input']");
    private final By menButtonLocator = By.xpath("//*[text()='Men']");
    private final By lookbookButtonLocator = By.xpath("//*[@id='topmenue_topmenue_lookbook']");


    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public MenPage openMenPage(){
        WebElement menButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(menButtonLocator));
        menButton.click();
        logger.info("Open Men page");
        return new MenPage(driver);
    }
    public LookbookPage openLookbookPage(){
        WebElement lookbook = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(lookbookButtonLocator));
        lookbook.click();
        logger.info("Open lookbook page");
        return new LookbookPage(driver);
    }

    public ItemsListPage searchQuery(String query){
        WebElement searchButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
        WebElement searchInput= new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchInputLocator));
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
        logger.info("Search query");
        return new ItemsListPage(driver);
    }
    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

}
