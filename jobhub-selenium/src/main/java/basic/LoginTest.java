import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private String jobhubLocal = "http://localhost:3000/login";

    @BeforeMethod
    public void setup(){
        //Create a new ChromeDriver
        System.setProperty("webdriver.chrome.driver","E:\\Devtools\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        System.out.println("1. Navigate to Login Page");
        driver.navigate().to(jobhubLocal);
    }

    @Test
    public void loginTest() throws InterruptedException {
        System.out.println("2. input Login credentials.");
        driver.findElement(By.name("email")).sendKeys("laurent.chenet@mail.mcgill.ca");
        driver.findElement(By.name("password")).sendKeys("jobhub");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/div/div[3]/div[1]/button")).click();
        Thread.sleep(3000);

        Assert.assertFalse(driver.findElement(By.className("Toastify")).isDisplayed());

    }

    @AfterMethod
    public void teardownTest (){
        //Close browser and end the session
        driver.quit();
    }
}
