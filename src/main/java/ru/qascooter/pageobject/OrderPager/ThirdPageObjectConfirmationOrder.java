package ru.qascooter.pageobject.OrderPager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThirdPageObjectConfirmationOrder extends ru.qascooter.pageobject.DriverClass {


        // Кнопка подтверждения заказа
        private final By saveButtonOnConfirmForm = By.xpath(".//div/div[@class='Order_Content__bmtHS']/div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[text()='Да']");


        public ThirdPageObjectConfirmationOrder(WebDriver driver) {
                super(driver);
        }

        public ForthPageObjectOrderPerformed clickSaveButtonOnConfirmForm() {
                driver.findElement(saveButtonOnConfirmForm).click();
                return new ForthPageObjectOrderPerformed(driver);
        }

}



