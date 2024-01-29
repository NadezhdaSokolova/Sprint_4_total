package ru.qascooter;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.qascooter.pageobject.HeadPage.HeadPage;

import java.util.concurrent.TimeUnit;


public class DriverTest {
    protected WebDriver driver;


    @Before

    public void setUp(){

        driver = getDriver();
        driver.get(HeadPage.URL);

        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));
    }

    private void setCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }

     @After

    public void tearDown (){
        driver.quit();
    }

    private WebDriver getDriver() {

        String driverType = System.getenv("BROWSER");
            if (driverType == null) {
                driverType = "chrome";

        }
            switch (driverType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();

                default:
                    throw new IllegalArgumentException("We don't provide this browser in owr code");
            }


    }

}
