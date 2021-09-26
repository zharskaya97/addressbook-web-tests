package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String id;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private String group;

     public ContactData(String firstname, String middlename, String lastname, String group) {
        this.id = null;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.group = group;
    }

    public ContactData(String id, String firstname, String middlename, String lastname, String group) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.group = group;
    }

    public String getId() {
        return id;
    }
    public String getFirstname() {return firstname;}

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData contactData = (ContactData) o;
        return Objects.equals(id, contactData.id) && Objects.equals(firstname, contactData.firstname) && Objects.equals(middlename, contactData.middlename) && Objects.equals(lastname, contactData.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, middlename, lastname);
    }
}
