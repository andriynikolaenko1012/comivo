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
    private int BusinessType;
    private String Email;
    private String deviceId;
    private String Password;
    private int UserId;

    private String device_model;
    private String platform;
    private String version;
    private String manufacturer;
    private String app_version;

    /*my contact*/
    private String alternativeEmail;

    /*address*/
    private String address;
    private String state;
    private String city;
    private int zipCode;
    private int countryId;
    private String countryName;

    /*tell */
    private int telephoneId;
    private int countryCode;
    private int areaCode;
    private int number;
    private int extension;

    /*cell*/
    private int cellTelephoneId;
    private int cellCountryCode;
    private int cellAreaCode;
    private int cellNumber;
    private int cellExtension;

    /*languages*/
    private int languageId;
    private int levelId;

    /*company*/
    private String CompanyId;
    private String Website;
    private String Description;
    private String ImageUrl;

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

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getTelephoneId() {
        return telephoneId;
    }

    public void setTelephoneId(int telephoneId) {
        this.telephoneId = telephoneId;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public int getCellTelephoneId() {
        return cellTelephoneId;
    }

    public void setCellTelephoneId(int cellTelephoneId) {
        this.cellTelephoneId = cellTelephoneId;
    }

    public int getCellCountryCode() {
        return cellCountryCode;
    }

    public void setCellCountryCode(int cellCountryCode) {
        this.cellCountryCode = cellCountryCode;
    }

    public int getCellAreaCode() {
        return cellAreaCode;
    }

    public void setCellAreaCode(int cellAreaCode) {
        this.cellAreaCode = cellAreaCode;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public int getCellExtension() {
        return cellExtension;
    }

    public void setCellExtension(int cellExtension) {
        this.cellExtension = cellExtension;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getBusinessType() {
        return BusinessType;
    }

    public void setBusinessType(int businessType) {
        BusinessType = businessType;
    }

    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
