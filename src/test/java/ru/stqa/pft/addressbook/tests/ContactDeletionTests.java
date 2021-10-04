package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().allContact().size() == 0) { //наличие контакта
            app.contact().create(new ContactData().withLastname("test11").withFirstname("test22").withGroup("group1"));
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().allContact();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().countC(), equalTo(before.size() - 1));
        Contacts after = app.contact().allContact();
        assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));

    }
}
