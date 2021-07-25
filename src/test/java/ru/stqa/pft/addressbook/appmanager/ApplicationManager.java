package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    JavascriptExecutor js;
    private WebDriver driver;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\Autotests\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        Map<String, Object> vars = new HashMap<String, Object>();
        login("admin", "secret");
    }

    private void login(String username, String password) {
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1200, 1500));
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.name("pass")).sendKeys(Keys.ENTER);
    }

    public void stop() {
        driver.quit();
    }

    public void returnToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void deleteSelectedGroups() {
      driver.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
      driver.findElement(By.name("selected[]")).click();
    }

    public void submitContactCreation() {
      driver.findElement(By.linkText("home")).click();
    }

    public void fillContactForm(ContactData contactData) {
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
      driver.findElement(By.name("middlename")).click();
      driver.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
      driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
      driver.findElement(By.name("nickname")).click();
      driver.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
      driver.findElement(By.name("address")).click();
      driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.cssSelector("label:nth-child(30)")).click();
      driver.findElement(By.name("mobile")).click();
      driver.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
      driver.findElement(By.name("theform")).click();
      changeBday(contactData.getByear(), contactData.getBday(), contactData.getBmonth());
      driver.findElement(By.name("theform")).click();
      changeGroup();
      driver.findElement(By.name("new_group")).click();
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.cssSelector("input:nth-child(87)")).click();
    }

    private void changeGroup() {
      driver.findElement(By.name("new_group")).click();
      {
        WebElement dropdown = driver.findElement(By.name("new_group"));
        dropdown.findElement(By.xpath("//option[. = 'group1']")).click();
      }
    }

    private void changeBday(String byear, String bday, String bmonth) {
      driver.findElement(By.name("bday")).click();
      {
        WebElement dropdown = driver.findElement(By.name("bday"));
        dropdown.findElement(By.xpath(bday)).click();
      }
      driver.findElement(By.name("bday")).click();
      driver.findElement(By.name("bmonth")).click();
      {
        WebElement dropdown = driver.findElement(By.name("bmonth"));
        dropdown.findElement(By.xpath(bmonth)).click();
      }
      driver.findElement(By.name("bmonth")).click();
      driver.findElement(By.name("byear")).click();
      driver.findElement(By.name("byear")).sendKeys(byear);
    }

    public void initContactCreation() {
      driver.findElement(By.linkText("add new")).click();
    }
}
