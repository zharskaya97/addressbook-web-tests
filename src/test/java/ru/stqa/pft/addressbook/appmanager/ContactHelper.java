package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends GroupHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContactCreation() {
        click(By.linkText("home"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("address"), contactData.getAddress());
        click(By.name("theform"));
        click(By.name("theform"));
        click(By.cssSelector("label:nth-child(30)"));
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        click(By.name("theform"));
        changeBday(contactData.getByear(), contactData.getBday(), contactData.getBmonth());
        click(By.name("theform"));
        changeGroup();
        click(By.name("new_group"));
        click(By.name("theform"));
        click(By.cssSelector("input:nth-child(87)"));
    }

    private void changeGroup() {
        click(By.name("new_group"));
        {
            WebElement dropdown = driver.findElement(By.name("new_group"));
            dropdown.findElement(By.xpath("//option[. = 'group1']")).click();
        }
    }

    private void changeBday(String byear, String bday, String bmonth) {
        click(By.name("bday"));
        {
            WebElement dropdown = driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath(bday)).click();
        }
        click(By.name("bday"));
        click(By.name("bmonth"));
        {
            WebElement dropdown = driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath(bmonth)).click();
        }
        click(By.name("bmonth"));
        click(By.name("byear"));
        driver.findElement(By.name("byear")).sendKeys(byear);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }
}
