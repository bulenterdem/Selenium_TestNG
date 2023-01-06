package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
            Driver class'indan driveri getDriver() ile kullaniriz
            sonradan projeye katilan insamlarin Driver class'indan obje olusturarak driver kullanmaya
            calismalrini engellemek icin

            Driver class'ini SINGLETON PATERN ile duzenleyebiliriz

            Bunun icin Driver class'inin parametresiz constructor'ini olusturup
            access modifier'ini PRIVATE yapmamiz yeterlidir
     */

    private Driver(){


    }

   static WebDriver driver;

    public static WebDriver getDriver(){


        String browser=ConfigReader.getProperty("browser");

        if (driver==null) {

            switch (browser) {

                case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;


                case  "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;

                case  "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;


                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }

        return driver;

    }

    public static void closeDriver(){

        if (driver != null){

            driver.close();
            driver=null;
        }
    }
}
