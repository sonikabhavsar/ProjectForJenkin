package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager extends Utils {
    LoadProp loadProp = new LoadProp();
    MutableCapabilities sauceOptions = new MutableCapabilities();
    public String USERNAME = loadProp.getProperty("SAUCE_USERNAME");
    public String ACCESS_KEY = loadProp.getProperty("SAUCE_ACCESS_KEY");
    public String URL = "https://"+ USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";
    public boolean SAUCE_LAB =true;
    //  String browserName = System.getProperty("browser");
    String browserName = loadProp.getProperty("browser");
    @BeforeMethod
    public void openBrowser() {
        if (SAUCE_LAB) {
            //it will run in sauce lab
            System.out.println("Running is sauceLab......" + browserName);

            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browserName.equalsIgnoreCase("FireFox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "113");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browserName.equalsIgnoreCase("edge")) {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "113");

                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        } else { //running locally browser
            System.out.println("Running local machine with browser name..." + browserName);

            if (browserName.equalsIgnoreCase("Chrome")) {
                //Open Chrome browser
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                //Open Firefox browser
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                //Open Edge browser
               // driver = new EdgeDriver();
                driver=new EdgeDriver();
            } else {
                System.out.println("Browser name is wrong or not implemented :" + browserName);
            }
        }


        //type the url
        driver.get(loadProp.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod

    public void closeBrowser () {
        driver.close();
    }
}
