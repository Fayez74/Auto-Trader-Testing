import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp {



    @FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-my-at > div")
    private WebElement signInButton;

    @FindBy(css = "#js-social__signup-tab")
    private  WebElement signUpButton;

    @FindBy(css = "#email")
    private WebElement signUpEmailField;

    @FindBy(css = "#password")
    private WebElement signUpPasswordField;

    @FindBy(css = "#social--signup--submit")
    private WebElement signUpConfirm;


    public void setSignInButton(){

        signInButton.click();
    }

    public void setSignUpButton(){

        signUpButton.click();
    }

    public void setSignUpEmailField(String email){

        signUpEmailField.sendKeys(email);
    }

    public void setSignUpPasswordField(String password){
        signUpPasswordField.sendKeys(password);

    }

    public void setSignUpConfirm(){

        signUpConfirm.submit();
    }






}
