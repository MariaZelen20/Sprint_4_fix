package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class OrderPage extends BasePage{


    private final By customerName = By.xpath(".//input[@placeholder = '* Имя']");
    private final By customerLastName = By.xpath(".//input[@placeholder = '* Фамилия']");
    private final By customerAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By whenMetroStation = By.xpath(".//input[@class='select-search__input']");

    private final By customerPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    private final By inputDataBlock = By.className("App_App__15LM-");
    private final By furtherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private final By backButton = By.xpath(".//[@class=Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i]");
    // Форма 2. Поле 'Когда привезти самокат'
    public final By whenOrderDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Локатор даты "когда привети самокат"
    private String xpathWhenOrderDateLocator ="//div[@class='react-datepicker__day react-datepicker__day--0%s']";
    //Поле Срок аренды
    private final By rentDurationField = By.xpath("//div[@class='Dropdown-placeholder']");
    //Локатор Срок аренды = 2 суток
    private String xpathRentDurationFieldLocator = "//div[@class='Dropdown-option' and text() = '%s']";
    //Цвет самоката
    private String xpathChooseColourScooter = "//input[@class='Checkbox_Input__14A2w' and @id='%s']";
    //Комментарий для курьера
    private final By commentForCourier = By.xpath("//input[@placeholder='Комментарий для курьера']");

    private final By agreementButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    private final By makeOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");


    private String name;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private String orderDate ;
    private String rentalPeriod;
    private String scooterColour;
    private String orderComment;

    public String getName() {
        return name;
    }

    public String getLastName() {

        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getRentalPeriod() {
        return rentalPeriod;
    }

    public String getScooterColour() {
        return scooterColour;
    }

    public String getCommentCourier() {
        return orderComment;
    }

    public OrderPage(String name, String lastName, String address, String metroStation, String phone, String orderDate, String rentalPeriod,String scooterColour,String orderComment) {
        super(driver);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.orderDate = orderDate;
        this.rentalPeriod = rentalPeriod;
        this.scooterColour = scooterColour;
        this.orderComment = orderComment;

    }
    //Выбор имени
    public OrderPage fillName(String name) {
        driver.findElement(customerName).sendKeys(name);
        return this;
    }

    //Выбор фамилии
    public OrderPage fillLastName(String lastName) {
        driver.findElement(customerLastName).sendKeys(lastName);
        return this;
    }

    //Выбор адреса
    public OrderPage fillAddress(String address) {
        driver.findElement(customerAddress).sendKeys(address);
        return this;
    }

    //Выбор станции метро
    public OrderPage fillMetroStation(String metroStation) {
        driver.findElement(whenMetroStation).sendKeys(metroStation + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }

    //Выбор телефона
    public OrderPage fillPhone(String phone) {
        driver.findElement(customerPhone).sendKeys(phone);
        return this;
    }

    //Выбор даты аренды
    public OrderPage fillOrderDate(String orderDate) {
        driver.findElement(whenOrderDate).click();
        driver.findElement(By.xpath(String.format(xpathWhenOrderDateLocator,orderDate))).click();
        return this;
    }

    //Выбор срока аренды
    public OrderPage fillRentDuration(String rentalPeriod) {
        driver.findElement(rentDurationField).click();
        driver.findElement(By.xpath(String.format(xpathRentDurationFieldLocator,rentalPeriod))).click();
        return this;
    }

    //Выбор цвета самоката
    public OrderPage fillColourScooter(String scooterColour) {
        driver.findElement(By.xpath(String.format(xpathChooseColourScooter,scooterColour))).click();
        return this;
    }

    //Комментарий для курьера
    public OrderPage fillCommentForCourier(String orderComment){
        driver.findElement(commentForCourier).sendKeys(orderComment);
        return this;
    }

    //Переход на следующую страницу заказа
    public OrderPage clickFurtherButton() {
        driver.findElement(furtherButton).click();
        return this;
    }

    //Клик по кнопке заказать
    public OrderPage clickMakeOrderButton() {
        driver.findElement(makeOrderButton).click();
        return this;
    }

    //Подтвердить заказ
    public OrderPage clickAgreementButton() {
        driver.findElement(agreementButton).click();
        return this;
    }







}
