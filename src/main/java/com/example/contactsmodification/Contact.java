package com.example.contactsmodification;

public class Contact {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String image;


    public Contact(String name, String lastName, String email, String phone, String image) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return getLastName();
    }
}
