import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class05Test {
  static WebDriver driver;

  @BeforeAll
  static void setUp() {
    System.setProperty("webdriver.chrome.driver", "D:\\Work Space\\IdeaProjects\\SoftTest\\Class_05\\src\\main\\resources\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();

  }
  @AfterAll
  static void tearDown() {
    driver.quit();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/cases.csv")
  public void class05(int locks, int stocks,int barrels, String expected) {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("commission")).click();
    driver.findElement(By.id("a")).sendKeys(locks+"");
    driver.findElement(By.id("b")).sendKeys(stocks+"");
    driver.findElement(By.id("c")).sendKeys(barrels+"");
    driver.findElement(By.id("action")).click();
    String result = driver.findElement(By.id("result")).getAttribute("value");

    Assertions.assertEquals(expected, result);
  }
}
