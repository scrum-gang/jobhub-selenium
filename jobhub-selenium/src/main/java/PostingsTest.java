import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PostingsTest {

    private WebDriver driver;
    private String jobhub = "https://jobhub.netlify.com/login";
    private String jobHubPosting = "https://jobhub.netlify.com/postings";

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
    public void verifyPostingTest() throws InterruptedException {

        driver.navigate().to(jobHubPosting);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/article/a/div/button")).click();
        Thread.sleep(3000);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/h1")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/h2")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/h6")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/p")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/span[1]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/span[2]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.name("comment")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("select-resume")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/div[2]/button/span[1]")).isDisplayed());
        softAssert.assertAll();
    }

    @AfterMethod
    public void teardownTest (){
        //Close browser and end the session
        driver.quit();
    }

}
