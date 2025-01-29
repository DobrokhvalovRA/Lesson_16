package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if (driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
        /*WebElement selectBtn = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        selectBtn.click();
        WebElement list = driver.findElement(By.name("pay"));
        Select select = new Select(list);
        List<WebElement> optionList = select.getOptions();

        WebElement divPay = driver.findElement(By.className("pay__wrapper"));

        for (int i = 0; i < optionList.size(); i++) {
            System.out.println(optionList.get(i).getText());
            optionList.get(i).click();
            List<WebElement> inputs = divPay.findElements(By.tagName("input"));
            for (WebElement input : inputs)
                System.out.println(i + input.getAttribute("placeholder"));

        }*/


        WebElement selector = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        WebElement number = driver.findElement(By.id("connection-phone"));
        WebElement sum = driver.findElement(By.id("connection-sum"));
        WebElement email = driver.findElement(By.id("connection-email"));
        WebElement continueBut = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        //WebElement frame = driver.findElement(By.className("bepaid-iframe"));



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


        WebElement sumFrame =driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div"));
        //WebElement sumFrame = driver.findElement(By.className("payment-page__order-description pay-description"));
        WebElement sum1 =driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/span"));
        //WebElement continueButFrame = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-required-fields"));
        List <WebElement> inputs = driver.findElements(By.tagName("input"));

        System.out.println(sumFrame.getText());
        System.out.println(inputs.size());

        System.out.println(sumFrame.getText());
        driver.quit();
    }

}
