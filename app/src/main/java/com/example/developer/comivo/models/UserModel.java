package com.example.developer.comivo.models;


public class UserModel {

    private static UserModel mInstance;
    private String FirstName;
    private String LastName;
    private String ProfileImage;
    private String ProfileCoverImage;
    private boolean NewUser;
    private String CompanyName;
    private int TokenId;
    private String Token;
    private int AccountType;
    private String Email;
    private String deviceId;
    private String Password;
    private int UserId;


    private UserModel() {

    }

    public static UserModel getInstance() {
        if (mInstance == null) {
            mInstance = new UserModel();
        }
        return mInstance;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(String profileImage) {
        ProfileImage = profileImage;
    }

    public String getProfileCoverImage() {
        return ProfileCoverImage;
    }

    public void setProfileCoverImage(String profileCoverImage) {
        ProfileCoverImage = profileCoverImage;
    }

    public boolean isNewUser() {
        return NewUser;
    }

    public void setNewUser(boolean newUser) {
        NewUser = newUser;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getTokenId() {
        return TokenId;
    }

    public void setTokenId(int tokenId) {
        TokenId = tokenId;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public int getAccountType() {
        return AccountType;
    }

    public void setAccountType(int accountType) {
        AccountType = accountType;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
