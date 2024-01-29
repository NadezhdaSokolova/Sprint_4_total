package ru.qascooter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.qascooter.pageobject.HeadPage.HeadPage;
import ru.qascooter.pageobject.OrderPager.FirstPageObjectForWhomScooter;
import ru.qascooter.pageobject.OrderPager.SecondPageObjectAboutRent;
import ru.qascooter.pageobject.OrderPager.ThirdPageObjectConfirmationOrder;
import ru.qascooter.pageobject.OrderPager.ForthPageObjectOrderPerformed;
import ru.qascooter.pageobject.OrderPager.FifthPageObjectOrderDetails;
import static org.junit.Assert.assertNotEquals;


@RunWith(Parameterized.class)

public class OrderTesting extends DriverTest {

    private final String orderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String station;
    private final String data;
    private final String comment;
    private final String period;

    public OrderTesting (String orderButton, String name, String surname, String address, String phoneNumber, String station, String data, String comment, String period ) {
        this.orderButton = orderButton;
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
                {HeadPage.orderButtonOnTop, "Надежда", "Волкова", "Москва", "895214569878", "Киевская", "20.02.2024", "Коммент", "сутки"},
                {HeadPage.orderButtonAtTheBottom, "Алексей", "Волкова", "Балахна", "892214369878", "Черкизовская", "20.05.2024", "Спокойной ночи", "пятеро суток"},
        };
    }


    @Test

    public void checkPosibilityToFillOrder () {


        // нажимаем на кнопку заказа вверху страницы

        HeadPage headPage = new HeadPage (driver);
        headPage.clickByOrderButton(By.xpath(orderButton));

        // заполняем первую страницу заказа

        SecondPageObjectAboutRent SecondPageObjectAboutRent = new FirstPageObjectForWhomScooter(driver)
                .fillingNameField(name)
                .fillingSurnameField(surname)
                .fillingAddressField(address)
                .selectOfMetro(station)
                .fillingNumberField(phoneNumber)
                .clickButtonContinue();


        // заполняем вторую страницу заказа

        ThirdPageObjectConfirmationOrder ThirdPageObjectConfirmationOrder = new SecondPageObjectAboutRent(driver)
                .clickByTimeFieldToGetCalendar()
                .fillingCalendar(data)
                .timeRent(period)
                .clickByColorOfScooter()
                .fillingCommentField(comment)
                .clickButtonOrderAfterFillingAllFieldonSecondPage();



        // заполняем третью страницу заказа

        ForthPageObjectOrderPerformed ForthPageObjectOrderPerformed = new ThirdPageObjectConfirmationOrder(driver)
                .clickSaveButtonOnConfirmForm();





        // заполняем 4-ю страничку

        FifthPageObjectOrderDetails fifthPageObjectOrderDetails = new ForthPageObjectOrderPerformed(driver)
                .clickViewStatusButton()
                .getOrderDetailPage();


        // Убеждаемся в наличии кнопки просмотра заказа

        FifthPageObjectOrderDetails NumberOfOrderIsPresent = new FifthPageObjectOrderDetails(driver)
                .fieldOrderIsNotEmpty();


        assertNotEquals ("Поле номера заказа пустое", null, NumberOfOrderIsPresent);

    }

}
