package ru.qascooter.pageobject.OrderPager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject_OrderPage2Locators extends ru.qascooter.pageobject.DriverClass {

    // Название странички
    private final By rentDetail = By.xpath(".//div/div/div[@class = 'Order_Header__BZXOb']");

    // Поле для заполнения сущности "* Когда привезти самокат"
    private final By timeField = By.xpath(".//div[@class = 'Order_Form__17u6u']/div/div/div/input[@placeholder='* Когда привезти самокат']");


    // Элемент выпадающего списка 'Срок аренды'
    private final By timeRent = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class ='Dropdown-root']/div/div[text()='* Срок аренды']");

     // Чекбокс для выбора черного самоката
     private final By blackScooter = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class='Order_Checkboxes__3lWSI']/label/input[@id='black']");

    // Чекбокс для выбора серого самоката
    private final By greyScooter = By.xpath (".//div[@class='Order_Form__17u6u']/div[@class='Order_Checkboxes__3lWSI']/label/input[@id='grey']");

    // Поле комментария для курьера
    private final By commentField = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class='Input_InputContainer__3NykH']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");

    // Кнопка 'Заказать'
    private final By buttonOrderAfterFillingAll = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Заказать']");


    public PageObject_OrderPage2Locators (WebDriver driver) {
        super(driver);
    }

    public PageObject_OrderPage2Locators clickByTimeFieldToGetCalendar() {
        driver.findElement(timeField).click();
        return this;
    }

    public PageObject_OrderPage2Locators fillingCalendar(String data) {
        driver.findElement(timeField).sendKeys(data);
        driver.findElement(rentDetail).click();
        return this;
    }

    public PageObject_OrderPage2Locators timeRent(String period) {

        final String periodOfRentPattern = ".//div[@class = 'Order_Form__17u6u']/div[@class='Dropdown-root is-open']/div[@class='Dropdown-menu']/div[text()= '%s']";
        final String periodOfRentSelected = String.format(periodOfRentPattern, period);
        driver.findElement(timeRent).click();

        WebElement searchPeriodItemsFromList = driver.findElement(By.xpath(periodOfRentSelected));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchPeriodItemsFromList);
        searchPeriodItemsFromList.click();

        return this;
    }

    public PageObject_OrderPage2Locators clickByColorOfScooter() {
        driver.findElement(blackScooter).click();
        return this;
    }

    public PageObject_OrderPage2Locators fillingCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
        return this;
    }

    public PageObject_OrderPage3Locators clickButtonOrderAfterFillingAllFieldonSecondPage() {
        driver.findElement(buttonOrderAfterFillingAll).click();
        return new PageObject_OrderPage3Locators(driver);
    }

}
