import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public abstract class AbstractFormTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://fluentforms.com/forms/contact-form-demo/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void submitForm() {
        fillForm();
        submit();
        assertErrorMessage();
    }

    protected abstract void fillForm();

    protected abstract void submit();

    protected abstract void assertErrorMessage();
}

// Create similar classes for other test cases, e.g., MissingLastnameTest, MissingMessageTest
