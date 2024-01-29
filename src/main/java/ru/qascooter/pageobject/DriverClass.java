package ru.qascooter.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class DriverClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    //  Добавили конструктор класса page object
    public DriverClass (WebDriver driver) {

        this.driver = driver; // Инициализировали в нём поле driver
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

}
