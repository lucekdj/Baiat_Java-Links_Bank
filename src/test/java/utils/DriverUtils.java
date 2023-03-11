package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverUtils {
    static WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(DriverUtils.class);
    public static String link = "http://18.118.14.155:8080/bank/login";

    public static void createDriver(){
        LOGGER.info("Driver setup started");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Driver connecting to: " + link);
        driver.get(link);

        if (driver == null) {
            LOGGER.warn("Driver instance was not created");
        }
        LOGGER.info("Driver setup and start is successful!");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
