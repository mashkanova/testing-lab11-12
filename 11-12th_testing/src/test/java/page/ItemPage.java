package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends AbstractPage {

    private final By addToBagButtonLocator = By.xpath("//button[@class='product-submit']");

    public ItemPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage addToBag(){
        WebElement addToBagButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(addToBagButtonLocator));
        addToBagButton.click();
        logger.info("Add to cart");
        return this;
    }

}
