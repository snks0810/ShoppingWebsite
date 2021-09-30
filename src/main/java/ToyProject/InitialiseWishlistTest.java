package ToyProject;
// Generated by Selenium IDE
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
import java.util.*;
//import java.net.MalformedURLException;
//import java.net.URL;
public class InitialiseWishlistTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  public void tearDown() {
    driver.quit();
  }

  public void initialiseWishlist() {
    driver.get("https://testscriptdemo.com/?post_type=product");
    driver.manage().window().setSize(new Dimension(1050, 680));
    driver.findElement(By.xpath("//div[@id='site-content']/div/div/article/ul/li/div/div[2]/div/div/a/i")).click();
    driver.findElement(By.xpath("//div[@id='site-content']/div/div/article/ul/li[3]/div/div[2]/div/div/a/i")).click();
    driver.findElement(By.xpath("//div[@id='site-content']/div/div/article/ul/li[4]/div/div[2]/div/div/a")).click();
    driver.findElement(By.xpath("//div[@id='site-content']/div/div/article/ul/li[6]/div/div[2]/div/div/a/i")).click();
  }

  public ArrayList<String> scrapePrice(){
    driver.get("https://testscriptdemo.com/?page_id=233&wishlist-action");
    ArrayList<String> prices = new ArrayList<>();
    ArrayList<String> xPaths = new ArrayList<>();
    xPaths.add("//tr[@id='yith-wcwl-row-18']/td[4]"); xPaths.add("//tr[@id='yith-wcwl-row-16']/td[4]");
    xPaths.add("//tr[@id='yith-wcwl-row-15']/td[4]"); xPaths.add("//tr[@id='yith-wcwl-row-22']/td[4]");
    for(String s: xPaths){
    prices.add(driver.findElement(By.xpath(s)).getText());}
    //System.out.println(driver.findElement(By.xpath(s)).getText());}
    return prices;
    }

    public ArrayList<String> returnXpath(){
      ArrayList<String> xPaths = new ArrayList<>();
      xPaths.add("//tr[@id='yith-wcwl-row-18']/td[4]"); xPaths.add("//tr[@id='yith-wcwl-row-16']/td[4]");
      xPaths.add("//tr[@id='yith-wcwl-row-15']/td[4]"); xPaths.add("//tr[@id='yith-wcwl-row-22']/td[4]");
      return xPaths;
    }

    public void addToCart() throws InterruptedException {
      driver.findElement(By.xpath("//tr[@id='yith-wcwl-row-22']/td[6]/a")).click();
      js.executeScript("window.scrollTo(0,0)");
      Thread.sleep(3000);
    }

    public boolean verifyCheapest(double cheapestPrice){
      boolean success;
      ArrayList<String> actualPrices = new ArrayList<>();
      ArrayList<Double> actualDoubles;
      driver.findElement(By.xpath("//body[@id='blog']/div[2]/div/div/div/div[3]/div/div/div/a/i")).click();
      String actualPrice = driver.findElement(By.xpath("//bdi")).getText();
      actualPrices.add(actualPrice);
      actualDoubles = StringProcessor.poundRemoval(actualPrices);
      double actualDouble = actualDoubles.get(0);
      if(actualDouble == cheapestPrice) {
        System.out.println("true");
        return true;
      }
      else{ System.out.println("false"); return false;}
    }
  }