package ru.stqa.pft.addressbook.tests;// Generated by Selenium IDE

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreateTest extends TestBase {

  @Test
  public void testCreateContact() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("test1","test2","test3","group1"));
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before +1);
  }

}
