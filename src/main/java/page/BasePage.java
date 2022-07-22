package page;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    public static WebDriver driver;

    @Before
    public void setUp() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public BasePage(WebDriver driver) {
        this.driver = (ChromeDriver) driver;
    }
//    public BasePage(WebDriver driver) {
//        this.driver = (FirefoxDriver) driver;
//    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public BasePage openUrl() {
        driver.get(URL);
        return this;
    }
    //верхняя кнопка "заказать"
    private final By orderButtonOverhead = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    //нижняя кнопка "заказать"
    private final By orderButtonUnderarm = By.className("Button_Middle__1CSJM");
    //Кнопка подтверждения куки
    private final By cookie = By.id("rcc-confirm-button");
    //скролл до вопросов
    public BasePage scrollToQuestion() {
        WebElement element = driver.findElement(By.className("Home_FAQ__3uVm4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
    //скролл до нижней кнопки "заказать"
    public BasePage scrollToButtonUnderarm() {
        WebElement buttonOrder = driver.findElement(By.className("Button_Middle__1CSJM"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", buttonOrder);
        return this;
    }
    //Кнопки с вопросами
    public static String questionButton = "accordion__heading-%s";
    // Ответы на вопросы
    public static String questionText = "accordion__panel-%s";
    //Динамический номер для локатора кнопок
    public static By questionButtonLocator(String number) {
        return By.id(String.format(questionButton, number));
    }
    //Динамический номер для локатора ответов
    public static By questionTextLocator(String number) {
        return By.id(String.format(questionText, number));
    }

    //Клик по кнопкам с вопросами
    public BasePage clickQuestionButton(String number) {
        driver.findElement(questionButtonLocator(number)).click();
        return this;
    }
    //Возвращение текста ответов на вопросы
    public static String getQuestionText(String number) {
        return driver.findElement(questionTextLocator(number)).getText();
    }

    //метод подтверждения куки
    public BasePage acceptCookie(){
        driver.findElement(cookie).click();
        return this;
    }

    public BasePage clickOrderButtonOverhead(){
        driver.findElement(orderButtonOverhead).click();
        return this;
    }

    public BasePage clickOrderButtonUnderarm(){
        WebElement underarmButtonElement = driver.findElement(orderButtonUnderarm);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",underarmButtonElement);
        underarmButtonElement.click();
        return this;
    }

    public OrderPage fillOrderDetailsForm(OrderPage orderPage) {
        orderPage.fillName(orderPage.getName());
        orderPage.fillLastName(orderPage.getLastName());
        orderPage.fillAddress(orderPage.getAddress());
        orderPage.fillMetroStation(orderPage.getMetroStation());
        orderPage.fillPhone(orderPage.getPhone());
        orderPage.clickFurtherButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(orderPage.whenOrderDate);
        orderPage.fillOrderDate(orderPage.getOrderDate());
        orderPage.fillRentDuration(orderPage.getRentalPeriod());
        orderPage.fillColourScooter(orderPage.getScooterColour());
        orderPage.fillCommentForCourier(orderPage.getCommentCourier());
        orderPage.clickMakeOrderButton();
        orderPage.clickAgreementButton();
        return (orderPage);
    }



}
