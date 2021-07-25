package ru.stqa.pft.addressbook.tests;// Generated by Selenium IDE

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class CreateContactTest extends TestBase {

  @Test
  public void testCreateContact() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Test", "Test", "Test", "Testing", "Samara", "88005553535", "marino4ka163@mail.ru", "1997", "//option[. = '28']", "//option[. = 'January']"));
    app.getContactHelper().submitContactCreation();
  }

}
