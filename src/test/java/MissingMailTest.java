import org.openqa.selenium.By;
import org.testng.Assert;

public class MissingMailTest extends AbstractFormTest {

    @Override
    protected void fillForm() {
        driver.findElement(By.id("ff_3_names_first_name_")).sendKeys("Toto");
        driver.findElement(By.id("ff_3_names_last_name_")).sendKeys("Tutu");
        // Commented out to simulate missing mail
        // driver.findElement(By.id("ff_3_email")).sendKeys("toto@tutu.com");
        driver.findElement(By.id("ff_3_subject")).sendKeys("Test");
        driver.findElement(By.id("ff_3_message")).sendKeys("Ceci est un test");
    }

    @Override
    protected void submit() {
        driver.findElement(By.xpath("//*[text()='Send Message']")).click();
    }

    @Override
    protected void assertErrorMessage() {
        String mailMissingMessage = driver.findElement(By.xpath("//*[@id='ff_3_email']/../div[@role='alert']"))
                .getText();
        Assert.assertEquals(mailMissingMessage, "This field is required");
    }

}
