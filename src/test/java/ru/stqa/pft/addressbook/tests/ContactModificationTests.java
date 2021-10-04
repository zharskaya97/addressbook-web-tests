package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().allContact().size() == 0) { //наличие контакта
            app.contact().create(new ContactData().withFirstname("test01").withLastname("test02"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().allContact();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("Testq1").withLastname("Testq1");
        app.contact().modify(contact);
        assertThat(app.contact().countC(), equalTo(before.size()));
        Contacts after = app.contact().allContact();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
