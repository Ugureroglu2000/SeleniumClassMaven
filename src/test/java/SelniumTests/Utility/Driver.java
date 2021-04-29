package SelniumTests.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private Driver(){}

    private static InheritableThreadLocal<WebDriver> driver=new InheritableThreadLocal<WebDriver>();

    public static WebDriver get(){
        if (driver.get() == null) {
            String browser=ConfigurationReader.get("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case"edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
            } }
        return driver.get();
    }
    public  static  void closeDriver()  {
//        Thread.sleep(3000);
//        if(driver!=null){driver.get().quit(); driver=null;}   //single
        driver.get().quit();        driver.remove();        //parallel
    }



}
