import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsMTS {
    private static WebDriver driver;

    @BeforeClass
    public static void make() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        //соглашаемся на куки
        driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[3]")).click();
    }

    @Test //проверяем заголовок
    public void checkTitle() {
        String title;

        // что делать с этим ? На сколько я понял он же должен запустится сам перед тестами,
        //если будет не сложно поясните
        make();

        title = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2")).getText();
        assertTrue(title.equals("Онлайн пополнение\n" + "без комиссии"));
    }

    @Test // проверяем логотипы
    //Буду откровенен тут мне тоже не понятно, если есть xpath значит элемент есть. Что тогда проверять.
    // Или надо проверить список с этими элементами ?
    public void checkLogo() throws NoSuchElementException {


        WebElement visa = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        WebElement vvisa = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
        WebElement mc = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
        WebElement mcsc = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
        WebElement bc = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));

        assertTrue(visa.isDisplayed());
        assertTrue(vvisa.isDisplayed());
        assertTrue(mc.isDisplayed());
        assertTrue(mcsc.isDisplayed());
        assertTrue(bc.isDisplayed());
    }

    @Test //проверяем ссылку
    // или надо проверить что она открыла ?
    public void checkLink() {
        WebElement link = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/a"));
        assertTrue(link.isEnabled());
    }

    @Test //проверка кнопки продолжить
    public void checkButton() {
        WebElement selector = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        WebElement number = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        WebElement continueBut = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));

        //assertTrue(number.isEnabled());
        number.click();
        number.sendKeys("297777777");

        //assertTrue(sum.isEnabled());
        sum.click();
        sum.sendKeys("100");

        //assertTrue(email.isEnabled());
        email.click();
        email.sendKeys("test@test.ru");

        //assertTrue(continueBut.isEnabled());
        continueBut.click();

    }


}

