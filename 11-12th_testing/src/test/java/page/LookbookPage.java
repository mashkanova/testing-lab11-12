package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LookbookPage extends AbstractPage {

    private final By womenLookbookButtonLocator = By.xpath("//*[@id='page-content']/section/a[2]/div");


    protected LookbookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        CustomDelay(2);
    }
    public ItemsListPage selectWomenLookbook(){
        WebElement womenLookbookButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(womenLookbookButtonLocator));
        womenLookbookButton.click();
        logger.info("womenLookbookButton");
        CustomDelay(2);
        return new ItemsListPage(driver);
    }
}
