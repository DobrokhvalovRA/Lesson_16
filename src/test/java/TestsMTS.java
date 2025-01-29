import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestsMTS {
    private static WebDriver driver;

    @BeforeEach
    public void make() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @AfterEach
    public void close() {
        //driver.quit();
    }

    @Test
    public void checkFields() {
        driver.get("https://www.mts.by/");
        if (driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
        //WebElement selectBtn = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        //selectBtn.click();
        //WebElement list = driver.findElement(By.name("pay"));
        //Select select = new Select(list);
        //List<WebElement> optionList = select.getOptions();
        WebElement divPay = driver.findElement(By.className("pay__wrapper"));


        //for (int i = 0; i < optionList.size(); i++) {
        //    optionList.get(i).click();
        List<WebElement> inputs = divPay.findElements(By.tagName("input"));
        for (WebElement input : inputs) {
            assertTrue(input.getText().equals(""));
        }
        //}

    }


    @Test
    public void checkButton() {
        driver.get("https://www.mts.by/");

        if (driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
        WebElement selector = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        WebElement number = driver.findElement(By.id("connection-phone"));
        WebElement sum = driver.findElement(By.id("connection-sum"));
        WebElement email = driver.findElement(By.id("connection-email"));
        WebElement continueBut = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        Actions builder = new Actions(driver);
        builder
                .click(number)
                .sendKeys(number, "297777777")
                .click(sum)
                .sendKeys(sum, "100")
                .click(email)
                .sendKeys(email, "test@test.ru")
                .click(continueBut)
               .build()
                .perform();

        WebElement payFrame = driver.findElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(payFrame);

        WebElement sumFrame = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/span[1]"));
        List <WebElement> inputs = driver.findElements(By.tagName("input"));

        for (WebElement input : inputs) {
            assertTrue(input.getText().equals(""));
        }
    }


}

