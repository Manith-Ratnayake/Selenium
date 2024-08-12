import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class start {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement searchBar = driver.findElement(By.className("gLFyf"));
        searchBar.sendKeys("Booking.com");
        searchBar.submit();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bookingLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Booking.com")));
        bookingLink.click();

        WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a7dc8ec444")));
        location.click();
        location.sendKeys("Colombo");


    }
}
