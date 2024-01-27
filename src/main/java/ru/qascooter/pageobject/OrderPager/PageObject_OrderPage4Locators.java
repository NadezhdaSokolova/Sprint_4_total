package ru.qascooter.pageobject.OrderPager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject_OrderPage4Locators extends ru.qascooter.pageobject.DriverClass {
    // Окно с номером заказа
    private final By orderNumber = By.xpath(".//div/div[@class='Order_Content__bmtHS']/div[@class='Order_Modal__YZ-d3']/div[@class ='Order_ModalHeader__3FDaJ']");

    // Кнопка 'Посмотреть статус'
    private final By viewStatusButton = By.xpath(".//div/div[@class='Order_Content__bmtHS']/div[@class='Order_Modal__YZ-d3']/div/button [text()='Посмотреть статус']");

    // Страница с деталями выполненного заказа
    private final By orderDetailPage = By.xpath(".//div/div/div[@class='Track_Content__St6Kn']");


    public PageObject_OrderPage4Locators (WebDriver driver) {
        super(driver);
    }

    public PageObject_OrderPage4Locators clickViewStatusButton() {
        driver.findElement(viewStatusButton).click();
        return this;
    }

    public PageObject_OrderPage5Locators getOrderDetailPage() {
        driver.findElement(orderDetailPage).click();
        return new PageObject_OrderPage5Locators(driver);
    }



}
