import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoTraderTesting {

    private JavascriptExecutor js;
    private static ExtentReports report;
    private ExtentTest test;
    private SpreadSheetReader spreadSheetReader;
    private WebDriver webDriver;

    private String url = "https://www.autotrader.co.uk/";

    private String carUrl = "https://www.autotrader.co.uk/classified/advert/201711221" +
                "474041?model=CONTINENTAL&onesearchad=Used&onesearchad=Nearly%20New&on" +
                "esearchad=New&make=BENTLEY&advertising-location=at_cars&sort=sponsored&" +
                "radius=30&postcode=e13aq&page=1&advert-type=featured-listing";

    private List<String> rowString;


    @BeforeClass
    public static void init() {

        report = new ExtentReports();
        String fileName = "AutoTrader Test" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setUp() {

        webDriver = new ChromeDriver();
        test = report.createTest("AutoTrader Tests");
        test.log(Status.INFO, "Test Start ");
        spreadSheetReader = new SpreadSheetReader((System.getProperty("user.dir") + File.separatorChar + "autotrader.xlsx"));

        rowString = new ArrayList<String>();
        rowString = spreadSheetReader.readRow(0, "Sheet1");

    }

    @After
    public void tearDown() {
         webDriver.quit();
    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }



    @Test
    public void researchCar(){

        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        ResearchNewCars newCars = PageFactory.initElements(webDriver, ResearchNewCars.class);
        newCars.setNewCarHeader();
        newCars.setNewCarLink();

        rowString = spreadSheetReader.readRow(0, "Sheet1");  //email
        newCars.setPostcodeField(rowString.get(1));


        WebElement make = webDriver.findElement(By.cssSelector("#searchVehiclesMake")); //make
        Select dropdown = new Select(make);
        dropdown.selectByValue("FERRARI");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Test
    public void carLoan(){

        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);

        CarLoan carLoan1 = PageFactory.initElements(webDriver, CarLoan.class);
        carLoan1.setRevieweheader();
        carLoan1.setCarFinanceLink();
        carLoan1.setCreditRatingButton();
        carLoan1.setBorrowAmount();
        carLoan1.setBorrowTime();
        carLoan1.setApplyNowButton();

    }

    @Test
    public void login(){

        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);

        SignIn signIn1 = PageFactory.initElements(webDriver, SignIn.class);
        signIn1.setSignInButton();

        rowString = spreadSheetReader.readRow(1, "Sheet1");  //email
        signIn1.setSigInEmailField(rowString.get(1));

        rowString = spreadSheetReader.readRow(1,"Sheet1"); // password
        signIn1.setSignInPasswordField(rowString.get(2));

        //signIn1.setCaptchaBox();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        signIn1.setGetSignInButton2();

    }


    @Test
    public void searchCar(){

        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        CarSearch carSearch1 = PageFactory.initElements(webDriver, CarSearch.class);

        rowString = spreadSheetReader.readRow(0, "Sheet1");  //postcode
        carSearch1.setPostcodeField(rowString.get(1));


        WebElement radius = webDriver.findElement(By.cssSelector("#radius"));  //#radius
        Select radiusdropDown = new Select(radius);
        radiusdropDown.selectByVisibleText("Within 30 miles");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement make = webDriver.findElement(By.cssSelector("#searchVehiclesMake")); //make
        Select dropdown = new Select(make);
        dropdown.selectByValue("BENTLEY");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement model = webDriver.findElement(By.cssSelector("#searchVehiclesModel")); //make
        Select dropdown2 = new Select(model);
        dropdown2.selectByValue("CONTINENTAL");


        carSearch1.setSearchCar();
        webDriver.navigate().to(carUrl);
        carSearch1.setDealerSite();


   }


    @Test
    public void signUp(){

        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        SignUp signUp1 = PageFactory.initElements(webDriver, SignUp.class);
        signUp1.setSignInButton();
        signUp1.setSignUpButton();

        rowString = spreadSheetReader.readRow(1, "Sheet1");  //email
        signUp1.setSignUpEmailField(rowString.get(1));

        rowString = spreadSheetReader.readRow(1,"Sheet1"); // password
        signUp1.setSignUpPasswordField(rowString.get(2));

        signUp1.setSignUpConfirm();



    }



}
