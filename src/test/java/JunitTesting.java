import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class JunitTesting {

WebDriver driver;


    @BeforeAll
    public  void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @DisplayName("Visit Website For Title")
    @Test
    public void getTitle(){
        driver.get("https://demoqa.com/");
        String actual_result = driver.getTitle();
        String expected_result = "DEMOQA";
        Assertions.assertTrue(actual_result.contains(expected_result));
    }
    @DisplayName("Check Banner Image Exists")
    @Test
    public void checkImage(){
        driver.get("https://demoqa.com/");
        boolean isExist = driver.findElement(By.cssSelector("[class='banner-image']")).isDisplayed();
        Assertions.assertTrue(isExist);
    }

    @DisplayName("Checking Form ")
    @Test
    public void submitForm(){
        driver.get("https://demoqa.com/text-box");
        List<WebElement> textBoxElement = driver.findElements(By.className("form-control"));
        textBoxElement.get(0).sendKeys("Risul Islam Tushar");
        textBoxElement.get(1).sendKeys("tushar@gmail.com");
        textBoxElement.get(2).sendKeys("Dhaka");
        textBoxElement.get(3).sendKeys("Tongi");
        driver.findElement(By.id("submit")).click();


    }


    @AfterAll
    public void closeDriver(){

        driver.quit();
    }


}
