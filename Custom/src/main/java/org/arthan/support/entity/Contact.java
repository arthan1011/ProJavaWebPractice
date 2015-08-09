package org.arthan.support.entity;

import java.time.Instant;
import java.time.MonthDay;

/**
 * Created by Артур on 09.08.2015.
 * Next to Ufa.
 */
public class Contact implements Comparable<Contact> {

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private MonthDay birthDay;
    private Instant dateCreated;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String address, String phoneNumber, MonthDay birthDay, Instant dateCreated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.dateCreated = dateCreated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public MonthDay getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(MonthDay birthDay) {
        this.birthDay = birthDay;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public int compareTo(Contact o) {
        int last = lastName.compareTo(o.lastName);
        if (last == 0) {
            return firstName.compareTo(o.firstName);
        } else {
            return last;
        }
    }
}
