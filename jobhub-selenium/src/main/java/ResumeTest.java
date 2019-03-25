import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ResumeTest {

    private WebDriver driver;
    private String jobhub = "https://jobhub.netlify.com/login";
    private String jobhubRes = "";

    //UPDATE THESE AS NEEDED
    public static String login = "laurent.chenet@mail.mcgill.ca";
    public static String password = "jobhub";

    @BeforeMethod
    public void setup() throws InterruptedException {
        //Create a new ChromeDriver
        System.setProperty("webdriver.chrome.driver","E:\\Devtools\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        System.out.println("1. Navigate to Login Page");
        driver.navigate().to(jobhub);
        Thread.sleep(3000);
        // login
        try {
            basic.Login.login(driver, login, password);
            Thread.sleep(3000);
        } catch (Exception e) {}

    }

    @Test
    public void resumeTest() throws InterruptedException {

    }

    @AfterMethod
    public void teardownTest (){
        //Close browser and end the session
        driver.quit();
    }
}
