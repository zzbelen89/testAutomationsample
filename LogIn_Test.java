import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn_Test {
    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager
       // WebDriver.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open the web application
            driver.get("https://practicetestautomation.com/practice-test-login");

            // Enter valid credentials
            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));

            username.sendKeys("student");
            password.sendKeys("Password123");

            // Submit the login form
            WebElement loginButton = driver.findElement(By.id("submit"));
            loginButton.click();

            // Wait for the page to load
            Thread.sleep(3000);

            // Verify that the user is successfully logged in by checking for a specific element or page title
            WebElement successMessage = driver.findElement(By.xpath("//h1[text()='Logged In Successfully']"));
            if (successMessage.isDisplayed()) {
                System.out.println("Login test passed.");
            } else {
                System.out.println("Login test failed.");
            }
        } catch (Exception e) {
            System.out.println("Login test failed. " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}