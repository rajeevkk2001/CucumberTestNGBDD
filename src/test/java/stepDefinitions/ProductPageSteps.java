package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.ProductListingPage;

public class ProductPageSteps {

    TestContext testContext;
    ProductListingPage productListingPage;

    public ProductPageSteps(TestContext context) {
        testContext = context;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();
    }

    @When("^choose to buy the first item$")
    public void choose_to_buy_the_first_item() {
        String productName = productListingPage.getProductName(0);
       // testContext.scenarioContext.setContext(Context.PRODUCT_NAME, productName);

        productListingPage.select_Product(0);
        productListingPage.selectColor();
        productListingPage.selectSize();
        productListingPage.clickOn_AddToCart();
    }
}