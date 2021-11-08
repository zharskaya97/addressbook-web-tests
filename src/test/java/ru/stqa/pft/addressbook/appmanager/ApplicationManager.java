package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ApplicationManager {

    private final Properties properties;
    WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    JavascriptExecutor js;
    private GroupHelper GroupHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        System.setProperty("webdriver.chrome.driver", "D:\\Autotests\\chromedriver_win32_93\\chromedriver.exe");
        System.setProperty("webdriver.firefox.marionette", "D:\\Autotests\\geckodriver-v0.29.1-win32\\geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "D:\\Autotests\\IEDriverServer_Win32_3.150.2\\IEDriverServer.exe");
        if (Objects.equals(browser, BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (Objects.equals(browser, BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (Objects.equals(browser, BrowserType.IE)) {
            driver = new InternetExplorerDriver();
        }
        js = (JavascriptExecutor) driver;
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1200, 1500));
        driver.get(properties.getProperty("web.baseUrl"));
        GroupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper group() {
        return GroupHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
}
