package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;

public class ApplicationManager {

    WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    JavascriptExecutor js;
    private GroupHelper GroupHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\Autotests\\chromedriver_win32_93\\chromedriver.exe");
        System.setProperty("webdriver.firefox.marionette", "D:\\Autotests\\geckodriver-v0.29.1-win32\\geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "D:\\Autotests\\IEDriverServer_Win32_3.150.2\\IEDriverServer.exe");
        if (Objects.equals(browser, BrowserType.CHROME)){
            driver = new ChromeDriver();
        } else if (Objects.equals(browser, BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (Objects.equals(browser, BrowserType.IE)){
            driver = new InternetExplorerDriver();
        }
        js = (JavascriptExecutor) driver;
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1200, 1500));
        GroupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return GroupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
