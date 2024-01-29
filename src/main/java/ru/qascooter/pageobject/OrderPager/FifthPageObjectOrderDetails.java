package ru.qascooter.pageobject.OrderPager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FifthPageObjectOrderDetails extends ru.qascooter.pageobject.DriverClass {

    // Страница с деталями выполненного заказа с наличием кнопки "Отменить заказ"

    private final By fieldWithNumberOfOrder = By.xpath(".//div/div/div[@class='Track_Content__St6Kn']/div[@class='Track_Form__N4FE3']/div/input");

    public FifthPageObjectOrderDetails(WebDriver driver) {
        super(driver);
    }


    public FifthPageObjectOrderDetails fieldOrderIsNotEmpty(){
        driver.findElement(fieldWithNumberOfOrder).getAttribute("value");
        return this;
    }


}
