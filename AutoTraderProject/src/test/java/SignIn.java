import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn {

    @FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-my-at > div")
    private WebElement signInButton;

    @FindBy(css = "#signin-email")
    private WebElement signInEmailField;

    @FindBy(css = "#signin-password")
    private WebElement signInPasswordField;

    @FindBy(css = "#signInSubmit")
    private WebElement getSignInButton2;

    @FindBy(css = "#recaptcha-anchor > div.recaptcha-checkbox-checkmark")
    private WebElement captchaBox;



    public void setSignInButton(){

        signInButton.click();
    }

    public void setSigInEmailField(String email){

        signInEmailField.sendKeys(email);
    }


    public void setSignInPasswordField(String password){
        signInPasswordField.sendKeys(password);

    }

    public void setGetSignInButton2(){

        getSignInButton2.submit();
    }

    public void setCaptchaBox(){

        captchaBox.click();
    }




}
