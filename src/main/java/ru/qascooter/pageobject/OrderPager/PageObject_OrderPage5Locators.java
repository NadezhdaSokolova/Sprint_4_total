package ru.qascooter.pageobject.OrderPager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject_OrderPage5Locators extends ru.qascooter.pageobject.DriverClass {

    // Страница с деталями выполненного заказа с наличием кнопки "Отменить заказ"

    private final By cancelOrderButtonIsPresent = By.xpath(".//div/button[text()='Отменить заказ']");


    public PageObject_OrderPage5Locators (WebDriver driver) {
        super(driver);
    }

    public PageObject_OrderPage5Locators cancelOrderButtonIsPresent () {
        driver.findElement(cancelOrderButtonIsPresent).getText();
        return this;
    }



}
