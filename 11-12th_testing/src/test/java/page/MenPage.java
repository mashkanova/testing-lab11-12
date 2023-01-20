package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenPage extends AbstractPage{
    private final By hatsButtonLocator = By.xpath("//*[@class='button primary']");
    private final By jacketButtonLocator = By.xpath("//*[@productid='I029449_89_XX']");

    protected MenPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        CustomDelay(2);
    }
    public ItemsListPage selectJeans(){
        WebElement jeansButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(hatsButtonLocator));
        jeansButton.click();
        logger.info("Jeans");
        CustomDelay(2);
        return new ItemsListPage(driver);
    }
    public ItemsListPage selectJacket(){
        WebElement jacketButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(jacketButtonLocator));
        jacketButton.click();
        logger.info("jacket");
        CustomDelay(2);
        return new ItemsListPage(driver);
    }

}