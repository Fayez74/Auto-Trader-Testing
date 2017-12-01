import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CarLoan {

    @FindBy(css = "#js-header-nav > ul > li:nth-child(4)")
    private WebElement revieweheader;

    @FindBy(css = "#other-services > li.header__sub-nav-listing.header__sub-nav-listing--2")
    private WebElement carFinanceLink;

    @FindBy(css = "body > div:nth-child(11) > section.top-section > div > form > div.finance-form__inputs > " +
            "section.finance-form__credit-record.js-finance-credit-score.multi-radio > " +
            "label.multi-radio-label.info-trigger.js-finance-hover-d")
    private WebElement creditRatingButton;

    @FindBy(css = "body > div:nth-child(11) " +
            "> section.top-section > div > form >" +
            " div.finance-form__inputs > " +
            "section.finance-form__sliders > div:nth-child(2) > div >" +
            " span.range-slider__increment.js-range-slider-increment")
    private WebElement borrowAmount;


    @FindBy(css = "body > div:nth-child(11) > section.top-section > " +
            "div > form > div.finance-form__inputs > section.finance-form__sliders " +
            "> div:nth-child(4) > div > span.range-slider__decrement.js-range-slider-decrement")
    private WebElement borrowTime;


    @FindBy(css = "body > div:nth-child(11) > section.top-section > div > form > div.finance-form__summary.js-finance-summary > button")
    private WebElement applyNowButton;
    public void setRevieweheader(){

        revieweheader.click();
    }
    public void setCarFinanceLink(){

        carFinanceLink.click();
    }

    public void setCreditRatingButton(){

        creditRatingButton.click();
    }

    public void setBorrowAmount(){

        for (int i =0; i<30; i++){

            borrowAmount.click();
        }

    }
    public void setBorrowTime(){

        for(int i =0;i<20;i++){

            borrowTime.click();
        }

    }

    public void setApplyNowButton(){
        applyNowButton.click();

    }



}
