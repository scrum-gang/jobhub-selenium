package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    public static void login(WebDriver driver, String login, String password) throws InterruptedException {

        driver.findElement(By.name("email")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/div/div[3]/div[1]/button")).click();
    }

}
