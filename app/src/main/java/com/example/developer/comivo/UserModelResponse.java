package com.example.developer.comivo;


public class UserModelResponse {

    private String FirstName;
    private String LastName;
    private String ProfileImage;
    private String ProfileCoverImage;
    private int AccountType;
    private boolean NewUser;
    private String CompanyName;
    private int TokenId;
    private String Token;
    private String Email;

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

    public int getAccountType() {
        return AccountType;
    }

    public void setAccountType(int accountType) {
        AccountType = accountType;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
