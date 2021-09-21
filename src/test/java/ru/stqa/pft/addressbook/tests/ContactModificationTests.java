package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
       if (! app.getContactHelper().isThereAContact()) { //наличие контакта
            app.getContactHelper().createContact(new ContactData("Test", "Test","Test", "group1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Test1", "Test1", "Test1", null
                /*"testing1", "Moscow", "111111","test@test.ru", "1991", "//option[. = '28']","//option[. = 'January']"*/
        ), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
