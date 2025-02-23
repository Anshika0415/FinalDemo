package stepdef;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import CommonUtil.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pages.LoginTest;

public class StepDef {
    static WebDriver driver;
    private LoginTest lt;
    private static ExtentReports extent;
    private static ExtentTest test;
    private static CommonUtils ss;

    // -------------------- Setup Hook -------------------- //
    static {
    
    	
        String reportPath = "reports/chromeFile.html";
        // Initialize ExtentReports (only once)
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setTheme(Theme.STANDARD);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);}
    }
    
    @Before
    public void setUp(Scenario scenario) {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       
        // Initialize Screenshot Utility
        
        ss = new CommonUtils(driver); //pass object using constructor
        lt = new LoginTest(driver,ss);
        
        // Create test node for the scenario
        test = extent.createTest(scenario.getName());
    }

    // -------------------- Tear Down Hook -------------------- //

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenshotPath = ss.captureScreenshot("Failed_" + scenario.getName());


            test.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @AfterAll
    public static void tearDown() {
        extent.flush(); // Writes everything to the report
    }


    // -------------------- BeforeStep: Take Screenshot Anytime -------------------- //

    @BeforeStep
    public void takeStepScreenshot(Scenario scenario) throws IOException {
    	
        String screenshotPath = ss.captureScreenshot("Step_" + scenario.getName());
        
		test.info("Step Execution Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    // -------------------- Step Definitions -------------------- //

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() {
        lt.homePage();
    }

  
    @When("User enters {string} and {string}")
    public void user_enters_name_and_pass(String name,String pass) {
    	 lt.updatedUserNamePass(name,pass);
    }
    
    @Then("just for the sake of learning pass {int}")
    public void just_for_the_sake_of_learning_pass(int int1) {
        // Write code here that turns the phrase above into concrete actions
       
    }
   
    @When("^Clicks Go button$")
    public void clicks_Go_button() throws InterruptedException {
        WebElement goButton = driver.findElement(By.id("login"));
       ss.clickElem(goButton);
        Thread.sleep(3000);
    }

    @Then("^He can visit the practice page$")
    public void he_can_visit_the_practice_page() throws InterruptedException {
    	lt.visitPracticePage();

    }


    @Then("^A message is displayed$")
    public void a_message_is_displayed() {
        System.out.println("Login Successful");
    }
    
    @Then("Context click on mouse hover button and select {string} option")
    public void context_click_on_mouse_hover_button_and_select_option(String string) {
       lt.mouseHoverCode(string);
    }
    @Then("Check iFrame functionality")
    public void check_i_frame_functionality() {
        // Write code here that turns the phrase above into concrete actions
        lt.checkIframe();
    }

}
