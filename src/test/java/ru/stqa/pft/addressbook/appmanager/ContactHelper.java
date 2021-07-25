package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper {
    private WebDriver driver;

    public ContactHelper(WebDriver driver) {
        this.driver=driver;
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
