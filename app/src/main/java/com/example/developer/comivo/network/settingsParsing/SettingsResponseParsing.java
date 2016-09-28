package com.example.developer.comivo.network.settingsParsing;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kevin Khanda on 28.09.2016.
 * This is a class to parse mobileapi/settings
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
     *
     * @param response JSON that will be returned by the server for route "faq/list"
     */
    public void parseFAQList(String response) {

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

    public String getNotificationSettingsId() {
        return notificationSettingsId;
    }

    public String getTitle() {
        return title;
    }

    public String getIsEnabled() {
        return isEnabled;
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
}
