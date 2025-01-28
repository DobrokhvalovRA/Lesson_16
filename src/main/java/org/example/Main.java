package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        if (driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
        WebElement selectBtn = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
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

        }
        driver.quit();
    }

}
