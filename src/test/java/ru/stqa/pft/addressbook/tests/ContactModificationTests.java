package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
       if (! app.getContactHelper().isThereAContact()) { //наличие контакта
            app.getContactHelper().createContact(new ContactData("Test", "Test","Test", "group1"));
        }
        //int before = app.getContactHelper().getContactCount();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Test1", "Test1", "Test1", null
                /*"testing1", "Moscow", "111111","test@test.ru", "1991", "//option[. = '28']","//option[. = 'January']"*/
        ), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        //int after = app.getContactHelper().getContactCount();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }
}
