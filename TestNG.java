package Pages;
2
import static org.testng.Assert.assertEquals;
3
import java.util.concurrent.TimeUnit;
4
import org.openqa.selenium.By;
5
import org.openqa.selenium.WebDriver;
6
import org.openqa.selenium.chrome.ChromeDriver;
7
import org.testng.annotations.AfterTest;
8
import org.testng.annotations.BeforeTest;
9
import org.testng.annotations.Test;
10
public class LoginPage {
11
    
12
    WebDriver driver;
13
    
14
    @BeforeTest
15
    public void setUp() {
16
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shalini\\Downloads\\chrom86_driver\\chromedriver.exe");
17
        driver = new ChromeDriver();
18
    }
19
    
20
    public void login() {
21
        String login_url = "https://opensource-demo.orangehrmlive.com/";
22
        driver.get(login_url);
23
        
24
        driver.manage().window().maximize();
25
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
26
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
27
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
28
        System.out.println(driver.getTitle());
29
    }
30
    
31
    @Test
32
    public void dashboard() {
33
        
34
        driver.findElement(By.id("menu_dashboard_index")).click();
35
        String textPresent = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
36
        
37
        String textToBePresent = "DashBoard";
38
        assertEquals(textPresent, textToBePresent);
39
    }
40
    
41
    
42
    @AfterTest
43
    public void tearDown() {
44
            driver.quit();
45
    }
46
47
}
