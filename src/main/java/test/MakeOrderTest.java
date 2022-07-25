package test;

import org.junit.Assert;
import org.junit.Test;
import page.BasePage;
import page.OrderPage;

import static org.junit.Assert.assertTrue;

public class MakeOrderTest extends BasePage{
    public MakeOrderTest() {
        super(driver);
    }

    @Test
    public void makeOrder() {
        OrderPage orderPage = new OrderPage("Мария", "Зеленова", "Москва, Красносельская", "Красносельская", "+79371730518","28","двое суток","black","Оставьте у двери");
        boolean isOrderCompleteImageDisplayed2 = new BasePage(driver)
                .openUrl()
                .acceptCookie()
                .clickOrderButtonOverhead()
                .fillOrderDetailsForm(orderPage)
                .isOrderCompleteImageDisplayed();
        assertTrue("Order created image is not displayed", isOrderCompleteImageDisplayed2);
    }
    @Test
    public void makeOrderDifferentButton() {
        OrderPage orderPage = new OrderPage("Мария", "Зел", "Москва, Красносельская", "Красносельская", "+79371730518","28","двое суток","black","Оставьте у двери");
        boolean isOrderCompleteImageDisplayed1 = new BasePage(driver)
                .openUrl()
                .acceptCookie()
                .clickOrderButtonUnderarm()
                .fillOrderDetailsForm(orderPage)
                .isOrderCompleteImageDisplayed();
        assertTrue("Order created image is not displayed", isOrderCompleteImageDisplayed1);

    }
}
