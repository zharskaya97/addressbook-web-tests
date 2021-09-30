package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().contactList().size() == 0) { //наличие контакта
            app.contact().create(new ContactData().withLastname("test11").withFirstname("test22").withGroup("group1"));
        }
    }

    @Test //(enabled = false)
    public void testContactDeletion() {
        //int before = app.getContactHelper().getContactCount();
        List<ContactData> before = app.contact().contactList();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);//лишний элемент удаляем из списка before
        Assert.assertEquals(before, after);
    }
}
