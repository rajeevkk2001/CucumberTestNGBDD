package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.en.When;
import pageObjects.CartPage;

public class CartPageSteps {

    //http://jsonviewer.stack.hu/

    TestContext testContext;
    CartPage cartPage;
    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @When("^moves to checkout from mini cart$")
    public void moves_to_checkout_from_mini_cart(){
        cartPage.clickOn_Cart();
//        testContext.getScenario().write("Clicked on the checkout buttton in Cart Page");
        cartPage.clickOn_ContinueToCheckout();
    }

}
