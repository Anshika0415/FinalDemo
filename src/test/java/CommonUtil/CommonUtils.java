package CommonUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    private WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public String captureScreenshot(String screenshotName) {
        try {
            // Capture screenshot as a file
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            screenshotName = screenshotName.replace(" ", "_");
            // Generate a timestamped file name
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = System.getProperty("user.dir")+"reports/screenshots/" + screenshotName + "_" + timestamp + ".png";

            // Save screenshot to the folder
            File destFile = new File(filePath);
            FileUtils.copyFile(srcFile, destFile);

            return filePath; // Return the screenshot path
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void clickElem(WebElement elem)
    {
    	((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	elem.click();
    }
}
