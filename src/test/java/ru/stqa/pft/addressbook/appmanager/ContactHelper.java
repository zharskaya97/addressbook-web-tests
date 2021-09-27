package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends GroupHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContactCreation() {
        click(By.cssSelector("input:nth-child(87)"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.cssSelector(".left:nth-child(8)"));
        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
    }

    public void initContactModification(int index) {
        driver.findElements(By.cssSelector("tr[name=entry]")).get(8).findElement(By.cssSelector("td.center:nth-child(8) img")).click();
        // > td.center:nth-child(8) img
        //click(By.cssSelector("tr:nth-child(2) > .center:nth-child(8) img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        returnToHomePage();
    }

    /*public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }*/

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> trs = driver.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement tr : trs){
            List<WebElement> tds = tr.findElements(By.cssSelector("td"));
            String lastname = tds.get(1).getText();
            String name = tds.get(2).getText();
            int id = Integer.parseInt(tr.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, name, lastname,null);
            contacts.add(contact);
        }
        return contacts;
    }
}
