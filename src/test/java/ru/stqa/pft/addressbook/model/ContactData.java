package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private String group;

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(middlename, that.middlename) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, middlename, lastname);
    }
    /* private final String nickname;
    private final String address;
    private final String mobile;
    private final String email;
    private final String byear;
    private final String bday;
    private final String bmonth;*/

    public ContactData(String firstname, String middlename, String lastname, String group
                       //String nickname, String address, String mobile, String email,
                       //String byear, String bday, String bmonth
    ) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        /*this.nickname = nickname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.byear = byear;
        this.bday = bday;
        this.bmonth = bmonth;*/
        this.group = group;
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

    /*public String getNickname() {
        return nickname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getByear() {
        return byear;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }*/
}
