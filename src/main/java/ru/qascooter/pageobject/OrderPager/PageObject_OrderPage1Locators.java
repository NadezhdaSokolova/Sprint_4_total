package ru.qascooter.pageobject.OrderPager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class PageObject_OrderPage1Locators extends ru.qascooter.pageobject.DriverClass {

    //Название страницы
    private final By arendatorDetails = By.xpath("..//div/div/[@text = 'Для кого самокат']");

    // Поле для заполнения сущности "* Имя"
    private final By nameField = By.xpath(".//div[@class = 'Order_Form__17u6u']/div/input[@placeholder='* Имя']");

    // Поле для заполнения сущности "* Фамилия"
    private final By surnameField = By.xpath(".//div[@class = 'Order_Form__17u6u']/div/input[@placeholder='* Фамилия']");

    // Поле для заполнения сущности адреса заказа
    private final By addressField = By.xpath(".//div[@class = 'Order_Form__17u6u']/div/input[@placeholder='* Адрес: куда привезти заказ']");

    private final By metro = By.xpath(".//div[@class = 'Order_Form__17u6u']/div/div[@class='select-search']/div/input");

    // Поле для заполнения сущности "* Телефон"
    private final By phoneNumberField = By.xpath(".//div[@class = 'Order_Form__17u6u']/div/input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка 'Далее'
    private final By buttonContinue = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");


    public PageObject_OrderPage1Locators(WebDriver driver) {
        super(driver);
    }

    public PageObject_OrderPage1Locators fillingNameField (String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public PageObject_OrderPage1Locators fillingSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }

    public PageObject_OrderPage1Locators fillingAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;
    }

    public PageObject_OrderPage1Locators selectOfMetro(String station) {

        final String MetroStationPattern = ".//div[@class='Order_Form__17u6u']/div/div[@class='select-search has-focus']/div[@class='select-search__select']//*[text()='%s']";
        final String MetroStationSelected = String.format(MetroStationPattern, station);
        driver.findElement(metro).click();

        WebElement searchStationFromList = driver.findElement(By.xpath(MetroStationSelected));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchStationFromList);

        searchStationFromList.click();

        return this;

    }

    public PageObject_OrderPage1Locators fillingNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }

    public PageObject_OrderPage2Locators clickButtonContinue() {
        driver.findElement(buttonContinue).click();
        return new PageObject_OrderPage2Locators(driver);
    }

}



