package ru.qascooter.pageobject.OrderPager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject_OrderPage3Locators extends ru.qascooter.pageobject.DriverClass {

        // Всплывающее окно с сообщением об успешном создании заказа
        private final By popupWithNubberoforder = By.xpath("/div/div[@class='Order_Content__bmtHS']/div[@class='Order_Modal__YZ-d3']/div[@class='class='Order_Text__2broi']");



        // Кнопка подтверждения заказа
        private final By saveButtonOnConfirmForm = By.xpath(".//div/div[@class='Order_Content__bmtHS']/div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[text()='Да']");


        public PageObject_OrderPage3Locators (WebDriver driver) {
                super(driver);
        }

        public PageObject_OrderPage4Locators clickSaveButtonOnConfirmForm() {
                driver.findElement(saveButtonOnConfirmForm).click();
                return new PageObject_OrderPage4Locators(driver);
        }



}



