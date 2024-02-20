import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormNonPassantTest {

    @Test
    public void missingMailTest(){

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://fluentforms.com/forms/contact-form-demo/");

        driver.findElement(By.id("ff_3_names_first_name_")).sendKeys("Toto");
        driver.findElement(By.id("ff_3_names_last_name_")).sendKeys("Tutu");
        //driver.findElement(By.id("ff_3_email")).sendKeys("toto@tutu.com");
        driver.findElement(By.id("ff_3_subject")).sendKeys("Test");
        driver.findElement(By.id("ff_3_message")).sendKeys("Ceci est un test");

        driver.findElement(By.xpath("//*[text()='Send Message']")).click();

        String mailMissingMessage = driver.findElement(By.xpath("//*[@id='ff_3_email']/../div[@role='alert']")).getText();
        Assert.assertEquals(mailMissingMessage, "This field is required");

        driver.quit();
    }

    @Test
    public void missingLastnameTest(){
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://fluentforms.com/forms/contact-form-demo/");

        driver.findElement(By.id("ff_3_names_first_name_")).sendKeys("Toto");
        //driver.findElement(By.id("ff_3_names_last_name_")).sendKeys("Tutu");
        driver.findElement(By.id("ff_3_email")).sendKeys("toto@tutu.com");
        driver.findElement(By.id("ff_3_subject")).sendKeys("Test");
        driver.findElement(By.id("ff_3_message")).sendKeys("Ceci est un test");

        driver.findElement(By.xpath("//*[text()='Send Message']")).click();

        String mailMissingMessage = driver.findElement(By.xpath("//*[@id='ff_3_names_last_name_']/../div[@role='alert']")).getText();
        Assert.assertEquals(mailMissingMessage, "This field is required");

        driver.quit();
    }

    @Test
    public void missingMessageTest(){
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://fluentforms.com/forms/contact-form-demo/");

        driver.findElement(By.id("ff_3_names_first_name_")).sendKeys("Toto");
        driver.findElement(By.id("ff_3_names_last_name_")).sendKeys("Tutu");
        driver.findElement(By.id("ff_3_email")).sendKeys("toto@tutu.com");
        driver.findElement(By.id("ff_3_subject")).sendKeys("Test");
        //driver.findElement(By.id("ff_3_message")).sendKeys("Ceci est un test");

        driver.findElement(By.xpath("//*[text()='Send Message']")).click();

        String mailMissingMessage = driver.findElement(By.xpath("//*[@id='ff_3_message']/../div[@role='alert']")).getText();
        Assert.assertEquals(mailMissingMessage, "This field is required");

        driver.quit();
    }
}
