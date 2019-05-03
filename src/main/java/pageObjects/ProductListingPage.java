package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

public class ProductListingPage {
    WebDriver driver;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
    private WebElement btn_AddToCart;

    @FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
    private List<WebElement> prd_List;

    @FindBy (how = How.XPATH, using = "//select[@id='pa_color']")
    private WebElement dropDown_color;

    @FindAll(@FindBy(how = How.XPATH, using = "//select[@id='pa_color']//option"))
    private List<WebElement> list_color;

    @FindBy (how = How.XPATH, using = "//select[@id='pa_size']")
    private WebElement dropDown_size;
    @FindAll(@FindBy(how = How.XPATH, using = "    //select[@id='pa_size']//option"))
    private List<WebElement> list_size;



    public void clickOn_AddToCart() {
        btn_AddToCart.click();
        Wait.untilJqueryIsDone(driver);
    }

    public void select_Product(int productNumber) {
        prd_List.get(productNumber).click();
    }

    public String getProductName(int productNumber) {
        return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
    }



    public  void selectColor(){
        dropDown_color.click();
        Wait.untilJqueryIsDone(driver);

        for(WebElement color : list_color){
            if(color.getText().equals("White")) {
                color.click();
                Wait.untilJqueryIsDone(driver);
                break;
            }
        }


    }


    public  void selectSize(){
        dropDown_size.click();
        Wait.untilJqueryIsDone(driver);

        for(WebElement size : list_size){
            if(size.getText().equals("Medium")) {
                size.click();
                Wait.untilJqueryIsDone(driver);
                break;
            }
        }


    }
}