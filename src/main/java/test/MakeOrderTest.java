package test;

import org.junit.Test;
import org.junit.runners.Parameterized;
import page.BasePage;
import page.OrderPage;

import static page.BasePage.driver;

public class MakeOrderTest extends BasePage{
    public MakeOrderTest() {
        super(driver);
    }

    @Test
    public void makeOrder() {
        OrderPage orderPage = new OrderPage("Мария", "Зеленова", "Москва, Красносельская", "Красносельская", "+79371730518","28","двое суток","black","Оставьте у двери");
        OrderPage isInputDataBlockDisplayed = (OrderPage) new BasePage(driver)
                .openUrl()
                .acceptCookie()
                .clickOrderButtonOverhead()
                .fillOrderDetailsForm(orderPage);

    }
    @Test
    public void makeOrderDifferentButton() {
        OrderPage orderPage = new OrderPage("Мария", "Зел", "Москва, Красносельская", "Красносельская", "+79371730518","28","двое суток","black","Оставьте у двери");
        OrderPage isInputDataBlockDisplayed = (OrderPage) new BasePage(driver)
                .openUrl()
                .acceptCookie()
                .clickOrderButtonUnderarm()
                .fillOrderDetailsForm(orderPage);

    }
}
