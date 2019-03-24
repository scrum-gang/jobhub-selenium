import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PageNavigationTest {

        private WebDriver driver;
        private String jobhub = "https://jobhub.netlify.com/login";
        private String jobhubApp = "https://jobhub.netlify.com/applications";

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

        @Test(priority = 1)
        public void applicationsNavigationTest() throws InterruptedException {

            driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/nav/div[2]/div/div/ul/a[2]")).click();
            Thread.sleep(1000);

            SoftAssert softAssert = new SoftAssert();

            String currentURL = driver.getCurrentUrl();
            String expectedURL = "https://jobhub.netlify.com/applications";

            softAssert.assertEquals(currentURL, expectedURL, "URL is not correct!");
            softAssert.assertTrue(driver.findElement(By.xpath(
                    "//*[@id=\"root\"]/div[2]/div/div/div[3]/table/thead/tr/th[2]")).isDisplayed());
            softAssert.assertAll();
        }

        @Test(priority = 2)
        public void postingsNavigationTest() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/nav/div[2]/div/div/ul/a[3]/div")).click();
            Thread.sleep(1000);

            SoftAssert softAssert = new SoftAssert();

            String currentURL = driver.getCurrentUrl();
            String expectedURL = "https://jobhub.netlify.com/postings";

            softAssert.assertEquals(currentURL, expectedURL, "URL is not correct!");
            softAssert.assertTrue(driver.findElement(By.xpath(
                    "//*[@id=\"root\"]/div[2]/div/div[1]")).isDisplayed());
            softAssert.assertAll();
        }

        @AfterMethod
        public void teardownTest (){
            //Close browser and end the session
            driver.quit();
        }
}
