import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResearchNewCars {


    @FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-buying")
    private WebElement newCarHeader;

    @FindBy(css = "#buying-new-used > li.header__sub-nav-listing.header__sub-nav-listing--2")
    private WebElement newCarLink;

    @FindBy(css = "#postcode")
    private WebElement postcodeField;

    public void setNewCarHeader(){

        newCarHeader.click();
    }

    public void setNewCarLink(){

        newCarLink.click();

    }

    public void setPostcodeField(String postcodeField1){

        postcodeField.sendKeys(postcodeField1);
    }

}
