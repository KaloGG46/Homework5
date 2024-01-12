import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Checkout {
    WebDriver driver;

    @BeforeMethod
    public void setUp () {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkBoxTest () {
        driver.get("http://shop.pragmatic.bg/index.php?route=product/product&product_id=43");
        driver.findElement(By.id("button-cart")).click();
        driver.findElement(By.id("cart-total")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart a:nth-of-type(2)")));
        driver.findElement(By.cssSelector("#cart a:nth-of-type(2)")).click();

        WebElement checkout = driver.findElement(By.xpath("//div[@id=\"checkout-checkout\"]//li[3]/a"));
        String checkoutText = checkout.getText();
        assertEquals(checkoutText,"Checkout");
    }

    @AfterMethod
    public void tearDown() { driver.quit();}
}
