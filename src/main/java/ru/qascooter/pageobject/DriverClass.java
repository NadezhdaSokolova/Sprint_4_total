package ru.qascooter.pageobject;
import org.openqa.selenium.WebDriver;


public class DriverClass {
    protected WebDriver driver;
    //protected WebDriverWait wait;

    //  Добавили конструктор класса page object
    public DriverClass (WebDriver driver) {

        this.driver = driver; // Инициализировали в нём поле driver

    }

}
