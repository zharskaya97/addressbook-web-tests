package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

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

    public void selectContactById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelectedContacts() {
        click(By.cssSelector(".left:nth-child(8)"));
        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
    }

    public void initContactModification(int id) {
//        click(By.cssSelector("td.center:nth-child(8) img"));
        click(By.xpath(String.format(".//tr[.//input[@value='%s']]//td[8]/a", id)));
    }

/*    public void initContactModification(int index) {
        driver.findElements(By.cssSelector("tr[name=entry]"))
                .get(index)
                .findElement(By.cssSelector("td.center:nth-child(8) img")).click();
        returnToHomePage();
    }*/

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }


    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }
   /* public void modify(int selIndex, ContactData contact) {
        selectContact(selIndex);
        initContactModification(selIndex);
        fillContactForm(contact, false);
            returnToHomePage();
        }*/

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        contactCache = null;
        returnToHomePage();
    }

    public int countC() {
        return driver.findElements(By.name("selected[]")).size();
    }
    /* public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }*/

/*    public List<ContactData> contactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> trs = driver.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement tr : trs) {
            List<WebElement> tds = tr.findElements(By.cssSelector("td"));
            String lastname = tds.get(1).getText();
            String name = tds.get(2).getText();
            int id = Integer.parseInt(tr.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(name).withLastname(lastname));
        }
        return contacts;
    }*/

    private Contacts contactCache = null;

    public Contacts allContact() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> trs = driver.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement tr : trs) {
            List<WebElement> tds = tr.findElements(By.cssSelector("td"));
            String lastname = tds.get(1).getText();
            String name = tds.get(2).getText();
            int id = Integer.parseInt(tr.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withFirstname(name).withLastname(lastname));
        }
        return new Contacts(contactCache);
    }
}
