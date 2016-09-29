package com.example.developer.comivo.network.settingsParsing;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Kevin Khanda on 28.09.2016.
 * This is a class to parse Settings
 */
public class SettingsResponseParsing {

    private SettingsResponseParsing() { }
    private static SettingsResponseParsing settingsResponseParsingInstance;

    public static SettingsResponseParsing getInstance() {
        if (settingsResponseParsingInstance == null) {
            settingsResponseParsingInstance = new SettingsResponseParsing();
        }
        return settingsResponseParsingInstance;
    }


    // Parsing "settings API"
    private static final String STATUS = "Status";
    private static final String DATA = "Data";
    private static final String MESSAGE = "Message";

    private String status;
    private String message;
    private String data;
    private String companyId;
    private String companyName;
    private String website;
    private String description;
    private String imageURL;
    private String photos1;
    private String photos2;
    private String FAQSectionId;
    private String FAQSectionTitle;
    private String FAQBoxId;
    private String FAQBoxTitle;
    private ArrayList<String> FAQJsonArray;
    private String notificationSettingsId;
    private String title;
    private String isEnabled;
    private String CMSPageTypeId;
    private String content;
    private String isActive;
    private String type;
    private String socialMediaId;
    private String name;
    private String clientId;
    private String clientSecret;
    private String userSocialAccountId;
    private String socialUserId;
    private String accessToken;
    private String userId;
    private String userContactId;
    private String firstName;
    private String lastName;
    private String profileImage;
    private String country;
    private String email;
    private String alternativeEmail;
    private String addressId;
    private String address;
    private String state;
    private String city;
    private String zipCode;
    private String countryId;
    private String countryName;
    private String isRequired;
    private String telephoneId;
    private String countryCode;
    private String areaCode;
    private String number;
    private String extension;
    private String mobileTelephoneId;
    private String mobileCountryCode;
    private String mobileAreaCode;
    private String mobileNumber;
    private String mobileExtension;
    private String userExperienceId;
    private String company;
    private String position;
    private String fromMonth;
    private String fromYear;
    private String toMonth;
    private String toYear;
    private String created;
    private String updated;
    private String isPresent;
    private String userEducationId;
    private String school;
    private String degree;
    private String fieldOfStudy;
    private String userLanguageId;
    private String languageId;
    private String languageValue;
    private String languageLevelId;
    private String languageLevelValue;
    private String englishId;
    private String englishValue;
    private String chineseId;
    private String chineseValue;
    private String spanishId;
    private String spanishValue;
    private String englishLevelId;
    private String englishLevelValue;
    private String chineseLevelId;
    private String chineseLevelValue;
    private String spanishLevelId;
    private String spanishLevelValue;

    /**
     * This method is parsing JSON that was received from route "userprofile/company"
     * I do not check the result of "Status"
     * In general, if status == 4, return company model
     * If status == 5, return exception message
     *
     * @param response JSON that is received from a server
     */
    public void parseUserprofileCompany(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONObject jsonData = jsonObject.getJSONObject(DATA);

                // Parsing jsonData
                companyId = jsonData.getString("CompanyId");
                companyName = jsonData.getString("CompanyName");
                website = jsonData.getString("Website");
                description = jsonData.getString("Description");
                imageURL = jsonData.getString("ImageUrl");

                JSONArray photos = jsonData.getJSONArray("Photoes");
                photos1 = photos.getString(0);
                photos2 = photos.getString(1);
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }

            Log.d(this.getClass().getName(), "Status = " + status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing FAQ
     * Please pay attention to this structure, because it is very strange for me also.
     * Some problems may occur with this parser
     *
     * @param response JSON that will be returned by the server for route "faq/list"
     */
    public void parseFAQList(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonDataArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonDataArray.getJSONObject(0);
                // FAQSection
                FAQSectionId = jsonData.getString("FAQSectionId");
                FAQSectionTitle = jsonData.getString("Title");
                // FAQBoxModelList
                JSONArray FAQBoxModelListArray = jsonData.getJSONArray("FAQBoxModelList");
                JSONObject FAQBoxModelList = FAQBoxModelListArray.getJSONObject(0);
                FAQBoxId = FAQBoxModelList.getString("FAQBoxId");
                FAQBoxTitle = FAQBoxModelList.getString("Title");
                FAQJsonArray = new ArrayList<>();
                // FAQModelList
                JSONArray FAQModelList = FAQBoxModelList.getJSONArray("FAQModelList");
                for (int i = 0; i < FAQModelList.length(); i++) {
                    JSONObject jsonFAQ = FAQModelList.getJSONObject(i);
                    // Every three elements from ArrayList == one jsonFAQ object
                    FAQJsonArray.add(jsonFAQ.getString("FAQId"));
                    FAQJsonArray.add(jsonFAQ.getString("Question"));
                    FAQJsonArray.add(jsonFAQ.getString("Answer"));
                }
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing Settings for notifications
     *
     * @param response JSON that will be returned by the server for route "notification/settings"
     */
    public void parseNotificationSettings(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonArray.getJSONObject(0);
                notificationSettingsId = jsonData.getString("NotificationSettingId");
                title = jsonData.getString("Title");
                description = jsonData.getString("Description");
                isEnabled = jsonData.getString("IsEnabled");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing JSON that is received with a parameter Privacy_Policy
     *
     * @param response JSON from route "cms/cmstype?type=Privacy_Policy"
     */
    public void parseCMSType(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONObject jsonData = jsonObject.getJSONObject(DATA);
                CMSPageTypeId = jsonData.getString("CMSPageTypeId");
                title = jsonData.getString("Title");
                content = jsonData.getString("Content");
                isActive = jsonData.getString("IsActive");
                type = jsonData.getString("Type");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing information about social media
     *
     * @param response JSON that is returned from route "account/social"
     */
    public void parseAccountSocial(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonArray.getJSONObject(0);
                socialMediaId = jsonData.getString("SocialMediaId");
                name = jsonData.getString("Name");
                clientId = jsonData.getString("ClientId");
                clientSecret = jsonData.getString("ClientSecret");
                userSocialAccountId = jsonData.getString("UserSocialAccountId");
                socialUserId = jsonData.getString("SocialUserId");
                accessToken = jsonData.getString("AccessToken");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing details in user profile
     *
     * @param response JSON that is returned from route "userprofile/detail"
     */
    public void parseUserprofileDetail(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONObject jsonData = jsonObject.getJSONObject(DATA);
                userId = jsonData.getString("UserId");
                userContactId = jsonData.getString("UserContactId");
                firstName = jsonData.getString("FirstName");
                lastName = jsonData.getString("LastName");
                profileImage = jsonData.getString("ProfileImage");
                companyName = jsonData.getString("CompanyName");
                country = jsonData.getString("Country");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that is parsing JSON that represents "Contact" in userprofile
     *
     * @param response JSON, returned from server on route "userprofile/contact"
     */
    public void parseUserprofileContact(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONObject jsonData = jsonObject.getJSONObject(DATA);
                userId = jsonData.getString("UserId");
                userContactId = jsonData.getString("UserContactId");
                companyName = jsonData.getString("CompanyName");
                email = jsonData.getString("Email");
                alternativeEmail = jsonData.getString("AlternativeEmail");
                // Address fields
                JSONObject jsonAddress = jsonData.getJSONObject("Address");
                address = jsonAddress.getString("Address");
                addressId = jsonAddress.getString("AddressId");
                state = jsonAddress.getString("State");
                city = jsonAddress.getString("City");
                zipCode = jsonAddress.getString("ZipCode");
                countryId = jsonAddress.getString("CountryId");
                countryName = jsonAddress.getString("CountryName");
                isRequired = jsonAddress.getString("IsRequired");
                // Telephone fields
                JSONObject jsonTelephone = jsonData.getJSONObject("Telephone");
                telephoneId = jsonTelephone.getString("TelephoneId");
                countryCode = jsonTelephone.getString("CountryCode");
                areaCode = jsonTelephone.getString("AreaCode");
                number = jsonTelephone.getString("Number");
                extension = jsonTelephone.getString("Extension");
                // Mobile fields
                JSONObject jsonMobile = jsonData.getJSONObject("Mobile");
                mobileTelephoneId = jsonMobile.getString("TelephoneId");
                mobileCountryCode = jsonMobile.getString("CountryCode");
                mobileAreaCode = jsonMobile.getString("AreaCode");
                mobileNumber = jsonMobile.getString("Number");
                mobileExtension = jsonMobile.getString("Extension");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that is parsing JSON that represents "Experience" in userprofile
     *
     * @param response JSON, returned from server on route "userprofile/experience"
     */
    public void parseUserprofileExperience(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonArray.getJSONObject(0);
                userId = jsonData.getString("UserId");
                userExperienceId = jsonData.getString("UserExperienceId");
                company = jsonData.getString("Company");
                position = jsonData.getString("Position");
                fromMonth = jsonData.getString("FromMonth");
                fromYear = jsonData.getString("FromYear");
                toMonth = jsonData.getString("ToMonth");
                toYear = jsonData.getString("ToYear");
                city = jsonData.getString("City");
                state = jsonData.getString("State");
                countryId = jsonData.getString("CountryId");
                countryName = jsonData.getString("CountryName");
                created = jsonData.getString("Created");
                updated = jsonData.getString("Updated");
                isPresent = jsonData.getString("IsPresent");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing JSON received for Education field is User Profile
     *
     * @param response JSON that is returned from server on route "userprofile/education"
     */
    public void parseUserprofileEducation(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonArray.getJSONObject(0);
                userId = jsonData.getString("UserId");
                userEducationId = jsonData.getString("UserEducationId");
                school = jsonData.getString("School");
                degree = jsonData.getString("Degree");
                fieldOfStudy = jsonData.getString("FieldOfStudy");
                fromMonth = jsonData.getString("FromMonth");
                fromYear = jsonData.getString("FromYear");
                toMonth = jsonData.getString("ToMonth");
                toYear = jsonData.getString("ToYear");
                created = jsonData.getString("Created");
                updated = jsonData.getString("Updated");
                isPresent = jsonData.getString("IsPresent");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing JSON from Languages field in User Profile
     *
     * @param response JSON, returned by "userprofile/languages"
     */
    public void parseUserprofileLanguages(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonArray.getJSONObject(0);
                userId = jsonData.getString("UserId");
                userLanguageId = jsonData.getString("UserLanguageId");
                // Language fields
                JSONObject jsonLanguage = jsonData.getJSONObject("Language");
                languageId = jsonLanguage.getString("Id");
                languageValue = jsonLanguage.getString("Value");
                // Language level fields
                JSONObject jsonLanguageLevel = jsonData.getJSONObject("LanguageLevel");
                languageLevelId = jsonLanguageLevel.getString("Id");
                languageLevelValue = jsonLanguageLevel.getString("Value");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing JSON for Languages
     *
     * @param response JSON with data from "languages" route
     */
    public void parseLanguages(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonDataArray = jsonObject.getJSONArray(DATA);
                JSONObject english = jsonDataArray.getJSONObject(0);
                JSONObject chinese = jsonDataArray.getJSONObject(1);
                JSONObject spanish = jsonDataArray.getJSONObject(2);
                englishId = english.getString("Id");
                englishValue = english.getString("Value");
                chineseId = chinese.getString("Id");
                chineseValue = chinese.getString("Value");
                spanishId = spanish.getString("Id");
                spanishValue = spanish.getString("Value");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that will parse JSON for level of languages
     *
     * @param response JSON that returned from "languages/levels"
     */
    public void parseLanguagesLevels(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonDataArray = jsonObject.getJSONArray(DATA);
                JSONObject englishLevel = jsonDataArray.getJSONObject(0);
                JSONObject chineseLevel = jsonDataArray.getJSONObject(1);
                JSONObject spanishLevel = jsonDataArray.getJSONObject(2);
                englishLevelId = englishLevel.getString("Id");
                englishLevelValue = englishLevel.getString("Value");
                chineseLevelId = chineseLevel.getString("Id");
                chineseLevelValue = chineseLevel.getString("Value");
                spanishLevelId = spanishLevel.getString("Id");
                spanishLevelValue = spanishLevel.getString("Value");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getWebsite() {
        return website;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotos1() {
        return photos1;
    }

    public String getPhotos2() {
        return photos2;
    }

    public String getFAQSectionId() {
        return FAQSectionId;
    }

    public String getFAQSectionTitle() {
        return FAQSectionTitle;
    }

    public String getFAQBoxId() {
        return FAQBoxId;
    }

    public String getFAQBoxTitle() {
        return FAQBoxTitle;
    }

    public ArrayList<String> getFAQJsonArray() {
        return FAQJsonArray;
    }

    public String getNotificationSettingsId() {
        return notificationSettingsId;
    }

    public String getTitle() {
        return title;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public String getCMSPageTypeId() {
        return CMSPageTypeId;
    }

    public String getContent() {
        return content;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getType() {
        return type;
    }

    public String getSocialMediaId() {
        return socialMediaId;
    }

    public String getName() {
        return name;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getUserSocialAccountId() {
        return userSocialAccountId;
    }

    public String getSocialUserId() {
        return socialUserId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserContactId() {
        return userContactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getTelephoneId() {
        return telephoneId;
    }

    public String getIsRequired() {
        return isRequired;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNumber() {
        return number;
    }

    public String getExtension() {
        return extension;
    }

    public String getMobileTelephoneId() {
        return mobileTelephoneId;
    }

    public String getMobileCountryCode() {
        return mobileCountryCode;
    }

    public String getMobileAreaCode() {
        return mobileAreaCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getMobileExtension() {
        return mobileExtension;
    }

    public String getUserExperienceId() {
        return userExperienceId;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public String getFromMonth() {
        return fromMonth;
    }

    public String getFromYear() {
        return fromYear;
    }

    public String getToMonth() {
        return toMonth;
    }

    public String getToYear() {
        return toYear;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public String getIsPresent() {
        return isPresent;
    }

    public String getUserEducationId() {
        return userEducationId;
    }

    public String getSchool() {
        return school;
    }

    public String getDegree() {
        return degree;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public String getUserLanguageId() {
        return userLanguageId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public String getLanguageValue() {
        return languageValue;
    }

    public String getLanguageLevelId() {
        return languageLevelId;
    }

    public String getLanguageLevelValue() {
        return languageLevelValue;
    }

    public String getEnglishId() {
        return englishId;
    }

    public String getEnglishValue() {
        return englishValue;
    }

    public String getChineseId() {
        return chineseId;
    }

    public String getChineseValue() {
        return chineseValue;
    }

    public String getSpanishId() {
        return spanishId;
    }

    public String getSpanishValue() {
        return spanishValue;
    }

    public String getEnglishLevelId() {
        return englishLevelId;
    }

    public String getEnglishLevelValue() {
        return englishLevelValue;
    }

    public String getChineseLevelId() {
        return chineseLevelId;
    }

    public String getChineseLevelValue() {
        return chineseLevelValue;
    }

    public String getSpanishLevelId() {
        return spanishLevelId;
    }

    public String getSpanishLevelValue() {
        return spanishLevelValue;
    }
}
