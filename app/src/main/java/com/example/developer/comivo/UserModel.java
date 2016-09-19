package com.example.developer.comivo;


public class UserModel {

    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String Company;
    private int AccountType;
    private int BusinessType;

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getCompany() {
        return this.Company;
    }

    public void setCompany(String company) {
        this.Company = company;
    }

    public int getAccountType() {
        return this.AccountType;
    }

    public void setAccountType(int accountType) {
        this.AccountType = accountType;
    }

    public int getBusinessType() {
        return this.BusinessType;
    }

    public void setBusinessType(int businessType) {
        this.BusinessType = businessType;
    }
}
