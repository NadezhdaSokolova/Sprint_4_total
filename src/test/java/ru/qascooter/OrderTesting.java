package ru.qascooter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.qascooter.pageobject.HeadPage.HeadPage;
import ru.qascooter.pageobject.OrderPager.PageObject_OrderPage1Locators;
import ru.qascooter.pageobject.OrderPager.PageObject_OrderPage2Locators;
import ru.qascooter.pageobject.OrderPager.PageObject_OrderPage3Locators;
import ru.qascooter.pageobject.OrderPager.PageObject_OrderPage4Locators;
import ru.qascooter.pageobject.OrderPager.PageObject_OrderPage5Locators;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)

public class OrderTesting extends DriverTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String station;
    private final String data;
    private final String comment;
    private final String period;

    public OrderTesting (String name, String surname, String address, String phoneNumber, String station, String data, String comment, String period ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.station = station;
        this.data = data;
        this.comment = comment;
        this.period = period;
    }

    @Parameterized.Parameters
    public static Object[][] TestData (){
        return new Object[][]  {
                {"Надежда", "Волкова", "Москва", "895214569878", "Киевская", "20.02.2024", "Коммент", "сутки"},
                {"Алексей", "Волкова", "Балахна", "892214369878", "Черкозовская", "20.05.2024", "Спокойной ночи", "пятеро суток"},
        };
    }


    @Test

    public void checkPosibilityToFillFirstOrderPage () {


        // нажимаем на кнопку заказа вверху страницы

        HeadPage headPage = new HeadPage (driver);
        headPage.clickByOrderButtonOnTop();

        // заполняем первую страницу заказа

        PageObject_OrderPage2Locators PageObject_OrderPage2Locators = new PageObject_OrderPage1Locators (driver)
                .fillingNameField(name)
                .fillingSurnameField(surname)
                .fillingAddressField(address)
                .selectOfMetro(station)
                .fillingNumberField(phoneNumber)
                .clickButtonContinue();


        // заполняем вторую страницу заказа

        PageObject_OrderPage3Locators pageObjectOrderPage3Locators = new PageObject_OrderPage2Locators (driver)
                .clickByTimeFieldToGetCalendar()
                .fillingCalendar(data)
                .timeRent(period)
                .clickByColorOfScooter()
                .fillingCommentField(comment)
                .clickButtonOrderAfterFillingAllFieldonSecondPage();



        // заполняем третью страницу заказа

        PageObject_OrderPage4Locators pageObject_OrderPage4Locators = new PageObject_OrderPage3Locators (driver)
                .clickSaveButtonOnConfirmForm();


        // заполняем 4-ю страничку

        PageObject_OrderPage5Locators pageObject_orderPage5Locators = new PageObject_OrderPage4Locators (driver)
                .clickViewStatusButton()
                .getOrderDetailPage();

        // Убеждаемся в наличии кнопки отказа от заказа

        PageObject_OrderPage5Locators CancelOrderButton = new PageObject_OrderPage5Locators (driver)
                .cancelOrderButtonIsPresent();


        assertEquals ("Не нашли кнопку отказа от заказа.", "Отменить заказ", CancelOrderButton);

    }

}
