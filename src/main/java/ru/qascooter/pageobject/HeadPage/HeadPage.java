package ru.qascooter.pageobject.HeadPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


public class HeadPage extends ru.qascooter.pageobject.DriverClass {

    // Адрес главной страницы
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    // Кнопка «Заказать» сверху
    public static final String orderButtonOnTop = ".//button[@class= 'Button_Button__ra12g']";

    // Кнопка «Заказать» снизу
    public static final String orderButtonAtTheBottom = ".//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']";


    // Заголовок «Вопросы о важном»
    By headerFAQ = By.xpath(".//div[text()='Вопросы о важном']");




    public HeadPage(WebDriver driver){
        super (driver);
    }


    public void clickByOrderButton(By orderButton){
        driver.findElement(orderButton).click();
    }



    public void scrollToBottomOfPage (){
        WebElement selectQuestion = driver.findElement(headerFAQ);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", selectQuestion);

    }

    public void clickOnTheQuestion (int numberOfQuestion){
        final String clickOnTheQuestionPattern = ".//div[@id='accordion__heading-%d']";
        final String selectOnQuestionNumber = String.format(clickOnTheQuestionPattern, numberOfQuestion);
        WebElement clickOnSelectedQuestion = driver.findElement(By.xpath(selectOnQuestionNumber));
        clickOnSelectedQuestion.click();
        //return clickOnSelectedQuestion.getText();

    }

    public String getAnswerOnQuestion (int numberOfQuestion){
        final String getTextAnswerOnQuestionPattern = ".//div[@id='accordion__panel-%d']";
        final String getTextAnswerOnQuestion = String.format(getTextAnswerOnQuestionPattern, numberOfQuestion);
        WebElement clickOnSelectedQuestion = driver.findElement(By.xpath(getTextAnswerOnQuestion));
        return clickOnSelectedQuestion.getText();

    }

}



