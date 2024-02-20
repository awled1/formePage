import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormPassantTest {

    @Test
    public void allFieldTest(){

        WebDriver driver = new ChromeDriver();

        //Implicite wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Explicte wait
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Fluent wait
//        FluentWait<WebDriver> wait = new FluentWait<>(driver);
//        wait.withTimeout(Duration.ofSeconds(15));
//        wait.pollingEvery(Duration.ofSeconds(1));
//        wait.ignoring(Exception.class);

        driver.get("https://fluentforms.com/forms/contact-form-demo/");

        driver.findElement(By.id("ff_3_names_first_name_")).sendKeys("Toto");
        driver.findElement(By.id("ff_3_names_last_name_")).sendKeys("Tutu");
        driver.findElement(By.id("ff_3_email")).sendKeys("toto@tutu.com");
        driver.findElement(By.id("ff_3_subject")).sendKeys("Test");
        driver.findElement(By.id("ff_3_message")).sendKeys("Ceci est un test");

        driver.findElement(By.xpath("//*[text()='Send Message']")).click();

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fluentform_3_success")));

        String successMessage = driver.findElement(By.id("fluentform_3_success")).getText();
        Assert.assertEquals(successMessage, "Thank you for your message. We will get in touch with you shortly");

        driver.quit();
    }

    @Test
    public void missingFirstnameTest(){
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://fluentforms.com/forms/contact-form-demo/");

        //driver.findElement(By.id("ff_3_names_first_name_")).sendKeys("Toto");
        driver.findElement(By.id("ff_3_names_last_name_")).sendKeys("Tutu");
        driver.findElement(By.id("ff_3_email")).sendKeys("toto@tutu.com");
        driver.findElement(By.id("ff_3_subject")).sendKeys("Test");
        driver.findElement(By.id("ff_3_message")).sendKeys("Ceci est un test");

        driver.findElement(By.xpath("//*[text()='Send Message']")).click();

        String successMessage = driver.findElement(By.id("fluentform_3_success")).getText();
        Assert.assertEquals(successMessage, "Thank you for your message. We will get in touch with you shortly");

        driver.quit();
    }

    @Test
    public void missingSubjectTest(){
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://fluentforms.com/forms/contact-form-demo/");

        driver.findElement(By.id("ff_3_names_first_name_")).sendKeys("Toto");
        driver.findElement(By.id("ff_3_names_last_name_")).sendKeys("Tutu");
        driver.findElement(By.id("ff_3_email")).sendKeys("toto@tutu.com");
        //driver.findElement(By.id("ff_3_subject")).sendKeys("Test");
        driver.findElement(By.id("ff_3_message")).sendKeys("Ceci est un test");

        driver.findElement(By.xpath("//*[text()='Send Message']")).click();

        String successMessage = driver.findElement(By.id("fluentform_3_success")).getText();
        Assert.assertEquals(successMessage, "Thank you for your message. We will get in touch with you shortly");

        driver.quit();
    }
}
