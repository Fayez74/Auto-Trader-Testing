import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarSearch {

    @FindBy(css = "#postcode")
    private  WebElement postcodeField;

    @FindBy(css = "#js-search-button")
    private WebElement searchCar;

    @FindBy(css = "#main-content > div.vehicle__secondarycol > section > div > div.seller_trade__" +
            "ctaButtons > a.seller_trade__visit-website--button.tracking-leads-link")
    private WebElement dealerSite;





    public void setPostcodeField(String postcode){

        postcodeField.sendKeys(postcode);
    }

    public  void setSearchCar(){
        searchCar.click();

    }

    public void setDealerSite(){
        dealerSite.click();

    }














}
