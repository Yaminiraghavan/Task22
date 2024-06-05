package Task22;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Question1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo/");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement firstname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("first_name")));
        firstname.sendKeys("test");
        WebElement lastname =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("last_name")));
        lastname.sendKeys("user");
        WebElement businessname =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("business_name")));
        businessname.sendKeys("testuser");
        WebElement email =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        email.sendKeys("testuser@gmail.com");
        Thread.sleep(2000);
        WebElement sumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number")));
        WebElement number1Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numb1")));
        WebElement number2Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numb2")));
        int number1 = Integer.parseInt(number1Input.getText());
        int number2 = Integer.parseInt(number2Input.getText());
        int sum = number1 + number2;
        sumInput.sendKeys(Integer.toString(sum));
        //Thread.sleep(2000);
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("demo")));
        submitButton.click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),' Thank you!')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Form submitted successfully!");
        } else {
            System.out.println("Form submission failed!");
        }
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshotFile, new File("screenshot.png"));
        driver.quit();

    }
}
