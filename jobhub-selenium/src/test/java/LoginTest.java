import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private String jobhubLocal = "http://localhost:3000/login";
//    private static String signInButtonClassName = "MuiButtonBase-root-142 MuiButton-root-246 MuiButton-contained-257 " +
//            "MuiButton-containedPrimary-258 MuiButton-raised-260 MuiButton-raisedPrimary-261 " +
//            "MuiButton-sizeLarge-270 MuiButton-fullWidth-271";

    @BeforeMethod
    public void setup(){
        //Create a new ChromeDriver
        System.setProperty("webdriver.chrome.driver","E:\\Devtools\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        System.out.println("1. Navigate to Login Page");
        driver.navigate().to(jobhubLocal);
    }

    @Test
    public void loginTest () {
        System.out.println("2. input Login credentials.");
        driver.findElement(By.name("email")).sendKeys("laurent.chenet@mail.mcgill.ca");
        driver.findElement(By.name("password")).sendKeys("jobhub");
        //driver.findElement(By.type("MuiButton-label-247")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/div/div[3]/div[1]/button")).click();

        Assert.assertFalse(driver.findElement(By.className("Toastify")).isDisplayed());

    }

    @AfterMethod
    public void teardownTest (){
        //Close browser and end the session
        driver.quit();
    }
}
